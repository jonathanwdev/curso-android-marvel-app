package com.example.marvelapp.presentation.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.databinding.ItemCharacterLoadingStateBinding

class CharactersLoadMoreStateViewHolder(
    itemBinding: ItemCharacterLoadingStateBinding,
    retry: () -> Unit
): RecyclerView.ViewHolder(itemBinding.root) {
    private val binding = ItemCharacterLoadingStateBinding.bind(itemView)

    private val progressBarLoadMore = binding.progressLoadingMore
    private val textTryAgain = binding.textTryAgain.also {
        it.setOnClickListener {
            retry()
        }
    }

    fun bind(loadState: LoadState) {
        progressBarLoadMore.isVisible = loadState is LoadState.Loading
        textTryAgain.isVisible = loadState is LoadState.Error
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): CharactersLoadMoreStateViewHolder {
            val itemBinding = ItemCharacterLoadingStateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return CharactersLoadMoreStateViewHolder(itemBinding, retry)
        }
    }
}