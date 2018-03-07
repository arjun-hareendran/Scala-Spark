package com.dataingestion

import org.apache.spark.rdd.RDD
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame


object JSONDataFrameGenerator {
  
  def getJsonDataFrame(fileName:String,SparkSesn:SparkSession):DataFrame = {
    SparkSesn.read.json(fileName)
  }
}