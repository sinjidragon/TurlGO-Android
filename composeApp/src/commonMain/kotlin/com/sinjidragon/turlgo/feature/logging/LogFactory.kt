package com.sinjidragon.turlgo.feature.logging

import com.sinjidragon.turlgo.feature.logging.KmLog

interface LogFactory {
    fun createKmLog(tag: String, className: String): KmLog
}
