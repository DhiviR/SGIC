public class StackAndHeap {

    /**
     * To run an application in an optimal way JVM divide the memory into Stack and Heap.
     *
     * Stack
     * -------
     * Stack memory in Java used for Static memory allocation and execution of a thread.
     * It contains primitive values and references to objects
     * Access to this memory is in LIFO order
     * It grows and shrinks as new methods are called and returned
     * If this memory is full java.lang.StackOverFlowError exception is thrown.
     * This memory is thread safe because each thread operates in its own stack
     *
     *
     * Heap
     * -----
     * Java objects reside in an area called the heap
     * New objects are always created in heap space and the reference is stored in stack memory
     * These objects can be accessed from anywhere in the application
     * This is not thread safe
     * When the heap is full garbage is collected
     * If the heap is full after the garbage collection java.lang.OutOfMemoryError is thrown
     * The heap is sometimes divided into two areas
     *      Nursery (or young space) - Reserved for allocation of new objects
     *      Old space - When the nursery becomes full the objects lived long enough in the nursery moved to old space
     *
     *
     *
     */
}
