/**
 * App: SimpleMusicPlayer
 * Autor: Roger
 * Descripcion: Logica principal para cargar un archivo local y reproducir audio desde el dispositivo.
 */
package com.rogerinfas.music_player

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val AUDIO_REQ_CODE = 305
    private var myAudioPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupListeners()
    }

    private fun setupListeners() {
        findViewById<Button>(R.id.buttonLoadAndPlay).setOnClickListener {
            if (myAudioPlayer != null) {
                myAudioPlayer?.start()
            } else {
                pickAudioFile()
            }
        }

        findViewById<Button>(R.id.buttonPauseAudio).setOnClickListener {
            myAudioPlayer?.let { player ->
                if (player.isPlaying) {
                    player.pause()
                }
            }
        }

        findViewById<Button>(R.id.buttonStopAudio).setOnClickListener {
            destroyPlayer()
        }
    }

    private fun pickAudioFile() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "audio/*"
        startActivityForResult(intent, AUDIO_REQ_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == AUDIO_REQ_CODE && resultCode == RESULT_OK) {
            data?.data?.let { uri ->
                initializePlayer(uri)
            }
        }
    }

    private fun initializePlayer(sourceUri: Uri) {
        try {
            destroyPlayer()
            myAudioPlayer = MediaPlayer().apply {
                setDataSource(this@MainActivity, sourceUri)
                prepare()
                start()
            }
            Log.i("AudioApp", "Playing audio from URI")
        } catch (ex: Exception) {
            Log.e("AudioApp", "Failed to play audio: ${ex.localizedMessage}")
            myAudioPlayer = null
        }
    }

    private fun destroyPlayer() {
        myAudioPlayer?.let { player ->
            if (player.isPlaying) {
                player.stop()
            }
            player.release()
        }
        myAudioPlayer = null
    }

    override fun onDestroy() {
        destroyPlayer()
        super.onDestroy()
    }
}
