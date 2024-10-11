package com.example.core.data.remote.repository

import androidx.paging.PagingSource
import com.example.core.domain.models.Character

interface CharactersRepository {
    fun getCharacters(query: String): PagingSource<Int, Character>
}