package sample;

public class Vec3 extends Vec2
{

    protected double z;

    public Vec3(double x, double y, double z)
    {
        super(x, y);
        this.z = z;
    }

    public double getZ()
    {
        return z;
    }

    public void setZ(double z)
    {
        this.z = z;
    }

    @Override
    public String toString()
    {
        return "Vec3{" +
                "z=" + z +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
