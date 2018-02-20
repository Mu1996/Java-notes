package com.muyonghui.SerializeDemo;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        //序列化
        SerializePerson();
        //反序列化
        DeSerializePerson();


    }

    private static void SerializePerson(){

        try {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("person")));

            Person person = new Person();
            person.setAge(23);
            person.setName("muyh");
            person.setAddress("aaa");
            oo.writeObject(person);
            System.out.println("序列化成功");
            oo.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void DeSerializePerson(){

        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("person")));

            Person person = (Person)ois.readObject();

            System.out.println("反序列化：");

            System.out.println(person);

            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
