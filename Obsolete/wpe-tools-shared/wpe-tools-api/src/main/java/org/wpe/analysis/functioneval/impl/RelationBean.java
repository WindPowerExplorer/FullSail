package org.wpe.analysis.functioneval.impl;

import java.util.List;

import org.wpe.analysis.functioneval.api.Relation;

/**
 * This bean is a {@code Relation} implementation the captures the inputs and
 * outputs of a single function execution forming a data &quot;<em>point</em>
 * &quot;. The resulting data point does not include the identifier used to
 * generate the function input (<em>domain</em>).
 * <p>
 * <strong>Note:</strong> this is an <em>immutable</em> class instance!
 * Therefore {@code clone} need only be shallow.
 * 
 * @author Donald Trummell
 *
 * @param <Y>
 *          data type of the <em>range</em> or output value of the function
 * @param <X>
 *          the data type for the <em>domain</em> elements or input of a
 *          function
 */
public class RelationBean<Y, X> implements Relation<Y, X>
{
  private static final long serialVersionUID = 151432918723911856L;

  private final Y range;
  private final List<X> domain;

  public RelationBean(final Y range, final List<X> domain)
  {
    if (range == null)
      throw new IllegalArgumentException("range null");

    if (domain == null)
      throw new IllegalArgumentException("domain null");

    this.range = range;
    this.domain = domain;
  }

  /*
   * (non-Javadoc)
   * @see org.wpe.analysis.functioneval.api.Relation#getRange()
   */
  @Override
  public Y getRange()
  {
    return range;
  }

  /*
   * (non-Javadoc)
   * @see org.wpe.analysis.functioneval.api.Relation#getDomain()
   */
  @Override
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

    if (!(obj instanceof RelationBean<?, ?>))
      return false;

    @SuppressWarnings("unchecked")
    final RelationBean<Y, X> rhs = (RelationBean<Y, X>) obj;

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
  public Object clone() throws CloneNotSupportedException
  {
    return super.clone();
  }
}
