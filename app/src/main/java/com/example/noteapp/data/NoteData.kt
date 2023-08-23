package com.example.noteapp.data

import com.example.noteapp.model.Note

class NoteDataSource {


    companion object {
        fun loadNotes(): List<Note> {

            return listOf(
                Note(title = "Note1", description = "Description1"),
                Note(title = "Note2", description = "Description2"),
                Note(title = "Note3", description = "Description3"),
                Note(title = "Note4", description = "Description4"),
                Note(title = "Note5", description = "Description5"),
            )
        }
    }


}