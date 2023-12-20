package org.example.app.service;

public interface ServiceInterfaceDTO<C, E> extends ServiceInterface<E> {
     C findDTOByKey(String key) throws Exception;
}
