package com.example.java8.fetures.serialization.customWithEncryDecryp;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Getter
@Setter
public class GfgAccount implements Serializable {

    private String username = "alex";
    private String champ1 = "champ1";
    private String champ2 = "champ2";
    private transient String perguntaSecreta = "pergunra";
    private transient String pwd = "senha";


    // Performing customized serialization using the below two methods:
    // this method is executed by jvm when writeObject() on
    // Account object reference in main method is
    // executed by jvm.
    private void writeObject(ObjectOutputStream os) throws IOException {
        os.defaultWriteObject();

        String encryptPwd = "12345678";
        String encryptPergunta = "zazbz";

        // writing encrypted password to the file (guarda como 2 objetos.. depois para ler tem que ler duas vezes)
        os.writeObject(encryptPergunta);
        os.writeObject(encryptPwd);
    }

    // this method is executed by jvm when readObject() on
    // Account object reference in main method is executed by jvm.
    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
        is.defaultReadObject();
       // System.out.println(" is.readObject()=" + is.readObject().toString());
       // System.out.println(" is.readObject()=" + is.readObject().toString());
        String decrypPergunta = (String) is.readObject();
        String decrypPWD = (String) is.readObject();

        this.pwd = decrypPWD.substring(2,6);
        this.perguntaSecreta = decrypPergunta.substring(1);
    }
}
