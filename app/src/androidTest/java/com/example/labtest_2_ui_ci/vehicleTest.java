package com.example.labtest_2_ui_ci;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.example.labtest_2_ui_ci.MainActivity;
import com.example.labtest_2_ui_ci.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)

public class vehicleTest{

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void sedan() {
        //clearing the i/p
        Espresso.onView(ViewMatchers.withId(R.id.editTextText4)).perform(ViewActions.clearText());
        Espresso.onView(ViewMatchers.withId(R.id.editTextText5)).perform(ViewActions.clearText());
        Espresso.onView(ViewMatchers.withId(R.id.editTextText6)).perform(ViewActions.clearText());
        // Test EditText input
        Espresso.onView(ViewMatchers.withId(R.id.editTextText4)).perform(ViewActions.typeText("sedan"));
        Espresso.onView(ViewMatchers.withId(R.id.editTextText5)).perform(ViewActions.typeText("red"));
        Espresso.onView(ViewMatchers.withId(R.id.editTextText6)).perform(ViewActions.typeText("5"), ViewActions.closeSoftKeyboard());

        // Test button click
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());

        // Verify TextViews
        Espresso.onView(ViewMatchers.withId(R.id.textView3)).check(ViewAssertions.matches(ViewMatchers.withText("fuel:3.0L milage:5.0m")));
        Espresso.onView(ViewMatchers.withId(R.id.textView4)).check(ViewAssertions.matches(ViewMatchers.withText("red")));
    }

    @Test
    public void suv() {
        //clearing the i/p
        Espresso.onView(ViewMatchers.withId(R.id.editTextText4)).perform(ViewActions.clearText());
        Espresso.onView(ViewMatchers.withId(R.id.editTextText5)).perform(ViewActions.clearText());
        Espresso.onView(ViewMatchers.withId(R.id.editTextText6)).perform(ViewActions.clearText());
        // Test EditText input
        Espresso.onView(ViewMatchers.withId(R.id.editTextText4)).perform(ViewActions.typeText("suv"));
        Espresso.onView(ViewMatchers.withId(R.id.editTextText5)).perform(ViewActions.typeText("blue"));
        Espresso.onView(ViewMatchers.withId(R.id.editTextText6)).perform(ViewActions.typeText("0.0"), ViewActions.closeSoftKeyboard());

        // Test button click
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());

        // Verify TextViews
        Espresso.onView(ViewMatchers.withId(R.id.textView3)).check(ViewAssertions.matches(ViewMatchers.withText("fuel:0.0L milage:0.0m")));
        Espresso.onView(ViewMatchers.withId(R.id.textView4)).check(ViewAssertions.matches(ViewMatchers.withText("blue")));
    }
}
