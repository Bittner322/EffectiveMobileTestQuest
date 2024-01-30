package com.mikhail.effectivemobiletestquest.presentation.screens.sign_in

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mikhail.effectivemobiletestquest.R
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.EffectiveCenterAlignedTopBar
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.EffectivePlaceholder
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.EffectiveSingleLineButton
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.EffectiveTextField

@Composable
fun SignInScreen(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = EffectiveTheme.color.white
            )
    ) {
        EffectiveCenterAlignedTopBar(
            text = stringResource(R.string.sign_in_topbar_title)
        )

        Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val name = remember { mutableStateOf("") }
            EffectiveTextField(
                value = name.value,
                onValueChange = {
                    name.value = it
                },
                singleLine = true,
                placeholder = {
                    EffectivePlaceholder(
                        text = stringResource(R.string.sign_in_name_placeholder)
                    )
                }
            )

            val surname = remember { mutableStateOf("") }
            EffectiveTextField(
                value = surname.value,
                onValueChange = {
                    surname.value = it
                },
                singleLine = true,
                placeholder = {
                    EffectivePlaceholder(
                        text = stringResource(R.string.sign_in_surname_placeholder)
                    )
                }
            )

            val phoneNumber = remember { mutableStateOf("") }
            EffectiveTextField(
                value = phoneNumber.value,
                onValueChange = {
                    phoneNumber.value = it
                },
                singleLine = true,
                placeholder = {
                    EffectivePlaceholder(
                        text = stringResource(R.string.sign_in_phone_number_placeholder)
                    )
                }
            )
        }

        EffectiveSingleLineButton(
            modifier = Modifier.padding(top = 32.dp),
            text = stringResource(R.string.sign_in_button_text)
        )

        Spacer(modifier = Modifier.weight(2f))
    }
}