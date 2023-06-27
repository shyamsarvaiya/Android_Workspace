fun main()
{
    println("Enter The Maths subject Marks:")
    var a = readLine()!!.toInt()
    println("Enter The Science subject Marks:")
    var b = readLine()!!.toInt()
    println("Enter The S.Science subject Marks:")
    var c = readLine()!!.toInt()
    println("Enter The English subject Marks:")
    var d = readLine()!!.toInt()
    println("Enter The Hindi subject Marks:")
    var e = readLine()!!.toInt()

    var total=a+b+c+d+e
    println("total is : $total")

    var per=total/5

    println("percentage is : $per %")
}