package com.rdbms

import oracle.jdbc.pool.OracleDataSource
import java.sql.Connection
import java.sql.ResultSet



object connect {

  def main(args: Array[String]) = {

    val username = "di_metadata"
    val password = "password12"

    
    val ods = new OracleDataSource()
    ods.setUser(username)
    ods.setPassword(password)
    //ods.setDatabaseName("di_metadata")
    //ods.setPortNumber(1521)
    
    ods.setURL("jdbc:oracle:thin:@10.119.2.98:1521/ikuodb.celgene.com")
    val con = ods.getConnection()
    
    println("Connected")
    
    val s1 = con.createStatement()
    val rs = s1.executeQuery("show tables")

  
  }

}