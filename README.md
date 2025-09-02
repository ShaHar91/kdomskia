# Kdomskia

**Create Web, Mobile, and Desktop apps with Kotlin — unified in a single codebase.**

Kdomskia is a **modern, cross-platform framework** built on top of **Compose Multiplatform**.  
It was created to address a gap in **Compose for Web**, which currently does not take advantage of **HTML, CSS, and JavaScript**.

Kdomskia solves this.

There is a **full working example** in production:
- Web app: [Pesto](https://pesto.kdomskia.io)
- Source code: [Pesto Repository](https://github.com/kdomskia/sample-pesto)

## Why Kdomskia?

✅ **Web** – Leverage all the browser's power with **HTML DOM, CSS, and JS**.  
✅ **Native Platforms** – On Android, iOS, and Desktop, Kdomskia runs with **Compose Multiplatform**.  
✅ **One Codebase, Every Platform** – Write once in Kotlin, run everywhere with a native user experience.  
✅ **Familiar API** – Kdomskia’s API and main concepts (**Column**, **Row**, **Box**, etc.) are **identical** to Compose Multiplatform. The main difference lies in the **imports**, making it simple to adopt if you already know Compose.  
✅ **Material 3** – Includes a growing set of **Material Design 3** components, styled consistently across platforms.  
✅ **Navigation** – Built-in navigation module with the **same API** as Compose Navigation, making multi-screen apps straightforward.

## Getting Started

Learning Kdomskia means learning **Compose Multiplatform**, since it is the foundation of the framework.  
If you already know Compose, you already know Kdomskia.

First, add the dependencies to your **Gradle build file**:

```kotlin
implementation("io.kdomskia:kdomskia-ui:0.1.0")
implementation("io.kdomskia:kdomskia-material3:0.1.0")
implementation("io.kdomskia:kdomskia-navigation:0.1.0")
```

Here is a minimal example:

```kotlin
@Composable
fun App() {
    KdomskiaApp(
        drawableResources = DrawableResourcesRef(
            all = Res.allDrawableResources,
            onGetUri = Res::getUri
        )
    ) {
        var counter by remember { mutableStateOf(0) }
        MaterialTheme {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row {
                        Text("Hello")
                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            text = "Kdomskia",
                            fontWeight = FontWeight.W600
                        )
                    }
                    Text(
                        modifier = Modifier.padding(top = 32.dp),
                        text = "Counter: $counter"
                    )
                    Button(
                        onClick = { counter++ }
                    ) {
                        Text("Increment")
                    }
                }
            }
        }
    }
}
```

## Dependencies & Imports

Your project dependencies may include some **Compose Multiplatform** artifacts that will not work properly if used in `commonMain`, such as `androidx.foundation`, `androidx.ui`, `androidx.material3` and `androidx.navigation`.

You will likely want to remove them to avoid using by mistake.  
See [SETUP](docs/SETUP.md) for more details.

## Supported Platforms

- **Web (DOM) – with [Compose HTML](https://github.com/JetBrains/compose-multiplatform), [Kobweb](https://github.com/varabyte/kobweb), and [Beercss](https://github.com/beercss/beercss)**
- **Android – with Compose Multiplatform**
- **iOS – with Compose Multiplatform**
- **Desktop (Windows, macOS, Linux via JVM) – with Compose Multiplatform**

## Modules

Kdomskia is organized into modules that provide structure and flexibility.  
You can include **all modules together**, or just the ones your project requires:

- **ui** → Core UI foundation: layouts, basic widgets, and building blocks.
- **material3** → Implementation of **Material Design 3** components, currently covering the most common UI needs.
- **navigation** → Navigation APIs and components to structure multi-screen applications.

## Cross-Platform Layout

Although Kdomskia shares most APIs with **Compose Multiplatform**, there are key differences when running on the Web:

1. **Element Dimensions** – In Compose, components often infer and expand to available space automatically. On the Web this does not happen, so you must explicitly use modifiers like `fillMaxWidth()`, `fillMaxHeight()`, and `fillMaxSize()` when needed.
2. **Background and Padding Stack** – In Compose you can stack multiple `padding` and `background` modifiers in sequence. On the Web, due to CSS constraints, this is not possible directly. Instead, wrap elements in additional Composables and apply modifiers at each level.
3. **Scrolling Behavior** – On the Web, when scrolling is applied to the window, all elements move. To keep elements fixed while scrolling, use the `ViewportContainer` component.

A detailed list of differences is available in [CROSS_PLATFORM_LAYOUT_GUIDE](docs/CROSS_PLATFORM_LAYOUT_GUIDE.md).

## Project Templates

To quickly start a new project, use one of the official Kdomskia templates:

- [Frontend Web Template](https://github.com/kdomskia/template-frontend-web)
- [Frontend All Platforms Template](https://github.com/kdomskia/template-frontend-all-platforms)
- [Fullstack Template](https://github.com/kdomskia/template-fullstack)

## Learning Resources

Start by checking out the **sample apps and playground**:
- [Pesto Repository](https://github.com/kdomskia/sample-pesto)
- [Playground Repository](https://github.com/kdomskia/playground)

Official learning materials:
- [Kotlin Multiplatform Documentation](https://kotlinlang.org/docs/multiplatform.html)
- [Compose Multiplatform Documentation](https://www.jetbrains.com/lp/compose-multiplatform/)
- [Compose Multiplatform GitHub](https://github.com/JetBrains/compose-multiplatform)
- [Jetpack Compose Basics (Android Developers)](https://developer.android.com/jetpack/compose)
- [Jetpack Compose Pathway (Codelabs)](https://developer.android.com/courses/pathways/compose)

## Roadmap & Evolution

Kdomskia is under active development. The roadmap includes:

- Add Tests (**Unit / UI**)
- Add **CI / CD**
- Ensuring **stability and performance** across all platforms
- Expanding coverage of **Material 3 components**
- Expanding coverage of **Foundation components**
- Add **animation support**
- Reducing **layout differences** between Web and native platforms

## Built With

Kdomskia Web (DOM) is powered by the following open-source projects:

- [Compose HTML](https://github.com/JetBrains/compose-multiplatform)
- [Kobweb](https://github.com/varabyte/kobweb)
- [Beercss](https://github.com/beercss/beercss)

## Credits & Inspiration

Kdomskia’s internal structure and organization were inspired by the well-designed [Coil](https://github.com/coil-kt/coil) library, which also served as a key reference for configuring Kotlin Multiplatform in this project.

## Docs & Wiki

All additional development guides and references are centralized in the [docs/](/docs) folder.

Check [WIKI](/docs/WIKI.md) for more details.