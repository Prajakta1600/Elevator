package com.gr.elevator.svc.Service;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBaseService<T> {

    T create(T t);

    T update(T t);

    T findById(Long id);

    Long deleteById(Long id);

    Boolean deleteAll();
    
    List<T> findAll();

}
