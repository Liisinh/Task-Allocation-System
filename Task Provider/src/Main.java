import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        boolean notExit = true;
        Scanner get = new Scanner(System.in);
        Generator generator = new Generator();

        do {

            System.out.println("Welcome to Ours Company!");
            System.out.println("Please Choose Option Below");
            System.out.println("1. Add Employee.");
            System.out.println("2. Add Task.");
            System.out.println("3. View Task.");
            System.out.println("4. Marked Task is Finished.");
            System.out.println("5. View Task.");
            System.out.println("6. Exit.");
            System.out.print("Your Option : ");
            int option = get.nextInt();

            switch (option) {
                case 1 : {
                    Employee employee = new Employee();

                    System.out.print("Enter Id : ");
                    employee.setId(get.nextInt());
                    System.out.print("Enter Name : ");
                    employee.setName(get.next());
                    System.out.print("Enter Position : ");
                    employee.setPosition(get.next());
                    System.out.print("Enter Email : ");
                    employee.setEmail(get.next());
                    System.out.print("Enter Phone : ");
                    employee.setPhone(get.next());

                    generator.setEmployees(employee);
                    break;
                }
                case 2 : {
                    Task task = new Task();
                    DateFormat Formatter = new SimpleDateFormat("yyyy-mm-dd");

                    System.out.print("Enter Id : ");
                    task.setId(get.nextInt());
                    System.out.print("Enter Name : ");
                    task.setName(get.next());
//                    System.out.print("Enter EmployeeId : ");
//                    task.setEmployeeId(get.nextInt());
                    System.out.print("Enter Issue : ");
                    task.setIssue(get.next());
                    System.out.print("Enter Scale : ");
                    task.setScale(get.next());
                    System.out.print("Enter Type : ");
                    task.setType(get.next());
                    System.out.print("Enter Date : ");
                    task.setDate(Formatter.parse(get.next()));

                    generator.assignTask(task);
                    break;
                }
                case 3 : {
                    generator.viewCurrentTasks();
                    break;
                }
                case 4 : {
                    System.out.print("Enter Task id to close : ");
                    generator.closeTask(get.nextInt());
                    break;
                }
                case 5 : {
                    generator.viewFinishedTasks();
                    break;
                }
                case 6 : {
                    notExit = false;
                    break;
                }
                default: {
                    System.out.println("Wrong Option!");
                }
            }

        }while(notExit);

    }
}