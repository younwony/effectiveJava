package dev.wony.effectivejava.chapter_3.item_16;

// package-private class
class PackagePrivateClass {
    // 이 필드는 같은 패키지 내에서 직접 접근 가능
    public String packagePrivateField;
}

public class MainClass {
    // private nested class
    private static class PrivateNestedClass {
        // 이 필드는 MainClass 내에서 직접 접근 가능
        public String privateNestedField;
    }

    public static void main(String[] args) {
        PackagePrivateClass obj1 = new PackagePrivateClass();
        obj1.packagePrivateField = "Hello, package-private!";  // 같은 패키지 내에서 직접 접근 가능

        PrivateNestedClass obj2 = new PrivateNestedClass();
        obj2.privateNestedField = "Hello, private nested!";  // MainClass 내에서 직접 접근 가능

        System.out.println(obj1.packagePrivateField);
        System.out.println(obj2.privateNestedField);
    }
}