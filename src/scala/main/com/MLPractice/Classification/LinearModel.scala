package com.MLPractice.Classification

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.regression.LinearRegressionModel
import org.apache.spark.mllib.regression.LinearRegressionWithSGD

object LinearModel {
  def main(args: Array[String]) {
    val Conf = new SparkConf()
      .setAppName("LinearRegressionApp")
      .setMaster("local")

    val sc = new SparkContext(Conf)
    // Load and parse the data
    val data = sc.textFile("C:/Users/ashokr/Documents/WORK/MachineLearnig/Milli'sSession/home_data.csv")
    val parsedData = data.map { line =>
      val parts = line.split(',')
      val vector = new Array[String](parts.size - 1)

      for (i <- 1 until parts.size) {
        vector(i - 1) = parts(i);
      }
      val v = vector.map(_.toDouble)
      LabeledPoint(parts(0).toDouble / 10000, Vectors.dense(v.map { s => s / 10000 }))
    }.cache()

    // Building the model
    val numIterations = 10000
    val stepSize = 0.00000001
    val model = LinearRegressionWithSGD.train(parsedData, numIterations, stepSize)

    // Evaluate model on training examples and compute training error
    val valuesAndPreds = parsedData.map { point =>
      val prediction = model.predict(point.features)
      (point.label, prediction)
    }
    println("Cofficients : " + model.weights)
    val MSE = valuesAndPreds.map { case (v, p) => math.pow((v - p), 2) }.mean()
    println("training Mean Squared Error = " + math.sqrt(MSE)*10000)

    // Save and load model
    // model.save(sc, "myModelPath")
    // val sameModel = LinearRegressionModel.load(sc, "myModelPath")

  }
}