package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;


public class Controller {

    private UsersView usersView;
    private EditUserView editUserView;
    private Model model;


    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setUsersView(UsersView view) {
        this.usersView = view;
    }

    public void onShowAllUsers() {
        this.model.loadUsers();
        this.usersView.refresh(this.model.getModelData());
    }

    public void onShowAllDeletedUsers() {
        this.model.loadDeletedUsers();
        this.usersView.refresh(this.model.getModelData());
    }

    public void onOpenUserEditForm(long userId) {
        this.model.loadUserById(userId);
        this.editUserView.refresh(this.model.getModelData());
    }

    public void onUserDelete(long userId) {
        this.model.deleteUserById(userId);
        this.usersView.refresh(this.model.getModelData());
    }

    public void onUserChange(String name, long id, int level) {
        this.model.changeUserData(name, id, level);
        this.usersView.refresh(this.model.getModelData());
    }
}
