package com.example.java8.fetures.functionalInterfaces.staticmethod;

@FunctionalInterface  // com essa anotacao, obriga a ter somente 1 metodo abstrato. Aqui
                      // o metodo abstrato eh accept. Se crio outro metodo ex: calcularX ele da erro de compilacao
public interface MyData {

    void accept(String texto);

    //int calcularX(int numero);

    default void print(String str) {
        if (!isNull(str))
            System.out.println("MyData Print::" + str);
    }

    static boolean isNull(String str) {
        System.out.println("Interface Null Check");

        return str == null ? true : "".equals(str) ? true : false;
    }

    default void otherMethod(Long numero) {
        if (numero == 10) {
            System.out.println("numero igual a 10");}
    }
}

