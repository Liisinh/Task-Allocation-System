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
    public void assignTask(Task task) {
        Employee employee = getEmployeeAvailable(task.getType());
        employee.setAvailable(employee.getAvailable()+1);

        task.setEmployeeId(employee.getId());

        tasks.add(task);

    }

    public void viewCurrentTasks() {
        DateFormat Formatter = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println("\tID\tName\tIssue\tScale\tType\tDate\tEmployeeID");
        for(Task task : tasks) {
            System.out.printf("\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n", Integer.toString(task.getId()), task.getName(), task.getIssue(), task.getScale(), task.getType(), Formatter.format(task.getDate()), task.getEmployeeId());
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
        temp.setAvailable(10);
        for(Employee employee : employees) {
            if(Objects.equals(employee.getPosition(), type) && employee.getAvailable() < temp.getAvailable() ) {

                temp = employee;

            }
        }
        return temp;
    }

    public void viewFinishedTasks() {
        DateFormat Formatter = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println("\tID\tName\tIssue\tScale\tType\tDate\tEmployeeID");
        for(Task finished : finishedTasks) {
            System.out.printf("\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n", Integer.toString(finished.getId()), finished.getName(), finished.getIssue(), finished.getScale(), finished.getType(), Formatter.format(finished.getDate()), finished.getEmployeeId());
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
