import java.io.*;
import java.util.*;

public class CourseSectionUI {
	
	//Create a CourseSection object
	static CourseSection course = new CourseSection(); //had to make static to re-use arraylist object throughout other methods

	  /*
	   * Here lies several methods used to simplify
	   * and reduce the level of complexity in the main method.
	   * They can only be called from inside the switch statement.
	   */
	public static void list() throws IOException{   
		
	    
	    Scanner scanner = new Scanner(System.in);
	    
	    String allMarks;
	    String indent = "                  ";

	      System.out.print("Show All the marks(yes/no): ");
	      allMarks = scanner.nextLine();
	      allMarks = allMarks.toLowerCase();
	      
	     if(allMarks.equals("yes"))   
	     {  
	    	 System.out.println("    ID           A1          A2         A3         A4      Midterm      Final   | Final Grade ");
	        System.out.println("                 35          35         35         30         30         100    |  ");
	        System.out.println("----------------------------------------------------------------------------------------------");
	        for(Student s : course.getStudents())
			   {
	        	
	        	//System.out.println("   " + s.getID() + "          "+ s.getA1() + "      " + s.getA2() + "      " + s.getA3() + "      " + s.getA4() + "      " +s.getMidterm() + "      " + s.getFinalExam()+ "      " + calcGrade(s.getFinalExam()));
	        	System.out.printf("%10s %10s %10s %10s %10s %10s %10s    | %4s%n",s.getID(),s.getA1(),s.getA2(),s.getA3(),s.getA4(),s.getMidterm(), s.getFinalExam(),calcGrade(s.getFinalGrade()) );
			    }
	     }
	     else {
	    	 System.out.println("   ID        Final");
		      System.out.println("---------------------------------------------------------------------------");
	    	 for(Student s : course.getStudents())
			   { 
			    	System.out.println("   " + s.getID() + "      " + "Weighted grade test" + s.getFinalGrade() + "  "+ calcGrade(s.getFinalGrade()));
			   }
	     }  
	  }
	
public static String calcGrade(float n) {
	
	if(n >= 90)
		return "A";
	else if ((n < 90) && (n >= 70))
		return "B";
	else if((n < 70) && (n >= 60))
		return "C";
	else if((n < 60) && (n >= 50))
		return "D";
	else
		return "F";
}

	
	public static void search() throws IOException{
		
	    Scanner scanner =  new Scanner(System.in);
	    int id;
	    boolean foundStudent = true;
	    	
	    System.out.print("Enter the Student's ID: ");
	    id = enterID();
	    
	   for(Student s : course.getStudents())
	   {
	    	if(s.getID() == id) {
	    	System.out.println();
	    	System.out.println("StudentID: " + s.getID());
	    	System.out.println("Assignment 1: " + s.getA1());
	    	System.out.println("Assignment 2: " + s.getA2());
	    	System.out.println("Assignment 3: " + s.getA3());
	    	System.out.println("Assignment 4: " + s.getA4());
	    	System.out.println("Midterm: " + s.getMidterm());
	    	System.out.println("Final Exam: " + s.getFinalExam());
	    	}

	   }
	   System.out.println(); // I still need to write a else condition in here in case the searched studentID is NOT found
  }
	
	  public static void add() throws IOException
	  {
	  	
	  	course.addStudent(createStudent());  //course object is for adding new students data

	  	PrintWriter aFile; // print writer will save the new data to .txt I'm using a different output here, BUT you can make it Marks.txt and overwrite the original file for continuity
		aFile = new PrintWriter(new FileWriter("Marks.txt")); // output format is still a bit janky
	    course.saveTo(aFile);
	    aFile.close(); // file needs to be closed OR you will not see output inside .txt file!!!
	    
	  }
	
