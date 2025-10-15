package ru.antonov.agent;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import ru.antonov.agent.event.EventProducer;
import ru.antonov.agent.event.JdbcEvent;

import java.lang.reflect.Method;

public class JdbcAdvice {

    @Advice.OnMethodEnter
    public static JdbcEvent onBeforeExecute(
            @Advice.This Object preparedStatement,
            @Advice.AllArguments Object[] allArguments,
            @Advice.Origin Method method) {
        JdbcEvent jdbcEvent = EventProducer.startJdbcQuery(preparedStatement.toString());
        return jdbcEvent;
    }

    @Advice.OnMethodExit
    public static void onAfterExecute(@Advice.Enter JdbcEvent jdbcEvent,
                                      @Advice.Return(typing = Assigner.Typing.DYNAMIC) long returnValue) {
         EventProducer.endJdbcEvent(jdbcEvent);
    }
}
