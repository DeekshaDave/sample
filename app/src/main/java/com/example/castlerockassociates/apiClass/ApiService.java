package com.example.castlerockassociates.apiClass;

import com.example.castlerockassociates.model.SignsData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("signs")
    Call<List<SignsData>> getSigns();

}
