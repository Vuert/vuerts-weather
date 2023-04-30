package com.vuerts.weather.utils.logging.impl.standard.logdestination.base

import java.io.PrintWriter
import java.io.StringWriter

/**
 * Denotes logs destinations, for example logcat, file, firebase etc.
 *
 * @param LogPriorityType - type of log levels, might be different because
 * it depends on implementation
 */
abstract class LogDestination<LogPriorityType : Any> {

    /**
     * Retrieves stacktrace from exception
     */
    private fun getStackTraceString(throwable: Throwable): String =
        StringWriter(STRING_WRITER_SIZE).use { writer ->
            PrintWriter(writer, false).use { printer ->
                throwable.printStackTrace(printer)
                printer.flush()
                writer.toString()
            }
        }

    /**
     * Creates log message and log it
     */
    protected fun prepareLog(
        priority: LogPriorityType,
        tag: String,
        message: String,
        throwable: Throwable?,
    ) {
        var msg = message

        if (msg.isEmpty()) {
            throwable ?: return
            msg = getStackTraceString(throwable)
        } else {
            if (throwable != null) {
                msg += "\n" + getStackTraceString(throwable)
            }
        }

        log(priority, tag, msg)
    }

    abstract fun info(tag: String, msg: String, ex: Throwable? = null)
    abstract fun warn(tag: String, msg: String, ex: Throwable? = null)
    abstract fun debug(tag: String, msg: String, ex: Throwable? = null)
    abstract fun error(tag: String, msg: String, ex: Throwable? = null)

    protected abstract fun log(priority: LogPriorityType, tag: String, message: String)

    companion object {

        private const val STRING_WRITER_SIZE = 256
    }
}