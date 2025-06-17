object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        if (start < 1)
            throw IllegalArgumentException("Start must be positive integer.")

        var counter: Int = 0;
        var temp = start;

        while (temp != 1) {
            if (temp % 2 == 0) {
                temp /= 2
            } else {
                temp = temp * 3 + 1
            }

            counter++
        }

        return counter
    }
}
