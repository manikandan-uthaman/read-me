package com.mani.project.readmeapi.app;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CreateBookValidator.class)
public @interface ValidateBookObject {
    String message() default "Input is not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};	
}
