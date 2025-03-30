package io.github.octopus.metrics.config

import feign.RequestInterceptor
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class FeignMetricsAutoConfig {
    @Value("\${spring.application.name:application}")
    private lateinit var appName: String

    /**
     * Populate application information to headers in outgoing requests.
     */
    @Bean
    open fun feignClientMetricsInterceptor() = RequestInterceptor { template ->
        template.header("X-Application-Name", appName)
    }
}
