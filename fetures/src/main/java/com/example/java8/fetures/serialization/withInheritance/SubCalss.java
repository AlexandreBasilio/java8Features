package com.example.java8.fetures.serialization.withInheritance;

import lombok.Getter;
import lombok.Setter;

import java.io.*;

/*
Sometimes we need to extend a class that doesn’t implement Serializable interface.
 If we rely on the automatic serialization behavior and the superclass has some state,
 then they will not be converted to stream and hence not retrieved later on.
  This is one place, where readObject() and writeObject() methods really help.
By providing their implementation, we can save the super class state to the stream and then retrieve it later on.

 */

@Getter
@Setter
public class SubCalss extends SuperCalss implements Serializable , ObjectInputValidation {

    private static final long serialVersionUID = -209317589265158912L;

    private String name;

    @Override
    public String toString(){
        return "SubClass{id="+getId()+",value="+getValue()+",name="+getName()+"}";
    }

    /*
        So in this way, we can serialize super class state even though it’s not implementing Serializable interface.
        This strategy comes handy when the super class is a third-party class that we can’t change.
     */
    private void writeObject(ObjectOutputStream os) throws IOException {
        os.defaultWriteObject();
        // Notice that order of writing and reading the extra data to the stream should be same.
        // notice the order of read and write should be same
        os.writeInt(super.getId());       // como a super classe nao eh Serializable, entao guardo o estado manualmente
        os.writeObject(super.getValue()); // como a super classe nao eh Serializable, entao guardo o estado manualmente
    }

    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
        is.defaultReadObject();
        // Notice that order of writing and reading the extra data to the stream should be same.
        // notice the order of read and write should be same
        super.setId(is.readInt());
        super.setValue((String) is.readObject());
    }

    @Override
    public void validateObject() throws InvalidObjectException {
        //validate the object here
        if(name == null || "".equals(name)) throw new InvalidObjectException("name can't be null or empty");
        if(getId() <=0) throw new InvalidObjectException("ID can't be negative or zero");
    }
}
