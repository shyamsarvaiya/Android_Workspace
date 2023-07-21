// right to left pyramid
fun main()
{
    println("Enter the Number:")
    var num= readLine()!!.toInt()

    for(i in 1..num)
    {
        for(j in i..(num-1))
        {
            print(" ")

        }
        for(k in 1..i)
        {
            print("*")
        }
        println("")
    }
}