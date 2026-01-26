import org.apache.spark
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, when}
import org.apache.spark.sql.SaveMode



object trial {
  def main(args:Array[String]):Unit= {

    var s_conf=new SparkConf()
    s_conf.set("spark.app.Name","newapp2")
    s_conf.set("spark.master","local[2]")
    s_conf.set("spark.driver.memory","1g")
    s_conf.set("spark.executor.memory","500m")

    val spark=new SparkSession.Builder().config(s_conf).getOrCreate()
    import spark.implicits._


    def f1():Unit= {
      val l=List(      (1, 1),      (2, 4),      (3, 5)    )
      val ddlschema=List("review_id", "rating")
      //val df=spark.createDataFrame(l)
      val df1=l.toDF("review_id", "rating")


      val df2=df1.select(col("review_id"),col("rating"),
        when(col("rating")<3,"bad")
          .when(col("rating").between(3,4),"good")
          .when(col("rating")>4,"excellent")
          .otherwise("excellent").alias("fb"),
        when(col("rating")<3,"-").otherwise("+").alias("ispos"))

      df2.show()

      df1.createOrReplaceTempView("tbl")
      val df3=spark.sql(
        """select review_id, rating,
                  case when rating <3 then 'bad'
                       when rating between 3 and 4 then 'good'
                        else 'excellent' end as fb from tbl""")

      //df3.write.mode("overwrite").option("header","true").csv("D:/SPARK/new_csv")

    }
    f1()

  }}
