package org.test.spark
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object WordCount {
  def main(args: Array[String]) {
  
    val Conf = new SparkConf()
              .setAppName("Word Count")
              .setMaster("local")
              
    val sc = new SparkContext(Conf)
    
    val test = sc.textFile("food.txt") 
    
    test.flatMap { line  => 
      line.split(" ")  
    }
    .map { word =>  
      (word, 1)  
    }
    .reduceByKey( _* _)
    .saveAsTextFile("food.Count.txt")
  }
}