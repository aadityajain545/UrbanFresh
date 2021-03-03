package com.test.uebanfresh.api;


import com.test.uebanfresh.model.HomeScreenApiModel;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @POST("api/home_test_section?category_id=2")
    Call<HomeScreenApiModel> getHomeApiData();
}
