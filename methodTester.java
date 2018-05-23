import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.io.*;

/**
 * <h1>Student</h1>
 * The program represents a student. 
 * 
 * @authors Javier Campos & Alberto Pizano
 * @version 1.0
 * @since 2018-04-18
 */

public class methodTester {
	// create static course object
	static CourseSection course = new CourseSection();
	
	private static void studentLoad() throws IOException {
        BufferedReader	file1;
        Student student1; // student object
        //String line;

        file1 = new BufferedReader(new FileReader("Marks.txt"));
        
        file1.readLine(); // skips 1st line
        file1.readLine(); // skips 2nd line
     
       student1 = Student.loadFromST(file1); // using String Tokenizer
       System.out.println(student1);
       
       //file1.close();
    }
	
	 private static void courseLoad() throws IOException {
	  
		    BufferedReader aFile = new BufferedReader(new FileReader("Marks.txt"));
	        
	        CourseSection course = CourseSection.loadFrom(aFile);
		   
	        course.listStudents(); // this outputs the STUDENT OBJECTS IN THE ARRAY LIST!
	        
	        //aFile.close();
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
		    
		    public static void finalAdder() throws IOException
		    {
		    	BufferedReader file1;
		    	
		    	file1 = new BufferedReader(new FileReader("Marks.txt"));
		    	course = CourseSection.loadFrom(file1);
		    	course.addStudent(createStudent());  //course is for adding and saving student test; course2 is for search test
		    	course.listStudents();
		    	
		    	PrintWriter    	aFile;
			  	aFile = new PrintWriter(new FileWriter("Marks_Add_method_output_test.txt"));
		        course.saveTo(aFile);
		        aFile.close();
		        
		    }
		    
		    public static void search() throws IOException{
				 
			 	BufferedReader aFile;
			 	
			    CourseSection course2 = new CourseSection(); //creates course object which is ArrayList of Student objects
			    
			    aFile = new BufferedReader( new FileReader("Marks.txt"));
			     course2 = CourseSection.loadFrom(aFile); // reads .txt into course ArrayList
			    
			    Scanner scanner =  new Scanner(System.in);
			    int id;
			    boolean foundStudent = true;
			    course2.listStudents();
			    	
			    System.out.print("Enter the Student's ID: ");
			    id = enterID();
			    
			   for(Student s : course2.getStudents())
			   {
			    	if(s.getID() == id) {
			    	System.out.println("The student's information is: ");
			    	System.out.println("StudentID: " + s.getID());
			    	System.out.println("Assignment 1: " + s.getA1());
			    	System.out.println("Assignment 2: " + s.getA2());
			    	System.out.println("Assignment 3: " + s.getA3());
			    	System.out.println("Assignment 4: " + s.getA4());
			    	System.out.println("Midterm: " + s.getMidterm());
			    	System.out.println("Final Exam: " + s.getFinalExam());
			    	}
			    }
			   
			   // I still need to write a else condition in here in case the searched studentID is NOT found
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
			    
			   course.listStudents(); // list the students to make sure it worked!!!
			   
			   PrintWriter  file1;
			  	file1 = new PrintWriter(new FileWriter("Marks_Remove_method_output_test.txt"));
		        course.saveTo(file1);
		        //aFile.close();	  
		 }
		    
		   
		    
			public static void list() throws IOException{   
				
				BufferedReader file1;
		    	
		    	file1 = new BufferedReader(new FileReader("Marks.txt"));
		    	course = CourseSection.loadFrom(file1);
		    	
						
			   int i = 0;
			   Scanner scanner = new Scanner(System.in);
			    		    
			    String answer;
			    	//Student s;   = course.getStudents();

			    	 while(i < course.getSize()) 
			    		{
			    			while(i<25)
			    			{	
			    				
			    				Student s = course.getStudents().get(i);
		    					System.out.println(s.getID());
			    				i++;
			    			}
			    			
			    			//-----------------------------------------------1
			    			System.out.println("Type ENTER to continue");
			    			answer = scanner.next();
			    			answer = answer.toUpperCase();
			    			
			    			if(answer.equals("ENTER"))
			    			{
			    				while(i < 50)
			    				{
			    					Student s = course.getStudents().get(i);
			    					System.out.println(s.getID());
				    				i++;
			    				}
			    				//-------------------------------------------------2
			    				System.out.println("Type ENTER to continue");
			    				answer = scanner.next();
			    				answer = answer.toUpperCase();
			    				
			    				if(answer.equals("ENTER"))
			    				{
			    					while(i < 75)
			    					{
			    						
			    						Student s = course.getStudents().get(i);
				    					System.out.println(s.getID());
					    				i++;
			    					}
			    					//--------------------------------------------- 3
			    					System.out.println("Type ENTER to continue");
			    					answer = scanner.next();
			    					answer = answer.toUpperCase();
			    					
			    					if(answer.equals("ENTER"))
			    					{
			    						while(i < course.getSize())
			    						{
			    							
			    							Student s = course.getStudents().get(i);
					    					System.out.println(s.getID());
			    							i++;
			    						}
			    		
			    					}
			    				}
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
		
		 public static int search(int id) {
			int ans = 0;
			  for(int i =0; i < course.getSize(); i++)
			   {
				  Student s = course.getStudents().get(i);
				  
			    	if(id == s.getID()) 
			    	ans = course.getStudents().indexOf(s);
			    	
			    	
			   }
			 return ans;
		  }
		 
		  public static int realSearch(int index) {
			  int ans =3;

			  	  for(int i = 0; i < course.getSize(); i++)
			  	   {
			  		  Student s = course.getStudents().get(i);
			  		  //System.out.println(s.getID());
			  	    	if(index == course.getStudents().indexOf(s)) 
			  	    	ans = s.getID();
			  	   }
			  	  return ans;
			    }
			    
		  
		  public static int yeah(int k) {
			  int[] thearray = {1, 2, 7, 3, 5};
			  int ans= 0;
			  for(int i=0; i<thearray.length; i++) {
				  if(k == thearray[i])
				  {
					   ans= i;
				 return ans;
				  }
			  }
			return -1;
		  }
		    
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader file1;
		file1 = new BufferedReader(new FileReader("Marks.txt"));
		course = CourseSection.loadFrom(file1);
		
		//System.out.println("Testing Student loader:");
		//studentLoad(); // testing to see if it outputs 1 Student Object per line
		//System.out.println();
		
		//System.out.println("Testing CourseSection loader:");
		//courseLoad(); // this should output the Entire marks.txt file as an ArrayList of Student objects
		
		//search(); // test SEARCH method
		//course.addStudent(createStudent());  
		//finalAdder(); // test ADD  method
		//remove(); // test REMOVE method
		//System.out.println("The size of course ArrayList<Student> is: " + course.getSize());
	
		//list();
		//System.out.println(course.pullA1(2));
		System.out.println(methodTester.search(15471));
		System.out.println(methodTester.search(202366));
		
		System.out.println(methodTester.realSearch(7));
		System.out.println(methodTester.realSearch(55));
		System.out.println(methodTester.yeah(9));
	}
}
