package com.skcomms.dev.api.common.exception;

import com.skcomms.dev.api.common.constants.ErrorCode;

public class DataNotFoundException extends BaseRuntimeException {

  private static final long serialVersionUID = -7469913817876019465L;

  @Override
  public ErrorCode errorCode() {
    return ErrorCode.DATA_NOT_FOUND;
  }

  @Override
  public String userErrorMessage() {
    return null;
  }

  public DataNotFoundException(Throwable t) {
    super(t);
  }

  public DataNotFoundException(String msg) {
    super(msg);
  }

}
