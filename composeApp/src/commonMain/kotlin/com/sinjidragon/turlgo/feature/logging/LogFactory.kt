package com.sinjidragon.turlgo.feature.logging

interface LogFactory {
    fun createKmLog(tag: String, className: String): KmLog
}
