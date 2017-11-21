package ohtu.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Class for checking that given ISBN number is valid. The ISBN needs to have correct length
 * and check digit.
 */
public class IsbnValidation implements ConstraintValidator<IsbnValid, String> {

	@Override
	public void initialize(IsbnValid constraintAnnotation) {
				
	}

	@Override
	public boolean isValid(String isbn, ConstraintValidatorContext context) {
		if ( isbn == null ){
            return false;
        }

        isbn = isbn.replaceAll( "-", "" );

        if ( isbn.length() != 13 ){
            return false;
        }
        
        int tot = 0;
        for ( int i = 0; i < 12; i++ ){
            int digit = Integer.parseInt( isbn.substring( i, i + 1 ) );
            tot += (i % 2 == 0) ? digit * 1 : digit * 3;
        }

        
        int checksum = 10 - (tot % 10);
        if ( checksum == 10 ){
            checksum = 0;
        }

        return checksum == Integer.parseInt( isbn.substring( 12 ) );
	}

}
