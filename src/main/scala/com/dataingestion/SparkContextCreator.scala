package com.dataingestion

import org.apache.spark.sql.SparkSession
  
object SparkContextCreator {

  def getSparkSession(master: String, appName: String): Option[SparkSession] = {
    
    try {
      val sparksession = SparkSession.builder.master(master).appName(appName).getOrCreate()
      return Some(sparksession)
    } catch {
      case exception:Exception =>  println("Exception Occured");return None
    }

  }
  
   def getSparkSession2(master: String, appName: String): Either[Exception,SparkSession] = {
    println("Inside getSparkSession")
    
    try {
      val sparksession = SparkSession.builder.master(master).appName(appName).getOrCreate()
      Right(sparksession)
    } catch {
      case exception:Exception =>  Left(exception)
    }

  }
}