package finterface.examples;


@FunctionalInterface
public interface FunctionalInterf {
    abstract public void abstractMethod();

}

/*

SAM interface - single abstract method interface

public interface Interface1 extends FunctionalInterf{

}


public interface Interface2 extends FunctionalInterf{
    @Override
    abstract public void abstractMethod();

public interface Interface3 extends FunctionalInterf{
    public default void (defMethod(){
    // to do sm
        };
}

 */
