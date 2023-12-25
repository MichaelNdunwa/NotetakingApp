package com.michael.note_takingapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(val context: Context, private val noteList: MutableList<Note>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val noteText: TextView = view.findViewById(R.id.noteTextView)

        init {
            view.setOnClickListener {
                val position = adapterPosition
                val item = noteList[position]

                // Creating explicit intent:
                val explicitIntent = Intent(context, DisplayFullNote::class.java)
                explicitIntent.putExtra(Constants.KEY_NOTE, item.noteText)
                context.startActivity(explicitIntent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewLayout = LayoutInflater.from(parent.context).inflate(
            R.layout.note_items, parent, false
        )

        return NoteViewHolder(viewLayout)
    }

    override fun getItemCount(): Int = noteList.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = noteList[position]
        holder.noteText.text = currentNote.noteText
    }
}