package com.skcomms.dev.zuul.filters.pre;

import javax.servlet.http.HttpServletRequest;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RequestLogFilter extends ZuulFilter {

  @Override
  public boolean shouldFilter() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public Object run() throws ZuulException {


    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();

    log.debug("Request Method: {}", request.getMethod());
    log.debug("Request URL: {}", request.getRequestURL().toString());

    return null;
  }

  @Override
  public String filterType() {
    // TODO Auto-generated method stub
    return FilterConstants.PRE_TYPE;
  }

  @Override
  public int filterOrder() {
    // TODO Auto-generated method stub
    return FilterConstants.PRE_DECORATION_FILTER_ORDER;
  }

}
