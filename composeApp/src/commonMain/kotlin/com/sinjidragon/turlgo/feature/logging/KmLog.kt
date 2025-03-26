package com.sinjidragon.turlgo.feature.logging

open class KmLog(tag: String) {
    val tagName = tag

    inline fun i(tag: String? = null, msg: () -> Any?) {
        if (KmLogging.isLoggingInfo) {
            infoApi(tag ?: tagName, msg().toString())
        }
    }

    @PublishedApi
    internal fun infoApi(tag: String, msg: String) = info(tag, msg)

    protected open fun info(tag: String, msg: String) {
        KmLogging.info(tag, msg)
    }

    override fun toString(): String {
        return "KmLog(tagName='$tagName')"
    }
}

/**
 * Create a logging object. This is the primary entry point for logging and should be called once for each file, class or object.
 * For classes a val can be created either as a private member of the class or as a member of the companion object.
 * @param tag string to be used instead of the calculated tag based on the class name or file name.
 */
fun logging(tag: String? = null): KmLog {
    if (tag != null) {
        return logFactory.get()?.createKmLog(tag, tag) ?: KmLog(tag)
    }
    val (tagCalculated, className) = KmLogging.createTag("KmLog")
    return logFactory.get()?.createKmLog(tagCalculated, className) ?: KmLog(tagCalculated)
}
