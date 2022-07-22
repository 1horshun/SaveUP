package com.horshun.saveup.di

import com.horshun.core.data.repository.ActivityRepositoryImpl
import com.horshun.core.data.repository.DataStoreRepositoryImpl
import com.horshun.core.data.source.local.data_store.DataStoreSource
import com.horshun.core.data.source.local.data_store.IDataStoreSource
import com.horshun.core.data.source.local.database.ILocalDataSource
import com.horshun.core.data.source.local.database.LocalDataSource
import com.horshun.core.domain.repository.ActivityRepository
import com.horshun.core.domain.repository.DataStoreRepository
import com.horshun.core.domain.use_case.*
import com.horshun.core.domain.use_case.interactors.*
import com.horshun.saveup.AppDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single<IDataStoreSource> { DataStoreSource(androidContext().AppDataStore) }
    single<ILocalDataSource> { LocalDataSource(get()) }
    single<DataStoreRepository> { DataStoreRepositoryImpl(get()) }
    single<ActivityRepository> { ActivityRepositoryImpl(get()) }
}

val useCaseModule = module {
    factory<OnBoardingUseCase> { OnBoardingInteractor(get()) }
    factory<SplashUseCase> { SplashInteractor(get()) }
    factory<HomeUseCase> { HomeInteractor(get(), get()) }
    factory<AddUseCase> { AddInteractor(get()) }
    factory<ArticleUseCase> { ArticleInteractor(get()) }
    factory<EditNameUseCase> { EditNameInteractor(get()) }
    factory<ProfileUseCase> { ProfileInteractor(get()) }
}