package com.sinjidragon.turlgo.feature.network.signup.di

import com.sinjidragon.turlgo.feature.network.signup.api.SignUpService
import com.sinjidragon.turlgo.feature.network.signup.dataSource.SignUpDataSource
import org.koin.dsl.module

val signUPDataSourceModule = module {
    single<SignUpDataSource> {
        SignUpService(get())
    }
}
