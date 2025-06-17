import kotlin.math.pow

object EliudsEggs {

    fun eggCount(number: Int): Int{
        // convert Int to binary string
        val binary: String = convertToBinary(number)
        // count 1's in string
        return binary.count { it -> it == '1'}
    }

    fun convertToBinary(number: Int): String {
        var remains: Int = number
        val binaryList: MutableList<Char?> = mutableListOf()

        while (remains > 0) {
            // find the highest power of 2
            var currentExponent = 0
            while (remains - 2.0.pow(currentExponent + 1) >= 0) {
                currentExponent += 1
            }

            remains -= 2.0.pow(currentExponent).toInt()
            setAt(binaryList, currentExponent, '1')
        }

        // fill null's in list with 0's
        for (i in binaryList.indices) {
            if (binaryList[i] == null) {
                binaryList[i] = '0'
            }
        }

        return binaryList.joinToString("").reversed()
    }

    private fun setAt(list: MutableList<Char?>, index: Int, value: Char) {
        while (list.size <= index) {
            list.add(null)
        }

        list[index] = value
    }
}
