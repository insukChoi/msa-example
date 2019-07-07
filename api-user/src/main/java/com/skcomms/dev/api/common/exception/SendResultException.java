package com.skcomms.dev.api.common.exception;

import com.skcomms.dev.api.common.constants.ErrorCode;

public class SendResultException extends BaseRuntimeException {
  @Override
  public ErrorCode errorCode() {
    return ErrorCode.SEND_RESULT_ERROR;
  }

  @Override
  public String userErrorMessage() {
    return null;
  }

  public SendResultException(Throwable t) {
    super(t);
  }

  public SendResultException(String msg) {
    super(msg);
  }
}
