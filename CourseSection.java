import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.*;

/**
 * <h1>Student</h1>
 * The program represents a student. 
 * 
 * @authors Javier Campos & Alberto Pizano
 * @version 1.0
 * @since 2018-04-18
 */

/**
 * <h1>Course Section</h1>
 * The program represents a course section. 
 * 
 * @authors Alberto Pizano
 * @version 1.0
 * @since 2018-04-18
 */

public class CourseSection implements Iterable<Student> {
	private static String assignsLabel;
	private static String highestMarks;
	private ArrayList<Student> students;

/**
 * Constructor for CourseSection class.
 * 
 */
public CourseSection()
	{
		assignsLabel = "ID       A1          A2      A3      A4      Midterm  Final";
		highestMarks = "                   35      35      35      30       30     100";
		students = new ArrayList<Student>();
	}
	  
/**
 * @param n
 */
public CourseSection(String n) {
	students = new ArrayList<Student>();
	}
  
/* (non-Javadoc)
 * @see java.lang.Iterable#iterator()
 */
public Iterator<Student> iterator() { return this.students.iterator(); } 

/** Get Method to return ArrayList of Students objects.
* @return ArrayList of Student objects.
*/
public ArrayList<Student> getStudents() { return this.students; }
  
/**
 * Get method to return string assignsLabel
 * @return string assignsLabel
 */
public static String getassignsLabel() { return assignsLabel; }
  
/**
 * Get method to return string highestMarks
 * @return String highestMarks
 */
public static String gethighestMarks() { return highestMarks; }
  
/**
 * Method to add a new Student object to the students ArrayList with the given int and float values that are passed as parameters.
 * @param id id of the Student object.
 * @param a1 assignment 1 grade of Student object.
 * @param a2 assignment 2 grade of Student object.
 * @param a3 assignment 3 grade of Student object.
 * @param a4 assignment 4 grade of Student object.
 * @param midterm midterm grade of Student object.
 * @param finalExam final exam grade of Student object.
 */
public void addStudents(int id, float a1, float a2, float a3, float a4, float midterm, float finalExam) {
	Student s = new Student(id,a1,a2,a3,a4,midterm,finalExam);
    students.add(s);
  }
  
/**
 * Will add a new student to the ArrayList.
 * @param s A Student object.
 */
public void addStudent(Student s) {
	  students.add(s);
  }
  
public void removeStudent(int index) { 
    Iterator studentIterator = students.iterator();
    
    while(studentIterator.hasNext()){
      if(students.indexOf(studentIterator.next()) == index)
        studentIterator.remove();
    }
  }
  

/**
 * 
 */
public void listStudents() {
    for(Student s: students){
      System.out.println(s.getID());  
    }  
  }
  
/**
 * @param index
 * @return
 */
public String pullID(int index) {
	  int i;
	  String id = "";  
	  Student s = new Student();
	  
	    for(i=0; i<students.size(); i++){
	    	if(index == i)
	    	{
	    		s = students.get(i);
	     id =   String.valueOf(s.getID());
	    	}
	    }  
	    return id;
	  }
  
/**
 * @param index
 * @return
 */
public String pullA1(int index) {
	  int i;
	  String a1 = "";  
	  Student s = new Student();
	  
	    for(i=0; i<students.size(); i++){
	    	if(index == i)
	    	{
	    		s = students.get(i);
	     a1 =   String.valueOf(s.getA1());
	    	}
	    }  
	    return a1;
	  }
  
/**
 * @param index
 * @return
 */
public String pullA2(int index) {
	  int i;
	  String a2 = "";  
	  Student s = new Student();
	  
	    for(i=0; i<students.size(); i++){
	    	if(index == i)
	    	{
	    		s = students.get(i);
	     a2 =  String.valueOf(s.getA2());
	    	}
	    }  
	    return a2;
	  }
  
public String pullA3(int index){
	  
	  int i;
	  String a3 = "";  
	  Student s = new Student();
	  
	    for(i=0; i<students.size(); i++){
	    	if(index == i)
	    	{
	    		s = students.get(i);
	     a3 =  String.valueOf(s.getA3());
	    	}
	    }  
	    return a3;
	  }
  
public String pullA4(int index){
	  
	  int i;
	  String a4 = "";  
	  Student s = new Student();
	  
	    for(i=0; i<students.size(); i++){
	    	if(index == i)
	    	{
	    		s = students.get(i);
	     a4 =  String.valueOf(s.getA4());
	    	}
	    }  
	    return a4;
	  }

public String pullMidterm(int index) {
	  int i;
	  String midterm = "";  
	  Student s = new Student();
	  
	    for(i=0; i<students.size(); i++){
	    	if(index == i)
	    	{
	    		s = students.get(i);
	     midterm =  String.valueOf(s.getMidterm());
	    	}
	    }  
	    return midterm;
	  }
 
public String pullFinalExam(int index) {
	 int i;
	 String finalExam = "";  
	 Student s = new Student();

	 for(i=0; i<students.size(); i++){
		 if(index == i)
		 {
			 s = students.get(i);
			 finalExam =  String.valueOf(s.getFinalExam());
		 }
	 }  
	 return finalExam;
 }
 
public String pullFinalGrade(int index){
	 int i;
	 float finalGrade = 0f;
	 Student s = new Student();

	 for(i=0; i<students.size(); i++){
		 if(index == i)
		 {
			 s = students.get(i);
			 finalGrade = s.getFinalGrade();
		 }
	 }  
	 return calcGrade(finalGrade);
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
 

/**
 * Method to convert original Student ArrayList to a single Integer array of student IDs.
 * @param students
 * @return An Integer array of consisting of students IDs
 */
public Integer[] idList(ArrayList<Student> students) {
	Integer[] ids = new Integer[students.size()];
	
	 for(int i=0; i<students.size(); i++) {
	    	Student s = students.get(i);
			ids[i] = s.getID();
	    }	  
	  return ids;
	  }
  
  
/**
 * Method to compute the size of ArrayList.
 * @return int value of the size of ArrayList.
 */
public int getSize() {
	int size = 0 ;
	int i;

	for(i = 0; i <students.size(); i++) {
		size++;
	}
	return size;
}
  
  
public void saveTo(PrintWriter aFile) {
	aFile.println(assignsLabel);
	aFile.println(highestMarks);
	for (Student s:  students) {
		s.saveTo(aFile);
	}
}
  
  /**
   * Reads aFile except for the header and continuously creates new student objects 
   * for a new CourseSection.
   * @param aFile File to read from.
   * @return CourseSection New CourseSection read from aFile
   */
public static CourseSection loadFrom(BufferedReader aFile) throws IOException {
	CourseSection course = new CourseSection(aFile.readLine()); 
	aFile.readLine(); // skips line
	while (aFile.ready()) //read until no more available (i.e., not ready)
	{ 

		course.addStudent(Student.loadFromST(aFile)); //read & add the student
	}
	return course;
}
  
/** 
 * Method that removes the Student object from ArrayList at the index that is passed as parameter.
 * @param index
 */
public void realRemove(int index) {
	    for(int i=0; i<students.size(); i++) {
	    	Student s = students.get(i);
	    	if(index == students.indexOf(s))
	    		students.remove(index);
	    	}
	    }
  
  
/**
 * Method to search through student IDs inside students ArrayList and returns int value of index of ID being searched for.
 * @param id of student you are searching for.
 * @return the int value of the index containing the id passed as parameter.
 */
public int realSearch(int id) {
	int ans = 0;
	  for(int i = 0; i<students.size(); i++) {
		  Student s = students.get(i);
		  if(s.getID() == id) {
			  ans = students.indexOf(s);  
			  return ans;
			  }
		  }
	  return -1;
	  }
}



