package com.sinjidragon.turlgo.feature.data.signUp.di

import com.sinjidragon.turlgo.feature.data.signUp.repository.SignUpRepository
import com.sinjidragon.turlgo.feature.data.signUp.repositoryImpl.SignUpRepositoryImpl
import com.sinjidragon.turlgo.feature.network.core.DispatcherType
import org.koin.core.qualifier.named
import org.koin.dsl.module

val signUpRepositoryModule = module {
    single<SignUpRepository> {
        SignUpRepositoryImpl(get(), get(named(DispatcherType.IO)))
    }
}