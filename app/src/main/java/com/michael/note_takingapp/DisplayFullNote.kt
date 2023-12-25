package com.michael.note_takingapp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class DisplayFullNote : AppCompatActivity() {

    private lateinit var displayFullNoteTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_full_note)

        displayFullNoteTextView = findViewById(R.id.displayFullNoteTextView)

        val data = intent.extras
        data?.let {
            displayFullNoteTextView.text = it.getString(Constants.KEY_NOTE)
        }

        displayFullNoteTextView.setOnLongClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("label", displayFullNoteTextView.text.toString())
            clipboard.setPrimaryClip(clip)
            Snackbar.make(it, "Text copied to your clipboard", Snackbar.LENGTH_SHORT).show()
            true
        }
    }
}