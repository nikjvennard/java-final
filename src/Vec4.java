public class Vec4 extends Vec3 {

    protected double w;

    public Vec4(double x, double y, double z, double w)
    {
        super(x, y, z);
        this.w = w;
    }

    public double getW()
    {
        return w;
    }

    public void setW(double w)
    {
        this.w = w;
    }

}
