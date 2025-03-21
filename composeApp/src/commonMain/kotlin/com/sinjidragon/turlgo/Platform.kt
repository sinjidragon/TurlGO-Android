package com.sinjidragon.turlgo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform