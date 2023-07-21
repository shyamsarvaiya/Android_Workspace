//left  to right upper   * pyramid
/*

***
**
*

 */
fun main()
{
    println("Enter the number:")
    var num= readLine()!!.toInt()
    for (i in 1..num)
    {
        for(j in i..num-1)
        {
            print("*")
        }
        println("")
    }
}