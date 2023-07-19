public class BasketballPlayer extends Person {
    private String position;
    private int salary;

    public BasketballPlayer(String name, int age, String pos, int s) {
        super(name,age);
        position = pos;
        salary = s;

    }

    public void setPosition(String n){
        position = n;
    }

    public void setSalary(int a){
        salary = a;
    }

    public String getPosition(){
        return position;
    }

    public int getSalary(){
        return salary;
    }

    public String toString(){
        return "Player: " + super.getName() + "\n"+
                "Position: " + getPosition()+ "\n" +
                "Salary: " + getSalary();
    }

}
