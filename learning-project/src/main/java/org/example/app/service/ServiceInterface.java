package org.example.app.service;

public interface ServiceInterface<E> {
    E findByKey(String id) throws Exception;
    void remove(String id) throws Exception;
    boolean isValid(String id) throws Exception;
}
