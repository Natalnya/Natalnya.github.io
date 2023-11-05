package lab4;

public class MyClass {
    @MyAnnotation(2)
    public void publicMethod() {
        System.out.println("Public method");
    }

    @MyAnnotation(3)
    protected void protectedMethod() {
        System.out.println("Protected method");
    }

    @MyAnnotation(4)
    private void privateMethod() {
        System.out.println("Private method");
    }
}
