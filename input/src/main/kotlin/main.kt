fun main(args: Array<String>) {

    val mathOp = MathOp()
    mathOp.summation(23 , 65, { x, y -> x + y })
}

class MathOp(){
    fun summation (fNum : Int , sNum : Int , action : (Int , Int) -> Int){
        println("Answer : " + action(fNum,sNum))
    }
}

