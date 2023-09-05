package pe.edu.services.ui.herolist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import data.model.Hero


@Composable
fun HeroList(heroes: MutableState<List<Hero>>){

    LazyColumn{
        items(heroes.value){ hero ->
            HeroRow(hero)
        }

    }

}

@Composable
fun HeroRow(hero: Hero){
    Card{
        Row {
            HeroCardImage(hero.image.url)
            Column {
                Text(text = hero.name)
                Text(text = hero.biography.fullName)
            }
        }

    }

}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun HeroCardImage(url: String) {
    GlideImage(model = url, contentDescription = null)
}