//write a program to print a number sequence pyramid
fun main()
{
    println("Enter the number:")
    var num= readLine()!!.toInt()

    var num1=1
    for(i in 1..num)
    {
        for(j in 1..i)
        {
            print("$num1")
            ++num1
        }
        println()
    }
}