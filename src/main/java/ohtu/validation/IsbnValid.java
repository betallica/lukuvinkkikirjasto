package ohtu.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsbnValidation.class)
@Documented
public @interface IsbnValid {
	String message() default "Not a valid isbn";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
