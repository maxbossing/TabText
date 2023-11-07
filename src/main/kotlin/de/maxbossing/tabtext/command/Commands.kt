package de.maxbossing.tabtext.command

import de.maxbossing.mxpaper.extensions.bukkit.cmp
import de.maxbossing.mxpaper.extensions.bukkit.plus
import de.maxbossing.mxpaper.main.prefix
import de.maxbossing.tabtext.TabText
import de.maxbossing.tabtext.data.loadConfig
import dev.jorel.commandapi.kotlindsl.anyExecutor
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.literalArgument

object Commands {
    val TabManagerReloadCommand = commandTree("tabtext") {
        literalArgument("reload") {
            anyExecutor { sender, _  ->
                TabText.config = loadConfig()
                sender.sendMessage(prefix + cmp("Config reloaded"))
            }
        }
    }
}

