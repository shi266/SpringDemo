package sanqi.com.test;


import java.lang.reflect.*;

public class Invoke {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, ClassNotFoundException {

        Class a = Class.forName("sanqi.com.entity.UserInfo");
        Field[] fields = a.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field);
        }

       /* Class<?>  clazz = UserInfo.class;

        UserInfo info = (UserInfo) clazz.newInstance();
        info.setUsername("张三");
        info.setPassword("zhang");
        info.setId(3);
        System.out.println(info);

        int[] temp = { 1, 2, 3, 4, 5 };
        Class<?> demo = temp.getClass().getComponentType();

        System.out.println("数组类型： " + demo.getName()+"\t");
        System.out.println("数组长度  " + Array.getLength(temp)+"\t"+temp.length);
        System.out.println("数组的第一个元素: " + Array.get(temp, 0)+"\t"+temp[0]);
        temp[2]=22;
        for (int i : temp) {
            System.out.print(i+",");
        }
*/

/*
        Method method = clazz.getMethod("testInfo",int.class,String.class);
        method.invoke(clazz.newInstance(),5,"ok");
        System.out.println("----------------------------");
        Object obj = clazz.newInstance();
        Field field = clazz.getDeclaredField("username");
        field.setAccessible(true);
        field.set(obj, "Java反射机制");

        System.out.println(field.get(obj));
        System.out.println(info);*/

      /*  Constructor<?>[] constructors = clazz.getConstructors();

        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> param : parameterTypes) {
                System.out.println("参数："+param.getName());
            }

        }
        info = (UserInfo) constructors[0].newInstance(32,"李四","lisi2");
        System.out.println(info);*/

    }
}
