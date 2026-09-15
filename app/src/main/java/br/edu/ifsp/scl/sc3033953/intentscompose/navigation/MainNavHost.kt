package br.edu.ifsp.scl.sc3033953.intentscompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.edu.ifsp.scl.sc3033953.intentscompose.ui.composable.AddWordScreen
import br.edu.ifsp.scl.sc3033953.intentscompose.ui.composable.HomeScreen

private const val NEW_WORD_RETURNED = "new_word_returned"

@Composable
fun MainNavHost(navHostController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {

        composable(route = Screen.Home.route) { backStackEntry ->
            val newWord = backStackEntry.savedStateHandle.get<String>(NEW_WORD_RETURNED) ?: ""

            HomeScreen(
                newWord = newWord,
                modifier = modifier,
                onAddWordClick = {current ->
                    navHostController.navigate("${Screen.AddWord.route}/$current")
                }
            )
        }

        composable(
            route = "${Screen.AddWord.route}/{currentValue}",
            arguments = listOf(
                navArgument(name = "currentValue") { type = NavType.StringType }
            )
        ) { backStepEntry ->
            val currentValue = backStepEntry.arguments?.getString("currentValue")?.trim() ?: ""

            AddWordScreen(
                currentValue = currentValue,
                modifier = modifier
            ) { wordTyped ->
                navHostController.previousBackStackEntry?.savedStateHandle?.set(NEW_WORD_RETURNED, wordTyped)
                navHostController.popBackStack()
            }
        }
    }
}