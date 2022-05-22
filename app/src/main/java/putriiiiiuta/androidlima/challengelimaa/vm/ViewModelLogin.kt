package putriiiiiuta.androidlima.challengelimaa.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import putriiiiiuta.androidlima.challengelimaa.model.remote.LoginResponse
import putriiiiiuta.androidlima.challengelimaa.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelLogin : ViewModel() {

    var liveDataLoginResponse : MutableLiveData<LoginResponse?> = MutableLiveData()

    fun loginData(email: String, password: String){
        viewModelScope.launch {
            ApiClient.instance.loginUser(email, password)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        if(response.isSuccessful){
                            liveDataLoginResponse.postValue(response.body())
                        }else{
                            liveDataLoginResponse.postValue(null)
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        liveDataLoginResponse.postValue(null)
                    }
                })
        }
    }
}