package org.wpe.analysis.library;

import java.util.List;

import org.wpe.analysis.functioneval.api.Function;

/**
 * Evaluate a third degree polynomial.
 * 
 * <pre>
 * <code>
 * Function(x) = a0 + a1 * X + a2 * x^2 + a3 * x^3
 * </code>
 * </pre>
 * 
 * @author Donald Trummell
 */
public class CubicDoubleParam implements Function<Double, Double>
{
  public static final int PARAM_COUNT = 1;

  private Double a0 = null;
  private Double a1 = null;
  private Double a2 = null;
  private Double a3 = null;

  public CubicDoubleParam(final Double a0, final Double a1, final Double a2,
      final Double a3)
  {
    this.a0 = a0;
    this.a1 = a1;
    this.a2 = a2;
    this.a3 = a3;

    if (a0 == null)
      throw new IllegalArgumentException("a0 null");
    if (a1 == null)
      throw new IllegalArgumentException("a1 null");
    if (a2 == null)
      throw new IllegalArgumentException("a2 null");
    if (a3 == null)
      throw new IllegalArgumentException("a3 null");
  }

  @Override
  public Double evaluate(final List<Double> vector)
  {
    if (vector == null)
      throw new IllegalArgumentException("vector null");

    final int pcount = vector.size();
    if (pcount != PARAM_COUNT)
      throw new IllegalArgumentException("Expected " + PARAM_COUNT
          + " parameters, found " + pcount);

    final Double v0 = vector.get(0);
    if (v0 == null)
      throw new IllegalArgumentException("vector[0] null");
    final double x = v0.doubleValue();

    final double y = a0 + x * (a1 + x * (a2 + x * a3));

    return y;
  }

  public Double getA0()
  {
    return a0;
  }

  public Double getA1()
  {
    return a1;
  }

  public Double getA2()
  {
    return a2;
  }

  public Double getA3()
  {
    return a3;
  }

  @Override
  public String toString()
  {
    return "[" + getClass().getSimpleName() + "0x"
        + Integer.toHexString(hashCode()) + ";  a0: " + a0 + ";  a1: " + a1
        + ";  a2: " + a2 + ";  a3: " + a3 + "]";
  }
}
