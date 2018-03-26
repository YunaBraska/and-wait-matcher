package com.springfrosch.matcher;


import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.util.function.Supplier;

public class AndWait<T> extends TypeSafeDiagnosingMatcher<Supplier<T>> {

    private Matcher<T> expected;
    private int timeoutMs;

    @Override
    protected boolean matchesSafely(final Supplier<T> actual, final Description description) {
        T result = null;
        long finalTime = System.currentTimeMillis() + timeoutMs;
        while (System.currentTimeMillis() < finalTime) {
            result = actual.get();
            if (expected.matches(result)) {
                return true;
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        description
                .appendText("[Timeout]\n")
                .appendText("\nExpected: ")
                .appendDescriptionOf(expected)
                .appendText("\n     but: ");
        expected.describeMismatch(result, description);
        return false;
    }

    @Override
    public void describeTo(final Description description) {

    }

    public static <T> AndWait<T> andWait(final Matcher<T> expected) {
        return new AndWait<>(expected, 15000);
    }

    public static <T> AndWait<T> andWait(final Matcher<T> expected, final int timeoutMs) {
        return new AndWait<>(expected, timeoutMs);
    }

    public AndWait(final Matcher<T> expected) {
        this(expected, 15000);
    }

    public AndWait(final Matcher<T> expected, final int timeoutMs) {
        this.expected = expected;
        this.timeoutMs = timeoutMs;
    }

}
