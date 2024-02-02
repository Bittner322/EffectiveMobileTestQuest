package com.mikhail.effectivemobiletestquest.presentation.screens.catalog

import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.dropdown.SortType
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.tag.Tag

data class CatalogScreenUiState(
    val sortType: SortType,
    val activeTag: Tag
) {
    companion object {
        val default = CatalogScreenUiState(
            sortType = SortType.BY_POPULARITY,
            activeTag = Tag.ALL
        )
    }
}