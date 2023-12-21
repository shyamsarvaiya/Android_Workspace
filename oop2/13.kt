//C Program to Convert a Person's Name in Abbreviated Form



//2.Convert country’s name in abbreviate form


fun main() {
    val str = "INDIA"
    abbreviateWord2(str)
}

fun abbreviateWord2(str: String) {


    val len = str.length

    print(str[0])


    print(len - 2)


    print(str[len - 1])
}
