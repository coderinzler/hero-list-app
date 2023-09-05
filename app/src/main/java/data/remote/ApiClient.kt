package data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {
    private const val API_BASE_URL = "https://www.superheroapi.com/api.php/"

    var heroService: HeroService? = null

    fun getHeroService(): HeroService {


        val retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(HeroService::class.java) as HeroService
    }

}