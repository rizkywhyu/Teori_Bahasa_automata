/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barutba;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Hanif
 */
public class viewOutput extends javax.swing.JFrame {
    int nextState;
    int valid = 1;
    Stack stack = new Stack();
    
    public int PDAnextState(int currState,int token ){
        switch(currState){
            case 1:
                if(token == 9){
                    stack.push("(");
                    nextState = 1;
                }
                else if(token == 6){
                    stack.push("i");
                    nextState = 2;
                }
                else if(token == 2){
                    nextState = 2;
                }
                else if(token == 1){
                    nextState = 3;
                }
                else {
                    valid = 0;
                }
                break;
            case 2:
                if(token == 9){
                    stack.push("(");
                    nextState=1;
                }
                else if(token == 1){
                    nextState=3; 
                }
                else{
                    valid = 0;
                }
                break;
            case 3:
                if(token == 10){
                    try {
                        stack.pop();
                        nextState = 3;
                    } catch (Exception e) {
                        valid = 0;
                    } 
                }
                else if(token == 7){
                    try {
                        stack.pop();
                        nextState=1;
                    } catch (Exception e) {
                        valid = 0;
                    }
                }
                else if(token == 3 || token == 4 || token == 5 || token == 8){
                    nextState = 4;
                }
                else{
                    valid = 0;
                }
                break;
            case 4:
                if(token == 1){
                    nextState = 3;
                }
                else if(token == 9){
                    stack.push("(");
                    nextState = 1;
                }
                else{
                    valid = 0;
                }
                break;
        }
        return nextState;
    }
    
    public int cekValid(int currState){
        if(stack.isEmpty() && currState == 3){
            if(valid != 0){
                return valid = 1;
            }
            else{
                return valid = 0;
            }
        }
        else {
                return valid = 0;
             }
    }
    
