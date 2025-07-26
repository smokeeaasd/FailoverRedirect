package com.smokeeaasd.failoverredirect

import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.plugin.annotation.DataDirectory
import com.velocitypowered.api.proxy.ProxyServer
import org.slf4j.Logger
import java.nio.file.Files
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
    saveResource("config.yml", false)
    logger.info("FailoverRedirect started successfully!")
  }

  private fun saveResource(name: String, replaceIfExists: Boolean = false) {
    val targetFile = dataDirectory.resolve(name)

    if (Files.notExists(targetFile) || replaceIfExists) {
      Files.createDirectories(dataDirectory)

      val inputStream = javaClass.getResourceAsStream("/$name")
        ?: throw IllegalStateException("Resource $name not found in jar")

      inputStream.use { input ->
        Files.newOutputStream(targetFile).use { output ->
          input.copyTo(output)
        }
      }
    }
  }
}