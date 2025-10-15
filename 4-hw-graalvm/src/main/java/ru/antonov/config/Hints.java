package ru.antonov.config;

import liquibase.changelog.ChangeLogHistoryServiceFactory;
import liquibase.database.LiquibaseTableNamesFactory;
import liquibase.report.ShowSummaryGeneratorFactory;
import liquibase.ui.LoggerUIService;
import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

import java.util.Collections;

public class Hints implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints.reflection().registerType(LoggerUIService.class, (type) ->
                        type.withConstructor(Collections.emptyList(), ExecutableMode.INVOKE))
                .registerType(ShowSummaryGeneratorFactory.class, (type) ->
                        type.withConstructor(Collections.emptyList(), ExecutableMode.INVOKE))
                .registerType(ChangeLogHistoryServiceFactory.class, (type) ->
                        type.withConstructor(Collections.emptyList(), ExecutableMode.INVOKE))
                .registerType(LiquibaseTableNamesFactory.class, (type) ->
                        type.withConstructor(Collections.emptyList(), ExecutableMode.INVOKE));
    }
}
