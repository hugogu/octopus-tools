package io.github.octopus.logging

import io.github.octopus.logging.mvc.PathRequestLoggingFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.CommonsRequestLoggingFilter

@Configuration
open class LoggingConfig {
    @Bean
    open fun mvcLoggingFilter(): CommonsRequestLoggingFilter {
        return PathRequestLoggingFilter()
    }
}
