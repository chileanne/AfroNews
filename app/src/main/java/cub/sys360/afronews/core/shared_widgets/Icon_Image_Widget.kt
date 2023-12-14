package cub.sys360.afronews.core.shared_widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import cub.sys360.afronews.ui.theme.lightGrey


@Composable
fun sharedIconsImages(icon: ImageVector, onclick: () -> Unit) {
    IconButton(
        modifier = Modifier
            .clip(CircleShape)
            .background(color = lightGrey)
            .size(32.dp),
        onClick = onclick,) {

        Icon(imageVector = icon,contentDescription = "Share")
    }
}
