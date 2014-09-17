package org.wpe.analysis.functioneval.impl;

import java.util.ArrayList;
import java.util.List;

import org.wpe.analysis.functioneval.api.Function;
import org.wpe.analysis.functioneval.api.Relation;
import org.wpe.analysis.functioneval.api.RelationCreator;

/**
 * Generate the input points and run the function evaluator on each point,
 * recording the output in the order of the inputs. A {@code DataGenerator}
 * presumably creates the inputs (e.g., equally spaced or random), and a
 * {@code Function} instance provides the test function value at that point.
 * Finally, the collected results are returned as a {@code List} of
 * {@code FunctionValue} instances.
 * 
 * @author Donald Trummell
 *
 * @param <Y>
 *          the output type of the test function (the <em>range</em>).
 * @param <X>
 *          the type of the test function input parameters (the <em>domain</em>
 *          ).
 */
public class TemplateFunctionEvaluator<Y, X> implements RelationCreator<Y, X>
{
  private Function<Y, X> functionEvaluator = null;

  public TemplateFunctionEvaluator()
  {
  }

  @Override
  public List<Relation<Y, X>> generateValues(final List<List<X>> inputs)
  {
    if (inputs == null)
      throw new IllegalArgumentException("inputs null");

    if (inputs.isEmpty())
      throw new IllegalArgumentException("inputs empty");

    if (functionEvaluator == null)
      throw new IllegalStateException("no function evaluator provided");

    final List<Relation<Y, X>> results = new ArrayList<Relation<Y, X>>();

    for (final List<X> vector : inputs)
      results
          .add(new Relation<Y, X>(functionEvaluator.evaluate(vector), vector));

    return results;
  }

  // ---------------------------------------------------------------------------

  public Function<Y, X> getFunctionEvaluator()
  {
    return functionEvaluator;
  }

  public void setFunctionEvaluator(final Function<Y, X> functionEvaluator)
  {
    this.functionEvaluator = functionEvaluator;
  }
}
