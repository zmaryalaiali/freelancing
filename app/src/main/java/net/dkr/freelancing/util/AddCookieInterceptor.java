package net.dkr.freelancing.util;

import android.content.Context;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AddCookieInterceptor implements Interceptor {
    public static final String PREF_COOKIES = "SHARECOKEI";
    private  Context context;

    public AddCookieInterceptor(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        HashSet<String> preferences = (HashSet<String>)
                PreferenceManager.getDefaultSharedPreferences(context).getStringSet(PREF_COOKIES, new HashSet<String>());

        Request original = chain.request();

            for (String cookie : preferences) {
                builder.addHeader("Cookie", cookie);

        }
        return chain.proceed(builder.build());

    }
}
