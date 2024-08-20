package com.anthonyla.paperize.feature.wallpaper.presentation.wallpaper_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.anthonyla.paperize.core.ScalingConstants
import com.anthonyla.paperize.core.isValidUri
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

/**
 * A composable that displays a wallpaper for preview
 */
@Composable
fun PreviewItem(
    wallpaperUri: String,
    darken: Boolean = false,
    darkenPercentage: Int,
    blur: Boolean = false,
    blurPercentage: Int,
    scalingMode: ScalingConstants
) {
    val context = LocalContext.current
    val showUri by remember { mutableStateOf(isValidUri(context, wallpaperUri)) }
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    if (showUri) {
        GlideImage(
            imageModel = { wallpaperUri },
            imageOptions = ImageOptions(
                contentScale = when (scalingMode) {
                    ScalingConstants.FILL -> ContentScale.FillHeight
                    ScalingConstants.FIT -> ContentScale.FillWidth
                    ScalingConstants.STRETCH -> ContentScale.FillBounds
                },
                requestSize = IntSize(300, 300),
                alignment = Alignment.Center,
                colorFilter = if (darken && darkenPercentage < 100) {
                    ColorFilter.tint(
                        Color.Black.copy(alpha = (100 - darkenPercentage).toFloat().div(100f)),
                        BlendMode.Darken
                    )
                } else { null },
            ),
            modifier = Modifier
                .size(screenWidth * 0.35f, screenHeight * 0.35f)
                .clip(RoundedCornerShape(16.dp))
                .border(3.dp, Color.Black, RoundedCornerShape(16.dp))
                .background(Color.Black)
                .blur(
                    if (blur && blurPercentage > 0) {
                        blurPercentage.toFloat().div(100f) * 1.5.dp
                    } else { 0.dp })
        )
    }
}