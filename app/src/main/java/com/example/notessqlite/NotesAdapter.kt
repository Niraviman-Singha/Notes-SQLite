package com.example.notessqlite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private var notes:List<Note>, context: Context) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {
    class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val titleTV: TextView = itemView.findViewById(R.id.titleTV)
        val contentTV: TextView = itemView.findViewById(R.id.contentTV)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NotesAdapter.NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.titleTV.text = note.title
        holder.contentTV.text = note.content
    }

    fun refreshData(newNotes:List<Note>){
        notes = newNotes
        notifyDataSetChanged()
    }

}