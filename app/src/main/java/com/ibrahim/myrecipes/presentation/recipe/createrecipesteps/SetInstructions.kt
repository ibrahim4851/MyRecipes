package com.ibrahim.myrecipes.presentation.recipe.createrecipesteps

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ibrahim.myrecipes.presentation.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetInstructions(navController: NavController){

    Scaffold(modifier = Modifier.fillMaxSize()) {
        paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
        ) {

            Row(modifier = Modifier.fillMaxWidth()) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }

            Text(
                text = "Here's Your Instructions",
                fontWeight = FontWeight.Bold,
                style = Typography.displaySmall
            )
            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                text = "Define the Steps of Creating This Masterpiece",
                style = Typography.titleLarge
            )
            Spacer(modifier = Modifier.padding(8.dp))

            LazyColumn(
                modifier = Modifier
                    .animateContentSize(keyframes {
                        durationMillis = 100
                    }),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {

            }
        }
    }

}