    /**
     * Creates new form viewOutput
     */
    public viewOutput(String kalimat) {
        initComponents();
        ArrayList<Kata> KataList = new ArrayList<>();
        String kata = "";
        nextState = 1;
        int z = 0;
        for (int i = 0; i < kalimat.length(); i++) {
            switch(z){
                case 0:
                    if (kalimat.charAt(i) == ' ' ){
                        z = 0;
                    }
                    else if ((kalimat.charAt(i) == 'p' || kalimat.charAt(i) == 'P') && (i == kalimat.length() - 1 || kalimat.charAt(i+1)==' ') ) {
                        kata += kalimat.charAt(i);
                        KataList.add(new Kata(kata,"Operand",1));
                        nextState = PDAnextState(nextState, 1);
                        z=99;
                    }
                    else if ((kalimat.charAt(i) == 'q' || kalimat.charAt(i) == 'Q') && (i == kalimat.length() - 1 || kalimat.charAt(i+1)==' ') ) {
                        kata += kalimat.charAt(i);
                        KataList.add(new Kata(kata,"Operand",1));
                        nextState = PDAnextState(nextState, 1);
                        z=99;
                    }
                    else if ((kalimat.charAt(i) == 'r' || kalimat.charAt(i) == 'R') && (i == kalimat.length() - 1 || kalimat.charAt(i+1)==' ')) {
                        kata += kalimat.charAt(i);
                        KataList.add(new Kata(kata,"Operand",1));
                        nextState = PDAnextState(nextState, 1);
                        z=99;
                    }
                    else if ((kalimat.charAt(i) == 's' || kalimat.charAt(i) == 'S') && (i == kalimat.length() - 1 || kalimat.charAt(i+1)==' ')) {
                        kata += kalimat.charAt(i);
                        KataList.add(new Kata(kata,"Operand",1));
                        nextState = PDAnextState(nextState, 1);
                        z=99;
                    }
                    else if (kalimat.charAt(i) == 'n' || kalimat.charAt(i) == 'N') {
                        kata += kalimat.charAt(i);
                        z=1;
                    }
                    else if (kalimat.charAt(i) == 'a' || kalimat.charAt(i) == 'A') {
                        kata += kalimat.charAt(i);
                        z=2;
                    }
                    else if (kalimat.charAt(i) == 'o' || kalimat.charAt(i) == 'O') {
                        kata += kalimat.charAt(i);
                        z=3;
                    }
                    else if (kalimat.charAt(i) == 'x' || kalimat.charAt(i) == 'X') {
                        kata += kalimat.charAt(i);
                        z=4;
                    }
                    else if (kalimat.charAt(i) == 'i' || kalimat.charAt(i) == 'I') {
                        kata += kalimat.charAt(i);
                        z=5;
                    }
                    else if (kalimat.charAt(i) == 't' || kalimat.charAt(i) == 'T') {
                        kata += kalimat.charAt(i);
                        z=6;
                    }
                    else if (kalimat.charAt(i) == '(' && (i == kalimat.length() - 1 || kalimat.charAt(i+1)==' ')) {
                        kata += kalimat.charAt(i);
                        KataList.add(new Kata(kata,"Grouping",9));
                        nextState = PDAnextState(nextState, 9);
                        z=99;
                    }
                    else if (kalimat.charAt(i) == ')'  && (i == kalimat.length() - 1 || kalimat.charAt(i+1)==' ') ) {
                        kata += kalimat.charAt(i);
                        KataList.add(new Kata(kata,"Grouping",10));
                        nextState = PDAnextState(nextState, 10);
                        z=99;
                    }
                    else {
                        z=88;
                    }
                    break;
                case 1:
                    if (kalimat.charAt(i) == 'o' || kalimat.charAt(i) == 'O') {
                        kata += kalimat.charAt(i);
                        z=7;
                    }
                    else {
                        z=88;
                    }
                    break;
                case 2:
                    if (kalimat.charAt(i) == 'n' || kalimat.charAt(i) == 'N') {
                        kata += kalimat.charAt(i);
                        z=8;
                    }
                    else {
                        z=88;
                    }
                    break;
                case 3:
                    if ((kalimat.charAt(i) == 'r' || kalimat.charAt(i) == 'R') && (i == kalimat.length() - 1 || kalimat.charAt(i+1)==' ')) {
                        kata += kalimat.charAt(i);
                        KataList.add(new Kata(kata,"Operator",4));
                        nextState = PDAnextState(nextState, 4);
                        z=99;
                    }
                    else {
                        z=88;
                    }
                    break;
                case 4:
                    if (kalimat.charAt(i) == 'o' || kalimat.charAt(i) == 'O') {
                        kata += kalimat.charAt(i);
                        z=9;
                    }
                    else {
                        z=88;
                    }
                    break;
                case 5:
                    if ((kalimat.charAt(i) == 'f' || kalimat.charAt(i) == 'F') && (i == kalimat.length() - 1 || kalimat.charAt(i+1)==' ')) {
                        kata += kalimat.charAt(i);
                        KataList.add(new Kata(kata,"Operator",6));
                        nextState = PDAnextState(nextState, 6);
                        z=99;
                    }
                    else if ((kalimat.charAt(i) == 'f' || kalimat.charAt(i) == 'F') && (kalimat.charAt(i+1)== 'f' || kalimat.charAt(i+1)=='F')) {
                        kata += kalimat.charAt(i);
                        z=10;    
                    }
                    else {
                        z=88;
                    }
                    break;
                case 6:
                    if (kalimat.charAt(i) == 'h' || kalimat.charAt(i) == 'H') {
                        kata += kalimat.charAt(i);
                        z=11;
                    }
                    else {
                        z=88;
                    }
                    break;
                case 7:
                    if ((kalimat.charAt(i) == 't' || kalimat.charAt(i) == 'T') && (i == kalimat.length() - 1 || kalimat.charAt(i+1)==' ')) {
                        kata += kalimat.charAt(i);
                        KataList.add(new Kata(kata,"Operator",2));
                        nextState = PDAnextState(nextState, 2);
                        z=99;
                    }
                    else {
                        z=88;
                    }
                    break;
                case 8:
                    if ((kalimat.charAt(i) == 'd' || kalimat.charAt(i) == 'D') && (i == kalimat.length() - 1 || kalimat.charAt(i+1)==' ')) {
                        kata += kalimat.charAt(i);
                        KataList.add(new Kata(kata,"Operator",3));
                        nextState = PDAnextState(nextState, 3);
                        z=99;
                    }
                    else {
                        z=88;
                    }
                    break;
                case 9:
                    if ((kalimat.charAt(i) == 'r' || kalimat.charAt(i) == 'R') && (i == kalimat.length() - 1 || kalimat.charAt(i+1)==' ')) {
                        kata += kalimat.charAt(i);
                        KataList.add(new Kata(kata,"Operator",5));
                        nextState = PDAnextState(nextState, 5);
                        z=99;
                    }
                    else {
                        z=88;
                    }
                    break;
                case 10:
                    if ((kalimat.charAt(i) == 'f' || kalimat.charAt(i) == 'F') && (i == kalimat.length() - 1 || kalimat.charAt(i+1)==' '))  {
                        kata += kalimat.charAt(i);
                        KataList.add(new Kata(kata,"Operator",8));
                        nextState = PDAnextState(nextState, 8);
                        z=99;
                    }
                    else {
                        z=88;
                    }
                    break;
                case 11:
                    if (kalimat.charAt(i) == 'e' || kalimat.charAt(i) == 'E') {
                        kata += kalimat.charAt(i);
                        z=12;
                    }
                    else {
                        z=88;
                    }
                    break;
                case 12:
                    if ((kalimat.charAt(i) == 'n' || kalimat.charAt(i) == 'N') && (i == kalimat.length() - 1 || kalimat.charAt(i+1)==' ')) {
                        kata += kalimat.charAt(i);
                        KataList.add(new Kata(kata,"Operator",7));
                        nextState = PDAnextState(nextState, 7);
                        z=99;
                    }
                    else {
                        z=88;
                    }
                    break;
                case 99:
                    kata="";
                    z=0;
                    break;
                case 88:
                    i = kalimat.length() - 1;
                    break;                    
            }
        }
        String jml = String.valueOf(kalimat.length());
        jmlKarakter.setText(jml);
        
        for (int i = 0; i < KataList.size(); i++){
            tabel.setValueAt(KataList.get(i).getKata(), i, 0);
            tabel.setValueAt(KataList.get(i).getTipe(), i, 1);
            tabel.setValueAt(KataList.get(i).getToken(), i, 2);
        }
        valid = cekValid(nextState);
        if(valid == 1){
            String st = "VALID";
            status.setText(st);
        }
        else{
            String st = "TIDAK VALID";
            status.setText(st);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jmlKarakter = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kata", "Tipe", "Token"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setText("Banyak Karakter :");

        jmlKarakter.setText("<BanyakKarakter>");

        jLabel2.setText("Status                 :");

        status.setText("status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jmlKarakter)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(jLabel1)
                    .addComponent(jmlKarakter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(status))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        viewInput input = new viewInput();
        input.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(viewOutput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewOutput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewOutput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewOutput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new viewOutput().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jmlKarakter;
    private javax.swing.JLabel status;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
