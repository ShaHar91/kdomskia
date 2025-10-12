package io.kdomskia.compose.css

import org.jetbrains.compose.web.css.StyleSheet

object BeerStyleSheet : StyleSheet() {
    val fieldLabelParent by style {
        child(self, type("*")) style {
            property("font-size", "inherit !important")
            property("line-height", "inherit !important")
            property("font-style", "inherit !important")
            property("color", "inherit !important")
            property("background-color", "inherit !important")
        }
    }

    val fieldSupportingParent by style {
        child(self, type("*")) style {
            property("font-size", "inherit !important")
            property("line-height", "inherit !important")
            property("font-style", "inherit !important")
            property("color", "inherit !important")
            property("background-color", "inherit !important")
        }
    }
}

