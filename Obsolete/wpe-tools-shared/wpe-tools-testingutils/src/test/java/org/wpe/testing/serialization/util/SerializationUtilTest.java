package org.wpe.testing.serialization.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SerializationUtilTest
{

  @Before
  public void setUp() throws Exception
  {
  }

  @After
  public void tearDown() throws Exception
  {
  }

  @Test
  public void testIntegerSerialized()
  {
    final Integer src = 1;

    final byte[] serialized = SerializationUtil.toSerialized(src);
    Assert.assertNotNull("serialized null", serialized);
    Assert.assertTrue("serialized empty", serialized.length > 0);
  }

  @Test
  public void testIntegerDeSerialized() throws ClassNotFoundException
  {
    final Integer src = 1;
    final byte[] serialized = SerializationUtil.toSerialized(src);

    final Object fromSerial = SerializationUtil.fromSerialized(serialized);
    Assert.assertNotNull("from serial null", fromSerial);
    Assert.assertTrue("from serial null wrong type, "
        + fromSerial.getClass().getName(), fromSerial instanceof Integer);
    Assert.assertTrue("identical instance", fromSerial != serialized);
    final Integer src2 = (Integer) fromSerial;
    Assert.assertEquals("content differs", src, src2);
  }

  @Test
  public void testRoundTripInteger() throws ClassNotFoundException
  {
    final Integer src = 1;
    byte[] serialized = SerializationUtil.toSerialized(src);
    Object fromSerial = SerializationUtil.fromSerialized(serialized);
    Integer src2 = (Integer) fromSerial;

    serialized = SerializationUtil.toSerialized(src2);
    fromSerial = SerializationUtil.fromSerialized(serialized);
    src2 = (Integer) fromSerial;

    Assert.assertEquals("round-trip content differs", src, src2);
  }
}
