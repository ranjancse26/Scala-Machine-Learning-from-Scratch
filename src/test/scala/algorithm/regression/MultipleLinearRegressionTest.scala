// Wei Chen - Multiple Linear Regression Test
// 2016-06-04

import org.scalatest.FunSuite
import com.scalaml.TestData._
import com.scalaml.general.MatrixFunc._
import com.scalaml.algorithm.MultipleLinearRegression

class MultipleLinearRegressionSuite extends FunSuite {

    val mlr = new MultipleLinearRegression()
    
    test("MultipleLinearRegression Test : Clear") {
        assert(mlr.clear())
    }

    test("MultipleLinearRegression Test : Linear Data") {
        assert(mlr.clear())
        assert(mlr.config(Map[String, Double]()))
        assert(mlr.train(LABELED_LINEAR_DATA.map(yx => yx._1.toDouble -> yx._2)))
        val result = mlr.predict(UNLABELED_LINEAR_DATA)
        assert(arraysimilar(result, LABEL_LINEAR_DATA.map(_.toDouble), 0.9))
    }

    test("MultipleLinearRegression Test : Nonlinear Data - WRONG") {
        assert(mlr.clear())
        assert(mlr.config(Map[String, Double]()))
        assert(mlr.train(LABELED_NONLINEAR_DATA.map(yx => yx._1.toDouble -> yx._2)))
        val result = mlr.predict(UNLABELED_NONLINEAR_DATA)
        assert(!arraysimilar(result, LABEL_LINEAR_DATA.map(_.toDouble), 0.45))
    }
}