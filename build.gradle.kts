import net.minecrell.pluginyml.bukkit.BukkitPluginDescription
plugins {
    kotlin("jvm") version "1.9.20"
    kotlin("plugin.serialization") version "1.6.0"

    id("io.papermc.paperweight.userdev") version "1.5.9"
    id("xyz.jpenilla.run-paper") version "2.2.0"
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
}

group = "de.maxbossing"
version = 3

repositories {
    mavenCentral()
    maven { url = uri("https://s01.oss.sonatype.org/content/groups/public/") }
    maven { url = uri("https://repo.extendedclip.com/content/repositories/placeholderapi/") }
}

dependencies {
    paperweight.paperDevBundle("1.20.1-R0.1-SNAPSHOT")

    implementation("de.maxbossing", "mxpaper", "2.0.0")

    compileOnly("dev.jorel","commandapi-bukkit-core", "9.2.0")
    compileOnly("dev.jorel", "commandapi-bukkit-kotlin", "9.2.0")

    compileOnly("me.clip", "placeholderapi", "2.11.5")
}


tasks {
    assemble {
        dependsOn(reobfJar)
    }
    runServer {
        minecraftVersion("1.20.1")
    }
}

bukkit {
    name = "TabText"
    website = "https://maxbossing.de"
    author = "Max Bossing <info@maxbossing.de>"
    prefix = "TabText"

    // version is set automatic from project version

    main = "de.maxbossing.tabtext.TabText"

    libraries = listOf(
        "org.jetbrains.kotlin:kotlin-stdlib:1.9.20",
        "dev.jorel:commandapi-bukkit-shade:9.2.0",
        "dev.jorel:commandapi-bukkit-kotlin:9.2.0",
        "de.maxbossing:mxpaper:2.0.0"
    )

    softDepend = listOf(
        "PlaceholderAPI"
    )

    apiVersion = "1.20"
    load = BukkitPluginDescription.PluginLoadOrder.POSTWORLD
}

