package pust.ice.krypton.pustcontacts.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import pust.ice.krypton.pustcontacts.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    public static String Token = null;
//    public static String URL = "http://pust.ac.bd/"; // exclude https to support android 4.4
//    public static String URL = "http://192.168.25.100:8000/";

    private static Retrofit rf;


    public static Retrofit getInstance() {

        Retrofit retrofit = rf;
        if (retrofit != null) {
            return retrofit;
        }
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();
            rf = new Builder().baseUrl(BuildConfig.URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        } else {
            rf = new Builder().baseUrl(BuildConfig.URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return rf;
    }

    public static <S> S createService(Class<S> cls) {
        getInstance();
        return rf.create(cls);
    }
}
