class Matrix(private val matrixAsString: String) {

    fun column(colNr: Int): List<Int> =
        matrixAsString.split("\n").map { line -> line.split(" ")[colNr - 1].toInt() }

    fun row(rowNr: Int): List<Int> =
        matrixAsString.split("\n")[rowNr - 1].split(" ").map { it.toInt() }

}
