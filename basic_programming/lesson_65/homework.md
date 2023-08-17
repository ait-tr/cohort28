**Задача 1**

Implementing Blocking Queue for Producer-Consumer Example 

    • Please download project BlockingQueueHW65.zip  from slack
    • Find class ait.mediation.BlkQueueImpl and write the implementation of all methods marked as //TODO (removing the code currently throwing  exceptions)
    • Run the project and verify that you have Producer-Consumer properly running example


Homework Hints:

    • The BlkQueueImpl class would implement the Blocking Queue, which works like Message Box in class work, where push  post, pop  get and number of messages in queue <= maxSize (instead of 1 in Message Box). The blocking logics is the same like Message Box:
        ◦ It blocks Consumers (readers) pop() operation, while it is empty
        ◦ It blocks Producers (writers) push() operation while it is full (has maxSize elements)  
    • Use LinkedList as internal implementation of queue in BlkQueue class
    • Look into classwork examples MessageBoxB or MessageBoxC to implement the proper synchronization logics.

    • And don’t afraid, because each implementation is about ~40 lines of copy-paste from MessageBox and only about ~10 lines of really new code  