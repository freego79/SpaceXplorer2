package cz.freego.tutorial.core.di

import android.content.Context
import cz.freego.tutorial.core.data.api.ApiManager
import cz.freego.tutorial.core.data.api.SpaceXApi
import cz.freego.tutorial.core.data.repository.CompanyRepository
import cz.freego.tutorial.core.data.repository.CrewRepository
import cz.freego.tutorial.core.domain.GetCompanyUseCase
import cz.freego.tutorial.core.domain.GetCrewUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideSpaceXApi(apiManager: ApiManager): SpaceXApi = apiManager.spaceXApi

    @Provides
    @Singleton
    fun provideApiManager(@ApplicationContext context: Context): ApiManager = ApiManager(context)

    @Provides
    @Singleton
    fun provideCompanyRepository(api: SpaceXApi) = CompanyRepository(api)

    @Provides
    fun provideGetCompanyUseCase(repository: CompanyRepository) = GetCompanyUseCase(repository)

    @Provides
    @Singleton
    fun provideCrewRepository(api: SpaceXApi): CrewRepository {
        return CrewRepository(api)
    }

    @Provides
    fun provideGetCrewUseCase(repository: CrewRepository): GetCrewUseCase {
        return GetCrewUseCase(repository)
    }
}