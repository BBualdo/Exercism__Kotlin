object Bob {
    private val responses: Map<String, String> = mapOf(
        "Question" to "Sure.",
        "YELL" to "Whoa, chill out!",
        "YELL A QUESTION" to "Calm down, I know what I'm doing!",
        "Silence" to "Fine. Be that way!",
        "Anything" to "Whatever."
    )

    fun hey(input: String): String {
        val trimmedInput: String = input.trim()
        val isEmpty: Boolean = trimmedInput.isEmpty()
        val filteredInput: String = trimmedInput.filter{c -> c == '?' || c.isLetterOrDigit()}
        val hasLetters: Boolean = trimmedInput.any{c -> c.isLetter()}
        val isYelling: Boolean = hasLetters && !isEmpty && filteredInput.none{c -> c.isLetter() && c.isLowerCase()}
        val isQuestion: Boolean = filteredInput.endsWith('?')

        return when {
            isYelling && isQuestion -> responses.getValue("YELL A QUESTION")
            isYelling -> responses.getValue("YELL")
            isQuestion -> responses.getValue("Question")
            isEmpty -> responses.getValue("Silence")
            else -> responses.getValue("Anything")
        }
    }
}
