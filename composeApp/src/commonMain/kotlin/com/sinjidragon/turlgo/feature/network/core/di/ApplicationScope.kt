package com.sinjidragon.turlgo.feature.network.core.di

import com.sinjidragon.turlgo.feature.network.core.DispatcherType
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.core.qualifier.named
import org.koin.dsl.module

val coroutineScopeModule = module {
    single<CoroutineScope> {
        val dispatcher: CoroutineDispatcher = get(named(DispatcherType.Default))
        CoroutineScope(SupervisorJob() + dispatcher)
    }
}
