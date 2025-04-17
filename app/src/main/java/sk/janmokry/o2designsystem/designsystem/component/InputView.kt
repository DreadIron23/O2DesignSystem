package sk.janmokry.o2designsystem.designsystem.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sk.janmokry.o2designsystem.designsystem.theme.O2DesignSystemTheme

@Composable
fun InputView(
    inputValue: String,
    onValueChange: (String) -> Unit,
    label: String,
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
    inputVisualTransformation: VisualTransformation = VisualTransformation.None,
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            BasicText(
                text = label,
                style = labelStyle,
            )

            if (!optionalText.isNullOrBlank()) {
                Spacer(modifier = Modifier.width(O2DesignSystemTheme.dimensions.xs))
                BasicText(
                    text = optionalText,
                    style = optionalTextStyle,
                )
            }
        }

        Spacer(modifier = Modifier.height(O2DesignSystemTheme.dimensions.xs))

        Box(
            modifier =
                Modifier
                    .border(
                        width = borderWidth,
                        color = borderColor,
                        shape = RoundedCornerShape(cornerRadius),
                    )
                    .padding(
                        top = O2DesignSystemTheme.dimensions.s,
                        start = O2DesignSystemTheme.dimensions.m,
                        end = O2DesignSystemTheme.dimensions.xs,
                        bottom = O2DesignSystemTheme.dimensions.s,
                    ),
        ) {
            var textInputValueState by remember {
                mutableStateOf(
                    TextFieldValue(
                        text = inputValue,
                        selection = TextRange(inputValue.length),
                    ),
                )
            }

            BasicTextField(
                value = textInputValueState,
                onValueChange =
                    {
                        onValueChange(it.text)
                        textInputValueState = it
                    },
                modifier = Modifier.fillMaxWidth(),
                textStyle = inputTextStyle,
                cursorBrush = SolidColor(inputTextStyle.color),
                singleLine = true,
                visualTransformation = inputVisualTransformation,
            )

            if (inputValue.isEmpty()) {
                BasicText(
                    text = hint,
                    style = hintStyle,
                    modifier = Modifier.align(Alignment.CenterStart),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InputViewPreview() {
    O2DesignSystemTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            var email by remember { mutableStateOf("jan.mokry@o2.com") }

            InputView(
                inputValue = email,
                onValueChange = { email = it },
                label = "Email Address",
                optionalText = "(Required)",
                hint = "Enter your email",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InputViewLabelOnlyPreview() {
    O2DesignSystemTheme {
        Box(Modifier.padding(16.dp)) {
            var name by remember { mutableStateOf("") }

            InputView(
                inputValue = name,
                onValueChange = { name = it },
                label = "Full Name",
                hint = "Enter your name",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InputViewDifferentStylesPreview() {
    O2DesignSystemTheme {
        Box(Modifier.padding(16.dp)) {
            var phone by remember { mutableStateOf("") }

            InputView(
                inputValue = phone,
                onValueChange = { phone = it },
                label = "Phone",
                optionalText = "(Optional)",
                hint = "Your phone number",
                labelStyle = TextStyle(fontSize = 14.sp, color = Color.Blue, fontWeight = FontWeight.Bold),
                optionalTextStyle = TextStyle(fontSize = 11.sp, color = Color.Red),
                cornerRadius = 8.dp,
            )
        }
    }
}
