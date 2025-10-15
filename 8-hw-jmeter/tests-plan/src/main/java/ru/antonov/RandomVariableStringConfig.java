package ru.antonov;

import lombok.Getter;
import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.engine.event.LoopIterationEvent;
import org.apache.jmeter.engine.event.LoopIterationListener;
import org.apache.jmeter.engine.util.NoConfigMerge;
import org.apache.jmeter.engine.util.NoThreadClone;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testelement.ThreadListener;
import org.apache.jmeter.threads.JMeterContextService;
import org.apache.jmeter.threads.JMeterVariables;

import java.util.Random;

@Getter
public class RandomVariableStringConfig extends ConfigTestElement
        implements TestBean, LoopIterationListener, NoThreadClone, NoConfigMerge, ThreadListener {

    private static final String CHARACTERS_TO_USE = "abcdefghijklmnopqrstuvxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final String variableName;

    private final int length;

    public RandomVariableStringConfig(final String variableName, final int length) {
        this.variableName = variableName;
        this.length = length;
    }

    @Override
    public void iterationStart(final LoopIterationEvent iterEvent) {
        JMeterVariables variables = JMeterContextService.getContext().getVariables();
        variables.put(getVariableName(), getNextRandomString());
    }

    private String getVariableName() {
        return variableName;
    }

    private String getNextRandomString() {
        if (length <= 0) {
            return "";
        }
        final Random random = new Random();
        final var buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            final var randomInt = random.nextInt(CHARACTERS_TO_USE.length());
            buffer.append(CHARACTERS_TO_USE.charAt(randomInt));
        }


        return buffer.toString();
    }

    @Override
    public void threadStarted() {

    }

    @Override
    public void threadFinished() {

    }
}
