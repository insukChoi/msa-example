package com.skcomms.dev.api.common.exception;

import com.skcomms.dev.api.common.constants.ErrorCode;

public class DataNotAllowException extends BaseRuntimeException {

  private static final long serialVersionUID = 5588738765195815925L;

  @Override
  public ErrorCode errorCode() {
    return ErrorCode.DATA_NOT_ALLOW;
  }

  @Override
  public String userErrorMessage() {
    return null;
  }

  public DataNotAllowException(Throwable t) {
    super(t);
  }

  public DataNotAllowException(String msg) {
    super(msg);
  }

}
