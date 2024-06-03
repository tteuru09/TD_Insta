package api

import retrofit2.Call
import retrofit2.http.GET

import java.util.List;

interface JsonPlaceholderApi {
    @GET("posts")
    fun getPosts(): Call<List<Article>>
}