package ru.antonov.agent.event;

import jdk.jfr.*;

@Name("JdbcEvent")
@Label("JDBC Invocation")
@Category("JDBC")
@Description("JDBC query")
@StackTrace(true)
public class JdbcEvent extends Event {
    @Label("Query")
    public String query;
}


