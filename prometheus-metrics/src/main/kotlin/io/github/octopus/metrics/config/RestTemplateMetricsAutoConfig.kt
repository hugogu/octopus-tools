package io.github.octopus.metrics.config

import io.github.octopus.metrics.client.RestClientHttpRequestCustomizer
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.boot.web.client.RestTemplateRequestCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.ClientHttpRequest
import org.springframework.web.client.RestTemplate

@Configuration
open class RestTemplateMetricsAutoConfig {
    @Bean
    @ConditionalOnBean(RestTemplate::class)
    open fun restTemplateRequestCustomizer(): RestTemplateRequestCustomizer<ClientHttpRequest> {
        return RestClientHttpRequestCustomizer()
    }
}
