package lab4;

public class Main {
    public static void main(String[] args) throws Exception {
        MyClass myClass = new MyClass();

        Class<?> clazz = myClass.getClass();

        java.lang.reflect.Method[] methods = clazz.getDeclaredMethods();

        for (java.lang.reflect.Method method : methods) {

            if (method.isAnnotationPresent(MyAnnotation.class)) {
                int value = method.getAnnotation(MyAnnotation.class).value();
                method.setAccessible(true);
                for (int i = 0; i < value; i++) {
                    method.invoke(myClass);
                }
            }
        }
    }
}

