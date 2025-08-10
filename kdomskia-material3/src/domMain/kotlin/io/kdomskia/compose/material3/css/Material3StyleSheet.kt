package io.kdomskia.compose.material3.css

val Material3StyleSheet = """
.beer :is(button, .button) { 
    background-color: var(--button-color) !important;
    transition: transform var(--speed3), padding var(--speed3) !important;
}

:is(.wave, .chip, .button, button, nav.tabbed > a, .tabs > a, nav.toolbar > a):not(.slow-ripple, .ripple, .fast-ripple)::after,
nav:is(.left, .right, .bottom, .top).max > a::after,
nav:is(.left, .right, .bottom, .top).max > :is(ol, ul) > li > a::after,
nav:is(.left, .right, .bottom, .top):not(.max) > a > i::after,
nav:is(.left, .right, .bottom, .top):not(.max) > :is(ol, ul) > li > a > i::after {
  background-image: radial-gradient(circle, var(--ripple-color) 1%, transparent 1%) !important;
}

:is(.wave, .chip, .button, button, nav.tabbed > a, .tabs > a, nav.toolbar > a):not(.slow-ripple, .ripple, .fast-ripple):is(:focus-visible, :hover)::after,
nav:is(.left, .right, .bottom, .top).max > a:not(.button, .chip):is(:focus-visible, :hover)::after,
nav:is(.left, .right, .bottom, .top).max > :is(ol, ul) > li > a:not(.button, .chip):is(:focus-visible, :hover)::after,
nav:is(.left, .right, .bottom, .top):not(.max) > a:not(.button, .chip):is(:focus-visible, :hover) > i::after,
nav:is(.left, .right, .bottom, .top):not(.max) > :is(ol, ul) > li > a:not(.button, .chip):is(:focus-visible, :hover) > i::after {
  opacity: var(--ripple-opacity);
}

.beer .tabs > a {
    color: var(--tab-content-color) !important;
}
.beer .tabs > a.active::before {
    background-color: var(--tab-indicator-color);
    height: var(--tab-indicator-height);
}
.beer .tabs {
    padding-left: var(--tab-container-horizontal-padding);
    padding-right: var(--tab-container-horizontal-padding);
    border-block-end: none;
    background-size: 100% var(--tab-divider-thickness), 100% 100%;
    background-repeat: no-repeat, no-repeat;
    background-position: bottom, center;
    background-image: linear-gradient(var(--tab-divider-color), var(--tab-divider-color)), linear-gradient(var(--tab-container-color), var(--tab-container-color));
}
.beer .tabs:is(.min) > a.active::before {
    max-inline-size: min(100%, var(--tab-indicator-min-width));
}
.beer .tabs > a {
    padding-left: var(--tab-padding-left);
    padding-right: var(--tab-padding-right);
}

.beer header.primary-container {
    background-color: var(--appbar-container-color) !important;
}

.beer * {
    border-radius: unset;
}

""".trimIndent()