package org.wpe.testing.serialization.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationUtil implements Serializable
{
  private static final long serialVersionUID = 6284328706916078644L;

  /**
   * Prevent construction
   */
  private SerializationUtil()
  {
  }

  /**
   * Return the serialized form of the source
   * 
   * @param src
   *          the instance to serialize
   * 
   * @return bytes representing the serialized object
   */
  public static byte[] toSerialized(final Serializable src)
  {
    if (src == null)
      throw new IllegalArgumentException("src null");

    ByteArrayOutputStream bas = new ByteArrayOutputStream(128);
    ObjectOutputStream oos = null;
    try
    {
      oos = new ObjectOutputStream(bas);
      oos.writeObject(src);
      oos.flush();
    }
    catch (IOException ex)
    {
    }
    finally
    {
      if (bas != null)
        try
        {
          bas.close();
        }
        catch (IOException ignore)
        {
          // Ignore
        }

      if (oos != null)
        try
        {
          oos.close();
        }
        catch (IOException ignore)
        {
          // Ignore
        }
    }

    return bas.toByteArray();
  }

  /**
   * Return the object instance derived from serialized representation
   * 
   * @param src
   *          the byte array representing the serialized form
   * 
   * @return an object instance derived from the source
   * @throws ClassNotFoundException
   */
  public static Object fromSerialized(final byte[] src)
      throws ClassNotFoundException
  {
    if (src == null)
      throw new IllegalArgumentException("src null");

    if (src.length < 1)
      throw new IllegalArgumentException("src empty");

    Object newInstance = null;
    final ByteArrayInputStream bis = new ByteArrayInputStream(src);
    ObjectInputStream ois = null;
    try
    {
      ois = new ObjectInputStream(bis);
      newInstance = ois.readObject();
    }
    catch (IOException ignore)
    {
      // Ignore
    }

    if (newInstance == null)
      throw new IllegalArgumentException("src with " + src.length
          + " bytes returned null instance");

    return newInstance;
  }
}
