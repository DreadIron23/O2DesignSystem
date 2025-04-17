package sk.janmokry.o2designsystem.designsystem.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import sk.janmokry.o2designsystem.designsystem.theme.O2DesignSystemTheme
import sk.janmokry.o2designsystem.designsystem.validation.DefaultPasswordValidation
import sk.janmokry.o2designsystem.designsystem.validation.PASSWORD_ERROR_MESSAGE

@Composable
fun PasswordInput(
    password: String,
    onPasswordChange: (String) -> Unit,
    label: String,
    passwordErrorMessage: String,
    modifier: Modifier = Modifier,
    optionalText: String? = null,
    hint: String = "",
    labelStyle: TextStyle = O2DesignSystemTheme.typography.labelM,
    optionalTextStyle: TextStyle =
        O2DesignSystemTheme.typography.labelS.copy(
            color = O2DesignSystemTheme.colorScheme.contentOnNeutralLow,
        ),
    inputTextStyle: TextStyle = O2DesignSystemTheme.typography.bodyM,
    hintStyle: TextStyle =
        O2DesignSystemTheme.typography.bodyM.copy(
            color = O2DesignSystemTheme.colorScheme.contentOnNeutralMedium,
        ),
    borderColor: Color = O2DesignSystemTheme.colorScheme.surfaceXHigh,
    borderWidth: Dp = 1.dp,
    cornerRadius: Dp = O2DesignSystemTheme.dimensions.radiusInput,
    passwordErrorMessageStyle: TextStyle =
        O2DesignSystemTheme.typography.labelS.copy(
            color = O2DesignSystemTheme.colorScheme.contentOnNeutralDanger,
        ),
    isError: Boolean = false,
    errorColor: Color = O2DesignSystemTheme.colorScheme.contentOnNeutralDanger,
) {
    Column(modifier = modifier.animateContentSize()) {
        InputView(
            inputValue = password,
            onValueChange = onPasswordChange,
            label = label,
            optionalText = optionalText,
            hint = hint,
            labelStyle = if (isError) labelStyle.copy(color = errorColor) else labelStyle,
            optionalTextStyle = optionalTextStyle,
            inputTextStyle = inputTextStyle,
            hintStyle = hintStyle,
            borderColor = if (isError) errorColor else borderColor,
            borderWidth = borderWidth,
            cornerRadius = cornerRadius,
            inputVisualTransformation = PasswordVisualTransformation(),
        )

        if (isError) {
            Spacer(modifier = Modifier.height(O2DesignSystemTheme.dimensions.xs))

            Box(modifier = Modifier.padding(horizontal = O2DesignSystemTheme.dimensions.m)) {
                BasicText(
                    text = passwordErrorMessage,
                    style = passwordErrorMessageStyle,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PasswordInputPreview() {
    O2DesignSystemTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            var password by remember { mutableStateOf("") }

            PasswordInput(
                password = password,
                onPasswordChange = { password = it },
                label = "Password",
                optionalText = "(Required)",
                hint = "Enter your password",
                passwordErrorMessage = PASSWORD_ERROR_MESSAGE,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PasswordInputInErrorPreview() {
    O2DesignSystemTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            var password by remember { mutableStateOf("") }
            var isError by remember { mutableStateOf(true) }

            PasswordInput(
                password = password,
                onPasswordChange =
                    {
                        password = it
                        isError = !DefaultPasswordValidation.validate(password)
                    },
                label = "Password",
                optionalText = "(Required)",
                hint = "Enter your password",
                passwordErrorMessage = PASSWORD_ERROR_MESSAGE,
                isError = isError,
            )
        }
    }
}

