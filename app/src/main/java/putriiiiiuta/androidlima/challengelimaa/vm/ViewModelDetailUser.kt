package putriiiiiuta.androidlima.challengelimaa.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import putriiiiiuta.androidlima.challengelimaa.model.remote.DetailUserResponse
import putriiiiiuta.androidlima.challengelimaa.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelDetailUser : ViewModel() {

    var liveDataDetailResponse: MutableLiveData<List<DetailUserResponse>?> = MutableLiveData()

    fun getDetailObserver(): MutableLiveData<List<DetailUserResponse>?>{
        return liveDataDetailResponse
    }

    fun detailUser(id: Int){
        ApiClient.instance.detailUser(id)
            .enqueue(object: Callback<List<DetailUserResponse>>{
                override fun onResponse(
                    call: Call<List<DetailUserResponse>>,
                    response: Response<List<DetailUserResponse>>
                ) {
                    if(response.isSuccessful){
                        liveDataDetailResponse.postValue(response.body())
                    }else{
                        liveDataDetailResponse.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<DetailUserResponse>>, t: Throwable) {
                    liveDataDetailResponse.postValue(null)
                }

            })
    }
}