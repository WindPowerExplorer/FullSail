package org.wpe.analysis.functioneval.api.test;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wpe.analysis.functioneval.api.Relation;
import org.wpe.analysis.functioneval.impl.RelationBean;
import org.wpe.testing.serialization.util.SerializationUtil;

public class RelationBeanTest
{
  private Relation<Integer, Integer> r;
  private Relation<Integer, Integer> ra;
  private Relation<Integer, Integer> r2;

  @Before
  public void setUp() throws Exception
  {
    r = new RelationBean<Integer, Integer>(3, Arrays.asList(1, 1));
    ra = new RelationBean<Integer, Integer>(3, Arrays.asList(1, 1));
    r2 = new RelationBean<Integer, Integer>(5, Arrays.asList(2, 1));
  }

  @After
  public void tearDown() throws Exception
  {
    r = null;
    ra = null;
    r2 = null;
  }

  @Test
  public void testEquals()
  {
    Assert.assertTrue("identical failed", r.equals(r));
    Assert.assertEquals("same content failed", r, ra);
    Assert.assertFalse("different equal", r.equals(r2));
    // System.err.println("Sample: " + r2);
  }

  @Test
  public void testHC()
  {
    Assert.assertEquals("identical differs", r.hashCode(), r.hashCode());
    Assert.assertEquals("same content differs", r.hashCode(), ra.hashCode());
    Assert.assertFalse("different has same HC", r.hashCode() == r2.hashCode());
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testClone()
  {
    Relation<Integer, Integer> rc = null;
    try
    {
      rc = (Relation<Integer, Integer>) r.clone();
    }
    catch (CloneNotSupportedException ex)
    {
      Assert.fail("clone failed: " + ex.getMessage());
    }

    Assert.assertNotNull("clone null", rc);
    Assert.assertEquals("clone not equal", r, rc);
  }

  @Test
  public void testSerialized() throws ClassNotFoundException
  {
    final byte[] serializedR = SerializationUtil.toSerialized(r);
    Assert.assertNotNull("serialized r null", serializedR);
    Assert.assertTrue("serialized r empty", serializedR.length > 0);

    final Object fromSerialR = SerializationUtil.fromSerialized(serializedR);
    Assert.assertNotNull("from serialized r null", fromSerialR);
    Assert.assertTrue("from serialized r not a relation",
        fromSerialR instanceof Relation<?, ?>);
    
    @SuppressWarnings("unchecked")
    final Relation<Integer, Integer> rs = (Relation<Integer, Integer>) fromSerialR;
    Assert.assertEquals("from serialized r differs", r, rs);
  }
}
