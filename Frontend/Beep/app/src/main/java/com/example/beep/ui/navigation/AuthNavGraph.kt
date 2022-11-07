package com.example.beep.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

//fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
//    navigation(
//        route = Graph.AUTHENTICATION,
//        startDestination = AuthScreen.Login.route
//    ) {
//        composable(route = AuthScreen.Login.route) {
//            LoginContent(
//                onClick = {
//                    navController.popBackStack()
//                    navController.navigate(Graph.HOME)
//                },
//                onSignClick = {
//                    navController.navigate(AuthScreen.SignUp.route)
//                },
//                onForgotClick = {
//                    navController.navigate(AuthScreen.Forgot.route)
//                }
//            )
//        }
//        composable(route = AuthScreen.SignUp.route) {
//            ScreenContent(name = AuthScreen.SignUp.route) {}
//        }
//        composable(route = AuthScreen.Forgot.route) {
//            ScreenContent(name = AuthScreen.Forgot.route) {}
//        }
//    }
//}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
    object SignUp : AuthScreen(route = "SIGN_UP")
    object Forgot : AuthScreen(route = "FORGOT")
}