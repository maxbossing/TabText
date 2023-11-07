package de.maxbossing.tabtext.data

import de.maxbossing.mxpaper.extensions.kotlin.createIfNotExists
import de.maxbossing.tabtext.tabtext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class Config(
    var header: Part,
    var footer: Part
)

@Serializable
data class Part(
    var raw: String,
    var animated: Boolean,
    var animationSpeed: Float
)

fun loadConfig(): Config {
    val file = File(tabtext.dataFolder, "config.json")
    if (!file.exists()) {
        file.createIfNotExists()
        file.writeText(
            Json.encodeToString(
                Config.serializer(), Config(

                header = Part(
                    raw = "",
                    animated = false,
                    animationSpeed = 0.1f
                ),

                footer = Part(
                    raw = "",
                    animated = false,
                    animationSpeed = 0.1f
                ),
            )
            )
        )
    }
    return Json.decodeFromString(file.readText())
}