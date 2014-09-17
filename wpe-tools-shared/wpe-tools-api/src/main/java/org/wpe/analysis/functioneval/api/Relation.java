package org.wpe.analysis.functioneval.api;

import java.io.Serializable;
import java.util.List;

/**
 * Capture the inputs and outputs of a single function execution forming a data
 * &quot;<em>point</em>&quot;. The resulting data point does not include the
 * identifier used to generate the function input ( <em>domain</em>).
 * <p>
 * <strong>Note:</strong> this is an <em>immutable</em> class! Therefore
 * {@code clone} need only be shallow.
 * 
 * @author Donald Trummell
 *
 * @param <Y>
 *          data type of the <em>range</em> or output value of the function
 * @param <X>
 *          the data type for the <em>domain</em> elements or input of a
 *          function
 */
public class Relation<Y, X> implements Cloneable, Serializable
{
  private static final long serialVersionUID = -4685032613178187556L;

  private final Y range;
  private final List<X> domain;

  public Relation(final Y range, final List<X> domain)
  {
    if (range == null)
      throw new IllegalArgumentException("range null");

    if (domain == null)
      throw new IllegalArgumentException("domain null");

    this.range = range;
    this.domain = domain;
  }

  public Y getRange()
  {
    return range;
  }

  public List<X> getDomain()
  {
    return domain;
  }

  @Override
  public String toString()
  {
    final StringBuilder msg = new StringBuilder();
    msg.append("[");
    msg.append(getClass().getSimpleName());
    msg.append(" - 0x");
    msg.append(Integer.toHexString(hashCode()));
    msg.append(";");
    msg.append(";  range: ");
    msg.append(range);
    msg.append(";  domain: ");
    msg.append(String.valueOf(domain));
    msg.append("]");

    return msg.toString();
  }

  @Override
  public int hashCode()
  {
    int code = 3541;

    if (range == null)
      code += 1;
    else
    {
      code *= 31;
      code += range.hashCode();
    }

    if (domain == null)
      code += 3;
    else
    {
      code *= 31;
      code += domain.hashCode();
    }

    return code;
  }

  @Override
  public boolean equals(final Object obj)
  {
    if (this == obj)
      return true;

    if (!(obj instanceof Relation<?, ?>))
      return false;

    @SuppressWarnings("unchecked")
    final Relation<Y, X> rhs = (Relation<Y, X>) obj;

    if (!compareMissing(this.range, rhs.range))
      return false;

    return compareMissing(this.domain, rhs.domain);
  }

  private static boolean compareMissing(final Object lhs, final Object rhs)
  {
    if (lhs == null)
      return rhs == null;

    if (rhs == null)
      return false;

    return lhs.equals(rhs);
  }

  /**
   * Shallow clone of immutable object
   */
  @Override
  protected Object clone() throws CloneNotSupportedException
  {
    return super.clone();
  }
}
