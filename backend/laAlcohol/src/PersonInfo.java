public class PersonInfo {

    private String email;
    private String name;
    private java.sql.Date birthday;
    private Float weight;
    private Float height;

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public java.sql.Date getBirthday() {
        return this.birthday;
    }

    public Float getWeight() {
        return this.weight;
    }

    public Float getHeight() {
        return this.height;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(java.sql.Date birthday) {
        this.birthday = birthday;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public void setHeight(Float height) {
        this.height = height;
    }
}
