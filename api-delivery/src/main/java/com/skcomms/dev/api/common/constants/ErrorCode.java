package com.skcomms.dev.api.common.constants;

import java.util.Arrays;

import lombok.Getter;

public enum ErrorCode {

		DATA_NOT_FOUND("DATA_NOT_FOUND"),
		SQL_QUERY_ERROR("SQL_QUERY_ERROR"),
		BAD_REQUEST_ERROR("BAD_REQUEST_ERROR"),
		DATA_NOT_ALLOW("DATA_NOT_ALLOW"),
		SEND_RESULT_ERROR("SEND_RESULT_ERROR"),
		INTERNAL_ERROR("INTERNAL_ERROR"),
		CUSTOM_ERROR("CUSTOM_ERROR");

	@Getter
	private final String value;

	ErrorCode(String s) {
		this.value = s.toUpperCase();
	}

	public static ErrorCode fromString(String s) {
		return Arrays.stream(ErrorCode.values()).filter(v -> v.value.equalsIgnoreCase(s)).findFirst().orElseThrow(() -> new IllegalArgumentException("Unknown value :"
						+ s));
	}
}
