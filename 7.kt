// Write a program to print the number in reverse order.

fun main()
{
    println("Enter The any Number:")
    var num= readLine()!!.toInt()

    var reverse =0

    while(num != 0)
    {
        var rev=num%10
        reverse=reverse*10+rev
        num /= 10

    }
    println("reverse is: $reverse")
}