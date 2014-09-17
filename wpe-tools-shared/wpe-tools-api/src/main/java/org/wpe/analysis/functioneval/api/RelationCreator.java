package org.wpe.analysis.functioneval.api;

import java.util.List;

/**
 * Input points are feed to the function evaluator {@code Function}, and the
 * function output is stored with its input in a {@code Relation}.
 * {@code Relation}s are created in the order of the inputs. Finally, the
 * collected results are returned as a {@code List} of {@code FunctionValue}
 * instances.
 * 
 * A {@code DataGenerator} implementation generates the input points and runs
 * the function evaluator on each point, and then records the output in the
 * order of the inputs. A {@code DataGenerator} creates the inputs (e.g.,
 * equally spaced or random) and a {@code EvaluateFunction} provides the
 * function value at that point. Finally, the collected results are returned as
 * a {@code List} of {@code FunctionValue} entries.
 * 
 * @author Donald Trummell
 *
 * @param <Y>
 *          the result type of running the function (the <em>domain</em>).
 * @param <X>
 *          the type of the parameters or input to the function (the
 *          <em>range</em>).
 */
@FunctionalInterface
public interface RelationCreator<Y, X>
{
  /**
   * Generate the function outputs for inputs and pair them in a list of
   * {@code Relation} instances.
   * 
   * @param inputs
   *          the input points to the function, each is a list of values of the
   *          same type.
   * 
   * @return the list of input-output value pairings defining the relation.
   */
  public abstract List<Relation<Y, X>> generateValues(List<List<X>> inputs);
}