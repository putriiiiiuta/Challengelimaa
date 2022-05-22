package putriiiiiuta.androidlima.challengelimaa.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import putriiiiiuta.androidlima.challengelimaa.model.FilmRepository
import putriiiiiuta.androidlima.challengelimaa.model.remote.FilmResponse
import putriiiiiuta.androidlima.challengelimaa.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelFilm(): ViewModel()  {

    var liveDataFilm : MutableLiveData<List<FilmResponse>?> = MutableLiveData()

    fun getLiveFilmObserver() : MutableLiveData<List<FilmResponse>?> {
        return liveDataFilm
    }

    fun makeApiFilm(){
        ApiClient.instance.GetDatafilm()
            .enqueue(object : Callback<List<FilmResponse>> {
                override fun onResponse(
                    call: Call<List<FilmResponse>>,
                    response: Response<List<FilmResponse>>
                ) {
                    if (response.isSuccessful){
                        liveDataFilm.postValue(response.body())
                    }else{
                        liveDataFilm.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<FilmResponse>>, t: Throwable) {
                    liveDataFilm.postValue(null)
                }

            })

    }

}