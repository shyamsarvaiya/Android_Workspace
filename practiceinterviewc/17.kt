// Gross Salary Program in C Programs

//1.Accept monthly salary from the user and deduct 10% insurance
//premium , 10% loan installment find out of remaining salary.

fun main()
{
    var salary = 50000

    var insurance_premium  = 10

    var loan_installment = 10

    val gross_salary = salary * insurance_premium /100


    val gross_salary2 = salary * loan_installment /100

    
    val net_salary = salary - gross_salary - gross_salary2


    println("$net_salary")




}