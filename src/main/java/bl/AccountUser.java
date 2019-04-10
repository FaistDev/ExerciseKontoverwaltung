/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import exceptions.NotEnoughMoneyException;
import gui.GUI;
import gui.ThreadStatePanel;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Ben
 */
public class AccountUser implements Runnable {

    private String name;
    private Account account;
    private GUI gui;
    private ThreadStatePanel panel;

    public AccountUser(String name, Account account, GUI gui, ThreadStatePanel panel) {
        this.name = name;
        this.account = account;
        this.gui = gui;
        this.panel = panel;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            panel.setRunning();
            int time = r.nextInt(1000 - 1 + 1) + 1;
            int amount = r.nextInt(50 - 10 + 1) + 10;
            int depOrWith = r.nextInt(3 - 1 + 1) + 1;

            try {
                Thread.sleep(time);
            } catch (InterruptedException ex) {
                Logger.getLogger(AccountUser.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (depOrWith == 1) {
                //Withdraw
                synchronized (account) {
                    account.appendToLog(name + ": Trying to withdraw money...\n");
                    gui.showBalance();
                    if (account.getAmount() >= amount) {
                        account.withdraw(amount);
                        account.appendToLog(name + ": Withdrawed " + amount + " €; Balance left: " + account.getAmount() + "\n");
                        gui.showBalance();
                    } else {
                        try {
                            account.appendToLog(name + ": Not enough money on account!\n");
                            gui.showBalance();
                            panel.setWaiting();
                            account.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(AccountUser.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            } else if (depOrWith == 2) {
                //Deposit
                synchronized (account) {
                    account.deposit(amount);
                    account.appendToLog(name + ": Deposit " + amount + " € to account!\n");
                    gui.showBalance();
                    account.notifyAll();
                }
            } else {
                try {
                    //Transfer
                    Account other = gui.getRandomAccount();
                    if(other == null){
                        panel.setWaiting();
                        continue;
                    }
                    account.appendToLog(name + ": Trying to transfer " + amount + " € to " + other.toString() + "!\n");
                    gui.showBalance();
                    
                    synchronized(account){
                        account.transfer(other, amount);
                    }
                    
                } catch (NotEnoughMoneyException ex) {
                    account.appendToLog(name + ": Not enough money on account!\n");
                    gui.showBalance();
                    panel.setWaiting();
                    try {
                        account.wait();
                    } catch (InterruptedException ex1) {
                        Logger.getLogger(AccountUser.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
            panel.setWaiting();
        }
        panel.setNotUsed();
    }

}
