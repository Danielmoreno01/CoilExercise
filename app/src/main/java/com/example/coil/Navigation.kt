package com.example.coil

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "screen1") {
        composable("screen1") {
            Screen1(navController)
        }
        composable(
            "screen2/{nombre}/{raza}/{tamano}/{edad}/{foto}",
            arguments = listOf(
                navArgument("nombre") { type = NavType.StringType },
                navArgument("raza") { type = NavType.StringType },
                navArgument("tamano") { type = NavType.StringType },
                navArgument("edad") { type = NavType.StringType },
                navArgument("foto") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val raza = backStackEntry.arguments?.getString("raza") ?: ""
            val tamano = backStackEntry.arguments?.getString("tamano") ?: ""
            val edad = backStackEntry.arguments?.getString("edad") ?: ""
            val foto = backStackEntry.arguments?.getString("foto") ?: ""

            Screen2(nombre, raza, tamano, edad, foto)
        }
    }
}
