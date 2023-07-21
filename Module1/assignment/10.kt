import java.util.Scanner

// Write a program you have to make a summation of first and last Digit.


fun main()
{

    var num:Int
    var sc=Scanner(System.`in`)
    println("Enter the number:")
    num=sc.nextInt()
    var first:Int
    var last:Int
    var sum:Int
    last=num%10
    println("last Number is:$last")
    while (num!=1)
    {
        num /= 10
    //    sum=last+num
    }
    sum=last+num
    println("first number is:$num")

   println("Sum of first and last number is :$sum")

    /*var n:Int
    var r:Int
    var fd:Int
    var ld:Int
    var sum:Int

    var rev=0
    var sc= Scanner(System.`in`)
    println("Enter the number:")
    n=sc.nextInt()
    ld=n%10
    while (n>0)
    {
        r=n%10
        rev=rev*10+r
        n/=10
    }
    fd=rev%10
    sum=fd+ld
    println("first digit is:$fd")
    println("first digit is:$ld")
    println("first digit is:$sum")

     */
}