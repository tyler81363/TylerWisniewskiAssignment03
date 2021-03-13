
        
package assignment03_tylerwisniewski;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;

public class Assignment03_TylerWisniewski extends Application
{
   Group group;
   GraphicsContext gc;
   
   //to launch application
   @Override
   public void start(Stage stage)
           
   {
       
       // This is to initiate the title of the canvas
       stage.setTitle("Canvas title");
       
//create the canvas that displays the application
       Canvas canvas = new Canvas(600.0f, 600.0f);
       
gc = canvas.getGraphicsContext2D();

//Group create
group = new Group(canvas);
draw1();

//creating scene for the actual image
Scene scene = new Scene(group, 600, 600);

stage.setScene(scene);
stage.show();
       }
    
   public void draw1()
   {
       // the sky
       gc.setFill(Color.LIGHTBLUE);
       gc.fillRect(0,0,600,250);
       
       // the lawn
       gc.setFill(Color.LIME);
       gc.fillRect(0,250,600,600);
       
       // triangle
       Polyline triangle = new Polyline();
       triangle.getPoints().addAll(new Double[]
               {
                   300.0,0.0, 50.0, 150.0,300.0,0.0,
               });
       
       // big white rectangle right below the top white triangle       
       triangle.setStroke(Color.BLACK);
       triangle.setFill(Color.WHITE);
       group.getChildren().add(triangle);
       
       // rectangle brown
       Rectangle rect = new Rectangle(70,150,460,30);
       rect.setFill(Color.WHITE);
       rect.setStroke(Color.BLACK);
       group.getChildren().add(rect);
       
       // first door
       rect = new Rectangle(125,295,80,165);
       rect.setFill(Color.WHITE);
       rect.setStroke(Color.BLACK);
       group.getChildren().add(rect);
       
       darkdoors(142, 310);
       pillar(80,180);
               
       
       // middle (2nd) door
       rect = new Rectangle(395,295,80,165);
       rect.setFill(Color.WHITE);
       rect.setStroke(Color.BLACK);
       group.getChildren().add(rect);
       
       darkdoors(277,310);
       pillar(215,180);
       
       // third door
       rect = new Rectangle(395,295,80,165);
       rect.setFill(Color.WHITE);
       rect.setStroke(Color.BLACK);
       group.getChildren().add(rect);
       
       //black door squares
       darkdoors(412,310);
       pillar(350,180);
       pillar(485,180);
       
       // rectangle below doors
       rect = new Rectangle(70,460,460,5);
       rect.setFill(Color.LIGHTGRAY);
       rect.setStroke(Color.BLACK);
       group.getChildren().add(rect);
       
       stairs(120,460);
   }
   
   // dark door method
   public void darkdoors(int x, int y)
   {
       Rectangle rect;
       
       for(int i = 0,j = 0;i<5;i++,j+=30)
       {
           rect = new Rectangle(x,y+j,15,25);
           rect.setFill(Color.BLACK);
           rect.setStroke(Color.BLACK);
           group.getChildren().add(rect);
           
           rect = new Rectangle(x+30, y+y,15,25);
           rect.setFill(Color.BLACK);
           rect.setStroke(Color.BLACK);
           group.getChildren().add(rect);
       }
   }
   
   // pillar method
   public void pillar(int x, int y)
   {
       Rectangle rect;
       int width=35, height=270;
       
       rect = new Rectangle(x,y,width,height);
       rect.setFill(Color.WHITE);
       rect.setStroke(Color.BLACK);
       group.getChildren().add(rect);
       
       rect = new Rectangle(x-5,y+height,45,10);
       rect.setFill(Color.WHITE);
       rect.setStroke(Color.BLACK);
       group.getChildren().add(rect);
       
       Circle circle1 = new Circle();
       int radius = 11;
       circle1.setFill(Color.WHITE);
       circle1.setStroke(Color.BLACK);
       circle1.setRadius(radius);
       circle1.setCenterX(x);
       circle1.setCenterY(y+radius);
       group.getChildren().add(circle1);
       
       Circle circle2 = new Circle();
       circle2.setFill(Color.WHITE);
       circle2.setStroke(Color.BLACK);
       circle2.setRadius(radius);
       circle2.setCenterX(x+width);
       circle2.setCenterY(y+radius);
       group.getChildren().add(circle2);
       
   }
   
   public void stairs(int x,int y)
   {
       Rectangle rect;
       int width = 360,height = 10;
       
       for(int i = 1;i<=11;i++)
       {
           rect = new Rectangle(x,y,width,10);
           rect.setFill(Color.LIGHTGRAY);
           rect.setStroke(Color.BLACK);
           group.getChildren().add(rect);
           x= x-10; 
           y= y+height;
           width = width + 20;
       }
   }
   
public static void main(String[] args) 
    {
launch(args);
    }

    }

// There seems to be an issue with having javafx.fxml, possible missing the javafx.base file. I had a bit of trouble finding this file on my machine. 
// This seems to be the only error causing my program to not launch