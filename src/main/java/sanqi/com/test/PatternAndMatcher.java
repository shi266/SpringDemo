package sanqi.com.test;

import sanqi.com.entity.Animal;

import java.util.*;
import java.util.stream.Collectors;

public class PatternAndMatcher {

    public static void main(String[] args) {
        List<sanqi.com.entity.Animal> list = new ArrayList<>();
        sanqi.com.entity.Animal a1 = new sanqi.com.entity.Animal();
        sanqi.com.entity.Animal a2 = new sanqi.com.entity.Animal();
        sanqi.com.entity.Animal a3 = new sanqi.com.entity.Animal();
        sanqi.com.entity.Animal a4 = new sanqi.com.entity.Animal();
        sanqi.com.entity.Animal a5 = new sanqi.com.entity.Animal();

            a1.setName("name1");a1.setAge(14);
            a2.setName("name2");a2.setAge(13);
            a3.setName("name3");a3.setAge(15);
            a4.setName("name4");a4.setAge(12);
            a5.setName(null);a5.setAge(17);

            list.add(a1);
            list.add(a2);
            list.add(a3);
            list.add(a4);
            list.add(a5);
        for (sanqi.com.entity.Animal animal : list) {
            System.out.println(animal.getName());
        }
        System.out.println("------------------");

        list= list.stream().sorted(Comparator.comparing(sanqi.com.entity.Animal::getAge,Comparator.nullsFirst(Integer::compareTo)).reversed()).collect(Collectors.toList());
      /*  Collections.sort(list,new Comparator<Animal>(){

            @Override
            public int compare(Animal o1, Animal o2) {
                return o2.getAge()-o1.getAge();
            }
        });*/
        for (Animal animal : list) {
            System.out.println(animal.getName());
        }



        }
}
