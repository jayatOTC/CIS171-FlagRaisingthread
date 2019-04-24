/*
 * Developer:   James Allen
 * Date:        04/23/2019
 * Purpose:     (Raise flags) Rewrite Listing 15.13 using a thread to animate a 
 *              flag being raised. Compare the program with Listing 15.13 by 
 *              setting the delay time to 10 in both programs. 
 *              Which one runs the animation faster?
 */
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.animation.PathTransition;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
public class FlagRaising extends Application
{
    @Override // Override the start method in the Application class
      public void start(Stage primaryStage) 
      {
        // Create a pane 
        Pane pane = new Pane();

        // Add an image view and add it to pane
        ImageView imageView = new ImageView("image/us.gif");
        pane.getChildren().add(imageView);

        // create tasks
        Runnable raise = new Raise(imageView);
        // create thread
        Thread thread = new Thread(raise);
        // start thread
        thread.start();     
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("FlagRaisingAnimation"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
      }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    } // end of main
    
    class Raise implements Runnable
    {
        
        public Raise(ImageView imageView)
        {
                // Create a path transition 
        PathTransition pt = new PathTransition(Duration.millis(10000),
          new Line(200, 200, 100, 0), imageView);
        pt.setCycleCount(10);
        pt.play(); // Start animation 
        } // end of imageview
        
        @Override
        public void run()
	{
            
        } // end of run
    } // end of Raise
    
} // end of class FlagRaising

