
package co.serv;

public class Student {
    private int roll;
    private String name,phone,email,city;

    public Student(int roll, String name, String phone, String email, String city) {
        this.roll = roll;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.city = city;
    }

    public Student() {
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
}
