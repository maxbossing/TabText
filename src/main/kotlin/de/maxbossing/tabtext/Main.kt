package de.maxbossing.tabtext
import de.maxbossing.mxpaper.extensions.pluginManager
import de.maxbossing.mxpaper.main.MXPaper
import de.maxbossing.tabtext.command.Commands
import de.maxbossing.tabtext.data.Config
import de.maxbossing.tabtext.data.loadConfig
import de.maxbossing.tabtext.text.PlaceHolderAPITextManager
import de.maxbossing.tabtext.text.TextManager
import dev.jorel.commandapi.CommandAPI
import dev.jorel.commandapi.CommandAPIBukkitConfig
import org.bukkit.Bukkit

class TabText: MXPaper() {
    companion object {
        lateinit var tabtext: TabText
        lateinit var config: Config
    }

    override fun load() {
        CommandAPI.onLoad(CommandAPIBukkitConfig(this))

        tabtext = this

        TabText.config = loadConfig()

        logger.info("TabText loaded!")
    }

    override fun startup() {
        if (pluginManager.isPluginEnabled("PlaceholderAPI")) {
            PlaceHolderAPITextManager()
        } else {
            TextManager()
        }

        Commands
        logger.info("TabText enabled")
    }
}
val tabtext by lazy { TabText.tabtext }