package io.github.octopus.metrics.client

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateRequestCustomizer
import org.springframework.http.client.ClientHttpRequest

class RestClientHttpRequestCustomizer(
    @Value("\${spring.application.name}")
    private val appName: String? = null,
) : RestTemplateRequestCustomizer<ClientHttpRequest> {
    override fun customize(request: ClientHttpRequest?) {
        if (appName != null) {
            request?.headers?.add("X-Application-Name", appName)
        }
    }
}
