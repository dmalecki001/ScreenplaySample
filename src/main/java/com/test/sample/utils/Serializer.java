package com.test.sample.utils;

import java.io.*;

import static java.util.Objects.requireNonNull;

public class Serializer {

    public static <T> void serialize(T obj, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(requireNonNull(obj));
                oos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T deserialize(String fileName) {
        T obj = null;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                obj = (T) ois.readObject();
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return requireNonNull(obj);
    }

}
