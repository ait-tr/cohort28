package todo_appl.model;

public enum Menu {

    LIST(1), ADD(2), FIND(3), REMOVE(4), EXIT(5);

    private final int menuItem;

    //конструктор
    Menu(int menuItem){
        this.menuItem = menuItem;
    }

    public int getMenuItem() {
        return menuItem;
    }

    // печатать меню
    public static void printMenu(){
        Menu[] menu = Menu.values();
        for (int i = 0; i < menu.length; i++) {
            System.out.print(menu[i].menuItem + " - " + menu[i] + " | "); // печатаем меню в 1 строку
        }
    }
}
