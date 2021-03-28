package sample;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main extends Application
{

    //IMAGE DEFAULTS
    public static int height = (int)(720/2);
    public int width = (int)(1280/2);
    private GraphicsContext g;
    private long time;
    private double frame = 0;

    //CREATE STAGE AND SCENE FOR JAVAFX WINDOW
    @Override
    public void start(Stage s) throws Exception
    {

        s.setScene(new Scene(createContent()));
        s.setResizable(false);
        s.show();

    }

    //CREATE WINDOW CONTENT AND UPDATE IMAGE
    private Parent createContent() throws IOException
    {

        Pane root = new Pane();
        root.setPrefSize(width, height);

        Canvas c = new Canvas(width, height);
        g = c.getGraphicsContext2D();
        root.getChildren().add(c);


        //CALLING DRAW FUNCTION AND CREATING TIME VAR
        AnimationTimer timer = new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                try {
                    onUpdate();
                    time = now;
                    frame+=.1;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        timer.start();

       // onUpdate();

        return root;
    }

    //DRAW IMAGE ON UPDATE
    private void onUpdate() throws IOException
    {
        ImageDraw draw = new ImageDraw();
        InputStream is = draw.d(height, width, time, 250, frame);
        Image image = new Image(is);
        g.drawImage(image, 0, 0);
    }

    //RUN MAIN APP
    public static void main(String[] args)
    {
        launch(args);
    }

}
