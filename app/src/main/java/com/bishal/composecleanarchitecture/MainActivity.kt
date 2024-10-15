package com.bishal.composecleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bishal.composecleanarchitecture.ui.Navigation
import com.bishal.composecleanarchitecture.ui.theme.ComposeCleanArchitectureTheme
import com.bishal.core_ui.NavigationItem
import dagger.hilt.android.AndroidEntryPoint

/**
 *
 * Created by bishal adhikari on 08/10/2024
 * */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCleanArchitectureTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
            }
        }
    }

    @Composable
    fun MainScreen() {

        val navController = rememberNavController()
        val topBarTitle = remember {
            mutableStateOf(NavigationItem.CurrentWeather.title)
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopBar(topBarTitle.value) },
            content = { padding ->
                Box(modifier = Modifier.padding(padding)) {
                    Navigation(navController = navController)
                }
            },
            bottomBar = {
                BottomNavigationBar(navController){
                    topBarTitle.value = it
                }
            }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopBar(title : String) {
        TopAppBar(
            title = {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        )
    }

    @Composable
    fun BottomNavigationBar(navController: NavController, onValueChange : (String) -> Unit) {
        val items = listOf(
            NavigationItem.CurrentWeather,
            NavigationItem.Forecasting
        )

        NavigationBar(
            contentColor = MaterialTheme.colorScheme.onBackground
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                NavigationBarItem(
                    alwaysShowLabel = true,
                    label = { Text(text = item.title) },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            modifier = Modifier
                                .height(20.dp)
                                .width(20.dp),
                            contentDescription = item.title
                        )
                    },

                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }

                            launchSingleTop = true
                            restoreState = true
                            onValueChange(item.title)
                        }
                    }
                )
            }
        }


    }


}

