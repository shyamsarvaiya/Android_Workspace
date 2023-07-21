//left to right number pyramid
/*
1
12
123
1234
12345
 */
fun main()
{
    println("Enter the number:")
    var num= readLine()!!.toInt()
    for(i in 1..num)
    {
        for(j in 1..i)
        {
            print("$j")
        }
        println("")
    }

}