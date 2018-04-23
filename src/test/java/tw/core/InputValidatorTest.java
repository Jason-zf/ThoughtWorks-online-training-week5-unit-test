package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.validator.InputValidator;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    private InputValidator inputValidator;

    @Before
    public void setInputValidator() {
        inputValidator = new InputValidator();
    }

    @Test
    public void should_return_true_when_input_four_different_numbers() {
        assertTrue(inputValidator.validate("1 2 3 4"));
    }

    @Test
    public void should_return_false_when_input_four_numbers_contains_same_number() {
        assertFalse(inputValidator.validate("1 1 3 4"));
    }

    @Test
    public void should_return_false_when_input_five_numbers_contains_one_same_number() {
        assertFalse(inputValidator.validate("1 2 3 4 4"));
    }

    @Test
    public void should_return_false_when_input_more_than_four_numbers() {
        assertFalse(inputValidator.validate("1 2 3 4 6"));
    }
}
