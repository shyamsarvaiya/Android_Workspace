// Write a program you have to print the Fibonacci series up to user given number
// increment a previous number & next number


fun main()
{
    println("Enter the number:")
    var num= readLine()!!.toInt()
    var first=0
    var next=1
    for(i in 1..num )
    {
        var sum=first+next
        first=next
        next=sum
        println(sum)
    }

}