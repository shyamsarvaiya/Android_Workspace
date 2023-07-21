//write a program to print a pyramid

fun main()
{
    println("Enter the number:")
    var num= readLine()!!.toInt()


    for(i in 1..num)
    {
        for(j in 1..i)
        {
            print("*")
        }
        println("")
    }
    for(i in num downTo 1)
    {
        for(j in 1..i)
        {
            print("*")
        }
        println("")
    }
}