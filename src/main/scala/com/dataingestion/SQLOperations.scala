package com.dataingestion

import org.apache.spark.sql.functions.col
import org.apache.spark.sql.Column
import scala.collection.mutable.ListBuffer

object SQLOperations {

  def generateMapping(columnmapping: Map[String, String]): ListBuffer[Column] = {
    println("Mapping begins")

    var columnMappingSql = ListBuffer[Column]()

    for ((sourceColumnName, destinationColumnName) <- columnmapping) {
      println("Source column name is  " + sourceColumnName + " Destination Column Name is " + destinationColumnName)
      columnMappingSql += col(sourceColumnName).alias(destinationColumnName)
    }
    return columnMappingSql
  }

}