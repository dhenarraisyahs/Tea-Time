package com.example.android.teatime;

import java.util.concurrent.atomic.AtomicBoolean;

import javax.annotation.Nullable;

/**
 * Created by dhenarra on 1/7/18.
 */

public class IdlingResource implements android.support.test.espresso.IdlingResource {

    @Nullable
    private volatile ResourceCallback mCallback;
    private AtomicBoolean mIsIdleNow = new AtomicBoolean(true);

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public boolean isIdleNow() {
        return mIsIdleNow.get();
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        mCallback = callback;
    }

    public void setIdleState(boolean isIdleNow) {
        mIsIdleNow.set(isIdleNow);
        if (isIdleNow && mCallback != null)
            mCallback.onTransitionToIdle();
    }
}
