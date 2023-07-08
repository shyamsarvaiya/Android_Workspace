//write a program you have to find the factorial of given number.
// 5!=5*4*3*2*1
//user input

fun main()
{
    println("Enter the any of number:")
    var num= readLine()!!.toInt()
    var fact=1
    for(i in 1..num)
    {
        fact=fact*i
    }
    println("factorial is : $fact")
}