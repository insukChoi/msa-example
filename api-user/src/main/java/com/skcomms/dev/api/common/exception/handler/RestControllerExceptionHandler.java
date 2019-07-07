package com.skcomms.dev.api.common.exception.handler;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.skcomms.dev.api.common.exception.BadRequestException;
import com.skcomms.dev.api.common.exception.BaseRuntimeException;
import com.skcomms.dev.api.common.exception.DataNotFoundException;
import com.skcomms.dev.api.common.exception.ErrorResponse;
import com.skcomms.dev.api.common.exception.InternalServerException;
import com.skcomms.dev.api.common.exception.SqlQueryException;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@ControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

  public RestControllerExceptionHandler() {
    super();
  }

  @Override
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
      HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {

    BadRequestException e = new BadRequestException(ex);
    return buildResponse(e, headers, HttpStatus.BAD_REQUEST, request);
  }

  // 추가됨
  @Override
  protected ResponseEntity<Object> handleServletRequestBindingException(
      ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {
    BadRequestException e = new BadRequestException(ex);
    return buildResponse(e, headers, HttpStatus.BAD_REQUEST, request);
  }

  @Override
  protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    BadRequestException e = new BadRequestException(ex);
    return buildResponse(e, headers, HttpStatus.BAD_REQUEST, request);
  }

  @Override
  protected ResponseEntity<Object> handleMissingServletRequestParameter(
      MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {

    BadRequestException e = new BadRequestException(ex);
    return buildResponse(e, headers, HttpStatus.BAD_REQUEST, request);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    BadRequestException e = new BadRequestException(ex);
    return buildResponse(e, headers, HttpStatus.BAD_REQUEST, request);
  }

  @Override
  protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    BadRequestException e = new BadRequestException(ex);
    return buildResponse(e, headers, HttpStatus.BAD_REQUEST, request);
  }

  @Override
  protected ResponseEntity<Object> handleAsyncRequestTimeoutException(
      AsyncRequestTimeoutException ex, HttpHeaders headers, HttpStatus status,
      WebRequest webRequest) {

    InternalServerException e = new InternalServerException(ex);
    return buildResponse(e, headers, status, webRequest);
  }

  @ExceptionHandler(NoSuchElementException.class)
  public final ResponseEntity<Object> handlerNoSuchElementException(NoSuchElementException ex,
      WebRequest request) {

    BadRequestException e = new BadRequestException(ex);

    return buildResponse(e, null, HttpStatus.BAD_REQUEST, request);
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<Object> handlerInternalServerError(RuntimeException ex,
      WebRequest request) {

    BaseRuntimeException e = null;
    if (ex instanceof BaseRuntimeException)
      e = (BaseRuntimeException) ex;
    else
      e = new InternalServerException(ex);

    return buildResponse(e, null, HttpStatus.INTERNAL_SERVER_ERROR, request);
  }

  @ExceptionHandler(DataNotFoundException.class)
  public ResponseEntity<Object> handlerDataNotFoundError(RuntimeException ex, WebRequest request) {

    BaseRuntimeException e = null;
    if (ex instanceof BaseRuntimeException)
      e = (BaseRuntimeException) ex;
    else
      e = new InternalServerException(ex);

    return buildResponse(e, null, HttpStatus.NOT_FOUND, request);
  }

  @ExceptionHandler({SQLException.class, SqlQueryException.class})
  public ResponseEntity<Object> handlerSQLError(RuntimeException ex, WebRequest request) {

    BaseRuntimeException e = null;
    if (ex instanceof BaseRuntimeException)
      e = (BaseRuntimeException) ex;
    else
      e = new SqlQueryException(ex);

    return buildResponse(e, null, HttpStatus.INTERNAL_SERVER_ERROR, request);
  }

  @ResponseBody
  ResponseEntity<Object> buildResponse(BaseRuntimeException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {

    if (ex != null) {

      log.error("{}",ex);

      String msg = ex.getMessage();

      String req = generateRequestMessage(request);
      StringBuilder debug = new StringBuilder();

      StackTraceElement ele = ex.getStackTrace()[0];
      if (ele != null) {
        debug.append(ele.getFileName() + "[" + ele.getLineNumber() + "] " + ele.getClassName()
            + " - [" + ele.getMethodName() + "]\n");
      }

      if (ex.getCause() != null) {
        ele = ex.getCause().getStackTrace()[0];
        if (ele != null) {
          debug.append(ele.getFileName() + "[" + ele.getLineNumber() + "] " + ele.getClassName()
              + " - [" + ele.getMethodName() + "]");
        }

      }
      ErrorResponse res = new ErrorResponse(ex, msg, req, debug.toString());
      log.error(res.toString());

      return new ResponseEntity<>(res, status);

    }

    InternalServerException e = new InternalServerException(ex);
    return new ResponseEntity<>(new ErrorResponse(e, e.getLocalizedMessage()),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private static String generateRequestMessage(WebRequest request) {

    StringBuilder str = new StringBuilder();

    if (request != null) {
      str.append(request.getDescription(false));
      Iterator<String> headerNames = request.getHeaderNames();

      str.append(" | headers : ");

      while (headerNames.hasNext()) {
        String name = headerNames.next();
        String value = request.getHeader(name);
        str.append(name + "=" + value + "&");
      }
      str.deleteCharAt(str.length() - 1);

      Iterator<String> names = request.getParameterNames();
      if (names.hasNext()) {
        str.append(" | parameters : ");
        String name = names.next();
        String value = request.getParameter(name);
        str.append(name + "=" + value + "&");

        while (names.hasNext()) {
          name = names.next();
          value = request.getParameter(name);
          str.append(name + "=" + value + "&");
        }
        str.deleteCharAt(str.length() - 1);

      }
    }

    return str.toString();
  }
}
