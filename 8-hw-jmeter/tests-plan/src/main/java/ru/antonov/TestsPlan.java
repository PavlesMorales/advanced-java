package ru.antonov;

import lombok.extern.slf4j.Slf4j;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.RandomVariableConfig;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.gui.LoopControlPanel;
import org.apache.jmeter.control.gui.TestPlanGui;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.control.Header;
import org.apache.jmeter.protocol.http.control.HeaderManager;
import org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui;
import org.apache.jmeter.protocol.http.gui.HeaderPanel;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.protocol.http.util.HTTPArgument;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testbeans.gui.TestBeanGUI;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.threads.gui.ThreadGroupGui;
import org.apache.jmeter.timers.ConstantThroughputTimer;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.ListedHashTree;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;

@Slf4j
public class TestsPlan {

    public static void main(String[] args) throws IOException {
        runPT();
    }

    private static void runPT() throws IOException {
        final var jmeterHome = System.getenv("JMETER_HOME");
        final var pathSeparator = File.separator;

        if (jmeterHome == null) {
            throw new RuntimeException("JMETER_HOME environment variable is not set.");
        }

        JMeterUtils.loadJMeterProperties(jmeterHome + pathSeparator + "jmeter.properties");
        JMeterUtils.setJMeterHome(jmeterHome);
        JMeterUtils.initLocale();

        final var jmeter = new StandardJMeterEngine();

        final var threadGroup = getThreadGroup();


        final var testPlan = getTestPlan(threadGroup);
        final var testPlanTree = new ListedHashTree();
        testPlanTree.add(testPlan);
        final var threadGroupHashTree = testPlanTree.add(testPlan, threadGroup);
        final var sampler = getHttpSamplerProxy();
        final var manager = getHeaderManager();
        final var timer = getTimer();

        threadGroupHashTree.add(sampler);
        threadGroupHashTree.add(timer);
        threadGroupHashTree.add(getRandomStringConfig("login", 10));
        threadGroupHashTree.add(getRandomStringConfig("password", 20));
        threadGroupHashTree.add(manager);

        SaveService.saveTree(testPlanTree, Files.newOutputStream(Paths.get("./tests-plan/script.jmx"), CREATE));

        Summariser summer = null;
        String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
        if (summariserName.length() > 0) {
            summer = new Summariser(summariserName);
        }

        var logger = new ResultCollector(summer);
        logger.setFilename("./tests-plan/pt-logs.jtl");
        testPlanTree.add(testPlanTree.getArray()[0], logger);

        jmeter.configure(testPlanTree);
        jmeter.run();
    }

    private static ConstantThroughputTimer getTimer() {
        final var timer = new ConstantThroughputTimer();
        timer.setThroughput(60);
        timer.setName("Timer");
        return timer;
    }

    private static HeaderManager getHeaderManager() {
        final HeaderManager manager = new HeaderManager();
        manager.add(new Header("Content-Type", "application/json"));
        manager.setName(JMeterUtils.getResString("header_manager_title"));
        manager.setProperty(TestElement.TEST_CLASS, HeaderManager.class.getName());
        manager.setProperty(TestElement.GUI_CLASS, HeaderPanel.class.getName());
        manager.setName("Header manager");
        return manager;
    }

    private static HTTPSamplerProxy getHttpSamplerProxy() {
        final var httpSampler = new HTTPSamplerProxy();
        httpSampler.setDomain("localhost");
        httpSampler.setPort(8080);
        httpSampler.setPath("/auth/register");
        httpSampler.setMethod("POST");
        httpSampler.setFollowRedirects(true);
        httpSampler.setUseKeepAlive(true);
        httpSampler.setPostBodyRaw(true);
        httpSampler.setName("register");

        final var arguments = getArguments();
        httpSampler.setArguments(arguments);

        httpSampler.setProperty(TestElement.TEST_CLASS, HTTPSamplerProxy.class.getName());
        httpSampler.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());

        return httpSampler;
    }

    private static Arguments getArguments() {
        final var jMeterProperties = new Arguments();
        final var argument = new HTTPArgument();
        argument.setValue("""
                {
                    "login" : "${login}@mail.ru",
                    "password" : "${password}"
                }
                """);
        argument.setAlwaysEncoded(false);
        jMeterProperties.setProperty(TestElement.TEST_CLASS, HTTPSamplerProxy.class.getName());
        jMeterProperties.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());
        jMeterProperties.setArguments(List.of(argument));
        return jMeterProperties;
    }

    private static ThreadGroup getThreadGroup() {
        final var loopController = new LoopController();
        loopController.setLoops(60);
        loopController.setFirst(true);
        loopController.setProperty(TestElement.TEST_CLASS, LoopController.class.getName());
        loopController.setProperty(TestElement.GUI_CLASS, LoopControlPanel.class.getName());
        loopController.initialize();

        final var threadGroup = new ThreadGroup();
        threadGroup.setName("Registration Service");
        threadGroup.setNumThreads(600);
        threadGroup.setRampUp(1);
        threadGroup.setSamplerController(loopController);
        threadGroup.setProperty(TestElement.TEST_CLASS, ThreadGroup.class.getName());
        threadGroup.setProperty(TestElement.GUI_CLASS, ThreadGroupGui.class.getName());
        return threadGroup;
    }

    private static TestPlan getTestPlan(final ThreadGroup threadGroup) {
        final var testPlan = new TestPlan("Registration Service Test Plan");
        testPlan.setProperty(TestElement.TEST_CLASS, org.apache.jmeter.testelement.TestPlan.class.getName());
        testPlan.setProperty(TestElement.GUI_CLASS, TestPlanGui.class.getName());
        testPlan.addThreadGroup(threadGroup);
        return testPlan;
    }

    private static RandomVariableStringConfig getRandomStringConfig(final String name, final int length) {
        final var randomVariable = new RandomVariableStringConfig(name, length);
        randomVariable.setProperty(TestElement.TEST_CLASS, RandomVariableConfig.class.getName());
        randomVariable.setProperty(TestElement.GUI_CLASS, TestBeanGUI.class.getName());
        return randomVariable;
    }
}