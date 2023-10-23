//Find circumference of Triangle formula : triangle = a + b + c

fun main()
{
    println("Enter a value of A:")
    val a = readLine()?.toInt()


    println("Enter a value of B:")
    val b = readLine()?.toInt()


    println("Enter a value of C:")
    val c = readLine()?.toInt()

    val sum  = a!! + b!! + c!!
    println("$sum")
}