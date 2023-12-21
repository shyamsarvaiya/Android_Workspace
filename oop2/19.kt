
// C Program to Find Percentage of 5 Subjects

//2.Accept 5 expense from user and find average of expense

fun main()
{


    println("Enter First Expenses :")

    val first  = readLine()?.toInt()

    println("///////////////////////////////")

    println("Enter Second Expenses :")
    var  second =readLine()?.toInt()

    println("///////////////////////////////")


    println("Enter third Expenses : ")

    var  third =readLine()?.toInt()

    println("///////////////////////////////")



    println("Enter fourth Expenses : ")

    var  fourth =readLine()?.toInt()

    println("///////////////////////////////")


    println("Enter fifth Expenses : ")

    var  fifth =readLine()?.toInt()


    val total = first!! + second!! + third!! + fourth!! + fifth!!


    val average_Expenses  = total * 5 / 100

    println("Average Expenses is : $average_Expenses %")


}