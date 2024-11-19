package com.example.nothing

import android.content.Context
import android.media.MediaPlayer

object MediaPlayerSingleton {

    private var mediaPlayer: MediaPlayer? = null

    // 播放音频资源
    fun play(context: Context, resId: Int) {
        stop() // 停止当前播放，防止资源冲突

        mediaPlayer = MediaPlayer.create(context, resId)
        mediaPlayer?.setOnCompletionListener {
            stop() // 播放完成后释放资源
        }
        mediaPlayer?.start()
    }

    // 暂停播放
    fun pause() {
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.pause()
        }
    }

    // 恢复播放
    fun resume() {
        mediaPlayer?.start()
    }

    // 停止播放并释放资源
    private fun stop() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}