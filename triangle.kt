fun main()
{
    println("Enter the width of triangle: ")
    var width = readLine() !!.toInt()

    println("Enter the length of triangle: ")
    var length = readLine() !!.toInt()

    var tria=width*length/2

    println("are of triangle is : $tria" )
}