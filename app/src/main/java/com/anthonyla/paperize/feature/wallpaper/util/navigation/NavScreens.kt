package com.anthonyla.paperize.feature.wallpaper.util.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.anthonyla.paperize.R


sealed class NavScreens(val route: String, @StringRes val resourceId: Int, val unfilledIcon: ImageVector, val filledIcon: ImageVector) {
    object Home : NavScreens("home_screen", R.string.home_screen, Icons.Outlined.Image, Icons.Filled.Image)
    object Settings : NavScreens("settings_screen", R.string.settings_screen, Icons.Outlined.Settings, Icons.Filled.Settings)
    object AddEdit : NavScreens("add_edit_screen", R.string.add_wallpaper_screen, Icons.Outlined.Add, Icons.Filled.Add)
}