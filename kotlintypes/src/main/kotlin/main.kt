import com.sun.org.apache.xpath.internal.FoundIndex
import java.util.function.DoubleBinaryOperator

fun main(args: Array<String>) {

    val calculator = Calculate();
    calculator.sum(listOf(2.0 , 4.4 , 8.6 , 10.0 , 12.12));
    calculator.multiply(listOf(6.0 , 6.0 , 12.0));
    calculator.divide(listOf(100.0 , 5.0 , 4.0));
    calculator.average(listOf(12.0 , 3.3 , 4.7));
    calculator.minus(listOf(11.0123 , -4.0 , 3.0));
    calculator.prime(15);
}
