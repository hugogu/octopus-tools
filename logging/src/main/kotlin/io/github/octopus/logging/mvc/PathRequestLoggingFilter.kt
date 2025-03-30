package io.github.octopus.logging.mvc

import org.apache.commons.lang3.StringUtils
import org.springframework.web.filter.CommonsRequestLoggingFilter
import jakarta.servlet.http.HttpServletRequest

/**
 * A filter that logs HTTP requests, excluding certain paths.
 * Request to /actuator is excluded by default.
 */
class PathRequestLoggingFilter(private val excludedPaths: Iterable<String> = listOf("/actuator")) :
    CommonsRequestLoggingFilter() {
    public override fun shouldLog(request: HttpServletRequest): Boolean {
        return logger.isDebugEnabled &&
                excludedPaths.all { !StringUtils.contains(request.requestURI, it) }
    }
}
