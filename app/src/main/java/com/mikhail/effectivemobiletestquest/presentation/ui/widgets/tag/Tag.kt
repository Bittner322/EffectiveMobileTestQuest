package com.mikhail.effectivemobiletestquest.presentation.ui.widgets.tag

import com.mikhail.effectivemobiletestquest.R

enum class Tag(
    val stringResourceOfTag: Int
) {
    ALL(stringResourceOfTag = R.string.catalog_all_tag),
    FACE(stringResourceOfTag = R.string.catalog_face_tag),
    BODY(stringResourceOfTag = R.string.catalog_body_tag),
    SUNTAN(stringResourceOfTag = R.string.catalog_tan_tag),
    MASK(stringResourceOfTag = R.string.catalog_masks_tag)
}