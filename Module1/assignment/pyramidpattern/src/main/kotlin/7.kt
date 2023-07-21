// write a program to triangle pyramid
fun main()
{
    println("Enter the number:")
    var num= readLine()!!.toInt()
    for(i in 1..num)
    {
        for(j in num-1 downTo i)
        {
            print(" ")
        }
        for(k in 1..i)
        {
            print("* ")
        }
        println()

    }
}