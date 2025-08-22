// Copyright (c) 2025 James Cook
// Accurate Divide functions for floats and doubles as a Java class.

package divide;

/**
 *
 * @author jmsck
 */
public class Divide {
      public static double MultInv(final double d) {
        double c, q, r;
        q = 1.0 / d;
        r = 0;
        for (int i = 0; i <= 20; i++) {
          c = q * (2 - q * d);
          if (c == q) {
            break;
          }
          if (i > 10) { // 10 and 20 above can be increased, if needed.
            q -= c;
            q = Math.abs(q);
            if (q == r) {
              q = c;
              break;
            }
            r = q;
          }
          q = c;
        }
        return q;
      }
      public static double Divide(final double n, final double d) {
        double q;
        q = n * MultInv(d);
        return q;
      }
}
