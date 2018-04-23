package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    private List<String> numList;
    private Answer answer = new Answer();

    @Before
    public void setUp() {
        numList = new ArrayList<>();
        numList.add("1");
        numList.add("2");
        numList.add("3");
        numList.add("4");
        answer.setNumList(numList);
    }

    @Test
    public void should_return_0_when_get_index_of_num_1() {
        int expected = 0;
        assertEquals(expected, answer.getIndexOfNum("1"));
    }

    @Test
    public void should_return_1_2_3_4_when_to_string() {
        String expected = "1 2 3 4";
        assertEquals(expected, answer.toString());
    }

    @Test
    public void should_return_correct_record_when_check_answer() {
        Record record = new Record();
        record.increaseCurrentNum();
        record.increaseCurrentNum();
        record.increaseCurrentNum();
        record.increaseCurrentNum();

        assertEquals(record.getValue()[0], answer.check(answer).getValue()[0]);
        assertEquals(record.getValue()[1], answer.check(answer).getValue()[1]);
    }

    @Test
    public void should_throw_exception_when_validate_incorrect_answer() {
        numList.set(0, "2");
        answer.setNumList(numList);
        String expected = "Answer format is incorrect";

        try {
            answer.validate();
        } catch (OutOfRangeAnswerException e) {
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    public void should_not_throw_exception_when_validate_correct_format_answer() {
        int num = 0;
        try {
            answer.validate();
        } catch (OutOfRangeAnswerException e) {
            num = 1;
        }

        assertEquals(0, num);
        assertNotEquals(1, num);
    }

    @Test
    public void should_create_correct_answer_when_create() {
        assertEquals(answer.toString(), answer.createAnswer("1 2 3 4").toString());
    }

}