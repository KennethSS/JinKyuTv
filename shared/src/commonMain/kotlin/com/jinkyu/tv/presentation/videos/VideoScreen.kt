package com.jinkyu.tv.presentation.videos

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jinkyu.tv.ui.AppNameLabel
import com.seiko.imageloader.rememberImagePainter
import org.koin.compose.koinInject

@Composable
fun VideoScreen(
    navigateVideo: (String) -> Unit,
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
            modifier = Modifier.fillMaxSize().padding(it),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(videos) { video ->
                VideoItem(
                    video = video,
                    onVideoClicked = { navigateVideo(video.videoUrl) }
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

    Row(
        modifier = Modifier.fillMaxWidth()
            .clickable { onVideoClicked() }
            .padding(horizontal = 16.dp)
    ) {
        Image(
            modifier = Modifier.width(120.dp)
                .aspectRatio(16 / 9f)
                .clip(RoundedCornerShape(4.dp)),
            painter = painter,
            contentDescription = "image",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.weight(1f)
                .padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            Text(
                text = video.videoName,
                fontSize = 14.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
            )
            Text(
                text = listOf("blender", "Garage419", "Red Bull Bike", "GCMeetup", "Kakato Shimizu").random(),
                modifier = Modifier
                    .padding(top = 2.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.DarkGray,
            )
        }
    }

}
