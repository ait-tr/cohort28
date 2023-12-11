package finterface.functionalInterfaces;

@FunctionalInterface
interface MyFuncInterface {
    int operation(int x, int y);

    default int operate(int x, int y, MyFuncInterface myFuncInterface) {
        return myFuncInterface.operation(x, y);
    }
}
