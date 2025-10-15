module client.api {
    requires client.service;

    requires spring.boot.autoconfigure;
    requires spring.web;
    requires spring.boot;
    requires spring.context;
    requires spring.beans;
    requires spring.aop;
    requires spring.core;
    requires spring.webmvc;

    requires static lombok;
    requires org.slf4j;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    opens ru.antonov.client.api to spring.core, spring.beans, spring.context, spring.web, spring.aop, org.slf4j;
    opens ru.antonov.client.api.dto to com.fasterxml.jackson.core, com.fasterxml.jackson.databind;
    opens ru.antonov.client.api.converter to spring.beans, spring.context;
    opens ru.antonov.client.api.controller to spring.core, spring.beans, spring.context, spring.web, spring.aop, spring.webmvc;
    opens ru.antonov.client.api.configuration to spring.core, spring.beans, spring.context;

}