	  public static Student createStudent(){
		    Scanner scanner = new Scanner(System.in);
		    int id;
		    float a1, a2, a3, a4, midterm, finalExam;

		    System.out.print("Enter the student's ID: ");
		    id = enterID();
		    System.out.print("Enter the grade for assigment #1: ");
		    a1 = enterGradeA1();
		    System.out.print("Enter the grade for assigment #2: ");
		    a2 = enterGradeA2();
		    System.out.print("Enter the grade for assigment #3: ");
		    a3 = enterGradeA3();
		    System.out.print("Enter the grade for assigment #4: ");
		    a4 = enterGradeA4();
		    System.out.print("Enter the midterm exam grade: ");
		    midterm = enterGradeMidterm();
		    System.out.print("Enter the final exam grade: ");
		    finalExam = enterGradeFinal();
		    
		    Student s = new Student(id, a1, a2, a3, a4, midterm, finalExam);
		    
		    return s;
		  }
	
	  /*
	   * Asks the user to enter a student's ID 
	   */
	  public static int enterID(){
	    
	    Scanner scanner = new Scanner(System.in);
	    int id = 0;
	    
	    try{
	      System.out.print("Enter the student's ID: ");
	      id = scanner.nextInt();
	    }catch(InputMismatchException e){
	      System.out.println("Error: InputMismatchException");
	      id = enterID();
	    }
	    
	    return id;
	  }
	  	  
	  /*
	   * Checks if the user is enter a valid grade
	   */
	  public static float enterGradeA1(){
	    
	    Scanner scanner = new Scanner(System.in);
	    float grade = 0f;
	    
	    try{
	      
	      System.out.print("Enter the student's grade: ");
	      grade = scanner.nextFloat();
	      
	      if(grade > 35 || grade < 0){
	        System.out.println("Invalid Grade");
	        grade = enterGradeA1();
	      }
	      
	    }catch(InputMismatchException e){
	      System.out.println("Error: InputMismatchException");
	      grade = enterGradeA1();
	    }
	   
	    return grade;
	  }
	  public static float enterGradeA2(){
		    
		    Scanner scanner = new Scanner(System.in);
		    float grade = 0f;
		    
		    try{
		      
		      System.out.print("Enter the student's grade: ");
		      grade = scanner.nextFloat();
		      
		      if(grade > 35 || grade < 0){
		        System.out.println("Invalid Grade");
		        grade = enterGradeA2();
		      }
		      
		    }catch(InputMismatchException e){
		      System.out.println("Error: InputMismatchException");
		      grade = enterGradeA2();
		    }
		   
		    return grade;
		  }
	  
	  public static float enterGradeA3(){
		    
		    Scanner scanner = new Scanner(System.in);
		    float grade = 0f;
		    
		    try{
		      
		      System.out.print("Enter the student's grade: ");
		      grade = scanner.nextFloat();
		      
		      if(grade > 35 || grade < 0){
		        System.out.println("Invalid Grade");
		        grade = enterGradeA3();
		      }
		      
		    }catch(InputMismatchException e){
		      System.out.println("Error: InputMismatchException");
		      grade = enterGradeA3();
		    }
		   
		    return grade;
		  }
	   
	  public static float enterGradeA4(){
		    
		    Scanner scanner = new Scanner(System.in);
		    float grade = 0f;
		    
		    try{
		      
		      System.out.print("Enter the student's grade: ");
		      grade = scanner.nextFloat();
		      
		      if(grade > 30 || grade < 0){
		        System.out.println("Invalid Grade");
		        grade = enterGradeA4();
		      }
		      
		    }catch(InputMismatchException e){
		      System.out.println("Error: InputMismatchException");
		      grade = enterGradeA4();
		    }
		   
		    return grade;
		  }
	  
	  public static float enterGradeMidterm(){
		    
		    Scanner scanner = new Scanner(System.in);
		    float grade = 0f;
		    
		    try{
		      
		      System.out.print("Enter the student's grade: ");
		      grade = scanner.nextFloat();
		      
		      if(grade > 30 || grade < 0){
		        System.out.println("Invalid Grade");
		        grade = enterGradeMidterm();
		      }
		      
		    }catch(InputMismatchException e){
		      System.out.println("Error: InputMismatchException");
		      grade = enterGradeMidterm();
		    }
		   
		    return grade;
		  }
	  
