
import org.apache.spark
import org.apache.spark.SparkContext.getOrCreate
import org.apache.spark.sql
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, lit}

object rough {
  def main(args:Array[String]):Unit= {
val spark= new SparkSession.Builder().master("local[2]").appName("app1").getOrCreate()

    def fun():Unit={
      import spark.implicits._
      import org.apache.spark.sql.functions._

      val employees = List(
        (1, 25, 30000),
        (2, 45, 50000),
        (3, 35, 40000)
      ).toDF("employee_id", "age", "salary")

      val e1 = employees.select(
        col("age"),col("salary"),
        (when(col("age")<30 && col("salary")<35000,"low sal & young")
                            .when(col("age").between (30,40) && col("salary").between(35000,45000),"mie sal & old")
                            .otherwise("old & high")).alias("cat"))


      e1.show()

      employees.createTempView("emp":String)
      spark.sql("""select * from emp""").show()


    }
    fun()
  }
}
