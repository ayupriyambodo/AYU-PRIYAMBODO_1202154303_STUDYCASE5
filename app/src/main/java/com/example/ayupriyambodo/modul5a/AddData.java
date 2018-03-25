package com.example.ayupriyambodo.modul5a;

/**
 * Created by AYUPRIYAMBODO on 25/03/2018.
 */

public class AddData {
    String todo, desk, prior;

    public AddData(String todo, String desk, String prior){
        this.todo = todo;
        this.desk = desk;
        this.prior = prior;
    }

    public String getTodo(){
        return todo;
    }
    public void setTodo(String todo){
        this.todo = todo;
    }
    public String getDesk(){
        return desk;
    }
    public void setDesk(String desk){
        this.desk = desk;
    }
    public String getPrior(){
        return prior;
    }
    public void setPrior(String prior){
        this.prior = prior;
    }
}
