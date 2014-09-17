package org.wpe.analysis.functioneval.api;

import java.util.List;

/**
 * A {@code DataGenerator} implementation generates a data point corresponding
 * to an identifier that will be used to evaluate the test function. This
 * generated data is the <em>domain</em> for the test function.
 * 
 * @author Donald Trummell
 *
 * @param <X>
 *          the data type of the generated data, to be used as the
 *          <em>domain</em> of the test function.
 * @param <P>
 *          the data type of the test point identifier.
 */
public interface DataGenerator<X, P>
{
  /**
   * Generate a data point corresponding to the test case defined by the
   * identifier.
   * 
   * @param pointId
   *          the identity for the test case
   * 
   * @return the generated test function input (<em>domain</em>).
   */
  public abstract List<X> generateDataPoint(final P pointId);
}
