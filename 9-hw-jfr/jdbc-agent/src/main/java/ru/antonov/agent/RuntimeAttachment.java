package ru.antonov.agent;


import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.File;
import java.io.IOException;

public class RuntimeAttachment {

    public static void main(String[] args) throws AgentLoadException, IOException, AgentInitializationException, AttachNotSupportedException {
        String javaProcessId = args[0];
        String agentJarLocation = args[1];
        VirtualMachine vm = VirtualMachine.attach(javaProcessId);
        String absoluteAgentPath = new File(agentJarLocation).getAbsolutePath();
        vm.loadAgent(absoluteAgentPath, "");
        System.out.println("Load agent to remote JVM!");
        vm.detach();
        System.out.println("Done.");
    }
}