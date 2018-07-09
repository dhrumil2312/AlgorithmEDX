package GraphAlgorithms;


import java.util.*;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
    public Employee(int id, int importance, List<Integer> subordinates){
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
}



public class EmployeeImportance {
    public static int getImportance(List<Employee> employees, int id) {
        Queue<Integer> q = new PriorityQueue<>();

        HashMap<Integer,Employee> hashMap = new HashMap<>();

        for(Employee emp : employees){
            hashMap.put(emp.id , emp);
        }

        q.add(id);
        int count = 0;
        while(!q.isEmpty()){
            int current = q.poll();
            Employee ep  = hashMap.get(current);
            for(int i : ep.subordinates){
                q.add(i);
            }
            count += ep.importance;
        }

        return count;
    }

    public static void main(String[] args) {

        List<Integer> sub1 = new ArrayList<>();
        sub1.add(2);
        sub1.add(3);
        Employee e1 = new Employee(1,5,sub1);

        List<Integer> sub2 = new ArrayList<>();
        List<Integer> sub3 = new ArrayList<>();

        Employee e2 = new Employee(2,3,sub2);
        Employee e3 = new Employee(3,3,sub3);


        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        System.out.println(getImportance(employees,1));

    }
}
