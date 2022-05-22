package putriiiiiuta.androidlima.challengelimaa.network

import putriiiiiuta.androidlima.challengelimaa.model.remote.*
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("apifilm.php")
    fun GetDatafilm() : retrofit2.Call<List<FilmResponse>>

    @POST("register.php")
    @FormUrlEncoded
    fun addRegister(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") pasword: String,
    ): retrofit2.Call<RegisterResponse>

    @POST("login.php")
    @FormUrlEncoded
    fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String
    ): retrofit2.Call<LoginResponse>

    @GET("apiuser.php")
    fun listUser(): Call<List<UserResponse>>

    @POST("detailuser.php")
    @FormUrlEncoded
    fun detailUser(
        @Field("id") id: Int
    ):retrofit2.Call<List<DetailUserResponse>>

    @POST("updateuser.php")
    @FormUrlEncoded
    fun updateUser(
        @Field("id")id : String,
        @Field("complete_name")completename : String,
        @Field("username")username : String,
        @Field("address")adress : String,
        @Field("dateofbirth")birthday : String
    ): retrofit2.Call<UpdateUserResponse>
}