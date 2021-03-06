/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bl.Account;
import bl.AccountUser;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Ben
 */
public class GUI extends javax.swing.JFrame {

    private Account account;
    private DefaultListModel dlmAccounts = new DefaultListModel();

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        newAcc();
        userList.setModel(account.getDlmUsers());
        accountList.setModel(dlmAccounts);
    }

    public Account getRandomAccount() {
        Random r = new Random();
        if (dlmAccounts.size() > 1) {
            int randInt = r.nextInt(dlmAccounts.size() - 1 - 0 + 1) + 0;
            Account a = (Account) dlmAccounts.get(randInt);
            if (a == account) {
                getRandomAccount();
            } else {
                return a;
            }
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        miAddUser = new javax.swing.JMenuItem();
        miTest = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        miAddAccount = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        logOutput = new javax.swing.JTextArea();
        lbAccAmount = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        accountList = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();

        miAddUser.setText("Add User");
        miAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddUserActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miAddUser);

        miTest.setText("Test");
        miTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTestActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miTest);

        miAddAccount.setText("Add Account");
        miAddAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddAccountActionPerformed(evt);
            }
        });
        jPopupMenu2.add(miAddAccount);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        userList.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(userList);

        logOutput.setEditable(false);
        logOutput.setColumns(20);
        logOutput.setRows(5);
        jScrollPane2.setViewportView(logOutput);

        lbAccAmount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbAccAmount.setText("jLabel1");

        jLabel1.setText("Users");

        jLabel2.setText("Accounts");

        accountList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        accountList.setComponentPopupMenu(jPopupMenu2);
        accountList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(accountList);

        jLabel3.setText("Log");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbAccAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(159, 159, 159)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(lbAccAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newAcc() {
        account = new Account(50.0, this);
        dlmAccounts.addElement(account);
        showBalance();
    }

    private void miAddAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddAccountActionPerformed
        // TODO add your handling code here:
        newAcc();
    }//GEN-LAST:event_miAddAccountActionPerformed

    private void miAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddUserActionPerformed
        // TODO add your handling code here:
        account.addUser();
    }//GEN-LAST:event_miAddUserActionPerformed

    private void miTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTestActionPerformed
        // TODO add your handling code here:
        Thread t;
        for (int selectedIndice : userList.getSelectedIndices()) {
            t = new Thread((Runnable) account.getDlmUsers().get(selectedIndice));
            t.start();
        }

    }//GEN-LAST:event_miTestActionPerformed

    private void accountListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountListMouseClicked
        // TODO add your handling code here:
        if (accountList.getSelectedIndex() != -1) {
            account = (Account) dlmAccounts.get(accountList.getSelectedIndex());
            userList.setModel(account.getDlmUsers());
            showBalance();
        }
    }//GEN-LAST:event_accountListMouseClicked

    public void putLine(String line) {
        logOutput.append(line);
    }

    public void showBalance() {
        lbAccAmount.setText("" + account.getAmount() + " €");
        logOutput.setText(account.getLog());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> accountList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbAccAmount;
    private javax.swing.JTextArea logOutput;
    private javax.swing.JMenuItem miAddAccount;
    private javax.swing.JMenuItem miAddUser;
    private javax.swing.JMenuItem miTest;
    private javax.swing.JList<String> userList;
    // End of variables declaration//GEN-END:variables
}
