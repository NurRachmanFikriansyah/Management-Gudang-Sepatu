package models;

import entity.AdminEntity;

public class Admin {
    public AdminEntity listAdmin;

    public Admin(){
        this.listAdmin = new AdminEntity("FikriAselole","Pedot1234");
    }

    public boolean statusLogin(String username, String password){
        return listAdmin.getUsername().equals(username) && listAdmin.getPassword().equals(password);
    }
}
