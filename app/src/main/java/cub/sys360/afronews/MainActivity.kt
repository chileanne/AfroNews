package cub.sys360.afronews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import cub.sys360.afronews.core.navigation.navigationGraph
import cub.sys360.afronews.core.navigation.navigationRoutes
import cub.sys360.afronews.presentation.HomeScreen
import cub.sys360.afronews.ui.theme.AfroNewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AfroNewsTheme {

                val navController = rememberNavController()
                navigationGraph(navController = navController)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AfroNewsTheme {
        Greeting("Android")
    }
}