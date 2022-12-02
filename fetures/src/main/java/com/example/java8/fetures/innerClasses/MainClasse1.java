package com.example.java8.fetures.innerClasses;

public class MainClasse1 {

    private String s_main_class;

    public void print() {
        String s_print_method_var_local_method = "";

        // local inner class inside the method
        class Logger {
            // able to access enclosing class variables
            String name = s_main_class;
            // s_main_class = "fsdf"; erro compilacao (nao deixa mudar var da instancia mae)

            // able to access non-final method variables
            String var_inner_class = s_print_method_var_local_method;

            public void foo() {
                String var_inner_class = s_print_method_var_local_method;
                // Below code will throw compile time error:
                // Local variable s_print_method defined in an enclosing scope must be final or effectively final
                // s_print_method_var_local_method= ":"; // erro compilacao (nao deixa mudar var do metodo fora da inner class)
            }
        }

        // instantiate local inner class in the method to use
        Logger logger = new Logger();

    }
}
