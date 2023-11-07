package de.maxbossing.tabtext.text

abstract class AbstractTextManager() {
    abstract var headerAnimator: Float
    abstract var footerAnimator: Float

    abstract fun run()
}