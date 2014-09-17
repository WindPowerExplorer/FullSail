package org.wpe.analysis.functioneval.api;

import java.util.List;

/**
 * Evaluates a test function using input data (<em>domain</em>) to produce a
 * scaler output (<em>range</em>).
 * 
 * @author Donald Trummell
 *
 * @param <Y>
 *          the type of the <em>range</em> or function output
 * @param <X>
 *          the type of the formal parameters in the <em>domain</em> or function
 *          input.
 */
@FunctionalInterface
public interface Function<Y, X>
{
  /**
   * Evaluate the test function, producing an output in the function
   * <em>range</em>, using the input (<em>domain</em>).
   * 
   * @param vector
   *          the multi-valued function input
   * 
   * @return the computed value corresponding to the input
   */
  public abstract Y evaluate(final List<X> vector);
}
