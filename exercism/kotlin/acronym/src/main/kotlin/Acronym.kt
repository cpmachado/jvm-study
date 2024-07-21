object Acronym {
    fun generate(phrase: String): String {
        val sep = "[ \\-]".toRegex();
        return phrase.split(regex = sep)
            .map { it.replace("_", "") }
            .filter(String::isNotEmpty)
            .map { it[0].toString() }
            .map(
                String::uppercase
            )
            .joinToString("")
    }
}
