package com.smokeeaasd.failoverredirect

import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.plugin.annotation.DataDirectory
import com.velocitypowered.api.proxy.ProxyServer
import org.slf4j.Logger
import java.nio.file.Path
import javax.inject.Inject

@Plugin(
    id = "failoverredirect",
    name = "FailoverRedirect",
    version = "1.0.0",
    authors = ["smokeeaasd"]
)
class FailoverRedirectPlugin @Inject constructor(
    private val server: ProxyServer,
    private val logger: Logger,
    @DataDirectory private val dataDirectory: Path
) {
    @Subscribe
    fun onInit(event: ProxyInitializeEvent) {
        logger.info("FailoverRedirect started successfully!")
    }
}
