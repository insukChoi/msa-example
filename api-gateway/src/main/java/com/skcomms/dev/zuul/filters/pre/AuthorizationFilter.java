package com.skcomms.dev.zuul.filters.pre;

import javax.servlet.http.HttpServletRequest;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthorizationFilter extends ZuulFilter {

  @Override
  public boolean shouldFilter() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();



    String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (!validateToken(authorizationHeader)) {
      ctx.setSendZuulResponse(false);
      ctx.setResponseBody("API key not authorized");
      ctx.getResponse().setHeader("Content-Type", "text/plain;charset=UTF-8");
      ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
    }
    return null;
  }

  private boolean validateToken(String tokenHeader) {
    // TODO authorization token 확인 로직
    log.debug("validateToken [{}]", tokenHeader);
    return true;
  }

  @Override
  public String filterType() {
    // TODO Auto-generated method stub
    return FilterConstants.PRE_TYPE;
  }

  @Override
  public int filterOrder() {
    // TODO Auto-generated method stub
    return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
  }

}
