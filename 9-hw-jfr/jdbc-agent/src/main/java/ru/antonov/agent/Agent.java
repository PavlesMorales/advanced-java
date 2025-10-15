package ru.antonov.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Agent {

    public static void agentmain(String arguments, Instrumentation instrumentation) {
        System.out.println("agent successfully attached at runtime");
        instrument(arguments, instrumentation);
    }

    private static void instrument(String arguments, Instrumentation instrumentation) {
        AgentBuilder.Transformer transformer = (builder, typeDescription, classLoader, javaModule, protectionDomain) ->
                builder.visit(Advice.to(JdbcAdvice.class)
                        .on(named("executeQuery")));

        new AgentBuilder.Default()
                .disableClassFormatChanges()
                .with(AgentBuilder.RedefinitionStrategy.RETRANSFORMATION)
                .type(ElementMatchers.isSubTypeOf(java.sql.PreparedStatement.class).and(
                        ElementMatchers.not(ElementMatchers.nameContainsIgnoreCase("proxy"))))
                .transform(transformer)
                .installOn(instrumentation);
    }
}
