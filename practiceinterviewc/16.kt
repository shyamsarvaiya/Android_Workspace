
//Calculate a Simple Interest

//3.Calculate compound interest


/*
A	=	final amount
P	=	initial principal balance
r	=	interest rate
n	=	number of times interest applied per time period
t	=	number of time periods elapsed*/

//A = P(1 + \frac{r}{n})^{nt}
fun main()
{
    var p = 60000
    var r = 10
    var n = 5
    var t = 10

    var ab = r/n

    println("$ab")

    var ac = 1 + ab

    println("$ac")

    var ad = n*t

    println("$ad")

    var a = p * ac * ad

    println("$a")

}