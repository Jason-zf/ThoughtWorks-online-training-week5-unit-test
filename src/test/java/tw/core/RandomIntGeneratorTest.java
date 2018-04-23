package tw.core;


import org.junit.Before;
import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    private RandomIntGenerator randomIntGenerator;

    @Before
    public void setRandomIntGenerator() {
        randomIntGenerator = new RandomIntGenerator();
    }

    @Test
    public void should_return_exception_when_digitmax_less_than_numbersOfNeed() {
        String expected = "Can't ask for more numbers than are available";

        try {
            randomIntGenerator.generateNums(2, 10);
        } catch (IllegalArgumentException error) {
            assertEquals(expected, error.getMessage());
        }
    }

    @Test
    public void should_return_four_numbers_when_generate_four_numbers() {
        String[] result = randomIntGenerator.generateNums(10, 4).split(" ");

        assertEquals(4, result.length);
    }

    @Test
    public void should_return_different_numbers_when_generate_numbers() {
        String[] result = randomIntGenerator.generateNums(10, 2).split(" ");

        assertNotEquals(result[0], result[1]);
    }

    @Test
    public void should_return_all_numbers_less_than_digitmax_when_generate_numbers() {
        String[] result = randomIntGenerator.generateNums(10, 2).split(" ");

        assertTrue(Integer.valueOf(result[0]).intValue() < 10);
        assertTrue(Integer.valueOf(result[1]).intValue() < 10);
    }
}