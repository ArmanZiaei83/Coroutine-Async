import javafx.beans.binding.DoubleExpression
import kotlin.math.min

open class Calculate {

    //Business Logic:

    fun sum(list: List<Double>) {
        var summation: Double = 0.0;
        if (list.isEmpty()) {
            println("List Is Empty");
        } else {
            for (i in list.indices) {
                summation += list[i]
            }
            println("Summation : $summation")
        }
    }

    fun multiply(list: List<Double>) {

        var len = list.size;
        var total = 1.0;
        for (i in 0 until len) {
            total *= list[i]
        }
        println("Total : $total")
    }

    fun divide(list: List<Double>) {
        var len = list.size
        var total = list[0];

        for (i in 1 until len) {
            total /= list[i]
        }

        println("Divide : $total")
    }

    fun average(list: List<Double>) {
        var len = list.size
        var total = 0.0

        for (i in 0 until len) {
            total += list[i]
        }
        println("Average : " + total / len)
    }

    fun minus(list: List<Double>) {
        var len = list.size
        var total = list[0]

        for (i in 1 until len) {
            total -= list[i]
        }

        println("Minus : $total")
    }

    open fun prime(num: Int) {
        var flag = false
        for (i in 2..num / 2) {
            if (num % i == 0) {
                flag = true
                break
            }
        }

        if (!flag) {
            println("$num is a prime number.")
        } else {
            println("$num is not a prime number.")
        }
    }
}