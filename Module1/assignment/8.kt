
// write a program to find a max number in digit

fun main() {
    var temp =0
    var maxnum = 0
    println("enter the number:")
    var num = readLine()!!.toInt()

    while (num > 0) {
        temp = num % 10
        if (maxnum < temp) {
            maxnum = temp
        }
        num = num / 10
    }
    println("Big Number is:$maxnum")
}