public class PersonInfo {

    private long user_id;
    private String email;
    private String name;
    private java.sql.Date birthday;
    private float weight;
    private float height;

    public long getUser_id(){ return this.user_id;}

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public java.sql.Date getBirthday() {
        return this.birthday;
    }

    public float getWeight() {
        return this.weight;
    }

    public float getHeight() {
        return this.height;
    }

    public void setUser_id(long user_id){this.user_id = user_id;}

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(java.sql.Date birthday) {
        this.birthday = birthday;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
