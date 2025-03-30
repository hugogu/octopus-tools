package io.github.octopus.logging.mvc

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.MDC
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.util.*

class RequestMdcInterceptor : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val correlation = request.getHeader(CORRELATION_ID_HEADER_NAME) ?: UUID.randomUUID().toString()

        MDC.put(CORRELATION_ID_HEADER_NAME, correlation)
        return true
    }

    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?
    ) {
        MDC.remove(CORRELATION_ID_HEADER_NAME)
    }

    companion object {
        const val CORRELATION_ID_HEADER_NAME = "CORRELATION_ID"
    }
}
