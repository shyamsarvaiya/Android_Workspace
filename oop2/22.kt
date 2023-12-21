//

//3.Convert years into days and months


fun main()
{
    print("Enter the years : ")
    var years= readLine()?.toInt()

    var days = years?.div(365)
    var months = days?.div(30)

    println("$years years is $months month and $days days in this year")
}