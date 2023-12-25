package com.michael.note_takingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var noteListRecyclerView: RecyclerView
    private lateinit var noteEditText: EditText
    private lateinit var addNoteButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        noteListRecyclerView = findViewById(R.id.noteListRecyclerView)
        noteEditText = findViewById(R.id.noteEditText)
        addNoteButton = findViewById(R.id.addNoteButton)

        val noteList = mutableListOf(Note("Type in your note and press the add button"))
        val noteAdapter = NoteAdapter(this, noteList)
        noteListRecyclerView.layoutManager = LinearLayoutManager(this)
        noteListRecyclerView.adapter = noteAdapter

        //When add button is clicked:
        addNoteButton.setOnClickListener {
            if (noteEditText.text.isNotBlank()) {
                val noteText = noteEditText.text.toString()
                val note = Note(noteText)
                noteList.add(note)
                noteAdapter.notifyItemInserted(noteList.size - 1)
                noteEditText.text.clear()
            } else {
                Snackbar.make(it, "Enter something first", Snackbar.LENGTH_SHORT).show()
            }

        }


    }
}