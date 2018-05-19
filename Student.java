import java.io.*;
import java.util.StringTokenizer;

/**
 * <h1>Student</h1>
 * The program represents a student. 
 * 
 * @authors Javier Campos & Alberto Pizano
 * @version 1.0
 * @since 2018-04-18
 */

public class Student {
  private int ID;
  private float a1;
  private float a2;
  private float a3;
  private float a4;
  private float midterm;
  private float finalExam;

  
  /**
   * The Default constructor is used to intialize all instance variables 
   * in the class to zero.
   */
  Student(){
    ID = 0;
    a1 = 0.0f;
    a2 = 0.0f;
    a3 = 0.0f;
    a4 = 0.0f;
    midterm = 0.0f;
    finalExam = 0.0f;
  }
  
  Student(int id, float a1, float a2, float a3, float a4, float midterm, float finalExam) {
    ID = id;
    this.a1 = a1;
    this.a2 = a2;
    this.a3 = a3;
    this.a4 = a4;
    this.midterm = midterm;
    this.finalExam = finalExam;
  }
    
//Set methods for all instance variables of Student 
  public void setID(int newID)
  { 
	  ID = newID; 
  }
  
  public void setA1(float newA1)
  { 
	  a1 = newA1; 
  }
  public void setA2(float newA2)
  { 
	  a2 = newA2; 
  }
  public void setA3(float newA3)
  { 
	  a3 = newA3; 
  }
  public void setA4(float newA4)
  { 
	  a4 = newA4; 
  }
  
  public void setMidterm(float newMidterm) 
  { 
	midterm = newMidterm; 
  } 
  
  public void setFinalGrade(float newFinal)
  { 
	 finalExam = newFinal; 
  }
  
  //Get methods for instance variables of Student
  public int getID()
  {
	  return ID; 
  }
  public float getA1()
  { 
	  return a1; 
  } 
  
  public String geta1() {
	  return String.valueOf(a1);
  }
  
  public float getA2()
  { 
	  return a2; 
	  }
  public float getA3()
  { 
	  return a3; 
  }
  public float getA4()
  { 
	  return a4; 
  }
  public float getMidterm()
  { 
	  return midterm; 
  }
  public float getFinalExam()
  { 
	  return finalExam; 
  }
  public float getFinalGrade() {

	  float assignPts = 0f;
	  float midPts = 0f;
	  float finalePts = 0f;
	  float theirWeighted;
	  float totalWeighted;
	  
	  totalWeighted = (35f+35f+35f+30f)*.2f + 30f*.3f + 100f*.5f;
	  assignPts = getA1() + getA2() + getA3()+ getA4();
	  midPts = getMidterm();
	  finalePts = getFinalExam();
	  
	  return theirWeighted = ((assignPts*.2f+midPts*.3f+ finalePts*.5f)/totalWeighted)*100;
  }
  
  /**
   * Prints all instance variables as a string.
   * @return A string representing the student.
   */
  public String toString(){
    return("   "+ ID + "          " + a1 + "      " + a2 + "      " + a3 + "      " + a4 + "       " + midterm + "      " + finalExam);
  }
  

  public void saveTo(PrintWriter aFile) {
	  aFile.println(toString());
	  
	}
  
  /**
   * Will read from the linked file which will create and return a new Student object.
   * @param aFile File to read from.
   * @return A new Student object read from a line of the file.
 * @throws IOException 
 * @throws NumberFormatException 
   */
  
  //using StringTokenizer
  public static Student loadFromST(BufferedReader aFile) throws IOException {
    Student newStudent = new Student();
 
    StringTokenizer st = new StringTokenizer(aFile.readLine()," ");
    
    newStudent.ID = Integer.parseInt(st.nextToken());
    newStudent.a1 = Float.parseFloat(st.nextToken());
    newStudent.a2 = Float.parseFloat(st.nextToken());
    newStudent.a3 = Float.parseFloat(st.nextToken());
    newStudent.a4 = Float.parseFloat(st.nextToken());
    newStudent.midterm = Float.parseFloat(st.nextToken());
    newStudent.finalExam = Float.parseFloat(st.nextToken());
  
    return (newStudent);
  }
    
 public static Student loadFromSTOnlyID(BufferedReader aFile) throws IOException {
	 
	 	String null1,null2,null3,null4,null5,null6 = "3";

        Student newStudent = new Student();
     
        StringTokenizer st = new StringTokenizer(aFile.readLine()," ");
        
        newStudent.ID = Integer.parseInt(st.nextToken());
        null1 = st.nextToken();
        null2 = st.nextToken();
        null3 = st.nextToken();
        null4 = st.nextToken();
        null5 = st.nextToken();
        null6 = st.nextToken();
        
      
        return (newStudent);
      } 
  } 
