package io.github.octopus.metrics

import io.micrometer.common.KeyValues
import org.springframework.http.server.observation.DefaultServerRequestObservationConvention
import org.springframework.http.server.observation.ServerRequestObservationContext

/**
 * This class is used to add a custom key-value pair to the observation context.
 *
 * This depends on Spring 6.0+, Spring Boot 3.2+ and Micrometer 1.11+.
 */
class ServerRequestSourceObservationConvention(
    private val appName: String
) : DefaultServerRequestObservationConvention() {
    override fun getLowCardinalityKeyValues(context: ServerRequestObservationContext): KeyValues {
        return super.getLowCardinalityKeyValues(context).apply {
            this.and("application", appName)
        }
    }
}
