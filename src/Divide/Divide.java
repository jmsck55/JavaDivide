// Copyright (c) 2025 James Cook
// Accurate Divide functions for floats and doubles as a Java class.

package divide;
import java.lang.Math;

/**
 *
 * @author jmsck
 */
public class Divide {
      public static double MultInv(final double d) {
        double c, q, r;
        q = 1 / d;
        r = 0;
        for (int i = 0; i <= 100050; i++) { // 100050
          c = q * d;
          if (c == 1) {
            return q;
          }
          if (c == r) {
            return q;
          }
          q *= (2 - c);
          r = c;
        }
        throw new java.lang.Exception();
      }
      public static double Divide(final double n, final double d) {
        double q;
        q = n * MultInv(d);
        return q;
      }

      public static float MultInvf(final float d) {
        float c, q, r;
        q = 1 / d;
        r = 0;
        for (int i = 0; i <= 100050; i++) { // 100050
          c = q * d;
          if (c == 1) {
            return q;
          }
          if (c == r) {
            return q;
          }
          q *= (2 - c);
          r = c;
        }
        throw new java.lang.Exception();
      }
      public static float Dividef(final float n, final float d) {
        float q;
        q = n * MultInvf(d);
        return q;
      }

public static double NthRoot(double x, short n)
{
  double quotient, average, guess;
  guess = Math.pow(x, MultInv(n));
  quotient = Divide(x, Math.pow(guess, (n-1)));
  average = Divide((quotient + (n-1) * guess), n);
  return average;
}
public static double NthRootf(float x, short n)
      {
            return NthRoot(x, n);
      }

public static double Sqrt(double x)
{
  return NthRoot(x, 2);
}
public static double Sqrtf(float x)
      {
            return Sqrt(x);
      }

public static double CubeRoot(double x)
{
  return NthRoot(x, 3);
}
public static double CubeRootf(float x)
      {
            return CubeRoot(x);
      }


public static double Exp(double x)
{
// using taylor series
// https://en.wikipedia.org/wiki/TaylorSeries
//
//  exp(1) = sum of k=0 to inf (1/k!);
//  exp(x) = sum of k=0 to inf ((x^k)/k!);
//
  double sum, num, den, last;
  num = 1.0;
  den = 1.0;
  sum = 1.0;
  last = 0.0;
  for (int i = 1; i <= 1000000000; i++)
  {
    num *= x;
    den *= i; // number of iterations
    sum += Divide(num, den);
    if (sum == last)
    {
      break;
    }
    last = sum;
  }
  return sum;
}


// Raw function: Natural Logarithm

public static double Log(double a)
{
    // Function: NaturalLogarithm()
    // Use for testing the method.
    // Alternative, between 0 and 2 exclusively:
    // ln(x) = - Sum[k = 1 to inf] ((-1)^k * (-1 + x)^k) / k, for abs(-1 + x) < 1; x > 0 and x < 2;
    // ((-1)^k * (-1 + x)^k) / k
    // ((-x + 1)^k) / k
    // Alternative, away from 0 to 2 exclusively: // Use factoring of "e" instead.
    // ln(x) = ln(-1 + x) - Sum[k = 1 to inf] ((-1)^k * (-1 + x)^(-k)) / k, for abs(-1 + x) > 1, x < 0 or x > 2;
    //
    // precalculate:
    // xNegativePlusOne = (1 - x), then multiply, and store as "p".
    // k = 1, (xNegativePlusOne^1) / 1
    // k = 2, (xNegativePlusOne^2) / 2
    // k = 3, (xNegativePlusOne^3) / 3
    // k = 4, (xNegativePlusOne^4) / 4
    // k = 5, (xNegativePlusOne^5) / 5
    // Then, summate and negate, then return sum:
    // while 1 do
    //  p *= xNegativePlusOne
    //  sum += p / k
    //  if k == inf then -- as k approaches infinity.
    //    exit -- break;
    //  end if
    //  k += 1
    // end while
    // return - (sum)
    //
    double x, p, sum, last, f;
    if (a <= 0.0)
    {
      throw new java.lang.Exception();
    }
    else if (a >= 2.0)
    {
      // factor, first find n, then calculate e^n
      // log(m/e^n) + n = log(m)
      if (a > Math.E)
      {
        f = Math.floor(Math.log(a));
      }
      else
      {
        f = 1.0;
      }
      a = Divide(a, Math.pow(Math.E, f));
    }
    else
    {
      f = 0.0;
    }
    x = 1 - a;
    last = 0.0;
    p = 1.0;
    sum = 0.0;
    for (int k = 1; k <= 1000000000; k++)
    {
      p *= x;
      sum += Divide(p, k);
      if (sum == last)
      {
        break;
      }
      last = sum;
    }
    sum = f - (sum);
    return sum;
}


}
