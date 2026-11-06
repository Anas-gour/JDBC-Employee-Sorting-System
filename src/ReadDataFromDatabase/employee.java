package ReadDataFromDatabase;

import java.util.Comparator;

class employee{
    private String name;
    private String job;
    private double sal;
    employee(String name, String job, double sal){
        this.job = job;
        this.name = name;
        this.sal = sal;
    }
    public String toString(){
        return "Name "+name+" Salary: "+sal+" Job: "+job;
    }

    static Comparator<employee> nameBase = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            employee e1 = (employee) o1;
            employee e2 = (employee) o2;
            return e1.name.compareTo(e2.name);
        }
    };

    static Comparator<employee> salBase = new Comparator(){
        @Override
        public int compare(Object o1, Object o2){
            employee e1 = (employee) o1;
            employee e2 = (employee) o2;
            return (int) (e1.sal-e2.sal);
        }
    };
}
