package com.example.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.core.data.remote.repository.CharactersRepository
import com.example.core.domain.models.Character
import com.example.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val getCharactersRepository: CharactersRepository
) : PagingUseCase<GetCharactersUseCase.GetCharactersParams,Character>() {
    data class GetCharactersParams(val query: String, val pagingConfig: PagingConfig)

    override fun createFlowObservable(params: GetCharactersParams): Flow<PagingData<Character>> {
        return Pager(config = params.pagingConfig) {
            getCharactersRepository.getCharacters(params.query)
        }.flow
    }
}