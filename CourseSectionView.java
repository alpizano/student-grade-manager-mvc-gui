import javax.xml.transform.Source;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CourseSectionView extends Pane {
	private CourseSection model;		// The model to which this view is attached
	
	// The user interface components needed by the controller
	private ListView<Integer> 			studentIDList;
	private Button 				searchButton;
	private Button 				addButton; 
	private Button 				removeButton;
	private TextField			a1Field;
	private TextField			a2Field;
	private TextField			a3Field;
	private TextField			a4Field;
	private TextField			midtermField;
	private TextField			finalExamField;
	private TextField 			finalGradeField;

	// public methods to allow access to window components
    public ListView<Integer> getList() { return studentIDList; }
    public Button getSearchButton() { return addButton; }
    public Button getAddButton() { return addButton; }
    public Button getRemoveButton() { return removeButton; }
    public TextField geta1Field() { return a1Field; }
    public TextField geta2Field() { return a2Field; }
    public TextField geta3Field() { return a3Field; }
    public TextField geta4Field() { return a4Field; }
    public TextField getMidtermField() { return midtermField; }
    public TextField getFinalExamField() { return finalExamField; }
    public TextField getFinalGradeField() { return finalGradeField; }
    
	// method for View for update itself based on model
	public CourseSectionView(CourseSection m) throws IOException {
		model = m;			//store the model for access later
		
		// Create and position the StudentID ListView with some students in it
	    studentIDList = new ListView<Integer>();
     
	    studentIDList.setItems(FXCollections.observableArrayList(model.idList(model.getStudents())));
	    studentIDList.relocate(5, 20);
	    studentIDList.setPrefSize(550, 250);
                                     
	    // Create and position the "studentIDList" Label
	        Label studentIDListLabel = new Label("Student ID");
	        studentIDListLabel.relocate(5, -5);
	        studentIDListLabel.setPrefSize(80, 30);	
	        
		// Create and position the "a1Label" Label
	        Label a1Label = new Label("A1");
	        a1Label.relocate(55, 300);
	        a1Label.setPrefSize(80, 30);	        
	    // Create and position the "a2Label" Label
	        Label a2Label = new Label("A2");
	        a2Label.relocate(150, 300);
	        a2Label.setPrefSize(80, 30);	        
	    // Create and position the "a3Label" Label
	        Label a3Label = new Label("A3");
	        a3Label.relocate(245, 300);
	        a3Label.setPrefSize(80, 30);	        
	    // Create and position the "a4Label" Label
	        Label a4Label = new Label("A4");
	        a4Label.relocate(340, 300);
	        a4Label.setPrefSize(80, 30);	        
	    // Create and position the "midtermLabel1" Label
	        Label midtermLabel1 = new Label("Midterm");
	        midtermLabel1.relocate(417, 285);
	        midtermLabel1.setPrefSize(80, 30);	        
	    // Create and position the "midtermLabel2" Label
	        Label midtermLabel2 = new Label("Exam");
	        midtermLabel2.relocate(425, 300);
	        midtermLabel2.setPrefSize(80, 30);	        
	    // Create and position the "finalExamLabel1" Label
	        Label finalExamLabel1 = new Label("Final");
	        finalExamLabel1.relocate(522, 285);
	        finalExamLabel1.setPrefSize(80, 30);	        
	    // Create and position the "finalExamLabel2" Label
	        Label finalExamLabel2 = new Label("Exam");
	        finalExamLabel2.relocate(520, 300);
	        finalExamLabel2.setPrefSize(80, 30);	        
	    // Create and position the "finalGradeLabel1" Label
	        Label finalGradeLabel1 = new Label("Final");
	        finalGradeLabel1.relocate(617, 285);
	        finalGradeLabel1.setPrefSize(80, 30);	     
	    // Create and position the "finalGradeLabel2" Label
	        Label finalGradeLabel2 = new Label("Grade");
	        finalGradeLabel2.relocate(615, 300);
	        finalGradeLabel2.setPrefSize(80, 30);		                  
		// Create and position the "a1" TextField
	        a1Field = new TextField();
	        a1Field.relocate(25, 325);
	        a1Field.setPrefSize(75, 30);	        
	    // Create and position the "a2" TextField
	        a2Field = new TextField();
	        a2Field.relocate(120, 325);
	        a2Field.setPrefSize(75, 30);	     
	    // Create and position the "a3" TextField
	        a3Field = new TextField();
	        a3Field.relocate(215, 325);
	        a3Field.setPrefSize(75, 30);	        
	    // Create and position the "a4" TextField
	        a4Field = new TextField();
	        a4Field.relocate(310, 325);
	        a4Field.setPrefSize(75, 30);	        
	    // Create and position the "midterm" TextField
	        midtermField = new TextField();
	        midtermField.relocate(405, 325);
	        midtermField.setPrefSize(75, 30);	        
	    // Create and position the "finalExam" TextField
	        finalExamField = new TextField();
	        finalExamField.relocate(500, 325);
	        finalExamField.setPrefSize(75, 30);	        
	    // Create and position the "finalGrade" TextField
	        finalGradeField = new TextField();
	        finalGradeField.relocate(595, 325);
	        finalGradeField.setPrefSize(75, 30);	        
		// Create and position the "Search" Button
		searchButton = new Button("Search");
        searchButton.relocate(100, 425);
        searchButton.setPrefSize(100, 25);
        //searchButton.setOnAction(this);        
        // Create and position the "Add" Button
        addButton = new Button("Add");
        addButton.relocate(300, 425);
        addButton.setPrefSize(100, 25);
        //addButton.setOnAction(this);
        // Create and position the "Remove" Button
        removeButton = new Button("Remove");
        removeButton.relocate(500, 425);
        removeButton.setPrefSize(100, 25);	
        //removeButton.setOnAction(this);
        
 // Add all the components to the window
getChildren().addAll(studentIDList,studentIDListLabel,a1Label,a2Label,a3Label,a4Label,midtermLabel1,midtermLabel2,finalExamLabel1,finalExamLabel2,finalGradeLabel1,finalGradeLabel2,a1Field,a2Field,a3Field,a4Field,midtermField,finalExamField,finalGradeField,searchButton,addButton,removeButton);

        // Call update() to make sure model contents are shown    
        update();
	}
	
	public void update() {
		// code for refreshing View
		/*
		ArrayList<Student> exactList = new ArrayList<Student>(model.getSize());
		for (int i=0; i<model.getSize(); i++)
		exactList[i] = model.getStudents().get(i);
		studentIDList.setItems(FXCollections.observableArrayList(exactList));
		*/

	}
}