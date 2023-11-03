package com.ibrahim.myrecipes.util

import android.Manifest
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.shouldShowRationale

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RequestReadExternalStoragePermission() {

    val lifecycleOwner = LocalLifecycleOwner.current
    val permissionState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
        )
    )

    DisposableEffect(key1 = lifecycleOwner) {
        val observer = LifecycleEventObserver { source, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    permissionState.launchMultiplePermissionRequest()
                }

                else -> {

                }
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }

    }

    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        permissionState.permissions.forEach {
            when(it.permission) {
                Manifest.permission.READ_EXTERNAL_STORAGE -> {
                    if (it.status.isGranted){
                        print("read permisyon grant")
                    }
                    else {
                        val text = if(it.status.shouldShowRationale){
                            "Permission Required For Reading Storage"
                        } else{
                            "Please provide the storaj permisyon"
                        }
                        Text(text = text)
                    }
                }
                Manifest.permission.WRITE_EXTERNAL_STORAGE -> {
                    if (it.status.isGranted){
                        print("read permisyon grant")
                    }
                    else {
                        val text = if(it.status.shouldShowRationale){
                            "Permission Required For Reading Storage"
                        } else{
                            "Please provide the storaj permisyon"
                        }
                        Text(text = text)
                    }
                }
            }
        }
    }

}