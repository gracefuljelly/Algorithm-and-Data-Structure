package OOD;

public class Employee {
    static double bonusRate = 0.1;
    final String name; //must be initialized. once assigned, it's immutable
    final String id;
    int age;
    int salary;
    int level;

    Employee(String name, int age, String id, int level){
        this.name=name;
        this.age=age;
        this.id=id;
        this.level=level;
    }

    void printInfo(){
        System.out.println("Name" + name+";Age:"+age+";ID"+id);
    }

    void setAge(int age){
        this.age =age;
    }

    public int calculateSalary(double performanceScore){
        return 0;
    }


}
