package com.example.notessqlite

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private var notes:List<Note>, context: Context) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {
    class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val titleTV: TextView = itemView.findViewById(R.id.titleTV)
        val contentTV: TextView = itemView.findViewById(R.id.contentTV)
        val updateBTN: ImageView = itemView.findViewById(R.id.updateBTN)

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

        holder.updateBTN.setOnClickListener {
            val intent = Intent(holder.itemView.context, UpdateNoteActivity::class.java).apply {
                putExtra("note_id", note.id)
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    fun refreshData(newNotes:List<Note>){
        notes = newNotes
        notifyDataSetChanged()
    }



}