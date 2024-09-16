package com.gr.elevator.svc.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface BaseMapper <Dto , Domain>{

    Dto toDTO(Domain domain);

    Domain toDomain(Dto dto);

    default List<Dto> toDTO(List<Domain> domains){
        return domains.stream().map(this::toDTO).collect(Collectors.toList());
    }

    default List<Domain> toDomain(List<Dto> dtos){
        return dtos.stream().map(this::toDomain).collect(Collectors.toList());
    }

    default void automate (Dto dto, Domain domain){

    }
}
