var rowInd = 0
var colInd = 0
var turn ='o'
val table = arrayOf(
    arrayOf(' ','1','2','3'),
    arrayOf('1','-','-','-'),
    arrayOf('2','-','-','-'),
    arrayOf('3','-','-','-')

)

fun main(){
        println("welcome to OX Game")
        printTable()
        printTurn()
        input()
    }

fun input() {
    while (true) {
        try {
            print("Please input Row Col: ")

            val input = readLine()
//            println(input)
            val rcList = input?.split(" ")
            if ( rcList?.size != 2 ) {
                println("Error: Must input 2 numbers Row Col [EX: 1 2]")
                continue
            }
//            println("Row ${rcList?.get(0)} Col ${rcList?.get(1)}")
            rowInd = rcList[0].toInt()
            colInd = rcList[1].toInt()

            if (rowInd > 3 || colInd > 3 || rowInd < 1 || colInd < 1) {
                println("Error: Must input number > 0 and number < 4")
            } else if (table[rowInd][colInd] == 'X' || table[rowInd][colInd] == 'O' ) {
                println("Error: ...")
            } else {
                table[rowInd][colInd] = turn
                printTable()
                if (checkWin()) {
                    printWin()
                    break
                }
                printTurn()
            }

//            println("Row $rowInd Col $colInd")
        } catch (t: Throwable) {
            println("Error: ${t.message} ,numbers Row Col [EX: 1 2]")
        }
    }
}

fun printTable(){
    for (row in table) {
        for( col in row){
            print(col)
        }
        println()
    }
}
fun printTurn(){
    if ( turn == 'X' ) {
        println("O Turn")
        turn = 'O'
    } else {
        println("X Turn")
        turn = 'X'
    }
}

fun checkWin(): Boolean {
    for (row in 1..3) {
        if (checkHorizontal(row)) {
            return true
        }
    }
    for (col in 1..3) {
        if (checkVertical(col)) {
            return true
        }
    }
    for (col in 1..3) {
        for(row in 1.. 3) {
            if (diagonal1(col, row)) {
                return true
            }
        }
    }
    return false
}
fun checkHorizontal(row: Int): Boolean {
    var countH = 0
    for (col in 1..3) {
        if (table[row][col] == turn) {
            countH++
        }
    }
    if (countH == 3) {
        return true
    }
    return false
}
fun checkVertical(col: Int): Boolean {
    var countV = 0
    for (row in 1..3) {
        if (table[row][col] == turn) {
            countV++
        }
    }
    if (countV == 3) {
        return true
    }
    return false
}
fun diagonal1(col: Int , row: Int): Boolean {
    var num = 0
    for (row in 1..3){
        for(col in 1..3){
            if(row == col && table[row][col] == turn)
                num++
        }
    }
    if(num == 3){
        return true
    }
    return false
}

    fun printWin() {
        println("$turn Win!!")
    }



