fun main()
{
    println("Enter The year:")
    var year= readLine()!!.toInt()

    if(year%4==0)
    {
        println("Leap year")

    }else
    {
        println("Not Leap")
    }
}