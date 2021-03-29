public class dMath {


    public static double invert(double fresnel)
    {
        return (fresnel * -1) + 1;
    }

    public static Vec3 clamp(Vec3 color)
    {

        if (color.x < 0.0) {
            color.x = 0.0;
        }

        if (color.y < 0.0) {
            color.y = 0.0;
        }

        if (color.z < 0.0) {
            color.z = 0.0;
        }

        if (color.x > 255.0) {
            color.x = 255.0;
        }

        if (color.y > 255.0) {
            color.y = 255.0;
        }

        if (color.z > 255.0) {
            color.z = 255.0;
        }

        return color;

    }

    public static double mix(double x, double y, double a)
    {
        return x * (1 - a) + y * a;
    }

    public static double clamp(double a, double x, double y)
    {
        if (a < x) {
            a = x;
        } else if (a > y) {
            a = y;
        }
        return a;
    }

    public static double smoothstep(double edge0, double edge1, double x)
    {
        double t = clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);
        return t * t * (3.0 - 2.0 * t);
    }

    public static double lerp(double a, double b, double f)
    {
        return a + f * (b - a);
    }

    public double sinF(double theta)
    {
        return fit(Math.sin(theta), -1, 1, 0, 1);
    }

    //FIT RANGE
    public double fit(final double valueIn, final double baseMin, final double baseMax, final double limitMin, final double limitMax)
    {

        double v = ((limitMax - limitMin) * (valueIn - baseMin) / (baseMax - baseMin)) + limitMin;
        if (v >= 0) {
            return v;
        } else {
            return 0.0;
        }

    }

    //MIN MAX ARRAY VALUE
    public Vec2 getRange(Vec3[] colors)
    {

        double maxA = 0.0;
        double minA = 0.0;
        double maxB = 0.0;
        double minB = 0.0;
        double maxC = 0.0;
        double minC = 0.0;


        for (int i = 0; i < colors.length; i++) {
            maxA = Math.max(maxA, colors[i].x);
            maxB = Math.max(maxB, colors[i].y);
            maxC = Math.max(maxC, colors[i].z);

            minA = Math.max(minA, colors[i].x);
            minB = Math.max(minB, colors[i].y);
            minC = Math.max(minC, colors[i].z);

        }

        double max = Math.max(maxC, Math.max(maxA, maxB));
        double min = Math.min(maxC, Math.min(maxA, maxB));
        return new Vec2(min, max);

    }

    public double N21(Vec2 v)
    {
        return fract(Math.sin(v.x * 100. + v.y * 5214) * 5213);
    }

    public double fract(double d)
    {
        return d - Math.floor(d);
    }

}
