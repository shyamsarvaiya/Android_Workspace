// write a program you have to print the table of given number.

fun main()
{
    println("Enter The number:")
    var num= readLine()!!.toInt()

    for(i in 1..10)
    {
        var m=i*num
        println("$num X $i = $m")
    }
}