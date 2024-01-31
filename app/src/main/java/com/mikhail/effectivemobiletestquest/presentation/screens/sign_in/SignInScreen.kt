package com.mikhail.effectivemobiletestquest.presentation.screens.sign_in

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mikhail.effectivemobiletestquest.R
import com.mikhail.effectivemobiletestquest.presentation.ui.theme.EffectiveTheme
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.EffectiveCenterAlignedTopBar
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.EffectivePlaceholder
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.EffectiveSingleLineButton
import com.mikhail.effectivemobiletestquest.presentation.ui.widgets.EffectiveTextField

private const val Mask = "+ # ###-###-##-##"
private const val PhoneLength = 11

private const val CatalogScreenRoute = "catalog"

@Composable
fun SignInScreen(
    navController: NavController,
    viewModel: SignInScreenViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.uiAction.collect {
            when (it) {
                SignInAction.NavToMainScreen -> {
                    navController.navigate(CatalogScreenRoute)
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = EffectiveTheme.color.white
            )
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
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
            EffectiveTextField(
                value = uiState.name,
                onValueChange = viewModel::onNameChange,
                singleLine = true,
                placeholder = {
                    EffectivePlaceholder(
                        text = stringResource(R.string.sign_in_name_placeholder)
                    )
                },
                trailingIcon = {
                    if (uiState.name.isNotEmpty()) {
                        Icon(
                            modifier = Modifier
                                .clip(CircleShape)
                                .clickable {
                                    viewModel.onNameChange(name = "")
                                },
                            painter = painterResource(R.drawable.ic_cross),
                            contentDescription = null
                        )
                    }
                }
            )

            EffectiveTextField(
                value = uiState.surname,
                onValueChange = viewModel::onSurnameChange,
                singleLine = true,
                placeholder = {
                    EffectivePlaceholder(
                        text = stringResource(R.string.sign_in_surname_placeholder)
                    )
                },
                trailingIcon = {
                    if (uiState.surname.isNotEmpty()) {
                        Icon(
                            modifier = Modifier
                                .clip(CircleShape)
                                .clickable {
                                    viewModel.onSurnameChange(surname = "")
                                },
                            painter = painterResource(R.drawable.ic_cross),
                            contentDescription = null
                        )
                    }
                }
            )

            EffectiveTextField(
                value = uiState.phoneNumber,
                onValueChange = viewModel::onPhoneNumberChange,
                singleLine = true,
                placeholder = {
                    EffectivePlaceholder(
                        text = stringResource(R.string.sign_in_phone_number_placeholder)
                    )
                },
                charsLimit = PhoneLength,
                trailingIcon = {
                    if (uiState.phoneNumber.isNotEmpty()) {
                        Icon(
                            modifier = Modifier
                                .clip(CircleShape)
                                .clickable {
                                    viewModel.onPhoneNumberChange(phoneNumber = "")
                                },
                            painter = painterResource(R.drawable.ic_cross),
                            contentDescription = null
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                visualTransformation = MaskVisualTransformation(mask = Mask)
            )
        }

        EffectiveSingleLineButton(
            modifier = Modifier.padding(top = 32.dp),
            text = stringResource(R.string.sign_in_button_text),
            enabled = !uiState.isError,
            onClick = {
                viewModel.onSignInClick()
            }
        )

        Spacer(modifier = Modifier.weight(2f))

        Text(
            text = stringResource(R.string.sign_in_disclaimer),
            style = EffectiveTheme.typography.caption1,
            color = EffectiveTheme.color.grey
        )

        Text(
            modifier = Modifier.padding(bottom = 2.dp),
            text = stringResource(R.string.sign_in_disclaimer_underlined),
            style = EffectiveTheme.typography.linkText,
            color = EffectiveTheme.color.grey
        )
    }
}