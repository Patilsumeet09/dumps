
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object shema_trial {

  def main(args:Array[String]):Unit= {
    //--------sparksession & context(inside session already created---------------------------------------------------------------------
    val spark=  SparkSession.builder().appName("app4").master("local[1]").getOrCreate()
    val sc=spark.sparkContext
   //----------list & schema types--------------------------------------------------------------------------------------------------
    val l=List((1,"smt"),(2,"eht"))
    val ddlschema=List("id","name")
    val pg_schema=StructType(List(StructField("id",IntegerType,nullable=true),StructField("name",StringType,nullable=true)))
    //------toDF()--TAKES ONLY LITERAL LIST OF HEADERS---------------------------
    import spark.implicits._
    val df1=l.toDF("id","name")
    df1.show()
    //--------createDataFrame-----will need rdd[Row]--------------------------------------------
    val rdd=sc.parallelize(l).map(x=>Row(x._1,x._2))
    val df2=spark.createDataFrame(rdd,pg_schema)
    df2.show()
    //--------createDataFrame-----will need list and then the ddlschema--------------------------------------------
    val df3=spark.createDataFrame(l)
    val df4=df3.toDF("id","name")
    df4.show()
    //-----------read external----will need structType schema--------------------------------------
    val df5=spark.read.format("csv").schema(pg_schema).load("C:/Users/Capricon/Desktop/SAMPLE.csv")
    df5.show()







    //C:\Users\Capricon\DesktopSAMPLE.csv

    //val ddlschema=List("id","name")

  }
}
