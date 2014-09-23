package org.wpe.analysis.functioneval.api;

import java.io.Serializable;
import java.util.List;

/**
 * A {@code Relation} instance captures the inputs and outputs of a single
 * function execution forming a data &quot;<em>point</em>&quot;. The resulting
 * data point does not include the identifier used to generate the function
 * input (<em>domain</em>).
 * 
 * @author Donald Trummell
 *
 * @param <Y>
 *          data type of the <em>range</em> or output value of the function
 * @param <X>
 *          the data type for the <em>domain</em> elements or input of a
 *          function
 */
public interface Relation<Y, X> extends Cloneable, Serializable
{
  public abstract Y getRange();

  public abstract List<X> getDomain();

  public abstract Object clone() throws CloneNotSupportedException;
}