//C Program to Find Percentage of 5 Subjects


// 1. Accept 5 employees name and salary and count average and total
//salary

fun main()
{

    println("Enter First Employee Name:")
    var name =readLine()

    println("Enter First Employee Salary :")

    val first  = readLine()?.toInt()

    println("///////////////////////////////")

    println("Enter Second Employee Name:")
    var name2 =readLine()

    println("Enter Second Employee Salary :")
    var  second =readLine()?.toInt()

    println("///////////////////////////////")

    println("Enter third Employee Name:")
    var name3 =readLine()

    println("Enter third Employee Salary : ")

    var  third =readLine()?.toInt()

    println("///////////////////////////////")

    println("Enter fourth Employee Name:")
    var name4 =readLine()

    println("Enter fourth Employee Salary : ")

    var  fourth =readLine()?.toInt()

    println("///////////////////////////////")

    println("Enter fifth Employee Name:")
    var name5 =readLine()

    println("Enter fifth Employee Salary : ")

    var  fifth =readLine()?.toInt()


    val total = first!! + second!! + third!! + fourth!! + fifth!!

    println("Total Salary is :$total")

    val average_salary  = total / 5

    println("Average Salary is : $average_salary")

}



