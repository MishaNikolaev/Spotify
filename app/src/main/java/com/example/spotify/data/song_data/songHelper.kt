package com.example.spotify.data.song_data

import android.media.MediaPlayer

class SongHelper {
    companion object {
        private var mediaPlayer: MediaPlayer? = null

        fun playStream(url: String) {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer().apply {
                    setDataSource(url)
                    prepareAsync()
                    setOnPreparedListener { mediaPlayer ->
                        mediaPlayer.start()
                    }
                    setOnCompletionListener {
                        onCompletionListener?.invoke()
                    }
                }
            } else {
                mediaPlayer?.reset()
                mediaPlayer?.setDataSource(url)
                mediaPlayer?.prepareAsync()
                mediaPlayer?.setOnPreparedListener { preparedMediaPlayer ->
                    preparedMediaPlayer.start()
                }
                mediaPlayer?.setOnCompletionListener {
                    onCompletionListener?.invoke()
                }
            }
        }

        fun pauseStream() {
            mediaPlayer?.pause()
        }

        fun stopStream() {
            mediaPlayer?.stop()
            mediaPlayer?.reset()
        }

        fun releasePlayer() {
            mediaPlayer?.release()
            mediaPlayer = null
        }

        fun getDuration(): Int {
            return mediaPlayer?.duration ?: 0
        }

        fun getCurrentPosition(): Int {
            return mediaPlayer?.currentPosition ?: 0
        }

        fun seekTo(position: Int) {
            mediaPlayer?.seekTo(position)
        }

        private var onCompletionListener: (() -> Unit)? = null

        fun setOnCompletionListener(listener: () -> Unit) {
            onCompletionListener = listener
        }

    }
}