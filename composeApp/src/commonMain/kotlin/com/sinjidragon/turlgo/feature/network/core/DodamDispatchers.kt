package com.sinjidragon.turlgo.feature.network.core

@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatcherType: DispatcherType)

enum class DispatcherType {
    Default,
    IO,
}
