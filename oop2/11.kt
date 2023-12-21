fun main()
{
    //Find ascii value of given number
    val N = 36
    convertToASCII(N)
}
fun convertToASCII(N: Int) {
    var num = N
    while (num > 0) {
        val d = num % 10
        println("$d (${d + 48})")
        num /= 10
    }
}
