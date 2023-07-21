//write a program to print a pyramid

fun main()
{
    println("Enter the number:")
    var num= readLine()!!.toInt()

    for(i in 1..num)
    {
        for(j in 0..i)
        {
            print(" ")
        }
        for(m in num downTo i)
        {
            print("* ")
        }
        println()
    }
}