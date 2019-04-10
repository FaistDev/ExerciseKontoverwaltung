/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import exceptions.NotEnoughMoneyException;
import gui.GUI;
import gui.ThreadStatePanel;
import gui.ThreadStates;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Ben
 */
public class Account {

    private static int accCount;
    private double amount;
    private int accNum;
    private DefaultListModel dlmUsers = new DefaultListModel();
    //private ThreadStates threadStates = new ThreadStates();
    private GUI gui;
    private String log="";

    public Account(double amount,GUI gui) {
        this.amount = amount;
        accNum=++accCount;
        this.gui=gui;
        //threadStates.setTitle(this.toString());
    }
    
    public void appendToLog(String txt){
        log+=txt;
    }

    public String getLog() {
        return log;
    }

    public void addUser(){
        String name = JOptionPane.showInputDialog("Name:");
        ThreadStatePanel panel = new ThreadStatePanel(name);
        //threadStates.addPanel(panel);
        dlmUsers.addElement(new AccountUser(name,this,gui,panel));
    }

    public DefaultListModel getDlmUsers() {
        return dlmUsers;
    }
    
    public double getAmount() {
        return amount;
    }

    public void withdraw(double amount) {
        this.amount -= amount;
    }

    public void deposit(double amount) {
        this.amount += amount;
    }

    public void transfer(Account acc, double am) throws NotEnoughMoneyException {
        if(amount>=am){
            this.withdraw(am);
            acc.deposit(am);
        }else{
            throw new NotEnoughMoneyException();
        }
    }
    
    public String toString(){
        return "Account "+accNum;
    }
}
