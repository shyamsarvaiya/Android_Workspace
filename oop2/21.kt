import java.util.*
import kotlin.random.Random.Default.nextInt

//

//2.Convert days into months

fun main()
{
    print("Enter the days : ")
    var days= readLine()?.toInt()

    var day = days?.rem(30)
   var month = days?.div(30)

    println("$days days is $month month and $day day")

}