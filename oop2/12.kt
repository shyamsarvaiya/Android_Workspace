//C Program to Convert a Person's Name in Abbreviated For

//1.Convert school’s name in abbreviated form
fun main() {
    val str = "San'sXavierSchool"
    abbreviateWord(str)
}

fun abbreviateWord(str: String) {


    val len = str.length

    print(str[0])

    print(len - 2)

    print(str[len - 1])
}

