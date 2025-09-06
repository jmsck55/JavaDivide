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
        q = 1 / d;
        r = 0;
        for (int i = 0; i <= 1050; i++) { // 1050
          c = q * d;
          if (c == 1) {
            break;
          }
          if (c == r) {
            break;
          }
          q *= (2 - c);
          r = c;
        }
        return q;
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
        for (int i = 0; i <= 1050; i++) { // 1050
          c = q * d;
          if (c == 1) {
            break;
          }
          if (c == r) {
            break;
          }
          q *= (2 - c);
          r = c;
        }
        return q;
      }
      public static float Dividef(final float n, final float d) {
        float q;
        q = n * MultInvf(d);
        return q;
      }
}
