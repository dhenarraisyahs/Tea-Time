package com.example.android.teatime;


import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.android.teatime.model.Tea;

import java.util.ArrayList;

/**
 * Created by dhenarra on 1/7/18.
 */

public class ImageDownloader {
    final static ArrayList<Tea> mTeas = new ArrayList<>();
    private static final int DELAY_MILLIS = 3000;

    static void downloadImage(Context context, final DelayerCallback callback, @Nullable final IdlingResource idleResource) {
        if (idleResource != null)
            idleResource.setIdleState(false);
        String text = context.getString(R.string.loading_message);
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        mTeas.add(new Tea(context.getString(R.string.black_tea_name), R.drawable.black_tea));
        mTeas.add(new Tea(context.getString(R.string.green_tea_name), R.drawable.green_tea));
        mTeas.add(new Tea(context.getString(R.string.white_tea_name), R.drawable.white_tea));
        mTeas.add(new Tea(context.getString(R.string.oolong_tea_name), R.drawable.oolong_tea));
        mTeas.add(new Tea(context.getString(R.string.honey_lemon_tea_name), R.drawable.honey_lemon_tea));
        mTeas.add(new Tea(context.getString(R.string.chamomile_tea_name), R.drawable.chamomile_tea));

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onDone(mTeas);
                if (idleResource != null) {
                    idleResource.setIdleState(true);
                }
            }
        }, DELAY_MILLIS);
    }

    interface DelayerCallback {
        void onDone(ArrayList<Tea> teas);
    }
}
