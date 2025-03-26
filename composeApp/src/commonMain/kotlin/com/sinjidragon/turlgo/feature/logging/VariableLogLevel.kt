package com.sinjidragon.turlgo.feature.logging

import com.sinjidragon.turlgo.feature.logging.DEBUG_MASK
import com.sinjidragon.turlgo.feature.logging.ERROR_MASK
import com.sinjidragon.turlgo.feature.logging.INFO_MASK
import com.sinjidragon.turlgo.feature.logging.LogLevel
import com.sinjidragon.turlgo.feature.logging.LogLevelController
import com.sinjidragon.turlgo.feature.logging.VERBOSE_MASK
import com.sinjidragon.turlgo.feature.logging.WARN_MASK

class VariableLogLevel(private val level: Int) : LogLevelController {

    constructor(logLevel: LogLevel = LogLevel.Verbose) : this(logLevel.level)

    init {
        KmLogging.setupLoggingFlags()
    }

    override fun isLoggingVerbose() = level and VERBOSE_MASK > 0
    override fun isLoggingDebug() = level and DEBUG_MASK > 0
    override fun isLoggingInfo() = level and INFO_MASK > 0
    override fun isLoggingWarning() = level and WARN_MASK > 0
    override fun isLoggingError() = level and ERROR_MASK > 0

    override fun toString(): String {
        return "VariableLogLevel(level=$level" +
            " verbose:${isLoggingVerbose()} debug:${isLoggingDebug()}" +
            " info:${isLoggingInfo()} warn:${isLoggingWarning()}" +
            " error:${isLoggingError()})"
    }
}
