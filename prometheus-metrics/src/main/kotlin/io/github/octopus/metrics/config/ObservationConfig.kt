package io.github.octopus.metrics.config

import io.github.octopus.metrics.ServerRequestSourceObservationConvention
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.server.observation.ServerRequestObservationConvention

@Configuration
open class ObservationConfig {
    @Bean
    @ConditionalOnClass(ServerRequestObservationConvention::class)
    open fun serverRequestSourceObservationConvention(
        @Value("\${spring.application.name:unknown}")
        appName: String,
    ): ServerRequestObservationConvention {
        return ServerRequestSourceObservationConvention(appName)
    }
}
