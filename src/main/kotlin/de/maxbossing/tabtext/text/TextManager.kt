package de.maxbossing.tabtext.text

import de.maxbossing.mxpaper.extensions.bukkit.cmp
import de.maxbossing.mxpaper.extensions.bukkit.plus
import de.maxbossing.mxpaper.extensions.deserialized
import de.maxbossing.mxpaper.extensions.onlinePlayers
import de.maxbossing.mxpaper.runnables.task
import de.maxbossing.tabtext.TabText
import de.maxbossing.tabtext.tabtext

class TextManager(): AbstractTextManager() {
    override var headerAnimator: Float = 0.0f
    override var footerAnimator: Float = 0.0f


    override fun run() {
        task(true, 0, 1,) {
            onlinePlayers.forEach {

                var header = TabText.config.header.raw.replace("<x>", headerAnimator.toString())
                var footer = TabText.config.footer.raw.replace("<x>", footerAnimator.toString())

                if (TabText.config.header.animated) {
                    headerAnimator += TabText.config.header.animationSpeed
                    if (headerAnimator < -1.0f) headerAnimator += 2.0f
                    if (headerAnimator > 1.0f) headerAnimator -= 2.0f
                }

                if (TabText.config.footer.animated) {
                    footerAnimator -= TabText.config.footer.animationSpeed
                    if (footerAnimator < -1.0f) footerAnimator += 2.0f
                    if (footerAnimator > 1.0f) footerAnimator -= 2.0f
                }

                header.replace("\n", "     \n     ")
                header = "     $header     "
                footer.replace("\n", "     \n     ")
                footer = "     $footer"

                it.sendPlayerListHeaderAndFooter(
                    cmp(" \n") + header.deserialized + cmp(" \n"),
                    cmp(" \n") + footer.deserialized + cmp(" \n")
                )
            }
        }
    }

    init {
        tabtext.logger.info("TextManager without PlaceHolderAPI Support loaded")
        run()
    }
}