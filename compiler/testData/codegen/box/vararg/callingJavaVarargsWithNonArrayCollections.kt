// TARGET_BACKEND: JVM
// WITH_STDLIB
// FILE: callingJavaVarargsWithNonArrayCollections.kt
fun box(): String {
    return A.foo(*listOf(1, 2, 3))
}

// FILE: A.java

public class A {
    public static String foo(int... ints) {
        return "OK";
    }
}
