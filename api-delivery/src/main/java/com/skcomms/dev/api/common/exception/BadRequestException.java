package com.skcomms.dev.api.common.exception;

import com.skcomms.dev.api.common.constants.ErrorCode;

public class BadRequestException extends BaseRuntimeException {

  @Override
  public ErrorCode errorCode() {
    return ErrorCode.BAD_REQUEST_ERROR;
  }

  @Override
  public String userErrorMessage() {
    return null;
  }

  public BadRequestException(Throwable t) {
    super(t);
  }

  public BadRequestException(String msg) {
    super(msg);
  }

}
