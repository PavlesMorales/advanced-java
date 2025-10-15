package ru.antonov.agent.event;

import jdk.jfr.FlightRecorder;

public class EventProducer {

    static {
        FlightRecorder.register(JdbcEvent.class);
    }

    public static JdbcEvent startJdbcQuery(String query) {
        System.out.println("Started JDBC query " + query);
        JdbcEvent jdbcEvent = new JdbcEvent();
        jdbcEvent.begin();
        jdbcEvent.query = query;
        return jdbcEvent;
    }

    public static void endJdbcEvent(JdbcEvent jdbcEvent) {
        System.out.println("Ended JDBC Event with query " + jdbcEvent.query);
        jdbcEvent.end();
        jdbcEvent.commit();
    }

}
