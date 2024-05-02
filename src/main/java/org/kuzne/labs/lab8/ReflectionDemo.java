package org.kuzne.labs.lab8;

import org.kuzne.labs.lab3.Packable;
import org.kuzne.labs.lab6.Human;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReflectionDemo {
    public static <T> int humanTypesCount(List<T> list) {
        int count = 0;
        for (T item : list) {
            if (item instanceof Human) {
                count++;
            }
        }
        return count;
    }

    public static <T> Set<String> getPublicMethods(T obj) {
        Set<String> publicMethodsNames = new HashSet<>();
        for (Method method : obj.getClass().getMethods()) {
//            System.out.println(method.getName() + " " + method.getModifiers());
            if (method.getModifiers() == Modifier.PUBLIC || method.getModifiers() == Modifier.PUBLIC + Modifier.STATIC) {
                publicMethodsNames.add(method.getName());
            }
        }
        return publicMethodsNames;
    }

    public static <T> Set<String> getSuperClasses(T obj) {
        Set<String> superClasses = new HashSet<>();
        Class<?> currentClass = obj.getClass();
        while (!currentClass.getSuperclass().getSimpleName().equals("Object")) {
            superClasses.add(currentClass.getSuperclass().getSimpleName());
            currentClass = currentClass.getSuperclass();
        }
        superClasses.add("Object");
        return superClasses;
    }
}
