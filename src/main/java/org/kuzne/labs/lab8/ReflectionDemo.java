package org.kuzne.labs.lab8;

import org.kuzne.labs.lab6.Human;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

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

    public static <T> List<String> getPublicMethods(T obj) {
        List<String> publicMethodsNames = new ArrayList<>();
        for (Method method : obj.getClass().getDeclaredMethods()) {
            if (!Modifier.isPublic(method.getModifiers())) continue;
            publicMethodsNames.add(method.getName());
        }
        Collections.sort(publicMethodsNames);
        return publicMethodsNames;
    }

    public static <T> List<String> getSuperClasses(T obj) {
        List<String> superClasses = new ArrayList<>();
        Class<?> currentClass = obj.getClass();
        while (currentClass.getSuperclass() != null) {
            currentClass = currentClass.getSuperclass();
            superClasses.add(currentClass.getSimpleName());
        }
        Collections.sort(superClasses);
        return superClasses;
    }

//    public static <T> int countImplementations(List<T> list) {
//        int count = 0;
//        for (T obj : list) {
//            for (Class<?> interf : obj.getClass().getInterfaces()) {
//                if (interf.getSimpleName().equals("Executable")) {
//                    ((Executable) obj).execute();
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    public static <T> int countImplementations(List<T> list) {
        int count = 0;
        for (T obj : list) {
            if (obj instanceof Executable) {
                ((Executable) obj).execute();
                count++;
            }
        }
        return count;
    }

    public static <T> List<String> getGettersAndSetter(T obj) {
        List<String> gettersAndSetters = new ArrayList<>();
        for (Method method : obj.getClass().getDeclaredMethods()) {
            if ((Modifier.isPublic(method.getModifiers())) &&
             (!Modifier.isStatic(method.getModifiers())) &&
             (method.getParameterTypes().length == 0) &&
             (method.getName().startsWith("get")) &&
             (!method.getReturnType().getName().equals("void"))) {
                gettersAndSetters.add(method.getName());
            }
            if ((Modifier.isPublic(method.getModifiers())) &&
                    (!Modifier.isStatic(method.getModifiers())) &&
                    (method.getParameterTypes().length == 1) &&
                    (method.getName().startsWith("set")) &&
                    (method.getReturnType().getName().equals("void"))) {
                gettersAndSetters.add(method.getName());
            }
        }
        Collections.sort(gettersAndSetters);
        return gettersAndSetters;
    }
}
