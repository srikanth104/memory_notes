package com.bruvi.core.usecase

import com.bruvi.core.data.Note

/**
 * Created by Srikanth on 26/05/20.
 */
class GetWorkCount {
    operator fun invoke(note: Note) = getCount(note.title) + getCount(note.content)

    private fun getCount(string: String) = string.split("", "\n")
        .filter {
            it.contains(Regex(".*[a-zA-Z.*]"))
        }.count()
}