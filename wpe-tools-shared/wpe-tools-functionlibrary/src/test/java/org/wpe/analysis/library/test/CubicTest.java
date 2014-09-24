package org.wpe.analysis.library.test;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wpe.analysis.functioneval.api.Function;
import org.wpe.analysis.library.CubicDoubleParam;

public class CubicTest
{
  private static final double FX_DELTA = 0.00000005;

  private Function<Double, Double> func = null;

  public double a0 = 1;
  public double a1 = 2;
  public double a2 = 3;
  public double a3 = 4;

  @Before
  public void setUp() throws Exception
  {
    func = new CubicDoubleParam(a0, a1, a2, a3);
  }

  @After
  public void tearDown() throws Exception
  {
    func = null;
  }

  @Test(expected = IllegalArgumentException.class)
  public void testParamListNull()
  {
    final Double actual = func.evaluate(null);
    Assert.assertNull(actual);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testParamEmpty()
  {
    final Double actual = func.evaluate(new ArrayList<Double>());
    Assert.assertNull(actual);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testParamValueNull()
  {
    final ArrayList<Double> vector = new ArrayList<Double>();
    vector.add(null);
    final Double actual = func.evaluate(vector);
    Assert.assertNull(actual);
  }

  // ----------------------------------------------------------------------------

  @Test
  public void testEvaluateOK()
  {
    double x = 0.0;
    Assert.assertEquals("failed for " + x, a0, func.evaluate(Arrays.asList(x)),
        0.0000005);

    x = -1.0;
    Assert.assertEquals("failed for " + x, fx(x),
        func.evaluate(Arrays.asList(x)), FX_DELTA);

    x = -2.0;
    Assert.assertEquals("failed for " + x, fx(x),
        func.evaluate(Arrays.asList(x)), 0.0000005);

    x = -3.0;
    Assert.assertEquals("failed for " + x, fx(x),
        func.evaluate(Arrays.asList(x)), 0.0000005);

    x = 1.0;
    Assert.assertEquals("failed for " + x, fx(x),
        func.evaluate(Arrays.asList(x)), 0.0000005);

    x = 2.0;
    Assert.assertEquals("failed for " + x, fx(x),
        func.evaluate(Arrays.asList(x)), 0.0000005);

    x = 3.0;
    Assert.assertEquals("failed for " + x, fx(x),
        func.evaluate(Arrays.asList(x)), 0.0000005);
  }

  // ---------------------------------------------------------------------------

  private Double fx(final double x)
  {
    return a0 + a1 * x + a2 * (x * x) + a3 * (x * x * x);
  }
}
