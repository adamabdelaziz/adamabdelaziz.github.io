package org.adam.resume.website

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import org.w3c.dom.DocumentReadyState
import org.w3c.dom.LOADING

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    println("main()")

    fun launchCompose() {
        injectGlobalFocusStyle()
        val body = document.body
        if (body == null) {
            println("document.body is null!")
        } else {
            println("document.body found. Launching ComposeViewport.")
            ComposeViewport(body) {
                App()
            }
        }
    }

    if (document.readyState == DocumentReadyState.LOADING) {
        document.addEventListener("DOMContentLoaded", {
            println("DOMContentLoaded fired")
            launchCompose()
        })
    } else {
        println("DOM already ready")
        launchCompose()
    }
}

fun injectGlobalFocusStyle() {
    val style = document.createElement("style")
    style.textContent = """
        *:focus {
            outline: none;
            box-shadow: none !important;
        }
    """.trimIndent()
    document.head?.appendChild(style)
}