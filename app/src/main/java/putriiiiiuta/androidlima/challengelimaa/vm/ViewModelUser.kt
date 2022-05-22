package putriiiiiuta.androidlima.challengelimaa.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import putriiiiiuta.androidlima.challengelimaa.model.remote.UserResponse
import putriiiiiuta.androidlima.challengelimaa.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelUser: ViewModel() {

    var liveDataUser : MutableLiveData<List<UserResponse>?> = MutableLiveData()


    fun getLiveDataUserObserver() : MutableLiveData<List<UserResponse>?> {
        return liveDataUser
    }

    fun getUserData(){
        viewModelScope.launch {
            ApiClient.instance.listUser()
                .enqueue(object : Callback<List<UserResponse>>{
                    override fun onResponse(
                        call: Call<List<UserResponse>>,
                        response: Response<List<UserResponse>>
                    ) {
                        if(response.isSuccessful){
                            liveDataUser.postValue(response.body())
                        }else{
                            liveDataUser.postValue(null)
                        }
                    }

                    override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {
                        liveDataUser.postValue(null)
                    }

                })
        }
    }

}