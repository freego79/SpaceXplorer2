package cz.freego.tutorial.core.data.api

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import cz.freego.tutorial.core.Constants
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import java.io.File

class ApiManager @Inject constructor(
    @ApplicationContext private val context: Context // Přidání kontextu
) {
    // Nastavení cache
    private val cacheDir = File(context.cacheDir, Constants.CACHE_DIR)
    private val cacheSize = Constants.CACHE_SIZE
    private val cache = Cache(cacheDir, cacheSize)

    private val retrofit by lazy {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())  // Přidáme KotlinJsonAdapter pro Moshi
            .build()

        // Vytvoření OkHttp klienta s cache
        val okHttpClient = OkHttpClient.Builder()
            .cache(cache)  // Použití cache
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY // Logování HTTP požadavků
            })
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .header("Cache-Control", "public, max-age=${Constants.CACHE_MAX_AGE_SECS}") // Cache pro 60 sekund
                    .build()
                chain.proceed(request)
            }
            .build()

        Retrofit.Builder()
            .baseUrl(Constants.SPACEX_API_BASE_URL)
            .client(okHttpClient)  // Přidání OkHttp klienta s cache
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val spaceXApi: SpaceXApi by lazy {
        retrofit.create(SpaceXApi::class.java)
    }
}