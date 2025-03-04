package com.example.swtandroidtest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testAddition() {
        // Click 2
        onView(withId(R.id.button2)).perform(click());

        // Click +
        onView(withId(R.id.buttonAdd)).perform(click());

        // Click 3
        onView(withId(R.id.button3)).perform(click());

        // Click =
        onView(withId(R.id.buttonEquals)).perform(click());

        // Check if the result is 5
        onView(withId(R.id.resultTextView)).check(matches(withText("5.0")));
    }

    @Test
    public void testSubtraction() {
        // Click 7
        onView(withId(R.id.button7)).perform(click());

        // Click -
        onView(withId(R.id.buttonSubtract)).perform(click());

        // Click 4
        onView(withId(R.id.button4)).perform(click());

        // Click =
        onView(withId(R.id.buttonEquals)).perform(click());

        // Check if the result is 3
        onView(withId(R.id.resultTextView)).check(matches(withText("3.0")));
    }

    @Test
    public void testMultiplication() {
        // Click 5
        onView(withId(R.id.button5)).perform(click());

        // Click *
        onView(withId(R.id.buttonMultiply)).perform(click());

        // Click 6
        onView(withId(R.id.button6)).perform(click());

        // Click =
        onView(withId(R.id.buttonEquals)).perform(click());

        // Check if the result is 30
        onView(withId(R.id.resultTextView)).check(matches(withText("30.0")));
    }

    @Test
    public void testDivision() {
        // Click 8
        onView(withId(R.id.button8)).perform(click());

        // Click /
        onView(withId(R.id.buttonDivide)).perform(click());

        // Click 2
        onView(withId(R.id.button2)).perform(click());

        // Click =
        onView(withId(R.id.buttonEquals)).perform(click());

        // Check if the result is 4
        onView(withId(R.id.resultTextView)).check(matches(withText("4.0")));
    }

    @Test
    public void testClearButton() {
        // Click 9
        onView(withId(R.id.button9)).perform(click());

        // Click C
        onView(withId(R.id.buttonClear)).perform(click());

        // Check if the result is 0
        onView(withId(R.id.resultTextView)).check(matches(withText("0")));
    }
    @Test
    public void testDivisionv2() {
        // Click 8
        onView(withId(R.id.button8)).perform(click());

        // Click /
        onView(withId(R.id.buttonDivide)).perform(click());

        // Click 2
        onView(withId(R.id.button2)).perform(click());

        // Click =
        onView(withId(R.id.buttonEquals)).perform(click());

        // Check if the result is 4
        onView(withId(R.id.resultTextView)).check(matches(withText("5.0")));
    }
}