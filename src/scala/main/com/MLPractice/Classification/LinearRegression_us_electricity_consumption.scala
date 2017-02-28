package com.MLPractice.Classification

import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.regression.LinearRegressionModel
import org.apache.spark.mllib.regression.LinearRegressionWithSGD
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext


object LinearRegression_us_electricity_consumption {
  def main(args: Array[String]) {
  val Conf = new SparkConf()
              .setAppName("Word Count")
              .setMaster("local")
              
  val sc = new SparkContext(Conf)
  
  //csv data
  val data = sc.textFile("C:/Users/ashokr/Documents/WORK/GitLab/MLSession-Practice/datasets/elec.csv")
  
  // Load and parse the data
  println("data modification...")
  val parsedData = data.map { line =>
      println("date: "+line)
      val parts = line.split(',')
      if(parts(4).replaceAll(" ", "") != "" && parts(4).replaceAll(" ", "").indexOf(":") == -1){
        val vector = new Array[String](2)
        vector(0) = parts(4)

//      for (i <- 4 until 5) {
//        vector(i - 1) = parts(i);
//      }
//      val v = vector.map(_.toDouble)
//      val dateToDays = parts(3).replaceAll("/", "-").split("-")
//      println("data to days: "+dateToDays)
      
     // LabeledPoint(0.0, Vectors.dense(v))      
    }
  }
  
  println("modification finished!")
  
  // Building the model
//  val numIterations = 100
//  val stepSize = 0.00000001
//  val model = LinearRegressionWithSGD.train(parsedData, numIterations, stepSize)
//  
//  // Evaluate model on training examples and compute training error
//  val valuesAndPreds = parsedData.map { point =>
//    val prediction = model.predict(point.features)
//    (point.label, prediction)
//  }
//  val MSE = valuesAndPreds.map{case(v, p) => math.pow((v - p), 2)}.mean()
//  println("training Mean Squared Error = " + MSE)
//  
//  // Save and load model
//  model.save(sc, "myModelPath")
//  val sameModel = LinearRegressionModel.load(sc, "myModelPath")

  }
}