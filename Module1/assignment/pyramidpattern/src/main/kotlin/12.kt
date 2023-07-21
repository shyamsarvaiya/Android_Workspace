//write a program to squre pyramid
// 1 4 4 9 9 9

fun main()
{
    println("Enter the number:")
    var num= readLine()!!.toInt()

    var sq:Int

    for(i in 1..num)
    {
        for(j in 1..i)
        {
            sq=i*i
            print("$sq")
        }
        println("")
    }

}