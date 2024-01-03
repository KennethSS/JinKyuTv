package com.jinkyu.tv.presentation.videos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jinkyu.tv.ui.AppNameLabel
import com.jinkyu.tv.ui.system.ColorGray
import com.seiko.imageloader.rememberImagePainter
import org.koin.compose.koinInject

@Composable
fun VideoScreen(
    navigateMain: (String) -> Unit,
    viewModel: VideoViewModel = koinInject()
) {
    val videos by viewModel.videos.collectAsState()
    Scaffold(
        topBar = {
            Text(
                modifier = Modifier.fillMaxWidth().padding(vertical = 18.dp),
                text = AppNameLabel,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        },
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(it)
        ) {
            items(videos) { video ->
                VideoItem(
                    video = video,
                    onVideoClicked = { navigateMain(video.videoUrl) }
                )
            }
        }
    }
}

@Composable
fun VideoItem(
    video: Video,
    onVideoClicked: () -> Unit
) {
    val painter = rememberImagePainter(url = video.videoThumbnail)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onVideoClicked() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(120.dp),
                painter = painter,
                contentDescription = "image",
            )
            Spacer(modifier = Modifier.width(24.dp))
            Text(
                modifier = Modifier.weight(1f),
                text = video.videoName,
                fontSize = 16.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.width(24.dp))
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(1.dp).background(ColorGray))
    }

}
