package com.annotation;

@Anno04(className="Reflection.Person1",methodName = "eat")
public class ReflectionDemo06{
    public static void main(String[] args) {
        Class<ReflectionDemo06> rc = ReflectionDemo06.class;
        Anno04 an = rc.getAnnotation(Anno04.class);
        try{
            String methodName= an.methodName();
            String className = an.className();
            System.out.println(className);
        }catch (NullPointerException e){

        }

    }
}
