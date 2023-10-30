import java.util.*

//Convert Temperature Celsius into Fahrenheit


//1. Convert temperature Fahrenheit to Celsius


fun main(args: Array<String>) {

    //Input Stream
    val scanner = Scanner(System.`in`)

    //Input temperature in Fahrenheit
    print("Enter temperature into Fahrenheit : ")
    val fahrenheit = scanner.nextDouble()

    //Convert  Fahrenheit to Celsius
    val celsius =( (fahrenheit  -  32  ) *  5)/9

    //Print temperature in Celsius
    println("Temperature in Fahrenheit ($fahrenheit) = Celsius ($celsius)")




    // celsius to fahrenheit

    print("Enter temperature in Celsius: ")
    val celsius2 = scanner.nextDouble()

    val fahrenheit2 = (celsius2 * 9/5) + 32


    println("$celsius2°C is equivalent to $fahrenheit2°F.")

}


