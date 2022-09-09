package Java8NewFeatures;

import com.sun.istack.internal.Interned;

public class TypeAnnotations {

    /**
     * Before Java 8, Annotations can be applied to declarations:  declarations of classes, fields, methods
     * As of Java 8, Annotations can also be applied to the use of types
     *
     * Class instance creation expression:
     *     new @Interned MyObject();
     *
     * Type cast:
     *     myString = (@NonNull String) str;
     *
     * implement clause:
     *     Class UnmodifiableList<T> implements @Readonly List <Readonly> {}
     *
     * Thrown exception declaration:
     *     void monitorTemperature() throws @Critical TemperatureException {}
     *
     */

}
