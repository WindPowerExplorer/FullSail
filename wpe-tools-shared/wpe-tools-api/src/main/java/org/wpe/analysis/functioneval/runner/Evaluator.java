package org.wpe.analysis.functioneval.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.wpe.analysis.functioneval.impl.RelationBean;
import org.wpe.analysis.functioneval.impl.TemplateFunctionEvaluator;

/**
 * This program generates data from a function using, input data points created
 * by a generator, and persists them using a writer. The test function
 * implements {@code Function}, the input generator for the test function
 * implements {@code DataGenerator}, and the output writer of {@code Relation}
 * instances implements {@code yyy}.
 * 
 * @author Donald Trummell
 */
public class Evaluator
{
  public Evaluator()
  {
  }

  public static void main(final String[] args)
  {
    System.out.println("Hi");

    TemplateFunctionEvaluator<Double, Double> eval = new TemplateFunctionEvaluator<Double, Double>();
    eval.setFunctionEvaluator((final List<Double> vector) -> 1000.0 * vector
        .get(0));

    final List<List<Double>> inputs = new ArrayList<List<Double>>();
    inputs.add(Arrays.asList(1.0, 22.2, 33.3));
    inputs.add(Arrays.asList(2.0, 44.4, 55.5));

    final List<RelationBean<Double, Double>> mapping = eval.generateValues(inputs);
    System.out.println("Got: " + mapping);
  }
}
