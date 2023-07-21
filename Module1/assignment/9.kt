//Write a program make a summation of given number(E.g. 1523 ans :-11)
fun main()
{
    println("Enter The Number:")
    var num= readLine()!!.toInt()

    var num2=0

    while(0 != num)
    {
          var sum=num%10
            num2=num2+sum
            num/=10

    }
    println("Sum is :$num2")
}