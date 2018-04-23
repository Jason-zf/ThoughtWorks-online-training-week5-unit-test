package tw.core.generator;

import org.junit.Before;
import org.junit.Test;
import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    private AnswerGenerator answerGenerator;
    private RandomIntGenerator randomIntGenerator;
    private String input;

    @Before
    public void setAnswerGenerator() {
        randomIntGenerator = mock(RandomIntGenerator.class);
        input = "1 2 3 4";

        when(randomIntGenerator.generateNums(9, 4)).thenReturn(input);

        answerGenerator = new AnswerGenerator(randomIntGenerator);
    }

    @Test
    public void should_not_throw_exception_when_generate() {
        int num = 0;
        try {
            answerGenerator.generate();
        } catch (OutOfRangeAnswerException e) {
            e.printStackTrace();
            num = 1;
        }
        assertEquals(0, num);
        assertNotEquals(1, num);
    }

    @Test
    public void should_return_answer_when_generate() throws OutOfRangeAnswerException {
        Answer expected = Answer.createAnswer(input);

        assertEquals(expected.toString(), answerGenerator.generate().toString());
    }
}

