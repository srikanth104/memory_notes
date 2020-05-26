package com.bruvi.memorynotes.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bruvi.core.data.Note
import com.bruvi.memorynotes.R
import kotlinx.android.synthetic.main.item_note.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Srikanth on 25/05/20.
 */
class NotesListAdapter(val notes: ArrayList<Note>, val actions: ListAction) :
    RecyclerView.Adapter<NotesListAdapter.NoteViewHolder>() {

    fun updateNotes(newNotes: List<Note>) {
        notes.clear()
        notes.addAll(newNotes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NoteViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
    )

    override fun getItemCount() = notes.size


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    inner class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val layout = view.noteLayout
        private val noteTitle = view.title
        private val noteConstant = view.content
        private val noteDate = view.date
        private val noteWords = view.wordCount

        fun bind(note: Note) {
            noteTitle.text = note.title
            noteConstant.text = note.content
            val sdf = SimpleDateFormat("MMM dd,HH:mm:ss")
            val resultDate = Date(note.updatedTime)
            noteDate.text = "Last Updated : ${sdf.format(resultDate)}"

            layout.setOnClickListener {
                actions.onClick(note.id)
            }
            noteWords.text = "Words : ${note.wordCount}"
        }
    }
}