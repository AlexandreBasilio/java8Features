package com.example.java8.fetures.serialization;

import java.io.*;

/*
 * A simple class with generic serialize and deserialize method implementations
 */
public class SerializationUtil {

    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        // ler o arquivo e transforma em bytes (ele eh um InputStream)
        FileInputStream fs = new FileInputStream(fileName);
        // agora preciso ler os bytes.. mas eu quero ler nao de bytes em bytes (fs.read).
        // eu quero ler os bytes e transformar em obj JAVA. entao crio o ObjectInputStream.. e uso o metodo read.. readObject
        // vou ler o input stream fs
        System.out.println("readObject automatic by SERIALIZABLE");
        ObjectInputStream objectInputStream = new ObjectInputStream(fs);
        System.out.println("objInputStream=" + objectInputStream);
        Object obj = objectInputStream.readObject();  // se o readObject estiver implementado na classe Employee sera ele o usado.
        objectInputStream.close();

        return obj;
    }

    public static void serializa(Object obj, String fileName) throws IOException {

        // busca arquivo para escrever em bytes. o arquivo lido estah em bytes. Ele eh um OutputStream
        FileOutputStream os = new FileOutputStream(fileName);
        // com o arquivo em bytes, agora posso escrever byte a byte com o write() ou escrever um array de bytes write(buffer)
        // mas para escrever um obj java preciso transformar primeiro em um ObjectoutputStream
        // e em seguida usar o write() ou writeObject()
        System.out.println("writeObject automatic by SERIALIZABLE");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
        objectOutputStream.writeObject(obj);

        objectOutputStream.close();
    }
}
