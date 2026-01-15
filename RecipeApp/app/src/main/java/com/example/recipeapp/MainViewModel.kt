package com.example.recipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel:ViewModel() {
    data class RecipeState(
        val loading:Boolean = true,
        val categories:List<Category> = emptyList(),
        val error:String? = null
    );
    private val _categoryState = mutableStateOf(RecipeState());
    val categoriesState: State<RecipeState> = _categoryState;

    init{
        fetchCategories();
    }

    private fun fetchCategories(){
        viewModelScope.launch {
            try{
                 val response = recipeService.getCategories();
                 _categoryState.value = _categoryState.value.copy(
                     categories=response.categories,
                     loading = false,
                     error = null
                 );

            }catch (e:Exception){
                  _categoryState.value = _categoryState.value.copy(
                      loading = false,
                      error = "Error Fetching Categories ${e.message}"
                  );
            }
        }
    }
}