package com.vuerts.weather.utils.logging.impl.standard

import com.vuerts.weather.utils.logging.base.BaseLogger
import com.vuerts.weather.utils.logging.impl.standard.logdestination.base.LogDestination

/**
 * Default implementation of [BaseLogger]
 *
 * @param logDestinations - list of destinations where need to put logs
 */
class StandardLogger(private vararg val logDestinations: LogDestination<*>) : BaseLogger() {

    override fun info(msg: String, ex: Throwable?) {
        val tag = createTag()
        logDestinations.forEach { it.info(tag, msg, ex) }
    }

    override fun info(tag: String, msg: String, ex: Throwable?) {
        logDestinations.forEach { it.info(tag, msg, ex) }
    }

    override fun warn(msg: String, ex: Throwable?) {
        val tag = createTag()
        logDestinations.forEach { it.warn(tag, msg, ex) }
    }

    override fun warn(tag: String, msg: String, ex: Throwable?) {
        logDestinations.forEach { it.warn(tag, msg, ex) }
    }

    override fun debug(msg: String, ex: Throwable?) {
        val tag = createTag()
        logDestinations.forEach { it.debug(tag, msg, ex) }
    }

    override fun debug(tag: String, msg: String, ex: Throwable?) {
        logDestinations.forEach { it.debug(tag, msg, ex) }
    }

    override fun error(msg: String, ex: Throwable?) {
        val tag = createTag()
        logDestinations.forEach { it.error(tag, msg, ex) }
    }

    override fun error(tag: String, msg: String, ex: Throwable?) {
        logDestinations.forEach { it.error(tag, msg, ex) }
    }
}