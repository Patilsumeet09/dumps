import org.apache.spark.SparkContext
object rdd_1{
def main(args:Array[String]):Unit= {
  val sc = new SparkContext("local[4]", "Project4")
  val rdd1 = sc.textFile("C:/Users/Capricon/Desktop/new_1.txt")
  var rdd2=rdd1.flatMap(x=>x.split(" "))
  var rdd3=rdd2.map(x=>(x,1))
  var rdd4=rdd3.reduceByKey((x,y)=>x+y)
  var rdd5=rdd4.filter(x=>(x._1=="spark")||(x._1=="a"))
  var rdd6=rdd4.filter(x=>(x._1=="programming")||(x._1=="language"))
  val rdd7=rdd5.union(rdd6)
  val rdd8=rdd7.sortBy(x=>x._2,false)
  for (i<-rdd8.collect())
    {println(i)}

  //scala.io.StdIn.readLine()
}}
