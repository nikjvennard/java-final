package sample;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageDraw
{

    //CREATE BASE COLORS
    InputStream d(int height, int width, long time, int samples, double frame) throws IOException
    {

        BufferedImage img;
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int k = 0;

        //REWRITE COLORS TO BE IN CORRECT RANGE AND WRITE
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {

                DrawFunction d = new DrawFunction(time, width, height, img, x, y, k, frame);

                Vec3 rgb = d.draw();
                rgb = dMath.clamp(rgb);

                int R = (int)rgb.x;
                int G = (int)rgb.y;
                int B = (int)rgb.z;

                Color c = new Color(R, G, B);
                img.setRGB(x, y, c.getRGB());

                k++;

            }
        }

        //CREATE INPUT STREAM FOR JAVAFX
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(img, "png", os);
        return new ByteArrayInputStream(os.toByteArray());
    }


}
