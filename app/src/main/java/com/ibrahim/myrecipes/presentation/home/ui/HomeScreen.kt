package com.ibrahim.myrecipes.presentation.home.ui

import android.app.LocaleManager
import android.content.Context
import android.os.Build
import android.os.LocaleList
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.core.os.LocaleListCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ibrahim.myrecipes.R
import com.ibrahim.myrecipes.Screen
import com.ibrahim.myrecipes.presentation.home.viewmodel.HomeScreenEvent
import com.ibrahim.myrecipes.presentation.home.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    var expandSearchBar by remember { mutableStateOf(false) }
    var expandLanguageDropdown by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    val context = LocalContext.current
    Surface(
        modifier = Modifier.fillMaxSize()
    )
    {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                MediumTopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.app_name))
                    },
                    actions = {
                        Box(
                            Modifier
                                .width(150.dp)
                                .animateContentSize(keyframes {
                                    durationMillis = 100
                                }
                                )
                        ) {
                            if (expandSearchBar) {
                                OutlinedTextField(
                                    value = searchQuery,
                                    onValueChange = { searchValue ->
                                        searchQuery = searchValue
                                        viewModel.onEvent(
                                            HomeScreenEvent.SearchFoodsByTitleAndIngredient(
                                                searchQuery
                                            )
                                        )
                                    })
                            }
                        }
                        DropdownMenu(
                            expanded = expandLanguageDropdown,
                            onDismissRequest = { expandLanguageDropdown = false },
                        ) {
                            DropdownMenuItem(
                                text = {
                                    Text("Türkçe")
                                },
                                onClick = { changeLocale(context, "tr") },
                            )
                            DropdownMenuItem(
                                text = {
                                    Text("English")
                                },
                                onClick = { changeLocale(context, "en") },
                            )
                        }
                        IconButton(onClick = { expandSearchBar = !expandSearchBar }) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = null
                            )
                        }
                        IconButton(onClick = { expandLanguageDropdown = !expandLanguageDropdown }) {
                            Icon(imageVector = Icons.Outlined.Settings, contentDescription = null)
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navController.navigate("create_recipe")
                    }
                ) {
                    Icon(Icons.Filled.Add, null)
                }
            }
        ) { values ->
            Column(
                modifier = Modifier
                    .padding(values)
                    .padding(start = 0.dp, end = 0.dp)
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        RoundedCornerShape(topStart = 36.dp)
                    )
            ) {
                MyChipGroup()
                RecipesStaggeredGrid(
                    viewModel.state.value.recipes,
                    onRecipeItemClick = { recipe ->
                        navController.navigate(Screen.RecipeDetail.route + "/" + recipe.recipeId)
                    }
                )
            }
        }
    }
}

fun changeLocale(context: Context, localeString: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        context.getSystemService(LocaleManager::class.java)
            .applicationLocales = LocaleList.forLanguageTags(localeString)
    } else {
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(localeString))
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        color = MaterialTheme.colorScheme.primary
    ) {
        TextField(modifier = Modifier
            .fillMaxWidth(),
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            placeholder = {
                Text(
                    modifier = Modifier.alpha(0.5f),
                    text = "Search here...",
                    color = Color.White
                )
            },
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier.alpha(0.5f),
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.White
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        if (text.isNotEmpty()) {
                            onTextChange("")
                        } else {
                            onCloseClicked()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Icon",
                        tint = Color.White
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                cursorColor = Color.White.copy(alpha = 0.5f)
            ))
    }
}