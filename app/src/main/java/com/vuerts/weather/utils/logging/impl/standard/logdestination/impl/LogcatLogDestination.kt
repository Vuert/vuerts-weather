package com.vuerts.weather.utils.logging.impl.standard.logdestination.impl

import android.os.Build
import android.util.Log
import com.vuerts.weather.utils.logging.impl.standard.logdestination.base.LogDestination
import kotlin.math.ceil

class LogcatLogDestination : LogDestination<Int>() {

    override fun info(tag: String, msg: String, ex: Throwable?) {
        prepareLog(Log.INFO, tag, msg, ex)
    }

    override fun warn(tag: String, msg: String, ex: Throwable?) {
        prepareLog(Log.WARN, tag, msg, ex)
    }

    override fun debug(tag: String, msg: String, ex: Throwable?) {
        prepareLog(Log.DEBUG, tag, msg, ex)
    }

    override fun error(tag: String, msg: String, ex: Throwable?) {
        prepareLog(Log.ERROR, tag, msg, ex)
    }

    override fun log(priority: Int, tag: String, message: String) {
        // Limitation was removed in Android Oreo (API 26)
        val validTag =
            if (tag.length <= MAX_TAG_LENGTH ||
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
            ) {
                tag
            } else {
                tag.substring(0, MAX_TAG_LENGTH)
            }

        if (message.length <= MAX_LOG_LENGTH) {
            Log.println(priority, validTag, message)
        } else {
            // Separates message into parts and log them separately

            val messageParts = ceil(message.length.toDouble() / MAX_LOG_LENGTH).toInt()

            var startIndex = 0
            var endIndex = MAX_LOG_LENGTH - 1

            Log.println(priority, validTag, "----- Beginning of separated log -----")
            repeat(messageParts) {
                Log.println(priority, validTag, message.substring(startIndex, endIndex))
                startIndex += MAX_LOG_LENGTH
                endIndex += MAX_LOG_LENGTH

                if (endIndex > message.lastIndex) {
                    endIndex = message.lastIndex
                }
            }
            Log.println(priority, validTag, "-----  Ending of separated log   -----")
        }
    }

    companion object {

        // Logcat limitations in android
        private const val MAX_LOG_LENGTH = 4000
        private const val MAX_TAG_LENGTH = 23
    }
}