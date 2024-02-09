package com.ibrahim.myrecipes.presentation.createrecipe.ui

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.ibrahim.myrecipes.R
import com.ibrahim.myrecipes.Screen
import com.ibrahim.myrecipes.presentation.createrecipe.CreateRecipeEvent
import com.ibrahim.myrecipes.presentation.createrecipe.RecipeViewModel
import com.ibrahim.myrecipes.presentation.ui.theme.Typography
import com.ibrahim.myrecipes.util.canGoBack

@Composable
fun AddRecipeImage(
    navController: NavController,
    viewModel: RecipeViewModel = hiltViewModel()
) {

    var uri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    val contentResolver = context.contentResolver

    val photoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            uri = it
            uri?.let {
                contentResolver.takePersistableUriPermission(
                    it,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
                )
            }

        }
    )

    val stroke = Stroke(
        width = 4f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 20f), 0f)
    )

    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                Column {
                    Row(
                        modifier = Modifier
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        OutlinedButton(
                            modifier = Modifier.weight(1f),
                            onClick = {
                                if (navController.canGoBack) {
                                    navController.popBackStack()
                                }
                            }
                        ) {
                            Text(text = stringResource(id = R.string.cancel))
                        }
                        Button(
                            modifier = Modifier.weight(1f),
                            onClick = {
                                viewModel.onEvent(
                                    CreateRecipeEvent
                                        .SetImage(uri!!)
                                )
                                viewModel.onEvent(
                                    CreateRecipeEvent
                                        .SaveRecipe
                                )
                                navController.navigate(Screen.HomeScreen.route) {
                                    launchSingleTop = true
                                    popUpTo(Screen.HomeScreen.route) {
                                        inclusive = true
                                    }
                                }
                            },
                            enabled = uri != null
                        ) {
                            Text(text = stringResource(id = R.string.next))
                        }
                    }
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(32.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(7f)
                        .background(MaterialTheme.colorScheme.surface)
                        .drawBehind {
                            if (uri == null) {
                                drawRoundRect(
                                    color = Color.Black,
                                    style = stroke
                                )
                            }
                        },
                    verticalArrangement = Arrangement.Center
                ) {
                    if (uri == null) {
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally),
                            text = stringResource(R.string.pick_your_image),
                            style = Typography.headlineLarge,
                            fontWeight = FontWeight.Bold
                        )
                    } else {
                        val hasPermission = runCatching {
                            context.contentResolver.persistedUriPermissions.any { permission ->
                                permission.uri == uri
                            }
                        }.getOrDefault(false)

                        if (hasPermission) {
                            AsyncImage(
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .fillMaxSize(),
                                model = uri,
                                contentDescription = null
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .weight(2f)
                        .padding(top = 12.dp)
                ) {
                    Button(
                        modifier = Modifier.weight(5f),
                        onClick = {
                            photoPicker.launch(
                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                            )
                        }
                    ) {
                        Text(text = stringResource(R.string.pick_photo))
                    }
                    Spacer(modifier = Modifier.weight(0.1f))
                    OutlinedButton(
                        modifier = Modifier.weight(5f),
                        onClick = { uri = null }
                    ) {
                        Text(text = stringResource(R.string.remove_photo))
                    }
                }
            }
        }
    }
}