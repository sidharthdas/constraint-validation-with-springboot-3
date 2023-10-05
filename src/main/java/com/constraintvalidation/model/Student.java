package com.constraintvalidation.model;

import com.constraintvalidation.annotation.NameSizeGreaterThan5AndStartWithS;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Student {

    @NotNull
    @NameSizeGreaterThan5AndStartWithS
    private String name;
    @NotNull
    private String address;


}
