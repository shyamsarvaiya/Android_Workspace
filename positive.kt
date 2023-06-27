fun main()
{
    println("Enter the any of number:")
    var num= readLine()!!.toInt()
    if(num>0)
    {
        println("Positive number")
    }
    else
    {
        if(num==0)
        {
            println("This number is not positive or negative")
            return;
        }

        println("Negative number")
    }
}