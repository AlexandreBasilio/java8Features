package com.example.java8.fetures.serialization.proxyPattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Data implements Serializable {

    private static final long serialVersionUID = -1320441711570953532L;

    private String data;

    @Override
    public String toString() {
        return "Data{data=" + data + "}";
    }

    // o proxy eh quem vai ler (fazer a DESERIALIZATION - stream to obj Java)
    // e depois da DESERIALIZATON ele vai validar os dados (data)
    private static class DataProxy implements Serializable {

        private static final long serialVersionUID = -1320441711570945445L;

        private String dataProxy;
        private static final String PREFIX = "ABC";
        private static final String SUFFIX = "DEFG";

        public DataProxy(Data d) {
            //obscuring data for security
            this.dataProxy = PREFIX + d.data + SUFFIX;
        }

        /*
         when Data class is deserialized, internally DataProxy is deserialized and
          when it’s readResolve() method is called, we get Data object.
          AFTER deserialization, the method readResolve is CALLED
          and then we return the obj without proxy
         */
        private Object readResolve() throws InvalidObjectException {
            if (dataProxy.startsWith(PREFIX) && dataProxy.endsWith(SUFFIX)) {
                return new Data(dataProxy.substring(3, dataProxy.length() - 4));
            } else {
                throw new InvalidObjectException("data corrupted");
            }
        }
    }

    // chamado apos a SERIALIZATION
    // replacing serialized object to DataProxy object
    /*
     when Data object is serialized, the returned stream is of DataProxy class.
     However DataProxy class is not visible outside, so it can’t be used directly.

     after serializaton, the method writeReplace is CALLED.
     e retorna o obj a ser gravado. Neste caso, esta sendo gravado o DataProxy
     */
    private Object writeReplace() {
        return new DataProxy(this);
    }

    // se alguem tentar usar o readObject do ObjectInputStream uma excecao serah lanacada
    // avoid hackers attack trying to fabricate Data object stream and parse it.
    private void readObject(ObjectInputStream ois) throws InvalidObjectException{
        throw new InvalidObjectException("Proxy is not used, something fishy");
    }
}
