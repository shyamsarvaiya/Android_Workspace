// left to right number pyramid
/*
1
22
333
4444
55555

 */
fun main()
{
    println("Enter the number:")
    var num= readLine()!!.toInt()

    for(i in 1..num)
    {
        for(j in 1..i)
        {
            print("$i")
        }
        println("")
    }
}