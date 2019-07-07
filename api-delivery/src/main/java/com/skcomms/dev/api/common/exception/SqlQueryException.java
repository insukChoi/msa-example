package com.skcomms.dev.api.common.exception;

import com.skcomms.dev.api.common.constants.ErrorCode;

public class SqlQueryException extends BaseRuntimeException {

  private static final long serialVersionUID = -6302514118640040972L;

  @Override
  public ErrorCode errorCode() {
    return ErrorCode.SQL_QUERY_ERROR;
  }

  @Override
  public String userErrorMessage() {
    return null;
  }

  public SqlQueryException(Throwable t) {
    super(t);
  }

  public SqlQueryException(String msg) {
    super(msg);
  }

}
