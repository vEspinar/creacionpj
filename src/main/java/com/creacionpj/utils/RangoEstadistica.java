package com.creacionpj.utils;

import jakarta.validation.constraints.*;
import jakarta.validation.Constraint;
import java.lang.annotation.*;
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Min(1)
@Max(30)
@Constraint(validatedBy = {})
public @interface RangoEstadistica {
    String message() default "El valor debe estar entre 1 y 30";
     Class<?>[] groups() default{};
     Class<? extends jakarta.validation.Payload>[] payload() default{};   
}
