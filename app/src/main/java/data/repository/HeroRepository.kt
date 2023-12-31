package data.repository

import data.model.Hero
import data.model.HeroResponse
import data.remote.ApiClient
import data.remote.HeroService
import utils.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroRepository(val heroService: HeroService = ApiClient.getHeroService()) {
    fun searchByName(name: String, callback: (Result<List<Hero>>) -> Unit) {
        val searchByName = heroService.searchByName(textQuery = name)
        searchByName.enqueue(object: Callback<HeroResponse>{
            override fun onResponse(call: Call<HeroResponse>, response: Response<HeroResponse>) {
                if(response.isSuccessful){
                    callback(Result.Success(response.body()!!.heroes))
                }

            }

            override fun onFailure(call: Call<HeroResponse>, t: Throwable) {
                callback(Result.Error(t.localizedMessage))
            }
        })
    }
}