package com.springfrosch.matcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Random;

import static com.springfrosch.matcher.AndWait.andWait;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class AndWaitTest {

    private static final Random random = new Random(10);

    @Test
    public void matcherShouldWait_UntilTheFunctionReturnsExpectedValue() {
        assertThat(this::receiveMessage, andWait(is(equalTo("Howdy"))));
    }

    @Test
    public void matcherShouldWait_AndFailWithTimeout() {
        AssertionError assertionError = null;
        try {
            assertThat(this::receiveMessage, andWait(is(equalTo("unknown message")), 500));
        } catch (AssertionError ae) {
            assertionError = ae;
        } finally {
            assertThat(assertionError, is(notNullValue()));
            assertThat(assertionError.getMessage(), containsString("\n" +
                    "Expected: \n" +
                    "     but: [Timeout]\n" +
                    "\n" +
                    "Expected: is \"unknown message\"\n" +
                    "     but: was \"other message\""));
        }
    }

    private String receiveMessage() {
        sleep();
        int messageId = random.nextInt(50);
        return (messageId == 5 ? "Howdy" : "other message");
    }

    private void sleep() {
        try {
            Thread.sleep((long) 10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
