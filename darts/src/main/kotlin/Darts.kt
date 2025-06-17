object Darts {
    fun score(x: Number, y: Number): Int {
        val dx = x.toDouble()
        val dy = y.toDouble()
        // formula: (x - a)^2 + (y - b)^2 = r^2

        return when {
            dx*dx + dy*dy <= 1 -> 10
            dx*dx + dy*dy <= 25 -> 5
            dx*dx + dy*dy <= 100 -> 1
            else -> 0
        }
    }
}
