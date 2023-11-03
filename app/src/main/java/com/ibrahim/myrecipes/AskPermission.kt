package com.ibrahim.myrecipes

import android.Manifest
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun CheckPermissionTiramisu() {
    val context = LocalContext.current
    val launcher: ActivityResultLauncher<String> = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
        } else {
            Toast.makeText(context, "Bildirim Ayarlarından İzin Verebilirsiniz", Toast.LENGTH_LONG).show()
        }
    }


    LaunchedEffect(launcher) {
        launcher.launch(Manifest.permission.READ_MEDIA_IMAGES)
    }
}

@Composable
fun CheckExternalStoragePermission() {
    val context = LocalContext.current
    val launcher: ActivityResultLauncher<String> = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {

        } else {
            Toast.makeText(context, "Please grant external storage permission", Toast.LENGTH_LONG).show()
        }
    }

    LaunchedEffect(launcher) {
        launcher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
    }
}
