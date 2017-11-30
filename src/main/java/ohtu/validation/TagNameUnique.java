package ohtu.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TagNameValidation.class)
@Documented
public @interface TagNameUnique {
    String message() default "Tag name already exists. ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
