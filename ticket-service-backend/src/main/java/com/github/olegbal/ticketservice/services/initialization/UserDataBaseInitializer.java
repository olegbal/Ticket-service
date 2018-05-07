package com.github.olegbal.ticketservice.services.initialization;

import com.github.olegbal.ticketservice.entities.Role;
import com.github.olegbal.ticketservice.entities.User;
import com.github.olegbal.ticketservice.enums.Roles;
import com.github.olegbal.ticketservice.services.user.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Order(4)
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDataBaseInitializer implements DataBaseInitializer {

    private final UserInfoService userInfoService;


    @PostConstruct
    @Override
    public void initializeData() {

        for (int i = 0; i < InitializationHelper.USERS_WITH_ROLE_ADMIN + 1; i++) {
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(new Role(Roles.ADMIN.roleId(), Roles.ADMIN.roleName()));
            User user = new User(-1L, "admin" + i, "admin" + i, "adminName" + i, "adminLastName" + i, "adminOrg" + i,
                    "adminNumber" + i, "admin" + i + "@gmail.com", null, roleSet);
            user.setRoles(roleSet);
            userInfoService.createUser(user);
        }

        for (int i = 0; i < InitializationHelper.USERS_WITH_ROLE_ORGANIZER + 1; i++) {
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(new Role(Roles.ORGANIZER.roleId(), Roles.ORGANIZER.roleName()));
            User user = new User(-1L, "organizer" + i, "organizer" + i, "organizerName" + i, "organizerLastName" + i,
                    "organizerOrg" + i, "organizerNumber" + i, "organizer" + i + "@gmail.com", null, roleSet);
            user.setRoles(roleSet);
            userInfoService.createUser(user);
        }

        for (int i = 0; i < InitializationHelper.USERS_WITH_ROLE_USER + 1; i++) {
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(new Role(Roles.USER.roleId(), Roles.USER.roleName()));
            User user = new User(-1L, "user" + i, "user" + i, "userName" + i, "userLastName" + i,
                    "userOrg" + i, "userNumber" + i, "user" + i + "@gmail.com", null, roleSet);
            user.setRoles(roleSet);
            userInfoService.createUser(user);
        }
    }
}