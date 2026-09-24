package com.creacionpj.utils;

import jakarta.validation.constraints.*;
import jakarta.validation.Constraint;
import java.lang.annotation.*;
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Min(0)
@Max(4)
@Constraint(validatedBy = {})
public @interface RangoCompetencia {
    String message() default "El valor debe estar entre 0 y 4";
     Class<?>[] groups() default{};
     Class<? extends jakarta.validation.Payload>[] payload() default{};   
}