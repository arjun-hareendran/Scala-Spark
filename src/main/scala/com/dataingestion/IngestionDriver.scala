package com.dataingestion

import org.apache.spark.sql.SparkSession
import scala.runtime.BoxedUnit


object dataingestion {

  def main(args: Array[String]): Unit = {
    println("Starting Program !")

    //Create spark context
    val sparkSession = SparkContextCreator.getSparkSession(master = "local[2]", appName = "Data Ingestion")
    sparkSession match {
      case Some(sparkSession) => {
        println("Spark Session Created")
        val dataframe = JSONDataFrameGenerator.getJsonDataFrame(fileName = "/tmp/files/trials.json", SparkSesn = sparkSession)
        println(dataframe.show(1))

        //perform mapping
        val columnmapping = Map("nct" -> "nctcolumn", "interventions.drug" -> "inventions_drug" )
        val mappingquery = SQLOperations.generateMapping(columnmapping)
        println(dataframe.select(mappingquery: _*).show())
        
        
        //perform UDF

        //perform casting

      }
      case None => println("Exception Occured , Ending the program"); System.exit(1)
    }

  }

}