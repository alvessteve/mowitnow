package infrastucture;

import org.junit.Test;
import org.xebia.mowitnow.infrastructure.validator.StringValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class StringValidatorTest {

    @Test
    public void empty_string(){
        assertTrue(StringValidator.isNullorEmpty(""));
    }

    @Test
    public void null_string(){
        assertTrue(StringValidator.isNullorEmpty(null));
    }

    @Test
    public void non_empty_string(){
        assertFalse(StringValidator.isNullorEmpty("astring"));
    }

}
