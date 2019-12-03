package com.licy.getcontextfromprovider.helper;

import android.app.Application;
import android.content.ContentProvider;
import android.content.Context;

/**
 * ContextProvider
 * description: TODO
 *
 * @author : Licy
 * @date : 2019/12/3
 * email ：licy3051@qq.com
 */
public class ContextProvider {

    private static volatile ContextProvider instance;
    private Context mContext;

    private ContextProvider(Context context) {
        this.mContext = context;
    }


    public static ContextProvider get() {
        if (instance == null) {
            synchronized (ContentProvider.class) {
                if (instance == null) {
                    Context context = GetContextProvider.mContext;
                    if (GetContextProvider.mContext == null) {
                        throw new IllegalStateException("Context == null");
                    }
                    instance = new ContextProvider(context);
                }
            }
        }
        return instance;
    }

    public Context getContext() {
        return mContext;
    }

    public Application getApplication() {
        return (Application) mContext.getApplicationContext();
    }
}
