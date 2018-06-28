package com.example.eminesezer.requesterwithvolley.patternpackage;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class RequesterQue {
    private static RequesterQue mAppSingletonInstance;
    private RequestQueue mRequestQueue;
    private static Context mContext;

    private RequesterQue(Context context) {
        mContext = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized RequesterQue getInstance(Context context) {
        if (mAppSingletonInstance == null) {
            mAppSingletonInstance = new RequesterQue(context);
        }
        return mAppSingletonInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        mRequestQueue.add( req );
    }

}
