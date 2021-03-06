package DBSAssign;

import java.util.*;
import java.lang.*;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rushi
 */
public class Ques2 extends javax.swing.JFrame {
    
    static int gd = 3;
    static int bfr = 3;
    static int[][] buckets = new int[100][200];
    static int[] ldarray = new int[100];
    static String[] biarray = new String[100];
    static int[] sizearray = new int[100];
    static String output = "";
    
    
    public static void add_key(int cur)
    {
    	int hash = cur%10;
    	String bi = Integer.toBinaryString(hash);
    	bi = String.format("%1$"+ 4+ "s", bi).replace(' ', '0');
        System.out.println(bi);
        for(int j=0; j<10; j++)
    	{
            try{
                            int ld = ldarray[j];
                            String keycomp, buckcomp;
                            if(ld != 0)
                            {
                                    keycomp = bi.substring(bi.length()-ld, bi.length());
                                    buckcomp = biarray[j].substring(biarray[j].length()-ld, biarray[j].length());
                                     System.out.println(keycomp);
                                     System.out.println(buckcomp);
                                            if(keycomp.equals(buckcomp))
                                            {
                                                    if(sizearray[j] < bfr)
                                                    {
                                                    buckets[j][sizearray[j]] = cur;
                                                    sizearray[j]++;
                                                     System.out.println("Added successfully "+cur+" at pos "+j+", "+sizearray[j]);
                                                     if(Arrays.stream(ldarray).max().getAsInt() > gd)
                                                     {
                                                         gd++;
                                                     }
                                                     output += ("Adding "+cur+"\n");
                                                            for(int i=0; i<10; i++)
                                                            {
                                                                System.out.println("checking bucket "+i+" size of this bucket = "+sizearray[i]);
                                                                if(sizearray[i] > 0)
                                                                {
                                                                    System.out.print("Bucket number "+i+" = ");
                                                                    output += ("Bucket number "+i+" = |");
                                                                    for(int k=0; k<sizearray[i]; k++)
                                                                    {
                                                                            System.out.print(buckets[i][k]+" ");
                                                                            output += (buckets[i][k]+" |");
                                                                    }
                                                                    System.out.println("");
                                                                    output += "\n";

                                                                }
                                                            }
                                                             output += "\n";
                                                            //outputArea.setText(output);
                                                    break;
                                                    }
                                                    else
                                                    {
                                                            reset(cur, j);
                                                            break;
                                                    }
                                            }
                            }
            }
            catch(Exception e)
            {
                output += "\n please choose a larger bfr and restart the hashing\n";
                break;
            }

    	}
    }
    
    public static void reset(int cur, int j)
    {
    	int[] temp = new int[10];
    	for(int i=0; i<bfr; i++)
    	{
    		temp[i] = buckets[j][i];
    		buckets[j][i] = -1;
    	}
    	sizearray[j] = 0;
    	temp[bfr] = cur;
    	System.out.println(temp[0]+" "+temp[1]+" "+temp[2]+" "+temp[3]);
    	ldarray[j]++;
    	int extra = (int) Math.pow(2, ldarray[j]-1);
    	ldarray[j+extra] = ldarray[j];
    	for(int i=0; i<=bfr; i++)
    	{
    		add_key(temp[i]);
    	}
    }
    
