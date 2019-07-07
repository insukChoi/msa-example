package com.skcomms.dev.api.common.exception;

import com.skcomms.dev.api.common.constants.ErrorCode;

public abstract class BaseRuntimeException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 6335109083862548798L;

  // 에러코드를 설정하면 ConfigServer의 메시지가 매칭됨
  public abstract ErrorCode errorCode();

  // 사용자 정의 에러메시지가 있다면 ErrorCode메시지 무시함
  public abstract String userErrorMessage();

  public BaseRuntimeException() {
    super();

  }

  public BaseRuntimeException(String msg) {
    super(msg);

  }

  public BaseRuntimeException(Throwable t) {
    super(t);

  }

}
