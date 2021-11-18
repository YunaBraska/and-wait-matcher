package berlin.yuna.hamcrest.matcher;

import org.hamcrest.StringDescription;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static berlin.yuna.hamcrest.matcher.AndWait.andWait;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@Tag("UnitTest")
class AndWaitTest {

    private static final Random random = new Random(10);

    @Test
    void matcherShouldWait_UntilTheFunctionReturnsExpectedValue() {
        assertThat(this::receiveMessage, andWait(is(equalTo("Howdy"))));
    }

    @Test
    void matcherShouldWait_withCustomTimeOut_shouldFailWithTimeout() {
        AssertionError assertionError = null;
        try {
            assertThat(this::receiveMessage, andWait(is(equalTo("unknown message")), 500));
        } catch (AssertionError ae) {
            assertionError = ae;
        } finally {
            assertTimeout(assertionError);
        }
    }

    @Test
    void matcherShouldWait_withDefaultTimeOut_shouldFailWithTimeout() {
        AssertionError assertionError = null;
        try {
            assertThat(this::receiveMessage, andWait(is(equalTo("unknown message"))));
        } catch (AssertionError ae) {
            assertionError = ae;
        } finally {
            assertTimeout(assertionError);
        }
    }

    @Test
    void instanceShouldWork() {
        final AndWait<String> andWait = new AndWait<>(is("howdy"));
        andWait.matchesSafely(() -> "howdy", new StringDescription());
    }

    private String receiveMessage() {
        sleep();
        final int messageId = random.nextInt(50);
        return (messageId == 5 ? "Howdy" : "other message");
    }

    private void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void assertTimeout(final AssertionError assertionError) {
        assertThat(assertionError, is(notNullValue()));
        assertThat(assertionError.getMessage(), containsString("\n" +
                "Expected: \n" +
                "     but: [Timeout]\n" +
                "\n" +
                "Expected: is \"unknown message\"\n" +
                "     but: was \"other message\""));
    }
}
