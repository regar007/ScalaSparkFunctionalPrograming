package com.MLPractice.Classification
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.KMeansDataGenerator

object clustering extends App{
val conf = new SparkConf().setAppName("ClusterApp").setMaster("local")
val sc = new SparkContext(conf)

// Load and parse the data
val data = sc.textFile("C:/Users/ashokr/Documents/WORK/MachineLearnig/Milli'sSession/home_data.csv")
val parsedData = data.map(line => {
    // println("parsed data : "+line)
      Vectors.dense(line.split(',').map(_.toDouble))
    }
  )
//val parsedDataforClsuter = data.map{ line => 
//  val parts = line.split(",")
//  val vector = new Array[String](parts.size -1)
//  
//  for(i <- 1 until parts.size){
//    vector(i-1) = parts(i)
//  }
//  val v = vector.map(_.toDouble)
//  LabeledPoint(parts(0).toDouble / 1000, Vectors.dense(v.map { s => s / 1000 }))
//}.cache()

// Cluster the data into two classes using KMeans
val numClusters = 2
val numIterations = 10
val clusters = KMeans.train(parsedData, numClusters, numIterations)

// Evaluate clustering by computing Within Set Sum of Squared Errors
val WSSSE = clusters.computeCost(parsedData)
println("Within Set Sum of Squared Errors = " + WSSSE)  
}