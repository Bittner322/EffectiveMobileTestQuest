package com.mikhail.effectivemobiletestquest.presentation.screens.catalog

import androidx.lifecycle.ViewModel
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.dropdown.SortType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CatalogScreenViewModel @Inject constructor(

): ViewModel() {

    fun onSortTypeChange(sortType: SortType) {

    }
}