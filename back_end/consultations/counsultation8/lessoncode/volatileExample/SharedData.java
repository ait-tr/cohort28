package volatileExample;



class SharedData {
    private volatile boolean flag = false;

    public void setFlag() {
        flag = true; // Изменяем значение флага
    }

    public void doSomething() {
        if (flag) {
            System.out.println("Флаг установлен!");
        }
    }
}

