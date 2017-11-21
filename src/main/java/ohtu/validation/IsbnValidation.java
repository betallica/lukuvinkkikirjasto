package ohtu.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsbnValidation implements ConstraintValidator<IsbnValid, String>{

	@Override
	public void initialize(IsbnValid constraintAnnotation) {
				
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		b
		return false;
	}

}
