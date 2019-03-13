package com.test.sample.utils;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static org.junit.Assert.assertNotNull;

public class PropertiesReader {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final String provider;

    public PropertiesReader(String provider) {
        this.provider = provider;
    }

    private String setPath() {
        return new File(provider).getAbsolutePath();

    }

    private Properties readProvidedProperties() {
        Properties properties = null;
        try (InputStreamReader envFileReader = new InputStreamReader(new FileInputStream(setPath()))) {
            properties = new Properties();
            properties.load(envFileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotNull(properties);
        return properties;
    }

    public String readSpecificProperty(String key) {
        lock.readLock().lock();
        try {
            return readProvidedProperties().getProperty(key);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void updateSpecificProperty(String key, String value) {
        lock.writeLock().lock();
        try {
            Properties properties = readProvidedProperties();
            try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(setPath()))) {
                properties.setProperty(key, value);
                properties.store(writer, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

}
