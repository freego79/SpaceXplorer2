package cz.freego.tutorial.core.di

import cz.freego.tutorial.core.data.api.ApiManager
import cz.freego.tutorial.core.data.api.SpaceXApi
import cz.freego.tutorial.core.data.repository.CompanyRepository
import cz.freego.tutorial.core.domain.GetCompanyUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideSpaceXApi() = ApiManager().spaceXApi

    @Provides
    @Singleton
    fun provideCompanyRepository(api: SpaceXApi) = CompanyRepository(api)

    @Provides
    fun provideGetCompanyUseCase(repository: CompanyRepository) = GetCompanyUseCase(repository)
}