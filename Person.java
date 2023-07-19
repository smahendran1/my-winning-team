public class Person {
  
    private int age;
    private String name;
    public Person(){
        age = 0;
        name = null;
    }
    public Person(String n, int a){
        age = a;
        name = n;
    }
    public void setName(String n){
        name = n;
    }
    public void setAge(int a){
        age = a;
    }
    public String getName(){
        return name;
    }

  
    public int getAge(){
        return age;
    }

    
}
