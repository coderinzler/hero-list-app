package pe.edu.services.ui.herolist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import data.model.Hero


@Composable
fun HeroSearch(){

    val textQuery = remember {
        mutableStateOf("")
    }

    val heroes = remember {
        mutableStateOf(listOf<Hero>())
    }
    Column{
        Search()
        HeroList(heroes)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search() {
    val textQuery = remember {
        mutableStateOf("")
    }

    OutlinedTextField(value = textQuery.value, onValueChange = { newTextQuery ->
        textQuery.value = newTextQuery },
        leadingIcon = {
            Icon(Icons.Filled.Search, null)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {


            }
        )
    )
}