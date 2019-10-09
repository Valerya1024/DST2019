package w3;

public class Teacher implements Cloneable{
    private String name;
    private Integer age;
    private Course course;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    
    @Override
    protected Teacher clone() throws CloneNotSupportedException {
        Teacher teacher = (Teacher)super.clone();
        teacher.course = course.clone();
        return teacher;
    }
    @Override
    public String toString() {
        return " [name=" + name + ", age=" + age + ", course=" + course + "]";
    }
    

}
