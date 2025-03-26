package com.sinjidragon.turlgo.feature.logging

interface Logger : LogLevelController {
    fun info(tag: String, msg: String)
}
