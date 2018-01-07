package com.example.android.teatime;

import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by dhenarra on 1/7/18.
 */

@RunWith(JUnit4.class)
public class IdlingResourceActivityTest {

    @Rule
    public ActivityTestRule<MenuActivity> menuActivityTestRule = new ActivityTestRule<>(MenuActivity.class);

    private IdlingResource mIdlingResource;

    @Before
    public void registerIdlingResource() {

    }

    @Test
    public void idlingResourceTest() {

    }

    @After
    public void unregisterIdlingResource() {

    }
}
