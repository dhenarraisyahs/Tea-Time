package com.example.android.teatime;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;

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
        mIdlingResource = menuActivityTestRule.getActivity().getIdlingResource();
        Espresso.registerIdlingResources(mIdlingResource);
    }

    @Test
    public void idlingResourceTest() {
        onData(anything()).inAdapterView(withId(R.id.tea_grid_view)).atPosition(0).perform(click());
    }

    @After
    public void unregisterIdlingResource() {
        if (mIdlingResource != null)
            Espresso.unregisterIdlingResources(mIdlingResource);
    }
}
