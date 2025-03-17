package cz.freego.tutorial.core.data.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class ApiManager @Inject constructor() {
    private val BASE_URL = "https://api.spacexdata.com/v4/"

    private val retrofit by lazy {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())  // Přidáme KotlinJsonAdapter pro Moshi
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val spaceXApi: SpaceXApi by lazy {
        retrofit.create(SpaceXApi::class.java)
    }
}