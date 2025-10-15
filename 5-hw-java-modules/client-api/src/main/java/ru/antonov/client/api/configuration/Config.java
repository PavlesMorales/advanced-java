package ru.antonov.client.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.antonov.client.service.service.ClientService;

import static ru.antonov.client.service.configuration.Config.clientService;

@Configuration
public class Config {

    @Bean
    public ClientService clientServiceBean() {
        return clientService();
    }
}
