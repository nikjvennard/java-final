package sample;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DrawFunction
{

    private double time;
    private int width;
    private int height;
    private BufferedImage img;
    private int x;
    private  int y;
    private Vec3 lastFrame;

    private ArrayList<Vec3> LB;

    public DrawFunction(double time, int width, int height, BufferedImage img, int X, int Y, int pxl, double frame)
    {
        this.time = time;
        this.width = width;
        this.height = height;
        this.img = img;
        this.x = X;
        this.y = Y;
        this.lastFrame = lastFrame;

    }

    public Vec3 draw()
    {
        double t = time;

        Vec2 uv = new Vec2((x)/(double)width, (y/(double)height));

        double r = uv.x;
        double g = uv.y;
        double b = 0;

        return vMath.mult(new Vec3(r, g, b), 255);

    }

}
