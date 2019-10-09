package w3;

public class Course implements Cloneable{
    
    private String name;
    private Integer id;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    protected Course clone() throws CloneNotSupportedException{
        return (Course)super.clone();
    }

    @Override
    public String toString() {
        return "Course [name=" + name + ", id=" + id + "]";
    }

}
