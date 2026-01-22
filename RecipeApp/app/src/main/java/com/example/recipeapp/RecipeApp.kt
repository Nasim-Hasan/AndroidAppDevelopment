package com.example.recipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController:NavHostController) {
    val recipeViewModel: MainViewModel = viewModel();
    val viewState by recipeViewModel.categoriesState;

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {
        composable(route = Screen.RecipeScreen.route) {
            RecipeScreen(viewState = viewState, navigateToDetails = {
                //Responsible for passing the data from the Current Screen to the Details Screen
                //Utilizing the savedStateHandle, which is a component of the Compose Navigation Framework
                navController.currentBackStackEntry?.savedStateHandle?.set("Category", it);
                navController.navigate(Screen.CategoryDetailsScreen.route);
            })
        }
        composable(route = Screen.CategoryDetailsScreen.route) {
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("Category")
                    ?: Category("", "", "", "");
            CategoryDetailsScreen(category = category);
        }
    }
}