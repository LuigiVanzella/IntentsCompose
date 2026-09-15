package br.edu.ifsp.scl.sc3033953.intentscompose.navigation

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object AddWord : Screen(route = "add_word_screen")
}