# Core Concepts

In many cases, you’ll need to access platform‑specific Modifiers for **DOM** and **Skia** in order to build the desired layout.

> If `dom` and `skia` source sets are not familiar to you, please refer to [SETUP.md](SETUP.md).

### Declaring an `expect` Modifier

On `commonMain`, declare the `expect` function:

```kotlin
import io.kdomskia.compose.ui.Modifier

expect fun Modifier.myCustomModifier(): Modifier
```

### Providing the `actual` Implementations

Access platform-specific Modifiers using the `unwrap` function:

On `domMain`:

```kotlin
import io.kdomskia.compose.ui.Modifier

actual fun Modifier.myCustomModifier() = unwrap {
    val kobwebModifier = this

    // Access the underlying Kobweb (DOM) Modifier
    kobwebModifier
        .margin(top = 50.percent)
        .ariaLabel("myLabel")
        .attrsModifier {
            // Modify HTML element attributes
            id("myClass")
            addEventListener("keydown") {
                // Add event listeners just like in the DOM
            }
        }
        .styleModifier {
            // Apply or override CSS styles
            pointerEvents(PointerEvents.None)

            // You can also set custom (non type-safe) CSS properties
            property("mask-repeat", "no-repeat")
        }
}
```

On `skiaMain`:

```kotlin
import io.kdomskia.compose.ui.Modifier

actual fun Modifier.myCustomModifier() = unwrap {
    val skiaModifier = this

    // Access the underlying AndroidX (Skia) Modifier
    skiaModifier
        // Apply low-level layout adjustments
        .offset(x = 10.dp, y = 20.dp)
        .graphicsLayer {
            // Apply transformations and visual effects
            scaleX = 1.1f
            scaleY = 1.2f
        }
}
```
