package ohtu.validation;

import ohtu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Class for checking and validating that the given String does not yet exist in the tag repository.
 */
public class TagNameValidation implements ConstraintValidator<TagNameUnique, String> {

    @Autowired
    private TagService tagService;

    @Override
    public void initialize(TagNameUnique constraintAnnotation) {

    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return !tagService.tagNameExists(name);
    }
}
