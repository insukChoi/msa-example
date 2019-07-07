package com.skcomms.dev.api.common.exception;

import com.skcomms.dev.api.common.constants.ErrorCode;

public class InternalServerException extends BaseRuntimeException {

  private static final long serialVersionUID = 6719974844964427804L;

  @Override
  public ErrorCode errorCode() {
    return ErrorCode.INTERNAL_ERROR;

  }

  @Override
  public String userErrorMessage() {
    return null;
  }

  public InternalServerException(Throwable t) {
    super(t);
  }

}
