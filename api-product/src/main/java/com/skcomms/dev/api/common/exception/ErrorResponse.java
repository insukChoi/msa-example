package com.skcomms.dev.api.common.exception;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.skcomms.dev.api.common.constants.ErrorCode;
import lombok.Data;

@Data
public class ErrorResponse {

  private ErrorCode errorCode;

  private String message;

  private String error;

  private String debug;

  private String request;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  private LocalDateTime timestamp;

  private ErrorResponse() {
    this.timestamp = LocalDateTime.now();
    this.request = "";
  }

  public ErrorResponse(BaseRuntimeException ex, String msg) {
    this();
    this.message = msg;
    this.error = ex.getLocalizedMessage();
    this.errorCode = ex.errorCode();
    this.debug = "";

  }

  public ErrorResponse(BaseRuntimeException ex, String msg, String req, String debug) {
    this();
    this.message = msg;
    this.request = req;
    this.debug = debug;
    this.error = ex.toString();
    this.errorCode = ex.errorCode();
  }

}
