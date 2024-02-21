import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Generator {
    private final List<Employee> employees;
    private final List<Task> tasks;
    private final List<Task> finishedTasks;
    public Generator() {
        employees = new ArrayList<Employee>();
        tasks = new ArrayList<Task>();
        finishedTasks = new ArrayList<Task>();
    }
    public Generator(List<Employee> employees, List<Task> tasks) {
        this.employees = employees;
        this.tasks = tasks;
        this.finishedTasks = new ArrayList<Task>();
    }
    public void P_Option(){
        System.out.printf("***-------------------------------------------------***%n");
        System.out.printf("|                    Position Employee                |%n");
        System.out.printf("***-------------------------------------------------***%n");
        System.out.printf("|                    %-10s               |%n",".C++ Programming  ");
        System.out.printf("|                    %-10s               |%n",".C# Programming   ");
        System.out.printf("|                    %-10s               |%n",".Java Programming ");
        System.out.printf("***-------------------------------------------------***%n");
    }
    public void Issue_Option(){
        System.out.printf("***---------------------------------------------------------***%n");
        System.out.printf("|                    ISSUE OPTION                             |%n");
        System.out.printf("***---------------------------------------------------------***%n");
        System.out.printf("|                    %-10s                |%n",".BACK END        ");
        System.out.printf("|                    %-10s                |%n",".FRONT END       ");
        System.out.printf("|                    %-10s                |%n",".UX/UI           ");
        System.out.printf("|                    %-10s                |%n",".DESIGN DATABASE ");
        System.out.printf("***-------------------------------------------------***%n");
    }
    public void checkEmp(){
        Employee emp=new Employee();
        System.out.println("...............................................................................|");
        System.out.println("                            Employee List                                      |");
        System.out.println("...............................................................................|");
        System.out.printf("%-5s%-12s%-12s%-17s%-15s","ID","Name","Position","Email","PhoneNumber");
        System.out.println();
        System.out.println("...............................................................................|");
        for(int i=0;i< employees.size();i++){
            System.out.printf("%-5s%-12s%-12s%-17s%-15s",employees.get(i).getId()
                    ,employees.get(i).getName()
                    ,employees.get(i).getPosition()
                    ,employees.get(i).getEmail()
                    ,employees.get(i).getPhone());
            System.out.println();
           // System.out.println(".............................................................................................");
        }
    }
    public void assignTask(Task task) {
        Employee employee = getEmployeeAvailable(task.getType());
        employee.setAvailable(employee.getAvailable()+1);

        task.setEmployeeId(employee.getId());


        tasks.add(task);

    }

    public void viewCurrentTasks() {
        DateFormat Formatter = new SimpleDateFormat("yyyy-mm-dd");
        System.out.printf("%-5s%-16s%-16s%-10s%-10s%-16s%-5s","ID","Name","Issue","Scale","Type","Date","EmployeeID");
        System.out.println();
        for(int i=0;i<tasks.size();i++){
            System.out.printf("%-5s%-16s%-16s%-10s%-10s%-16s%-5s", Integer.toString(tasks.get(i).getId()), tasks.get(i).getName(), tasks.get(i).getIssue(), tasks.get(i).getScale(), tasks.get(i).getType(), Formatter.format(tasks.get(i).getDate()), tasks.get(i).getEmployeeId());
            System.out.println();
        }
    }

//    public void viewEmployee() {
//        DateFormat Formatter = new SimpleDateFormat("yyyy-mm-dd");
//        System.out.println("\tID\tName\tIssue\tScale\tType\tDate\tEmployeeID");
//        for(Task task : tasks) {
//            System.out.printf("\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n", Integer.toString(task.getId()), task.getName(), task.getIssue(), task.getScale(), task.getType(), Formatter.format(task.getDate()), task.getEmployeeId());
//        }
//    }
    public void closeTask(int id) {
        for(int i=0; i< tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                finishedTasks.add(tasks.get(i));
                for(Employee employee : employees) {
                    if(employee.getId() == this.tasks.get(i).getEmployeeId()) {
                        employee.setAvailable(employee.getAvailable()-1);
                    }
                }
                tasks.remove(i);
                break;
            }
        }
    }
    private Employee getEmployeeAvailable (String type) {
        Employee temp = new Employee();
        temp.setAvailable(2);
        for(Employee employee : employees) {
            if(Objects.equals(employee.getPosition(), type) && employee.getAvailable() < temp.getAvailable() ) {

                temp = employee;
            }else {
                System.out.println();
                System.out.println("Not assign to Employee");
                System.out.println();
            }
        }
        return temp;
    }

    public void viewFinishedTasks() {
        DateFormat Formatter = new SimpleDateFormat("yyyy-mm-dd");

        System.out.printf("%-5s%-16s%-16s%-10s%-10s%-16s%-5s","ID","Name","Issue","Scale","Type","Date","EmployeeID");
        System.out.println();
        for(int i=0;i<finishedTasks.size();i++){
            System.out.printf("%-5s%-16s%-16s%-10s%-10s%-16s%-5s", Integer.toString(finishedTasks.get(i).getId()), finishedTasks.get(i).getName(), finishedTasks.get(i).getIssue(), finishedTasks.get(i).getScale(), finishedTasks.get(i).getType(), Formatter.format(finishedTasks.get(i).getDate()), finishedTasks.get(i).getEmployeeId());
            System.out.println();
        }
    }
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employees) {
        this.employees.add(employees);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Task tasks) {
        this.tasks.add(tasks);
    }
}
