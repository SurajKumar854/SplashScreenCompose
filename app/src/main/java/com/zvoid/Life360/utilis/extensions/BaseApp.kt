package com.zvoid.Life360.utilis.extensions

import android.content.Context
import android.net.Uri
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView


fun Context.buildExoPlayer(uri: Uri) = ExoPlayer.Builder(this).build().apply {

    setMediaItem(MediaItem.fromUri(uri))
    repeatMode = Player.REPEAT_MODE_ALL
    playWhenReady = true
    prepare()

}

fun Context.buildExoPlayerView(exoPlayer: ExoPlayer) = PlayerView(this).apply {
    player = exoPlayer
    layoutParams = FrameLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT
    )
    useController = false
    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
}


fun getVideoUri(context: Context): Uri {

    val rawId = context.resources.getIdentifier("intro", "raw", context.packageName)
    val videoUri = "android.resource://$context.packageName/$rawId"


    return Uri.parse(videoUri)

}
