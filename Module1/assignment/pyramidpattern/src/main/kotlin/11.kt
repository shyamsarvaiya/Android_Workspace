//print a binary number pyramid
//0 1 0 1

fun main()
{
    println("Enter the number:")
    var num= readLine()!!.toInt()
    var count=1
    for(i in 0 until num)
    {
        for(j in 0..i)
        {
            print("$count")

            count = if (count==1) 0 else 1

        }
        count=i%2
        println("")
    }
}