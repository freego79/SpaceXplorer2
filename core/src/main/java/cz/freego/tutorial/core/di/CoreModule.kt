package cz.freego.tutorial.core.di

import android.content.Context
import cz.freego.tutorial.core.data.api.ApiManager
import cz.freego.tutorial.core.data.api.SpaceXApi
import cz.freego.tutorial.core.data.repository.QueryCapsulesRepository
import cz.freego.tutorial.core.data.repository.GetCompanyRepository
import cz.freego.tutorial.core.data.repository.GetCrewRepository
import cz.freego.tutorial.core.data.repository.QueryCrewsRepository
import cz.freego.tutorial.core.data.repository.QueryDragonsRepository
import cz.freego.tutorial.core.data.repository.QueryLandpadsRepository
import cz.freego.tutorial.core.data.repository.QueryLaunchpadsRepository
import cz.freego.tutorial.core.data.repository.QueryRocketsRepository
import cz.freego.tutorial.core.data.repository.QueryShipsRepository
import cz.freego.tutorial.core.domain.QueryCapsulesUseCase
import cz.freego.tutorial.core.domain.GetCompanyUseCase
import cz.freego.tutorial.core.domain.GetCrewUseCase
import cz.freego.tutorial.core.domain.QueryCrewsUseCase
import cz.freego.tutorial.core.domain.QueryDragonsUseCase
import cz.freego.tutorial.core.domain.QueryLandpadsUseCase
import cz.freego.tutorial.core.domain.QueryLaunchpadsUseCase
import cz.freego.tutorial.core.domain.QueryRocketsUseCase
import cz.freego.tutorial.core.domain.QueryShipsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    // --- SpaceXApi + ApiManager ---
    @Provides
    @Singleton
    fun provideSpaceXApi(apiManager: ApiManager): SpaceXApi = apiManager.spaceXApi

    @Provides
    @Singleton
    fun provideApiManager(@ApplicationContext context: Context): ApiManager = ApiManager(context)

    // --- Company Repository + UseCase ---

    @Provides
    @Singleton
    fun provideGetCompanyRepository(api: SpaceXApi) = GetCompanyRepository(api)

    @Provides
    fun provideGetCompanyUseCase(repository: GetCompanyRepository) = GetCompanyUseCase(repository)

    // --- Crew Repository + UseCase ---

    @Provides
    @Singleton
    fun provideGetCrewRepository(api: SpaceXApi) = GetCrewRepository(api)

    @Provides
    fun provideGetCrewUseCase(repository: GetCrewRepository) = GetCrewUseCase(repository)

    // --- Crews Repository + UseCase ---

    @Provides
    @Singleton
    fun provideQueryCrewsRepository(api: SpaceXApi): QueryCrewsRepository {
        return QueryCrewsRepository(api)
    }

    @Provides
    fun provideQueryCrewsUseCase(repository: QueryCrewsRepository): QueryCrewsUseCase {
        return QueryCrewsUseCase(repository)
    }

    // --- Rockets Repository + UseCase ---

    @Provides
    @Singleton
    fun provideQueryRocketsRepository(api: SpaceXApi): QueryRocketsRepository {
        return QueryRocketsRepository(api)
    }

    @Provides
    fun provideQueryRocketsUseCase(repository: QueryRocketsRepository): QueryRocketsUseCase {
        return QueryRocketsUseCase(repository)
    }

    // --- Dragons Repository + UseCase ---

    @Provides
    @Singleton
    fun provideQueryDragonsRepository(api: SpaceXApi): QueryDragonsRepository {
        return QueryDragonsRepository(api)
    }

    @Provides
    fun provideQueryDragonsUseCase(repository: QueryDragonsRepository): QueryDragonsUseCase {
        return QueryDragonsUseCase(repository)
    }

    // --- Capsules Repository + UseCase ---

    @Provides
    @Singleton
    fun provideQueryCapsulesRepository(api: SpaceXApi): QueryCapsulesRepository {
        return QueryCapsulesRepository(api)
    }

    @Provides
    fun provideQueryCapsulesUseCase(repository: QueryCapsulesRepository): QueryCapsulesUseCase {
        return QueryCapsulesUseCase(repository)
    }

    // --- Ships Repository + UseCase ---

    @Provides
    @Singleton
    fun provideQueryShipsRepository(api: SpaceXApi): QueryShipsRepository {
        return QueryShipsRepository(api)
    }

    @Provides
    fun provideQueryShipsUseCase(repository: QueryShipsRepository): QueryShipsUseCase {
        return QueryShipsUseCase(repository)
    }

    // --- Launchpads Repository + UseCase ---

    @Provides
    @Singleton
    fun provideQueryLaunchpadsRepository(api: SpaceXApi): QueryLaunchpadsRepository {
        return QueryLaunchpadsRepository(api)
    }

    @Provides
    fun provideQueryLaunchpadsUseCase(repository: QueryLaunchpadsRepository): QueryLaunchpadsUseCase {
        return QueryLaunchpadsUseCase(repository)
    }

    // --- Landpads Repository + UseCase ---

    @Provides
    @Singleton
    fun provideQueryLandpadsRepository(api: SpaceXApi): QueryLandpadsRepository {
        return QueryLandpadsRepository(api)
    }

    @Provides
    fun provideQueryLandpadsUseCase(repository: QueryLandpadsRepository): QueryLandpadsUseCase {
        return QueryLandpadsUseCase(repository)
    }

}