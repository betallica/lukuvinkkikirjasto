package ohtu.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsbnValidation.class)
@Documented
public @interface IsbnValid {

}
