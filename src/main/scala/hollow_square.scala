object new6 {
  def main(args: Array[String]): Unit = {
    for (i<-0 to 8)
    {
      for (j<-0 to 8)
        {
          if((j==0) || (j==8)||(i==0)||(i==8)||(i==4)||(i==4)||(j==4)||(j==4))
          {
            print("*")}
          else
          {
            print(" ")
          }
          }
      println()
        }

    }



}