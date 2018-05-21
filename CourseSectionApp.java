import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.*;
import javafx.stage.Stage;
import java.util.StringTokenizer;

/**
 * <h1>Student</h1>
 * The program represents a student. 
 * 
 * @authors Javier Campos & Alberto Pizano
 * @version 1.0
 * @since 2018-04-18
 */

public class CourseSectionApp extends Application {
	 private CourseSection			model;  // model to which this view is attached
	 private CourseSectionView		view;   // view that shows the state of the model
	 
	 public void start(Stage primaryStage) throws IOException {
		 
	 // Create the model and view
     model = new CourseSection();   
     
     BufferedReader aFile = new BufferedReader ( new FileReader("Marks.txt"));
     model = CourseSection.loadFrom(aFile);
     
     // Pass model as parameter thru view constructor
     view = new CourseSectionView(model);
     
     // Plug in the event handlers
     // Event to display student assignment scores & grades when selecting the ID in the IDList
     view.getList().setOnMousePressed(new EventHandler<MouseEvent>() {
         public void handle(MouseEvent mouseEvent) { handleListSelection(); }
     });
     
     // Even to remove students from array list by clicking "Remove" button
     view.getRemoveButton().setOnAction(new EventHandler<ActionEvent>() {
    	 public void handle(ActionEvent actionEvent) { handleRemoveButtonPress(); }
     });
     
     
    // Event to add students to array list by clicking "Add" button
     view.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
    	 public void handle(ActionEvent actionEvent) { handleAddButtonPress(); }
     });
     
     // Need to fix this method
     view.getSearchButton().setOnAction(new EventHandler<ActionEvent>() {
    	 public void handle(ActionEvent actionEvent) { handleSearchButtonPress(); }
     }); 
     
     // Event to clear text fields by clicking "Clear" button
     view.getClearButton().setOnAction(new EventHandler<ActionEvent>() {
    	 public void handle(ActionEvent actionEvent) { handleClearButtonPress(); }
     });
     
     // Methods to handle text entry
     view.getidField().setOnKeyReleased(new EventHandler<KeyEvent>() {
         public void handle(KeyEvent keyEvent) { handleTextEntry(); }
     });
	    view.geta1Field().setOnKeyReleased(new EventHandler<KeyEvent>() {
         public void handle(KeyEvent keyEvent) { handleTextEntry(); }
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
	    
	    /* // Methods to handleTextClear, not working properly ATM (They erase text after typping in 1 field)
	    view.getidField().setOnMousePressed(new EventHandler<MouseEvent>() {
	         public void handle(MouseEvent mouseEvent) { handleTextClear(); }
	     });
		 view.geta1Field().setOnMousePressed(new EventHandler<MouseEvent>() {
	         public void handle(MouseEvent mouseEvent) { handleTextClear(); }
	     });
		 view.geta2Field().setOnMousePressed(new EventHandler<MouseEvent>() {
	         public void handle(MouseEvent mouseEvent) { handleTextClear(); }
	     });
		 view.geta3Field().setOnMousePressed(new EventHandler<MouseEvent>() {
	         public void handle(MouseEvent mouseEvent) { handleTextClear(); }
	     });
		  view.geta4Field().setOnMousePressed(new EventHandler<MouseEvent>() {
	         public void handle(MouseEvent mouseEvent) { handleTextClear(); }
	     });
		  view.getMidtermField().setOnMousePressed(new EventHandler<MouseEvent>() {
	         public void handle(MouseEvent mouseEvent) { handleTextClear(); }
	     });
		  view.getFinalExamField().setOnMousePressed(new EventHandler<MouseEvent>() {
	         public void handle(MouseEvent mouseEvent) { handleTextClear(); }
	     });
		  view.getFinalGradeField().setOnMousePressed(new EventHandler<MouseEvent>() {
		         public void handle(MouseEvent mouseEvent) { handleTextClear(); }
		     });*/
		     
     

     primaryStage.setTitle("Student Grade Manager"); // Set window title
     primaryStage.setResizable(false);
     Scene scene = new Scene(view,800,600); // Set window size
     primaryStage.setScene(scene);
     primaryStage.show();// Show window
 }
	 

	    private void handleListSelection() {
	    	int index = view.getList().getSelectionModel().getSelectedIndex();
	        if (index >= 0) {
	            // Can you use .setInt or .setFloat to set value instead of it being Text aka String ?
	        	view.getidField().setText(model.pullID(index));
	            view.geta1Field().setText(model.pullA1(index));
	            view.geta2Field().setText(model.pullA2(index));
	            view.geta3Field().setText(model.pullA3(index));
	            view.geta4Field().setText(model.pullA4(index));
	            view.getMidtermField().setText(model.pullMidterm(index));
	            view.getFinalExamField().setText(model.pullFinalExam(index));
	            view.getFinalGradeField().setText(model.pullFinalGrade(index));
	            view.update();
	        }	
	    }
	    
	    private void handleRemoveButtonPress()  {
	    	int index = view.getList().getSelectionModel().getSelectedIndex();
	    		if(index >= 0) {
	    		model.realRemove(index);
	    		//view.update();
	    		}
	    		
	    		//to clear TextFields after removing element
	    		view.getidField().setText("");
	  	    	view.geta1Field().setText("");
	            view.geta2Field().setText("");
	            view.geta3Field().setText("");
	            view.geta4Field().setText("");
	            view.getMidtermField().setText("");
	            view.getFinalExamField().setText("");
	            view.getFinalGradeField().setText("");
	            view.update();
	
	    }
   
	    private void handleAddButtonPress() {
	    	int id;
	    	float a1;
	    	float a2;
	    	float a3;
	    	float a4;
	    	float midterm;
	    	float finalExam;
	    	
	    	if(view.getidField().getText().trim().length() > 0)
	    		id = Integer.parseInt(view.getidField().getText().trim());
	    	else
	    		id = 0;
	    	if(view.geta1Field().getText().trim().length() >0)
	    		a1 = Float.parseFloat(view.geta1Field().getText().trim());
	    	else 
	    		a1 = 0f;
	    	if(view.geta2Field().getText().trim().length() > 0)
	    		a2 = Float.parseFloat(view.geta2Field().getText().trim());
	    	else
	    		a2 = 0f;
	    	if(view.geta3Field().getText().trim().length() > 0)
	    		a3 = Float.parseFloat(view.geta3Field().getText().trim());
	    	else
	    		a3 = 0f;
	    	if(view.geta4Field().getText().trim().length() > 0)
	    		a4 = Float.parseFloat(view.geta4Field().getText().trim());
	    	else
	    		a4 = 0f;
	    	if(view.getMidtermField().getText().trim().length() > 0)
	    		midterm = Float.parseFloat(view.getMidtermField().getText().trim());
	    	else
	    		midterm = 0f;
	    	if(view.getFinalExamField().getText().trim().length() > 0)
	    		finalExam = Float.parseFloat(view.getFinalExamField().getText().trim());
	    	else
	    		finalExam = 0f;
     
            view.getidField().setText("");
	    	view.geta1Field().setText("");
            view.geta2Field().setText("");
            view.geta3Field().setText("");
            view.geta4Field().setText("");
            view.getMidtermField().setText("");
            view.getFinalExamField().setText("");
            
	    	model.addStudents(id,a1,a2,a3,a4,midterm,finalExam);
            view.update();
	    }
	    
	    // Need to fix this code
	    private void handleSearchButtonPress() {
	    	
	    	//String id = view.getsearchIDField().getText().trim();
	    	//int index = model.realSearch(Integer.parseInt(id));
	    	
	    	view.getList().scrollTo(55);
	    	//view.getList().getSelectionModel().select(index);
	    	//view.getList().getSelectionModel().setSelectedIndex(Integer.parseUnsignedInt(model.realSearch(Integer.parseInt(id)));
	    	view.update();
	    }
	    

	    // Event that clear all the text fields when you have a student selected from ArrayList and but you want to type new data and add to list
	  private void handleTextClear() {	  
		  //if(view.getidField().getText().trim().length() > 0)
			  view.getidField().setText("");
			  view.geta1Field().setText("");
			  view.geta2Field().setText("");
	            view.geta3Field().setText("");
	            view.geta4Field().setText("");
	            view.getMidtermField().setText("");
	            view.getFinalExamField().setText("");
	            view.getFinalGradeField().setText("");
		  view.update();
	  }
	   private void handleClearButtonPress() {
		   view.getidField().setText("");
			view.geta1Field().setText("");
		view.geta2Field().setText("");
	        view.geta3Field().setText("");
	        view.geta4Field().setText("");
	        view.getMidtermField().setText("");
	        view.getFinalExamField().setText("");
	        view.getFinalGradeField().setText("");
		   view.update();
	   }
	   
	   
	    // The TextField typing event handler
	    private void handleTextEntry() { view.update(); }
	 
	    
	    public static void main(String[] args) { 
		 launch(args); 
		 }
}
