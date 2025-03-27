package com.sinjidragon.turlgo.feature.network.login.di

import com.sinjidragon.turlgo.feature.network.login.api.LoginService
import com.sinjidragon.turlgo.feature.network.login.dataStore.LoginDataSource
import org.koin.dsl.module

val loginDataSourceModule = module {
    single<LoginDataSource> {
        LoginService(get())
    }
}
