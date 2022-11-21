package ru.javamentor.springmvchibernate.service;

import ru.javamentor.springmvchibernate.model.Role;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoleService {
    Set<Role> findAll();

    void addRole(Role role);

    Role findById(Long id);

}
