package hongchengstudy.dataformat;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy:MM:dd  hh:mm:ss SSS");
        System.out.println(dataFormat.format(date));
    }
}
/*
 public static int round(float a) {
        int intBits = Float.floatToRawIntBits(a);
        int biasedExp = (intBits & FloatConsts.EXP_BIT_MASK)
                >> (FloatConsts.SIGNIFICAND_WIDTH - 1);
        int shift = (FloatConsts.SIGNIFICAND_WIDTH - 2
                + FloatConsts.EXP_BIAS) - biasedExp;
        if ((shift & -32) == 0) { // shift >= 0 && shift < 32
            // a is a finite number such that pow(2,-32) <= ulp(a) < 1
            int r = ((intBits & FloatConsts.SIGNIF_BIT_MASK)
                    | (FloatConsts.SIGNIF_BIT_MASK + 1));
            if (intBits < 0) {
                r = -r;
            }
            // In the comments below each Java expression evaluates to the value
            // the corresponding mathematical expression:
            // (r) evaluates to a / ulp(a)
            // (r >> shift) evaluates to floor(a * 2)
            // ((r >> shift) + 1) evaluates to floor((a + 1/2) * 2)
            // (((r >> shift) + 1) >> 1) evaluates to floor(a + 1/2)
            return ((r >> shift) + 1) >> 1;
        } else {
            // a is either
            // - a finite number with abs(a) < exp(2,FloatConsts.SIGNIFICAND_WIDTH-32) < 1/2
            // - a finite number with ulp(a) >= 1 and hence a is a mathematical integer
            // - an infinity or NaN
            return (int) a;
        }
    }

    public static double rint(double a) {

double twoToThe52 = (double)(1L << 52); // 2^52
    double sign = Math.copySign(1.0, a); // preserve sign info
        a = Math.abs(a);

                if (a < twoToThe52) { // E_min <= ilogb(a) <= 51
        a = ((twoToThe52 + a ) - twoToThe52);
        }

        return sign * a; // restore original sign
        }


 */
