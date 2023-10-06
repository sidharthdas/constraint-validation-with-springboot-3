package com.constraintvalidation.exception;

import jakarta.annotation.Nullable;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public record ErrorDetail(LocalDateTime localDateTime, String message, String URI, @Nullable LinkedHashMap<String, String> map) {
}
