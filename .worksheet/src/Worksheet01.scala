import org.apache.spark.sql.functions.col
  
object Worksheet01 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(109); 
  println("Welcome to the Scala worksheet");$skip(44); val res$0 = 
	col("some name").alias("some other nname");System.out.println("""res0: org.apache.spark.sql.Column = """ + $show(res$0))}
  
}
