//
//import org.apache.spark.sql.SparkSession
//import org.apache.spark.{SparkConf,SparkContext}
//
//import sun.misc.ObjectInputFilter.Config
//
//object when_otherwise_3 {
//  def main(args: Array[String]): Unit = {
//   def f1():Unit={
//    val s_conf = new SparkConf()
//
//    s_conf.setAppName("app3")
//    s_conf.setMaster("local[2]")
//    s_conf.set("apache.spark.executor.memory", "1G")
//    s_conf.set("apache.spark.app.driver.memory", "500m")
//
//    val spark = new SparkSession.Builder().config(s_conf).getOrCreate()
//     val sc= spark.sparkContext
//     val l = List((1, "The quick brown fox"), (2, "Lorem ipsum dolor sit amet"), (3, "Spark is a unified analytics engine"))
//     val  ddlschema = List("doc_id", "content")
//     val rdd= sc.parallelize(l)
//
//
//     import spark.implicits._
//     val df1=rdd.toDF((ddlschema))
//     df1.show()
//
//
//  }
//    f1()
//  }
//
//}
