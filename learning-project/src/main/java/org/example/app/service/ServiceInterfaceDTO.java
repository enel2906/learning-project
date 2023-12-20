package org.example.app.service;

public interface ServiceInterfaceDTO<C, E> extends ServiceInterface<E> {
     static int x = 10;
     C findDTOByKey(String key) throws Exception;
}
