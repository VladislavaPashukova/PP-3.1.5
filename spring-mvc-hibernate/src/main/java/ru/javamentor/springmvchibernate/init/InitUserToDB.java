package ru.javamentor.springmvchibernate.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.javamentor.springmvchibernate.model.Role;
import ru.javamentor.springmvchibernate.model.User;
import ru.javamentor.springmvchibernate.service.RoleService;
import ru.javamentor.springmvchibernate.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitUserToDB {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public InitUserToDB(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void initUserToDB() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        Set<Role> roleAdminList = new HashSet<>();
        Set<Role> roleUserList = new HashSet<>();

        roleAdminList.add(roleAdmin);
        roleUserList.add(roleUser);

        User user1 = new User("admin", "admin", "admin@gmail.com", "admin", 23, roleAdminList);
        User user2 = new User("user", "user", "user@gmail.com", "user", 35, roleUserList);

        userService.saveUser(user1);
        userService.saveUser(user2);
    }
}
