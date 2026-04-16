/**
 * App: ImageInteraction view
 * Author: Roger
 * Desc: Tapping the image switches between two states with toast alerts.
 */
package com.rogerinfas.image_interaction

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var showSecondPicture = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val posterView = findViewById<ImageView>(R.id.mainImageView)

        posterView.setOnClickListener {
            toggleImage(posterView)
        }
    }

    private fun toggleImage(imgView: ImageView) {
        if (!showSecondPicture) {
            imgView.setImageResource(R.drawable.image_two)
            Toast.makeText(this, "Picture updated", Toast.LENGTH_SHORT).show()
            showSecondPicture = true
        } else {
            imgView.setImageResource(R.drawable.image_one)
            Toast.makeText(this, "Initial picture", Toast.LENGTH_SHORT).show()
            showSecondPicture = false
        }
    }
}
