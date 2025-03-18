package cz.freego.tutorial.core.di

import android.content.Context
import cz.freego.tutorial.core.data.api.ApiManager
import cz.freego.tutorial.core.data.api.SpaceXApi
import cz.freego.tutorial.core.data.repository.CapsuleRepository
import cz.freego.tutorial.core.data.repository.CompanyRepository
import cz.freego.tutorial.core.data.repository.CrewRepository
import cz.freego.tutorial.core.data.repository.DragonRepository
import cz.freego.tutorial.core.data.repository.RocketRepository
import cz.freego.tutorial.core.data.repository.ShipRepository
import cz.freego.tutorial.core.domain.GetCapsuleUseCase
import cz.freego.tutorial.core.domain.GetCompanyUseCase
import cz.freego.tutorial.core.domain.GetCrewUseCase
import cz.freego.tutorial.core.domain.GetDragonUseCase
import cz.freego.tutorial.core.domain.GetRocketUseCase
import cz.freego.tutorial.core.domain.GetShipUseCase
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
    fun provideCompanyRepository(api: SpaceXApi) = CompanyRepository(api)

    @Provides
    fun provideGetCompanyUseCase(repository: CompanyRepository) = GetCompanyUseCase(repository)

    // --- Crew Repository + UseCase ---

    @Provides
    @Singleton
    fun provideCrewRepository(api: SpaceXApi): CrewRepository {
        return CrewRepository(api)
    }

    @Provides
    fun provideGetCrewUseCase(repository: CrewRepository): GetCrewUseCase {
        return GetCrewUseCase(repository)
    }

    // --- Rocket Repository + UseCase ---

    @Provides
    @Singleton
    fun provideRocketRepository(api: SpaceXApi): RocketRepository {
        return RocketRepository(api)
    }

    @Provides
    fun provideGetRocketUseCase(repository: RocketRepository): GetRocketUseCase {
        return GetRocketUseCase(repository)
    }

    // --- Dragon Repository + UseCase ---

    @Provides
    @Singleton
    fun provideDragonRepository(api: SpaceXApi): DragonRepository {
        return DragonRepository(api)
    }

    @Provides
    fun provideGetDragonUseCase(repository: DragonRepository): GetDragonUseCase {
        return GetDragonUseCase(repository)
    }

    // --- Capsule Repository + UseCase ---

    @Provides
    @Singleton
    fun provideCapsuleRepository(api: SpaceXApi): CapsuleRepository {
        return CapsuleRepository(api)
    }

    @Provides
    fun provideGetCapsuleUseCase(repository: CapsuleRepository): GetCapsuleUseCase {
        return GetCapsuleUseCase(repository)
    }

    // --- Ship Repository + UseCase ---

    @Provides
    @Singleton
    fun provideShipRepository(api: SpaceXApi): ShipRepository {
        return ShipRepository(api)
    }

    @Provides
    fun provideGetShipUseCase(repository: ShipRepository): GetShipUseCase {
        return GetShipUseCase(repository)
    }

}