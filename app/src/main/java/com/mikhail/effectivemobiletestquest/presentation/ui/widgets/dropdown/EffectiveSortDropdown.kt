package com.mikhail.effectivemobiletestquest.presentation.ui.widgets.dropdown

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mikhail.effectivemobiletestquest.R
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme

@Composable
fun EffectiveSortDropdown(
    onChosenSortTypeClick: (SortType) -> Unit,
    modifier: Modifier = Modifier,
    chosenSortType: SortType = SortType.BY_POPULARITY
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable { expanded = true }
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_sort),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = stringResource(chosenSortType.sortType),
                style = EffectiveTheme.typography.title4,
                overflow = TextOverflow.Ellipsis
            )
            Icon(
                painter = painterResource(R.drawable.ic_arrow_down),
                contentDescription = null
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = {
                    Text(
                        text = stringResource(R.string.catalog_sort_by_popular),
                        style = EffectiveTheme.typography.title4,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                onClick = {
                    onChosenSortTypeClick(SortType.BY_POPULARITY)
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = {
                    Text(
                        text = stringResource(R.string.catalog_sort_by_price_down),
                        style = EffectiveTheme.typography.title4,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                onClick = {
                    onChosenSortTypeClick(SortType.BY_PRICE_DOWN)
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = {
                    Text(
                        text = stringResource(R.string.catalog_sort_by_price_up),
                        style = EffectiveTheme.typography.title4,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                onClick = {
                    onChosenSortTypeClick(SortType.BY_PRICE_UP)
                    expanded = false
                }
            )
        }
    }
}