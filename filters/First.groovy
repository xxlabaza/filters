package ru.xxlabaza.test.zuul.filters.groovy

import javax.servlet.http.HttpServletRequest
import com.netflix.zuul.context.RequestContext
import com.netflix.zuul.ZuulFilter

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MyFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyFilter.class)

    boolean shouldFilter () {
        return true
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext()
        HttpServletRequest request = ctx.getRequest()

        log.info(String.format("%s request to %s", request.method, request.requestURL.toString()))

        return Boolean.TRUE
    }

    int filterOrder () {
        return 1
    }

    String filterType () {
        return 'pre'
    }

    String disablePropertyName () {
        return 'zuul.MyFilter.disable'
    }
}
