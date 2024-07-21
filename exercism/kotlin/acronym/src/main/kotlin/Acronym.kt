object Acronym {
    fun generate(phrase: String): String {
        val sep = "[ \\-]".toRegex();
        return phrase.split(regex = sep).map { it.replace("_", "") }.filter(String::isNotEmpty)
            .map {
                it.subSequence(0, 1).toString().uppercase()
            }.joinToString(prefix = "", separator = "", postfix = "")
    }
}
