package pust.ice.krypton.pustcontacts.api.Ainterface;

import pust.ice.krypton.pustcontacts.api.Ainterface.Objects.CheckObject;
import pust.ice.krypton.pustcontacts.api.Ainterface.Objects.FetchObject;
import pust.ice.krypton.pustcontacts.pojo.Postpojo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiCall {
    @POST("api/android/get")
    Call<FetchObject> getupdate(@Body Postpojo postpojo);

    @GET("api/android/check")
    Call<CheckObject> performCheck();
}
