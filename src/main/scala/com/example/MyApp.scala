package com.example

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.UserDefinedFunction

object MyApp {
  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder().appName("TestApp").master("local[*]").getOrCreate();

    import sparkSession.sqlContext.implicits._

    val integerList = List(1, 2, 4, 6)
    val df1 = integerList.toDF()

    df1.show()

    import org.apache.spark.sql.functions._

    def expandColumn: UserDefinedFunction = udf((value: Int) => {
      (1 to value).toList
    })

    val df2 = df1.withColumn("rangeData", expandColumn(col("value")))

    df2.show()

  }
}
