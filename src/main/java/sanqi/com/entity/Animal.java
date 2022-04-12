package sanqi.com.entity;

import org.jetbrains.annotations.NotNull;

public class Animal  implements Comparable<Animal>{
    private String name;
    private Integer age;

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

    @Override
    public int compareTo(@NotNull Animal o) {
        System.out.println(o.age+"-"+this.age+"="+(o.age-this.age));
        return o.age-this.age;
    }
}
