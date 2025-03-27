package com.sinjidragon.turlgo.feature.data.login.di

import com.sinjidragon.turlgo.feature.data.login.repository.LoginRepository
import com.sinjidragon.turlgo.feature.data.login.repositoryimpl.LoginRepositoryImpl
import com.sinjidragon.turlgo.feature.network.core.DispatcherType
import org.koin.core.qualifier.named
import org.koin.dsl.module

val loginRepositoryModule = module {
    single<LoginRepository> {
        LoginRepositoryImpl(get(), get(named(DispatcherType.IO)))
    }
}
