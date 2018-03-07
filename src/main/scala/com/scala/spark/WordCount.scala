
package com.scala.spark

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


object WordCount {
  
  def main(args:Array[String]):Unit = {
  println("Staring word count program")
  
  val sc = new SparkContext(new SparkConf().setAppName("Spark Count").setMaster("local[2]"))
  
  val lines = sc.textFile("/tmp/files/MeetinsAddinLog.txt")
  val wordsRdd = lines.map(x => x.split(" ")).flatMap(x => x)
  val wordRdd = wordsRdd.map(x => (x,1))
  val CountRdd = wordRdd.reduceByKey(_+_)

  CountRdd.foreach(println)
  
  println("End of word count program")
    
    
  }
  
  
}