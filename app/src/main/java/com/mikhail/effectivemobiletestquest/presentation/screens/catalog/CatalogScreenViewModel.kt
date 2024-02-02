package com.mikhail.effectivemobiletestquest.presentation.screens.catalog

import androidx.lifecycle.ViewModel
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.dropdown.SortType
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.tag.Tag
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CatalogScreenViewModel @Inject constructor(

): ViewModel() {
    private val _uiState = MutableStateFlow(CatalogScreenUiState.default)
    val uiState = _uiState.asStateFlow()

    fun onSortTypeChange(sortType: SortType) {
        _uiState.update {
            it.copy(sortType = sortType)
        }
    }

    fun onActiveTagChange(tag: Tag) {
        _uiState.update {
            it.copy(activeTag = tag)
        }
    }

    fun onDisableTagClick() {
        _uiState.update {
            it.copy(activeTag = Tag.ALL)
        }
    }
}