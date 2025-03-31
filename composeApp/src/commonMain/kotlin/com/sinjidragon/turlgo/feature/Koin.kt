package com.sinjidragon.turlgo.feature

import com.sinjidragon.turlgo.feature.data.login.di.loginRepositoryModule
import com.sinjidragon.turlgo.feature.data.signUp.di.signUpRepositoryModule
import com.sinjidragon.turlgo.feature.network.core.di.coroutineScopeModule
import com.sinjidragon.turlgo.feature.network.core.di.dispatchersModule
import com.sinjidragon.turlgo.feature.network.core.di.networkCoreModule
import com.sinjidragon.turlgo.feature.network.login.di.loginDataSourceModule
import com.sinjidragon.turlgo.feature.network.signup.di.signUPDataSourceModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initKoin(block: KoinApplication.() -> Unit = {}) {
    startKoin {
        modules(
            loginRepositoryModule,
            loginDataSourceModule,
            networkCoreModule,
            dispatchersModule,
            coroutineScopeModule,
            signUpRepositoryModule,
            signUPDataSourceModule
        )
        block()
    }
}
