
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TrafficSimulator extends Application implements Runnable{
    Circle red = new Circle();
    Circle green = new Circle();
    Circle yellow = new Circle();
    Button b1 = new Button();
@Override
public void start(Stage stage) {
    //Drawing a Rectangle 
    Rectangle rectangle = new Rectangle();

    //grid layout
    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
//buttons
    HBox hbButtons = new HBox();

    Button buttonStart = new Button("Start");
    Button buttonStop = new Button("Stop");
  buttonStart.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
        green.setFill(Color.YELLOW);
}
    });
   buttonStart.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent event) {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    green.setFill(Color.GREEN);

                    Thread.sleep(3000L);
                    green.setFill(Color.GRAY);
                    yellow.setFill(Color.YELLOW);

                    Thread.sleep(3000L);
                    yellow.setFill(Color.GRAY);
                    red.setFill(Color.RED);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
});

  
   
    //labels and textfeilds
    Label lblGreen = new Label("Green");
   // TextField tfGreen = new TextField("3");
    Slider sl1 = new Slider();
    sl1.setMin(0);
    sl1.setMax(5);
    System.out.println(sl1.getValue());
    
    Label lblYellow = new Label("Yellow");
    //TextField tfYellow = new TextField("3");
     Slider sl2 = new Slider();
     sl2.setMin(0);
    sl2.setMax(5);
    System.out.println(sl2.getValue());
    
    Label lblRed = new Label("Red");
   // TextField tfRed = new TextField("3");
     Slider sl3 = new Slider();
     sl3.setMin(0);
    sl3.setMax(5);
    System.out.println(sl3.getValue());

    grid.add(lblGreen, 0, 0);
    grid.add(sl1, 1, 0);
    grid.add(lblYellow, 0, 1);
    grid.add(sl2, 1, 1);
    grid.add(lblRed, 0, 2);
    grid.add(sl3, 1, 2);
    grid.setPadding(new Insets(320, 5, 30, 40));


    hbButtons.getChildren().addAll(buttonStart, buttonStop);
    hbButtons.setAlignment(Pos.BOTTOM_CENTER);
    //Setting the properties of the rectangle 
    rectangle.setX(200);
    rectangle.setY(25);
    rectangle.setWidth(200);
    rectangle.setHeight(400);

    rectangle.setArcHeight(25);
    rectangle.setArcWidth(25);
    Color c = Color.web("#404040");
    Color color1 = Color.web("#404040");
    Color color2 = Color.web("#808080");
    Color greenColor = Color.web("#00FF00");

    rectangle.setFill(c);
    //setting circle properties

    green.setCenterX(305);
    green.setCenterY(100);
    green.setRadius(50);
    green.setFill(greenColor);

    yellow.setCenterX(305);
    yellow.setCenterY(210);
    yellow.setRadius(50);
    yellow.setFill(color2);
   
    red.setCenterX(305);
    red.setCenterY(325);
    red.setRadius(50);
    red.setFill(color2);
    hbButtons.setPadding(new Insets(15, 12, 15, 12));
    hbButtons.setSpacing(10);   // Gap between nodes
    //Creating a Group object  
    StackPane rootPane = new StackPane();
    Pane p1 = new Pane(red, green, yellow);
    Pane p2 = new Pane(rectangle);
    grid.add(hbButtons, 2, 2, 2, 1);
    //  grid.add(grid, 2, 0, 0, 0);

    rootPane.getChildren().addAll(p2, p1, grid);
    //Creating a scene object 
    Scene scene = new Scene(rootPane, 500, 500);

    //Setting title to the Stage 
    stage.setTitle("Traffic Light");

    //Adding scene to the stage 
    stage.setScene(scene);

    //Displaying the contents of the stage 
    stage.show();
}
public static void main(String args[]) {
    launch(args);
}

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    


    
}