	  public static float enterGradeFinal(){
		    
		    Scanner scanner = new Scanner(System.in);
		    float grade = 0f;
		    
		    try{
		      
		      System.out.print("Enter the student's grade: ");
		      grade = scanner.nextFloat();
		      
		      if(grade > 100 || grade < 0){
		        System.out.println("Invalid Grade");
		        grade = enterGradeFinal();
		      }
		      
		    }catch(InputMismatchException e){
		      System.out.println("Error: InputMismatchException");
		      grade = enterGradeFinal();
		    }
		   
		    return grade;
		  }
	  
	  public static void remove() throws IOException{
			 
		 	BufferedReader aFile;
		 	
		    aFile = new BufferedReader( new FileReader("Marks.txt"));
		    course = CourseSection.loadFrom(aFile); // reads .txt into course ArrayList
		    
		    Scanner scanner =  new Scanner(System.in);
		    int id;
		    boolean foundStudent = true;
		    course.listStudents(); // to see the ArrayList of students before you remove to make sure it worked
		    	
		    System.out.print("Enter the Student's ID: ");
		    id = enterID();
		    
		    Iterator studentIterator = course.iterator();
		    while(studentIterator.hasNext()) {
		    	Student s = (Student)studentIterator.next();
		    	if(s.getID() == id)
		    		studentIterator.remove();
		    }
		          
		    PrintWriter  file1;
			file1 = new PrintWriter(new FileWriter("Marks.txt"));
		    course.saveTo(file1);
		    file1.close();
	}
	  
	  // should save any ADDS or REMOVES of students to Marks.txt file
	  public static void quit() throws IOException{
		
	  }
	  
	
//********************************************* Main method of the file ********************************************************************************
	  
			public static void main(String[] args) throws IOException{
    
			/*
			 * Opens Marks.txt and loads all information from the file 
			 * to the ArrayList<Student> in CourseSection by " course = CourseSection.loadFrom(aFile);"
			 */
	  
			// Marks.txt needs only be read and assigned to course 1 time here in the main method
			try{
				BufferedReader aFile = new BufferedReader(new FileReader("Marks.txt"));
				course = CourseSection.loadFrom(aFile);
			} catch(FileNotFoundException e){
				System.out.println("Error: Cannot open file for reading.");
			}catch(NoSuchElementException e){
				System.out.println("Error: EOF encountered, file may be corrupt.");
			}
    
			char input;
    
			Scanner scanner = new Scanner(System.in);
			System.out.println("ECE 25100 Student Grade Manager.");
			System.out.println();
    
			do{
				System.out.println("Please make a selection: ");
				System.out.println("(L) List All Students");
				System.out.println("(S) Search For a Student");
				System.out.println("(A) Add a Student");
				System.out.println("(R) Remove a Student");
				System.out.println("(Q) Quit");
      
				input = scanner.next().charAt(0); // to take char user input
				input = Character.toUpperCase(input);
      
				if(validInput(input)){
					switch(input) {
					case 'L': list(); 
          			break;
					case 'S': search(); 
					break;
					case 'A': add(); 
					break;
					case 'R': remove(); 
          			break;
					case 'Q': quit(); 
          			break;
						}
					}
					else
					{
						System.out.println("Invalid input!");
						System.out.println("Please re-enter your input.");
						}
					}
					while(input != 'Q');
					//aFile.close(); //still not sure if we need to close file after or not
						}
  

  /*
   * Checks if the user enters a valid input.
   * @return Returns true if the input is valid.
   */
  public static boolean validInput(char c){
    return (c == 'L' || c == 'S' || c == 'A' || c == 'R' || c == 'Q');
  }
}