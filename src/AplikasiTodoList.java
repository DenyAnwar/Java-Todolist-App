public class AplikasiTodoList {
    // create Array
    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoLst();
    }

    /**
     * For to show todo list
     */
    public static void showTodoList() {
        System.out.println("TODOLIST APP.");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo!= null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus Java Dasar : Aplikasi Todolist";
        showTodoList();
    }

    /**
     * For to add todo to list
     */
    public static void addTodoList(String todo) {
        // Check whether the model is full?
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            // there is an empty model
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        // If model is full, we will resize an array twice
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // add to position where the array data is NULL
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 5; i++) {
            addTodoList("Contoh Todo Ke. " + i);
        }

        showTodoList();
    }

    /**
     * For to remove todo from list
     */
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        var result = removeTodoList(2);
        System.out.println(result);
        System.out.println(model.length);

        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);
    }

    /**
     * For to show view todo list
     */
    public static void viewShowTodoLst() {
        while (true) {
            showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("x. Exit");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Option is not available");
            }
        }
    }

    public static void testViewShowTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        viewShowTodoLst();
    }

    /**
     * For to show view add todo list
     */
    public static void viewAddTodoList() {
        System.out.println("ADD TODOLIST");

        var todo = input("Todo (x If Cancel)");

        if (todo.equals("x")) {
            // cancel
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");

        viewAddTodoList();

        showTodoList();
    }

    /**
     * For to show view remove todo list
     */
    public static void viewRemoveTodoList() {
        System.out.println("DELETE TODOLIST");

        var number = input("Number that will be deleted (x If Cancel)");

        if (number.equals("x")) {
            // cancel
        } else {
            try {
                var isNumber = Integer.parseInt(number);
                boolean success = removeTodoList(Integer.valueOf(isNumber));
                if (!success) {
                    System.out.println("Failed to deleted todolist : " + number);
                }
            } catch (NumberFormatException ex) {
                System.out.println("Option is not available");
            }

        }
    }

    public static void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
