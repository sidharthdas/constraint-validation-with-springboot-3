package com.constraintvalidation.enums;

public enum ValidationEnum {

    PHONE_NUMBER_SHOULD_BE_OF_SIZE_10("ERROR", "Phone number should be of size 10"),
    SCHOOL_ID_SHOULD_STARTS_WITH("ERROR", "School id should start with SCHOOL");

    private final String errorSeverity;
    private final String errorMessage;

    ValidationEnum(String errorSeverity, String errorMessage) {
        this.errorSeverity = errorSeverity;
        this.errorMessage = errorMessage;
    }

    public String getErrorSeverity(){
        return errorSeverity;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
