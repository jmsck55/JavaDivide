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

public static double NthRootf(float x, short n)
{
  double quotient, average, guess;
  guess = Math.pow(x, MultInv(n));
  quotient = Divide(x, Math.pow(guess, (n-1)));
  average = Divide((quotient + (n-1) * guess), n);
  return average;
}

      
}
