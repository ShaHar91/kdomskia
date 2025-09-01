# Navigation

Navigation in **Kdomskia** follows the same principles as **Compose Multiplatform**.
The setup is straightforward and typically involves the following steps:

- Define destinations as serializable objects or data classes
- Create and remember a `NavHostController` instance
- Set up a `NavHost` and specify the starting destination
- Declare a `composable` for each destination route
- Use `NavHostController.navigate()` to move between destinations
- Retrieve route arguments in a type-safe way using `toRoute()`

```kotlin
import androidx.navigation.toRoute
import io.kdomskia.navigation.compose.NavHost
import io.kdomskia.navigation.compose.composable
import io.kdomskia.navigation.compose.rememberNavController

object Destination {

    @Serializable
    @SerialName("home")
    object Home

    @Serializable
    @SerialName("detail")
    data class Detail(
        val id: String
    )
}

val navController = rememberNavController()

NavHost(
    navController = navController,
    startDestination = Destination.Home
) {
    composable<Destination.Home> {
        HomeScreen(
            onDetailClick = { detailId ->
                navController.navigate(
                    Destination.Detail(
                        id = detailId
                    )
                )
            }
        )
    }
    composable<Destination.Detail> {
        val detailRoute = it.toRoute<Destination.Detail>()
        DetailScreen(
            id = detailRoute.id
        )
    }
}
```

### Linking in Web Applications

When targeting the Web, you may want to display links that users can hover over to preview destinations,
similar to traditional hyperlinks. For this purpose, Kdomskia provides two helper composables:

- `NavLink` – For internal navigation within your app
- `NavExternalLink` – For linking to external resources

```kotlin
import io.kdomskia.compose.navigation.NavExternalLink
import io.kdomskia.compose.navigation.NavLink

NavLink(
    modifier = Modifier.fillMaxWidth(),
    navController = navController,
    route = Destination.Detail(id = "some_id")
) {
    Button(
        onClick = navigateThen {
            // Perform additional actions after navigation
        }
        // Or simply use navigate() if no extra actions are needed
        // onClick = navigate()
    ) {
        Text("Go to Detail")
    }
}

NavExternalLink(
    modifier = Modifier.fillMaxWidth(),
    uri = "https://github.com/kdomskia/kdomskia"
) {
    Button(
        onClick = navigate() // Or use navigateThen {}
    ) {
        Text("Go to Kdomskia Repo")
    }
}
```