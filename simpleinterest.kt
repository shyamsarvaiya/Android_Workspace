fun main()
{
    println("Enter The principal amount:")
    var principal = readLine()!!.toInt()
    println("Enter The rate of interest:")
    var interest= readLine()!!.toInt()
    println("Enter the time period:")
    var time= readLine()!!.toInt()

    var total=principal*interest*time/100
    println("simple interest is: $total")
}