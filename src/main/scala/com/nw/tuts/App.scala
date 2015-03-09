package com.nw.tuts

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object App {

	def main(args: Array[String]) = {
		
		val logFile = "data/hard_drug_users_by_sex.csv"
		val conf = new SparkConf().setAppName("Simple Tutorial")
		val sc = new SparkContext(conf)

		val csvData = sc.textFile(logFile, 2).cache()

		val pairedData = csvData.map{ line => 
								var lineArr = line.split(",")
								//( (year, gender), count )
								( (lineArr(0), lineArr(2)), lineArr(3).toInt )
							}
		pairedData.reduceByKey(_ + _).collect() foreach ( println(_) )
	}
}