    public static int search_key(int key)
    {
    	int hash = key%10;
    	String bi = Integer.toBinaryString(hash);
    	bi = String.format("%1$"+ 4+ "s", bi).replace(' ', '0');

    	for(int i=0; i<10; i++)
    	{
    		if(sizearray[i] > 0)
    		{
    			int ld = ldarray[i];
    			String keycomp = bi.substring(bi.length()-ld, bi.length());
				String buckcomp = biarray[i].substring(biarray[i].length()-ld, biarray[i].length());
				if(keycomp.equals(buckcomp))
				{
					for(int j=0; j<sizearray[i]; j++)
					{
						if(buckets[i][j] == key)
						{
							System.out.println(key+" is in the system in bucket "+i);
							return i;
						}
					}
				}

    		}
    	}
    	return -1;
    }
    
    
    public Ques2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        keysInput = new javax.swing.JTextField();
        doneButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        findInput = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        mainmenu_button = new javax.swing.JButton();
        bfr_label = new javax.swing.JLabel();
        bfr_input = new javax.swing.JTextField();
        clear_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Extendible Hashing Simulator");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Enter the keys: ");

        doneButton.setText("Done");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Find key:");

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        outputArea.setColumns(20);
        outputArea.setRows(5);
        jScrollPane1.setViewportView(outputArea);

        mainmenu_button.setText("Main Menu");
        mainmenu_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainmenu_buttonActionPerformed(evt);
            }
        });

        bfr_label.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bfr_label.setText("BFR:");

        bfr_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bfr_inputActionPerformed(evt);
            }
        });

        clear_button.setText("Clear");
        clear_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(99, 99, 99))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keysInput, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(doneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bfr_label, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(findInput, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                    .addComponent(bfr_input))
                                .addGap(32, 32, 32)
                                .addComponent(searchButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(clear_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mainmenu_button, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))))
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(keysInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doneButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bfr_label)
                            .addComponent(bfr_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(findInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton))
                        .addGap(36, 36, 36)
                        .addComponent(mainmenu_button, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clear_button, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        Arrays.fill(ldarray, 0);
        Arrays.fill(sizearray, 0);
        ldarray[0] = 1;
        ldarray[1] = 1;
        output = "";
        String bfr_text = bfr_input.getText();
        if(bfr_text.equals("") == false)
        {
            bfr = Integer.parseInt(bfr_text);
        }
        outputArea.setText(output);
        
        for(int i=0; i<10; i++)
        {
            biarray[i] = String.format("%1$"+ 4+ "s", Integer.toBinaryString(i)).replace(' ', '0');
        }
        
        String keys_string = keysInput.getText();
        String keys_split[] = keys_string.split(",");
        int keys_to_add = (keys_split.length);
        
        int[] keys = new int[100];
        for(int i=0; i<keys_to_add; i++)
        {
            keys[i] = Integer.parseInt(keys_split[i]);
            System.out.println(keys[i]);
        }
        for(int i=0; i<keys_to_add; i++)
        {
            System.out.println("Entering add keys for "+keys[i]);
            add_key(keys[i]);
            outputArea.setText(output);
            System.out.println("Called set text");
        }
        /*
        for(int i=0; i<10; i++)
        {
            System.out.println("checking bucket "+i+" size of this bucket = "+sizearray[i]);
            if(sizearray[i] > 0)
            {
                System.out.print("Bucket number "+i+" = ");
                output += ("Bucket number "+i+" = |");
                for(int j=0; j<sizearray[i]; j++)
                {
                        System.out.print(buckets[i][j]+" ");
                        output += (buckets[i][j]+" |");
                }
                System.out.println("");
                output += "\n";

            }
        }
        outputArea.setText(output);
        */
    }//GEN-LAST:event_doneButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        int key = Integer.parseInt(findInput.getText());
        int result = search_key(key);
        if(result != -1)
        {
            output += "\n\n";
            output += (key+" found in bucket "+result);
        }
        else
        {
            output += "\n\n";
            output += (key+" not found");   
        }
        outputArea.setText(output);
    }//GEN-LAST:event_searchButtonActionPerformed

    private void mainmenu_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainmenu_buttonActionPerformed
        dispose();
        MainMenu mm = new MainMenu();
        mm.setVisible(true);
    }//GEN-LAST:event_mainmenu_buttonActionPerformed

    private void bfr_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bfr_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bfr_inputActionPerformed

    private void clear_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_buttonActionPerformed
        bfr = 3;
        buckets = new int[100][200];
        ldarray = new int[100];
        biarray = new String[100];
        sizearray = new int[100];
        output = "";
        outputArea.setText("");
        keysInput.setText("");
        bfr_input.setText("");
        findInput.setText("");
        
    }//GEN-LAST:event_clear_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(Ques2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ques2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ques2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ques2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ques2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bfr_input;
    private javax.swing.JLabel bfr_label;
    private javax.swing.JButton clear_button;
    private javax.swing.JButton doneButton;
    private javax.swing.JTextField findInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField keysInput;
    private javax.swing.JButton mainmenu_button;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
