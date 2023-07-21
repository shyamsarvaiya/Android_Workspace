//write a program to print a pyramid

fun main()
{
    println("Enter the number:")
    var num= readLine() !!.toInt()
    for(i in 1..num)
    {
        for(j in i..num)
        {
            print("*")
        }
        for(k in 1..i*2-2)
        {
            print(" ")
        }
       for(l in i..num)
        {
            print("*")
        }
        println("")

    }

}