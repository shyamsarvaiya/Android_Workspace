//○ Accept number of students from user. I need to give 5 apples to each
//student. How many apples are required?


fun main() {

    println("Please Enter Student Total No:")
    var st = readLine()?.toInt()


    val count = st?.times(5)

    println("Apple Required : $count")


}