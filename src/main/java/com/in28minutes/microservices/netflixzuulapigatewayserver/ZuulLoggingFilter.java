package com.in28minutes.microservices.netflixzuulapigatewayserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

// From now on, if you wish your request go through this gateway, you must type http://localhost:{port of this server}/{application-name}/{uri}
// For example, http://localhost:8765/currency-exchange-service/currency-exchange/from/AUD/to/INR
// http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/564
@Component
public class ZuulLoggingFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // What type of filter you want to filter?
    @Override
    public String filterType() {
        return "pre"; // Filter that request before executed
        // return "post" // Filter the request after executed
        // return "error"; // Filter only error request (Exceptions)
    }

    // Set priority order for this project, if you many more filters
    @Override
    public int filterOrder() {
        return 1;
    }

    // Active this filter or not. return true to filter everything that passes through this project
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // Real implementation of the intercepting logic
    @Override
    public Object run() throws ZuulException {
        // Give me the current HTTP request
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("request -> {} request uri -> {}", request, request.getRequestURI());

        return null;
    }
}
