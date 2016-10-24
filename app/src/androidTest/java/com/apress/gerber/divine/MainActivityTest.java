package com.apress.gerber.divine;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void listsGoesOver() {
        onView(withText("Input your birthday!")).check(matches(isDisplayed()));
    }

    @Test
    public void typetext(){
        onView(withId(R.id.editText))
                .perform(typeText("1019")).check(matches(isDisplayed()));
    }

    @Test
    public void click_test(){
        onView(withId(R.id.editText))
                .perform(typeText("1019"),closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        //クリックしてSubActivityの画面が表示されるか？
        onView(withText("Excellent luck"))
                .check(matches(isDisplayed()));
    }


}
