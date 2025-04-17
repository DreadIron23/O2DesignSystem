package sk.janmokry.o2designsystem.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sk.janmokry.o2designsystem.R
import sk.janmokry.o2designsystem.designsystem.component.InputView
import sk.janmokry.o2designsystem.designsystem.component.PasswordInput
import sk.janmokry.o2designsystem.designsystem.theme.O2DesignSystemTheme
import sk.janmokry.o2designsystem.designsystem.validation.DefaultPasswordValidation
import sk.janmokry.o2designsystem.designsystem.validation.PASSWORD_ERROR_MESSAGE

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            O2DesignSystemTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Screen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Screen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var email by remember { mutableStateOf("") }

        InputView(
            inputValue = email,
            onValueChange = { email = it },
            label = stringResource(R.string.email_label),
            optionalText = stringResource(R.string.email_optional),
            hint = stringResource(R.string.email_hint),
        )

        Spacer(Modifier.padding(vertical = O2DesignSystemTheme.dimensions.m))

        var password by remember { mutableStateOf("") }
        var isError by remember { mutableStateOf(false) }

        PasswordInput(
            password = password,
            onPasswordChange =
                {
                    password = it
                    isError = !DefaultPasswordValidation.validate(password)
                },
            label = stringResource(R.string.password_label),
            optionalText = stringResource(R.string.password_optional),
            hint = stringResource(R.string.password_hint),
            passwordErrorMessage = PASSWORD_ERROR_MESSAGE,
            isError = isError,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    O2DesignSystemTheme {
        Screen()
    }
}