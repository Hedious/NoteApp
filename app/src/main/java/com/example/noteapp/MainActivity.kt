package com.example.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteapp.data.NoteDataSource
import com.example.noteapp.model.Note
import com.example.noteapp.screen.NoteScreen
import com.example.noteapp.screen.NoteViewModel
import com.example.noteapp.ui.theme.NoteAppTheme
import kotlin.reflect.KProperty

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val noteViewModel: NoteViewModel by viewModels()
                    NotesApp(noteViewModel)
                }
            }
        }
    }
}

@Composable
fun NotesApp(noteViewModel: NoteViewModel = viewModel()) {

    NoteScreen(noteList = noteViewModel.getAllNotes(), onAddNote = { note ->
        noteViewModel.addNote(note)
    }, onRemoveNote = {
        noteViewModel.removeNote(it)
    })

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteAppTheme {
        NoteScreen(noteList = emptyList(), onAddNote = {},
            onRemoveNote = {}
        )
    }
}