import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.stage.Stage;
import java.util.StringTokenizer;

public class CourseSectionApp extends Application {
	 private CourseSection			model;  // model to which this view is attached
	 private CourseSectionView		view;   // view that shows the state of the model
	 
	 public void start(Stage primaryStage) throws IOException {
	 // Create the model and view
     model = new CourseSection();   // Start with an empty list
     BufferedReader aFile = new BufferedReader ( new FileReader("Marks.txt"));
     model = CourseSection.loadFrom(aFile);
     view = new CourseSectionView(model);
     
  // Plug in the event handlers
     /*
     view.getSearchButton().setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent actionEvent) { handleSearchButtonPress(); }
     });
     */
     
     /*
     view.getRemoveButton().setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent actionEvent) { handleRemoveButtonPress(); }
     });
     */
     view.getList().setOnMousePressed(new EventHandler<MouseEvent>() {
         public void handle(MouseEvent mouseEvent) { handleListSelection(); }
     });
     view.getList().setOnMousePressed(new EventHandler<MouseEvent>() {
         public void handle(MouseEvent mouseEvent) { handleShowInfo(); }
     });
     view.geta2Field().setOnKeyReleased(new EventHandler<KeyEvent>() {
         public void handle(KeyEvent keyEvent) { handleTextEntry(); }
     });
     view.geta3Field().setOnKeyReleased(new EventHandler<KeyEvent>() {
         public void handle(KeyEvent keyEvent) { handleTextEntry(); }
     });
     view.geta4Field().setOnKeyReleased(new EventHandler<KeyEvent>() {
         public void handle(KeyEvent keyEvent) { handleTextEntry(); }
     });
     view.getMidtermField().setOnKeyReleased(new EventHandler<KeyEvent>() {
         public void handle(KeyEvent keyEvent) { handleTextEntry(); }
     });
     view.getFinalExamField().setOnKeyReleased(new EventHandler<KeyEvent>() {
         public void handle(KeyEvent keyEvent) { handleTextEntry(); }
     });
     view.getFinalGradeField().setOnKeyReleased(new EventHandler<KeyEvent>() {
         public void handle(KeyEvent keyEvent) { handleTextEntry(); }
     });

     primaryStage.setTitle("Student Grade Manager"); // Set window title
     primaryStage.setResizable(true);
     Scene scene = new Scene(view,700,500); // Set window size
     primaryStage.setScene(scene);
     primaryStage.show();// Show window
 }
	 

	    private void handleShowInfo() {
	    	
	    	int index = view.getList().getSelectionModel().getSelectedIndex();
	        if (index >= 0) {
	            
	            view.geta1Field().setText(model.pullA1(index));
	            view.geta2Field().setText(model.pullA2(index));
	            view.geta3Field().setText(model.pullA3(index));
	            view.geta4Field().setText(model.pullA4(index));
	            view.getMidtermField().setText(model.pullA1(index));
	            view.getFinalExamField().setText(model.pullA1(index));
	            view.getFinalGradeField().setText(model.pullA1(index));
	            view.update();
	        }	
	    }
	    
	    private void handleListSelection() { view.update(); }

	    // The TextField typing event handler
	    private void handleTextEntry() { view.update(); }
	 
	 
	 public static void main(String[] args) { 
		 launch(args); 
		 }
}
