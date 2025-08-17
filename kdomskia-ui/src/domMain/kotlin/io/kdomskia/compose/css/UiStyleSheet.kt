package io.kdomskia.compose.css

import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.PointerEvents
import com.varabyte.kobweb.compose.css.margin
import com.varabyte.kobweb.compose.css.overflow
import com.varabyte.kobweb.compose.css.pointerEvents
import com.varabyte.kobweb.compose.css.setVariable
import io.kdomskia.compose.foundation.layout.ViewportContainer
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s

internal val UiStyleSheet = styleSheet {
    "head" {
        display(DisplayStyle.None)
    }
    "html" {
        overflow(Overflow.Hidden)
    }
    "html, body" {
        margin(0.px)
        padding(0.px)
        height(100.percent)
    }
    "h1" {
        margin(top = 0.px)
    }
    "*" {
        setVariable(Variable.speed1, 0.1.s)
        setVariable(Variable.speed2, 0.2.s)
        setVariable(Variable.speed3, 0.3.s)
        setVariable(Variable.speed4, 0.4.s)
    }
    ".${ViewportContainer.className} *" {
        pointerEvents(PointerEvents.Auto)
    }
}

//TODO: replace by type safe styleSheet
internal val UiRawStyleSheet = """
@keyframes slide-left-right-in-anim {
    from {
        transform: translateX(-100%);
    }
    to {
        transform: translateX(0%);
    }
}

.slide-left-right-in {
    animation: slide-left-right-in-anim var(--speed2);
    animation-iteration-count: 1;
    animation-fill-mode: both;
}

@keyframes slide-left-right-out-anim {
    from {
        transform: translateX(0%);
    }
    to {
        transform: translateX(100%);
    }
}

.slide-left-right-out {
    animation: slide-left-right-out-anim var(--speed2);
    animation-iteration-count: 1;
    animation-fill-mode: both;
}

@keyframes slide-right-left-in-anim {
    from {
        transform: translateX(100%);
    }
    to {
        transform: translateX(0%);
    }
}

.slide-right-left-in {
    animation: slide-right-left-in-anim var(--speed2);
    animation-iteration-count: 1;
    animation-fill-mode: both;
}

@keyframes slide-right-left-out-anim {
    from {
        transform: translateX(0%);
    }
    to {
        transform: translateX(-100%);
    }
}

.slide-right-left-out {
    animation: slide-right-left-out-anim var(--speed2);
    animation-iteration-count: 1;
    animation-fill-mode: both;
}

@keyframes fade-in-anim {
    from {
        opacity: 0;
    }
    to {
        opacity: 1;
    }
}

.fade-in {
    animation: fade-in-anim var(--speed2);
    animation-iteration-count: 1;
    animation-fill-mode: both;
}

@keyframes fade-out-anim {
    from {
        opacity: 1;
    }
    to {
        opacity: 0;
    }
}

.fade-out {
    animation: fade-out-anim var(--speed2);
    animation-iteration-count: 1;
    animation-fill-mode: both;
}
""".trimIndent()

fun styleSheet(
    block: StyleSheet.() -> Unit
) = object : StyleSheet() {

    init {
        block()
    }

}