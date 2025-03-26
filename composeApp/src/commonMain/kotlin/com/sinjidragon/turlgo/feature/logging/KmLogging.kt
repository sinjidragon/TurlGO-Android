package com.sinjidragon.turlgo.feature.logging

import androidx.lifecycle.AtomicReference
import kotlin.native.concurrent.ThreadLocal

internal val logFactory: AtomicReference<LogFactory?> = AtomicReference(null)

private val loggers: AtomicReference<List<Logger>> = AtomicReference(emptyList())

@ThreadLocal
object KmLogging {
    private var isLoggingVerbose = true
    private var isLoggingDebug = true
    var isLoggingInfo = true
    private var isLoggingWarning = true
    private var isLoggingError = true

    fun info(tag: String, msg: String) {
        for (logger in loggers.get()) {
            if (logger.isLoggingInfo()) {
                logger.info(tag, msg)
            }
        }
    }

    fun createTag(fromClass: String? = null): Pair<String, String> {
        for (logger in loggers.get()) {
            if (logger is TagProvider) {
                return logger.createTag(fromClass)
            }
        }
        return Pair("", "")
    }

    override fun toString(): String {
        return "KmLogging(verbose:$isLoggingVerbose debug:$isLoggingDebug info:$isLoggingInfo warn:$isLoggingWarning error:$isLoggingError) ${loggers.get()}"
    }
}
