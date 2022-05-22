package putriiiiiuta.androidlima.challengelimaa.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import putriiiiiuta.androidlima.challengelimaa.model.remote.RegisterResponse
import putriiiiiuta.androidlima.challengelimaa.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelRegister : ViewModel() {
    var liveRegisterResponse : MutableLiveData<RegisterResponse?> = MutableLiveData()

    fun getliveRegisterObserver() : MutableLiveData<RegisterResponse?> {
        return liveRegisterResponse
    }
    fun RegisterApi(username: String, email: String, password: String){
        viewModelScope.launch {
            ApiClient.instance.addRegister(username, email, password)
                .enqueue(object : Callback<RegisterResponse> {
                    override fun onResponse(
                        call: Call<RegisterResponse>,
                        response: Response<RegisterResponse>
                    ) {
                        if (response.isSuccessful){
                            liveRegisterResponse.postValue(response.body())
                        }else{
                            liveRegisterResponse.postValue(null)
                        }
                    }

                    override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                        liveRegisterResponse.postValue(null)
                    }
                })
        }
    }
}