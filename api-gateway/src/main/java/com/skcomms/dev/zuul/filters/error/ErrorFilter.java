package com.skcomms.dev.zuul.filters.error;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ErrorFilter extends ZuulFilter {
  @Override
  public boolean shouldFilter() {
    // TODO Auto-generated method stub
    return RequestContext.getCurrentContext().getThrowable() != null;
  }

  @Override
  public Object run() throws ZuulException {
    Throwable throwable = RequestContext.getCurrentContext().getThrowable();
    log.error("Exception was thrown in filters: {}", throwable);
    return null;
  }

  @Override
  public String filterType() {
    // TODO Auto-generated method stub
    return FilterConstants.ERROR_TYPE;
  }

  @Override
  public int filterOrder() {
    // TODO Auto-generated method stub
    return FilterConstants.SEND_ERROR_FILTER_ORDER;
  }


}
