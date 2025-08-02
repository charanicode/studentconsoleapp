import java.util.ArrayList;
import java.util.*;
class Student{
    int roll_num;
    String name;
    ArrayList<Integer> marks=new ArrayList<>();
    char grade;
    public void average(){
        int total=0;
        for (int i = 0; i < marks.size(); i++) {
            total+= marks.get(i);
        }
        int average=total/marks.size();
        System.out.println("Average marks of a "+name+" is "+average);
        if(average>=90){
            System.out.println("grade A");
        } else if (average>=75) {
            System.out.println("grade B");
        } else if (average>=60) {
            System.out.println("grade C");
        } else if (average>=40) {
            System.out.println("grade D");
        }
        else {
            System.out.println("Grade F");
        }
    }
}
public class project {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        HashMap<Integer,Student>store_details=new HashMap<>();
        while (true) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Exit");
            System.out.println("5. Delete Student by Roll Number");
            System.out.println("6. Update Student Details");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    Student student=new Student();
                    System.out.print("enter roll number: ");
                    student.roll_num=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("enter your name: ");
                    student.name=scanner.nextLine();
                    System.out.println("enter number of subjects: ");
                    int no_of_subjects= scanner.nextInt();
                    System.out.println("enter marks of subjects: ");
                    for (int j = 0; j < no_of_subjects; j++) {
                        student.marks.add(scanner.nextInt());
                    }
                    student.average();
                    store_details.put(student.roll_num,student);
                    break;
                case 2:
                    for (Student student1: store_details.values()) {
                        System.out.println("name: "+student1.name);
                        System.out.println("roll_num1: "+student1.roll_num);
                        System.out.println("marks: "+student1.marks);
                        System.out.print("average and grade of a student: ");
                        student1.average();
                    }
                    break;
                case 3:
                    System.out.println("enter toll number to search details: ");
                    int roll_no=scanner.nextInt();
                    Student student1 = store_details.get(roll_no);
                    if (student1 != null) {
                        System.out.println("Name: " + student1.name);
                        System.out.println("Roll Number: " + student1.roll_num);
                        System.out.println("Marks: " + student1.marks);
                        System.out.println("Grade: " + student1.grade);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.println("exited ");
                    return;
                case 5:
                    System.out.print("enter roll number: ");
                    int roll_num= scanner.nextInt();
                    if(store_details.containsKey(roll_num)){
                        store_details.remove(roll_num);
                        System.out.println("student details deleted successfully!");
                    }
                    else{
                        System.out.println("student not found");
                    }
                    break;
                case 6:
                    System.out.println("enter roll number ");
                    int roll_num1 =scanner.nextInt();
                    scanner.nextLine();
                    if(store_details.containsKey(roll_num1)) {
                        store_details.get(roll_num1);
                        Student student2=store_details.get(roll_num1);
                        System.out.println("Do you want to update name?(please respond with yes/no)");
                        String update_name = scanner.nextLine();
                        if (update_name.equalsIgnoreCase("yes")) {
                            String new_name = scanner.nextLine();
                            student2.name = new_name;
                        }
                        System.out.println("Do you want to update marks?(please respond with yes/no)");
                        String update_marks = scanner.nextLine();
                        if(update_marks.equalsIgnoreCase("yes")){
                            student2.marks.clear();
                            System.out.println("enter number of subjects: ");
                            int num_subjects= scanner.nextInt();
                            scanner.nextLine();
                            for (int j = 0; j < num_subjects; j++) {
                                student2.marks.add(scanner.nextInt());
                            }
                            student2.average();
                        }
                    }
                    else{
                        System.out.println("student not found");
                    }
                    break;
                default:
                    System.out.println("Invalid choice.try again");
            }
        }
    }
}
