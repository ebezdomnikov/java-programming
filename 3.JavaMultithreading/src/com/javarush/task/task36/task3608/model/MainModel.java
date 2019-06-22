package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {
    private UserService userService;
    private ModelData modelData;

    public MainModel() {
        this.userService = new UserServiceImpl();
        this.modelData = new ModelData();
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        this.modelData.setDisplayDeletedUserList(false);
        this.modelData.setUsers(this.getAllUsers());
    }

    @Override
    public void loadDeletedUsers() {
        this.modelData.setDisplayDeletedUserList(true);
        this.modelData.setUsers(userService.getAllDeletedUsers());
    }

    @Override
    public void loadUserById(long userId) {
        this.modelData.setDisplayDeletedUserList(false);
        User user = this.userService.getUsersById(userId);
        this.modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long userId) {
        this.userService.deleteUser(userId);
        this.modelData.setUsers(this.getAllUsers());
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        this.userService.createOrUpdateUser(name, id, level);
        this.modelData.setUsers(this.getAllUsers());
    }


    private List<User> getAllUsers() {
        return this.userService.filterOnlyActiveUsers(this.userService.getUsersBetweenLevels(1, 100));
    }
}
