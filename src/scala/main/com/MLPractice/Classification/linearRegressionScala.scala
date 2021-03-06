import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.regression.LinearRegressionModel
import org.apache.spark.mllib.regression.LinearRegressionWithSGD
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext


object linearR {
  def main(args: Array[String]) {
  val Conf = new SparkConf()
              .setAppName("Word Count")
              .setMaster("local")
              
  val sc = new SparkContext(Conf)
  
  // Load and parse the data
  val data = sc.textFile("C:/Users/ashokr/Documents/WORK/MachineLearnig/Milli'sSession/home_data.csv")
  val parsedData = data.map { line =>
    val parts = line.split(',')
    LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(' ').map(_.toDouble)))
  }.cache()
  
  // Building the model
  val numIterations = 100
  val stepSize = 0.00000001
  val model = LinearRegressionWithSGD.train(parsedData, numIterations, stepSize)
  
  // Evaluate model on training examples and compute training error
  val valuesAndPreds = parsedData.map { point =>
    val prediction = model.predict(point.features)
    (point.label, prediction)
  }
  val MSE = valuesAndPreds.map{case(v, p) => math.pow((v - p), 2)}.mean()
  println("training Mean Squared Error = " + MSE)
  
  // Save and load model
  model.save(sc, "myModelPath")
  val sameModel = LinearRegressionModel.load(sc, "myModelPath")

  }
}