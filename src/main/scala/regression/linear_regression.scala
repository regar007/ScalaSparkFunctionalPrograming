package main.scala.regression

import scala.math.{pow}
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.collection.mutable.ArrayBuffer

object linear_regression {
  def linear(pairs: IndexedSeq[Seq[Double]]) = {
    val n = pairs.size

    val sums = for {
      sumXi <- Future {
        var sum = 0.0
        for (pair <- pairs) sum += pair(0)
        sum
      }
      sumYi <- Future {
        var sum = 0.0
        for (pair <- pairs) sum += pair(1)
        sum
      }
      sumX2i <- Future {
        var sum = 0.0
        for (pair <- pairs) sum += pow(pair(0), 2)
        sum
      }
      sumY2i <- Future {
        var sum = 0.0
        for (pair <- pairs) sum += pow(pair(1), 2)
        sum
      }
      sumXYi <- Future {
        var sum = 0.0
        for (pair <- pairs) sum += pair(0) * pair(1)
        sum
      }

    } yield (sumXi, sumYi, sumX2i, sumY2i, sumXYi)

    val (sumX, sumY, sumX2, sumY2, sumXY) = Await.result(sums, Duration.Inf)

    val dn = n * sumX2 - pow(sumX, 2)
    assert(dn != 0.0, "Can't solve the system!")

    val poms = for {
      slopei <- Future {
        ((n * sumXY) - (sumX * sumY)) / dn
      }
      intercepti <- Future {
        ((sumY * sumX2) - (sumX * sumXY)) / dn
      }
      t1i <- Future {
        ((n * sumXY) - (sumX * sumY)) * ((n * sumXY) - (sumX * sumY))
      }
      t2i <- Future {
        (n * sumX2) - pow(sumX, 2)
      }
      t31 <- Future {
        (n * sumY2) - pow(sumY, 2)
      }

    } yield (slopei, intercepti, t1i, t2i, t31)

    val (slope, intercept, t1, t2, t3) = Await.result(poms, Duration.Inf)

    if (t2 * t3 != 0.0)
      (slope, intercept, t1 / (t2 * t3))
    else
      (slope, intercept, 0.0)
  }
}

/*
How to use it?
*/
object RegressionApp {
  def main(args: Array[String]): Unit = {

    // From IndexedSeq
    /*
    println(Regression.linear(
      IndexedSeq(
        Seq(1, 4),
        Seq(2, 6),
        Seq(4, 12),
        Seq(5, 15),
        Seq(10, 34),
        Seq(20, 68)
      ))
    )
    */
    val results = linear_regression.linear(
      IndexedSeq(
        Seq(1, 4), Seq(2, 6), Seq(4, 12),
        Seq(5, 15), Seq(10, 34), Seq(20, 68)
      )
    )

    println(results)
    // From file
//    var path = "numbers.csv"
//    println(linear_regression.linear(io.Source.fromFile(path)
//      .getLines
//      .map(_.split(",")
//        .map(_.toDouble).to[collection.immutable.Seq]
//    ).toIndexedSeq))

    // Returns tuple:
    //#=> (3.4365079365079363,-0.8888888888888888,0.9983838545202817)

    // Meaning:
    //_1 => slope
    //_2 => intercept
    //_2 => r^2

    // Final function:
    // y = 3.4365079365079363*x + (-0.8888888888888888)

    // High r^2 means that function is "very close" to provided dataset
    // and as such can give good predictions.

    // If you like it let me know. :) Cheers!
  }

/*
  Compile and run with: scalac RegressionApp.scala && scala RegressionApp
  Updated w/ performance and language based improvements suggested by help from @Upio.
  Read: https://www.reddit.com/r/algorithms/comments/3wel8h/linear_regression_with_pure_scala/
*/
  
  
}