package com.example.notessqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notessqlite.databinding.ActivityUpdateNoteBinding

class UpdateNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateNoteBinding
    private lateinit var db:NotesDatabaseHelper
    private var noteId:Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)

        noteId = intent.getIntExtra("note_id", -1)
        if(noteId == -1){
            finish()
            return
        }

        val note = db.getNoteByID(noteId)
        binding.updateTitleET.setText(note.title)
        binding.updateContentET.setText(note.content)

        binding.updateSaveButton.setOnClickListener {
            val newTitle = binding.updateTitleET.text.toString()
            val newContent = binding.updateContentET.text.toString()
            val updateNote = Note(noteId, newTitle, newContent)
            db.updateNote(updateNote)
            finish()
            Toast.makeText(this,"Changes Saved", Toast.LENGTH_SHORT).show()
        }


    }
}