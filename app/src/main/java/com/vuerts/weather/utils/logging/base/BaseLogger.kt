package com.vuerts.weather.utils.logging.base

import com.vuerts.weather.utils.extensions.common.EMPTY
import java.util.regex.Pattern

abstract class BaseLogger {

    private val baseLoggerClass = BaseLogger::class.java
    private val threadClassName = Thread::class.java.name

    /**
     * Generates tag based on a class name where a log function was invoked
     */
    protected fun createTag(): String {
        var tag = Throwable()
            .stackTrace
            .first {
                it.className != threadClassName &&
                        !baseLoggerClass.isAssignableFrom(Class.forName(it.className))
            }
            .className
            .substringAfterLast('.')

        val matcher = ANONYMOUS_CLASS_PATTERN.matcher(tag)

        if (matcher.find()) {
            tag = matcher.replaceAll(String.EMPTY)
        }

        return tag
    }

    abstract fun info(msg: String, ex: Throwable? = null)
    abstract fun info(tag: String, msg: String, ex: Throwable? = null)

    abstract fun warn(msg: String, ex: Throwable? = null)
    abstract fun warn(tag: String, msg: String, ex: Throwable? = null)

    abstract fun debug(msg: String, ex: Throwable? = null)
    abstract fun debug(tag: String, msg: String, ex: Throwable? = null)

    abstract fun error(msg: String, ex: Throwable? = null)
    abstract fun error(tag: String, msg: String, ex: Throwable? = null)

    companion object {

        private val ANONYMOUS_CLASS_PATTERN = Pattern.compile("(\\$\\d+)+$")
    }
}