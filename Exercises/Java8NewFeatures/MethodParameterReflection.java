package Java8NewFeatures;

import java.util.Collection;
import java.util.List;

public class MethodParameterReflection {

    /**
     * We can obtain the names of the parameters of any method or constructor with method
     *      java.lang.reflect.Executable.getParameters
     *
     * .class files do not store formal parameters by default.
     *  we should compile the source code using -parameters option of the javac compiler.
     */

    public class ExampleMethods<T> {

        public boolean simpleMethod(String stringParam, int intParam) {
            System.out.println("String: " + stringParam + ", integer: " + intParam);
            return true;
        }

        public int varArgsMethod(String... manyStrings) {
            return manyStrings.length;
        }

        public boolean methodWithList(List<String> listParam) {
            return listParam.isEmpty();
        }

        public <T> void genericMethod(T[] a, Collection<T> c) {
            System.out.println("Length of array: " + a.length);
            System.out.println("Size of collection: " + c.size());
        }

        /**
         * After compiling (javac -parameters ExampleMethods) the above class and if we run the following code it will
         * print the formal parameter names of the method and constructors
         *          java MethodParameterSpy ExampleMethods
         *
         *
         *This command prints the following:
         *
         *      Number of constructors: 1
         *
         *      Constructor #1
         *      public ExampleMethods()
         *
         *      Number of declared constructors: 1
         *
         *      Declared constructor #1
         *      public ExampleMethods()
         *
         *      Number of methods: 4
         *
         *      Method #1
         *      public boolean ExampleMethods.simpleMethod(java.lang.String,int)
         *                      Return type: boolean
         *              Generic return type: boolean
         *                  Parameter class: class java.lang.String
         *                   Parameter name: stringParam
         *                        Modifiers: 0
         *                      Is implicit?: false
         *              Is name present?: true
         *                  Is synthetic?: false
         *                  Parameter class: int
         *                  Parameter name: intParam
         *                      Modifiers: 0
         *                  Is implicit?: false
         *              Is name present?: true
         *                  Is synthetic?: false
         *
         *      Method #2
         *      public int ExampleMethods.varArgsMethod(java.lang.String...)
         *                      Return type: int
         *              Generic return type: int
         *                      Parameter class: class [Ljava.lang.String;
         *                  Parameter name: manyStrings
         *                      Modifiers: 0
         *                  Is implicit?: false
         *              Is name present?: true
         *                  Is synthetic?: false
         *
         *      Method #3
         *      public boolean ExampleMethods.methodWithList(java.util.List<java.lang.String>)
         *                      Return type: boolean
         *              Generic return type: boolean
         *                  Parameter class: interface java.util.List
         *                  Parameter name: listParam
         *                      Modifiers: 0
         *                  Is implicit?: false
         *              Is name present?: true
         *                  Is synthetic?: false
         *
         *      Method #4
         *      public <T> void ExampleMethods.genericMethod(T[],java.util.Collection<T>)
         *                      Return type: void
         *              Generic return type: void
         *                  Parameter class: class [Ljava.lang.Object;
         *                  Parameter name: a
         *                      Modifiers: 0
         *                  Is implicit?: false
         *              Is name present?: true
         *                  Is synthetic?: false
         *                  Parameter class: interface java.util.Collection
         *                  Parameter name: c
         *                      Modifiers: 0
         *                  Is implicit?: false
         *              Is name present?: true
         *                  Is synthetic?: false
         */


    }
}
