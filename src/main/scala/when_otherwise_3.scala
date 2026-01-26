
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf,SparkContext}
import org.apache.spark.sql.functions
import org.apache.spark.sql.functions.{col,when}

object when_otherwise_3 {
  def main(args: Array[String]): Unit = {
   def f1():Unit={
    val s_conf = new SparkConf()
    s_conf.setAppName("app3")
    s_conf.setMaster("local[2]")
    s_conf.set("apache.spark.executor.memory", "1G")
    s_conf.set("apache.spark.app.driver.memory", "500m")

    val spark =  SparkSession.builder().config(s_conf).getOrCreate()
     val sc= spark.sparkContext
     val l = List((1, "The quick brown fox"), (2, "Lorem ipsum dolor sit amet"), (3, "Spark is a unified analytics engine"))
     import spark.implicits._
     val df1=spark.createDataFrame(l).toDF("id","content")

     val df2=df1.select(col("id"),col("content"),
       when(col("content").like("%fox%") ,"Animal Related")
         .when(col("content").like("%lorem%"),"Placeholder Text")
         .when(col("content").like("%Spark%"),"tech").otherwise("ok").alias("new"))

     df2.show()
  }
    f1()
    //scala.io.StdIn.readLine()
  }
}
