package sample;

import java.util.Random;

public class vMath
{

    public static double length(Vec2 a)
    {
        return Math.sqrt(Math.pow(a.x, 2) + Math.pow(a.y, 2));
    }

    public static double length(Vec3 a)
    {
        return Math.sqrt(Math.pow(a.x, 2) + Math.pow(a.y, 2) + Math.pow(a.z, 2));
    }

    public static double length(Vec4 a)
    {
        return Math.sqrt(Math.pow(a.x, 2) + Math.pow(a.y, 2) +
                               Math.pow(a.z, 2) + Math.pow(a.w, 2));
    }
    public static double dot(Vec2 a, Vec2 b)
    {
        return (a.x*b.x)+(a.y*b.y);
    }

    public static double dot(Vec3 a, Vec3 b)
    {
        return (a.x*b.x)+(a.y*b.y)+(a.z*b.z);
    }

    public static double dot(Vec4 a, Vec4 b)
    {
        return (a.x*b.x)+(a.y*b.y)+(a.z*b.z)+(a.w*b.w);
    }

    public static Vec3 cross(Vec3 a, Vec3 b)
    {
        double x, y, z;
        x = a.y*b.z - a.z*b.y;
        y = a.z*b.x - a.x*b.z;
        z = a.x*b.y - a.y*b.x;
        return new Vec3(x, y, z);
    }
    public static Vec2 add(Vec2 a, Vec2 b)
    {
        return new Vec2(a.x+b.x,a.y+b.y);
    }

    public static Vec3 add(Vec3 a, Vec3 b)
    {
        return new Vec3(a.x+b.x,a.y+b.y, a.z+b.z);
    }

    public static Vec4 add(Vec4 a, Vec4 b)
    {
        return new Vec4(a.x+b.x,a.y+b.y,a.z+b.z,a.w+b.w);
    }

    public static Vec2 sub(Vec2 a, Vec2 b)
    {
        return new Vec2(a.x-b.x,a.y-b.y);
    }

    public static Vec3 sub(Vec3 a, Vec3 b)
    {
        return new Vec3(a.x-b.x,a.y-b.y, a.z-b.z);
    }

    public static Vec4 sub(Vec4 a, Vec4 b)
    {
        return new Vec4(a.x-b.x,a.y-b.y,a.z-b.z,a.w-b.w);
    }

    public static Vec2 mult(Vec2 a, double s)
    {
        return new Vec2(a.x*s,a.y*s);
    }

    public static Vec3 mult(Vec3 a, double s)
    {
        return new Vec3(a.x*s,a.y*s, a.z*s);
    }

    public static Vec4 mult(Vec4 a, double s)
    {
        return new Vec4(a.x*s,a.y*s,a.z*s,a.w*s);
    }

    public static Vec2 div(Vec2 a, double s)
    {
        return new Vec2(a.x/s,a.y/s);
    }

    public static Vec3 div(Vec3 a, double s)
    {
        return new Vec3(a.x/s,a.y/s, a.z/s);
    }

    public static Vec4 div(Vec4 a, double s)
    {
        return new Vec4(a.x/s,a.y/s,a.z/s,a.w/s);
    }

    public static Vec2 normalize(Vec2 v)
    {
        return div(v, length(v));
    }

    public static Vec3 normalize(Vec3 v)
    {
        return div(v, length(v));
    }

    public static Vec4 normalize(Vec4 v)
    {
        return div(v, length(v));
    }

    public static Vec2 fract(Vec2 v)
    {
        return  new Vec2(v.x - Math.floor(v.x), v.y - Math.floor(v.y));
    }

    public static Vec2 floor(Vec2 v)
    {
        return new Vec2(Math.floor(v.x), Math.floor(v.y));
    }

    public static Vec3 pRay(Vec3 v, Vec3 v2, double t)
    {
        return    add(mult( v, 1.0-t), mult( v2, t));
    }

    public static Vec2 sub(Vec2 uv, double v)
    {
        return new Vec2(uv.x - v, uv.y - v);
    }

    public static Vec2 normCoord(Vec2 uv, Vec2 resolution)
    {
        uv = sub(uv, .5);
        uv.x *= (double)resolution.x/(double)resolution.y;
        return uv;
    }

    public static Vec3 add(Vec3 n, double i)
    {
        return new Vec3(n.x+i, n.y+i, n.z+i);
    }

    public static Vec3 randV(long seed)
    {
        Random rand = new Random();
        rand.setSeed(seed);
        double x, y ,z;
        x = (rand.nextDouble()-.5)*5.0;
        y = (rand.nextDouble()-.5)*5.0;
        z = (rand.nextDouble()-.5)*5.0;

        return new Vec3(x, y, z);

    }

    public static Vec3 randUnitV()
    {
        long i;
        while(true)
        {
            i = new Random().nextLong();
            Vec3 P = randV(i);
            i += i;
            if(length(P)*length(P) >= 1) continue;
            return vMath.normalize(P);
        }

    }

    public static Vec3 mult(Vec3 n, Vec3 i)
    {
        return new Vec3(n.x*i.x, n.y*i.y, n.z*i.z);
    }

    public static Vec3 reflect(Vec3 v, Vec3 n)
    {
        return sub(v, mult(n, dot(v, n)*2));
    }

    public static Vec3 mix(Vec3 met, Vec3 dif, double mix)
    {
         return new Vec3(dMath.mix(met.x, dif.x, mix), dMath.mix(met.y, dif.y, mix), dMath.mix(met.z, dif.z, mix));
    }


}
