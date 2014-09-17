package org.wpe.testing.concurrent.util;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * Execute the list of <code>Runnable</code> instances capturing runtime errors.
 * 
 * @author Donald Trummell
 */
public interface Launch
{
  /**
   * Collect each <code>Runnable</code> instance and run them all, starting at
   * the <em>same time</em> if mult-threaded. If multi-threaded, the pool of
   * threads neither grows nor shrinks.
   * 
   * @param label
   *          the identity of this run
   * @param runnables
   *          the items to run in each thread
   * @param maxTimeoutSeconds
   *          the maximum execution timeout
   * @return a optionally empty list of exceptions encountered while running
   * 
   * @throws InterruptedException
   * @throws TimeoutException
   */
  public abstract List<Throwable> launchRunnables(final String label,
      final List<? extends Runnable> runnables, final int maxTimeoutSeconds)
      throws InterruptedException, TimeoutException;

  /**
   * If trace is <code>true</code>, then log executions.
   * 
   * @return the trace state
   */
  public abstract boolean isTrace();

  /**
   * If trace is <code>true</code>, then log executions.
   * 
   * @param trace
   *          the trace state to set
   */
  public abstract void setTrace(boolean trace);
}