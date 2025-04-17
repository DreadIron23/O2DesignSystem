package sk.janmokry.o2designsystem.designsystem.validation

object DefaultPasswordValidation {
    /**
     * @return true when valid, false otherwise
     */
    fun validate(password: String): Boolean =
        password.length >= 8 &&
            password.any { it.isUpperCase() } &&
            password.any { it.isDigit() } &&
            password.any { it in "?=#/%" }
}

val PASSWORD_ERROR_MESSAGE =
    """
        Minimum of 8 characters
        Et least one capital character
        Et least one number
        Et least one special character (? = # / %)
    """
        .trimIndent()
