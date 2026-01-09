object bitwise_swap {
  def main(args: Array[String]): Unit = {

var a=10;
    var b=30

    a=a^b
    b=b^a
    a=a^b

    print(a,b)

  }

}
