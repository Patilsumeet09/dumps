import scala.collection.mutable.ListBuffer
object patterns
{
  def main(args: Array[String]): Unit =
  {
    var pre=ListBuffer[Int]()
    for (i<-0 to 10)
      {
    var curr=ListBuffer[Int]()

       for (j<-0 to i)
         {
           if ((j==0) || (j==i))
             {
               curr.append(1)
               }
           else
               {
                 curr.append(pre(j-1)+pre(j))
                 //print((i-1)+(j-1)+(i-1)+(j))
               }
             }
        print(pre)
        println()
        pre=curr
           }


         }
     }



