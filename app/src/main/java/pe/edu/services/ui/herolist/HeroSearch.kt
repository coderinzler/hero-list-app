package pe.edu.services.ui.herolist

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import data.model.Hero
import data.repository.HeroRepository


@Composable
fun HeroSearch(){

    val textQuery = remember {
        mutableStateOf("")
    }

    val heroes = remember {
        mutableStateOf(listOf<Hero>())
    }
    Column{
        Search(textQuery, heroes)
        HeroList(heroes)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(textQuery: MutableState<String>, heroes: MutableState<List<Hero>>) {

    val repository = HeroRepository()
    val context = LocalContext.current

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
                repository.searchByName(textQuery.value) {result ->
                    if(result is Result.Success) {
                        heroes.value = result.data!!
                    }else {
                        Toast.makeText(context, result.message!!, Toast.LENGTH_SHORT).show()
                    }
                }


            }
        )
    )
}