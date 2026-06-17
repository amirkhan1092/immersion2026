class student{
    
    private int StudentID;
    private String StudentName;

    
    public student(int studentID, String studentName) {
        StudentID = studentID;
        StudentName = studentName;
    }
    public int getStudentID() {
        return StudentID;
    }
    public void setStudentID(int studentID) {
        StudentID = studentID;
    }
    public String getStudentName() {
        return StudentName;
    }
    public void setStudentName(String studentName) {
        StudentName = studentName;
    }
    @Override
    public String toString() {
        return "student [StudentID=" + StudentID + ", StudentName=" + StudentName + "]";
        // return "This is Method to print object";
    }


    
   

}
public class Test {
    public static void main(String[] args) {
        student s1 = new student();
        System.out.print(s1);
    }
}


// Parth and Hemant Presentation 
