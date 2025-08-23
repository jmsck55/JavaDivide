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
        for (int i = 0; i <= 77; i++) { // 77
          c = q * (2 - q * d);
          if (c == q) {
            break;
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
