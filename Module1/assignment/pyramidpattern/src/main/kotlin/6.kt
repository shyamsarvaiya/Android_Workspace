// right to left pyramid  - print number
fun main()
{
  /*  println("Enter the number:")
    var num= readLine()!!.toInt() //5
    var i=0
    var j:Int
    var space:Int
    while(i<num)      //1<5
    {

        space=i        //space=1
        while(space<num)  // 1<5
        {
            print(" ")  //
            space++     // space=2
        }
        j=0
        while (j<i+1)   //0<1+1
        {
            if(j>=0)
            {
                print("$i")
                j++
            }
                    // *
         // j=1
        }
           println("")    //
      i++             //2
    }

   */

        println("Enter the number:")
        var num= readLine()!!.toInt()
        for(i in 1..num)
        {

            for(k in i..num-1)
            {
                print(" ")
            }
            for(j in i downTo 1)
            {
                print("$j")
            }

            println("")
        }
}