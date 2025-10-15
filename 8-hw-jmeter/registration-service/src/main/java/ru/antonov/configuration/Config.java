package ru.antonov.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.antonov.service.HashService;
import ru.antonov.service.impl.Md5HashService;
import ru.antonov.service.impl.Sha256HashService;
import ru.antonov.service.impl.Sha512HashService;

@Slf4j
@Configuration
public class Config {

    private static final String MD5_ALGORITHM = "MD5";
    private static final String SHA256_ALGORITHM = "SHA256";
    private static final String SHA512_ALGORITHM = "SHA512";


    @Bean
    @ConditionalOnProperty(name = "hash.algorithm", havingValue = MD5_ALGORITHM)
    @ConditionalOnMissingBean(value = HashService.class)
    HashService hashServiceMd5() {
        log.info("MD5 algorithm is used");
        return new Md5HashService();
    }

    @Bean
    @ConditionalOnProperty(name = "hash.algorithm", havingValue = SHA256_ALGORITHM)
    HashService hashServiceSha256() {
        log.info("SHA256 algorithm is used");
        return new Sha256HashService();
    }

    @Bean
    @ConditionalOnProperty(name = "hash.algorithm", havingValue = SHA512_ALGORITHM)
    HashService hashServiceSha512() {
        log.info("SHA512 algorithm is used");
        return new Sha512HashService();
    }
}
