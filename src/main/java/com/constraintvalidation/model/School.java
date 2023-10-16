package com.constraintvalidation.model;

import com.constraintvalidation.annotation.SchoolAddressCheck;
import com.constraintvalidation.annotation.SchoolIdCheck;
import com.constraintvalidation.annotation.SchoolPhoneNumberCheck;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {

    @NotNull
    @SchoolIdCheck
    private String schoolId;
    @NotNull
    @SchoolAddressCheck
    private String schoolAddress1;
    @NotNull
    @SchoolAddressCheck
    private String schoolAddress2;
    @NotNull
    @SchoolAddressCheck
    private String schoolAddress3;
    @NotNull
    @SchoolPhoneNumberCheck
    private String schoolPhoneNumber;

}
