/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiantes;


import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author DELL
 */
public class Registro extends javax.swing.JFrame {
    
    
    ArrayList<Variables> arreglo = new ArrayList<Variables>();
    

    /**
     * Creates new form Registro
     */
    public Registro() {
        initComponents();
    }
    
    public void Limpiar()
    {
        txtcarnet.setText("");
        txtnombre.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
        txtcorreo.setText("");
        txtcorreo.setText("");
        txtcatedratico.setText("");
        
    }
     
     
     public void guardar(){
         
          if (txtcarnet.getText().length()==0 || txtnombre.getText().length()==0 || txtdireccion.getText().length()==0
                || txttelefono.getText().length()==0 || txtcorreo.getText().length()==0 || txtcatedratico.getText().length()==0
                )
        {
            JOptionPane.showMessageDialog(null, "HACE FALTA RELLENAR ALGUN CAMPO");
        }
          else{
      
         Variables al = new Variables();
         
         al.setCarnet(txtcarnet.getText());
         al.setNombre(txtnombre.getText());
         al.setDireccion(txtdireccion.getText());
         al.setTelefono(txttelefono.getText());
         al.setCorreo(txtcorreo.getText());
         al.setCarrera(comcarrera.getSelectedItem().toString());
         al.setSede(comsede.getSelectedItem().toString());
         al.setCurso(comcurso.getSelectedItem().toString());
         al.setCatedratico(txtcatedratico.getText());
       
         arreglo.add(al);
         JOptionPane.showMessageDialog(null, "Datos guardados con éxito, Registros: " + arreglo.size());
         Limpiar();
          }
         
     }
      public void Mostrar()
         {
             
             String matriz[][] = new String[arreglo.size()][9];
                     
                  for (int i=0; i < arreglo.size(); i++){
                      
                      matriz[i][0] = arreglo.get(i).getCarnet();
                      matriz[i][1] = arreglo.get(i).getNombre();
                      matriz[i][2] = arreglo.get(i).getDireccion();
                      matriz[i][3] = arreglo.get(i).getTelefono();
                      matriz[i][4] = arreglo.get(i).getCorreo();
                      matriz[i][5] = arreglo.get(i).getCarrera();
                      matriz[i][6] = arreglo.get(i).getSede();
                      matriz[i][7] = arreglo.get(i).getCurso();
                      matriz[i][8] = arreglo.get(i).getCatedratico();
                  }
                  
        tablaestudiantes.setModel(new javax.swing.table.DefaultTableModel(
              matriz,
                
                new String[] 
                {
        "CARNET","NOMBRE","DIRECCION","TELEFONO","CORREO","CARRERA","SEDE","CATEDRATICO","CURSO"
                    
                    
                }
                                     
             ));
           
         }
      
     
        
      public void eliminar(){
          
          int delete = tablaestudiantes.getSelectedRow();
    
        if (delete >=0)
        {
         
         int finish = arreglo.size(); 
        
        //
        int decision = JOptionPane.showConfirmDialog(null,
            "¿DESEAS ELIMINAR UNA FILA" + (delete+1) + "?",
            "PREGUNTA DE SEGURIDAD",
            JOptionPane.YES_NO_OPTION);

        if(decision == JOptionPane.YES_OPTION){
           arreglo.remove(delete);
           JOptionPane.showMessageDialog(null, "FILA "+ (delete+1) + " ELIMINADA CORRECTAMENTE");
            
        }
        else {
            System.out.println("NO SE A ELIMINADO NINGUN DATOS DE LA TABLA");
        }
        
        
        }
        else
        {
          JOptionPane.showMessageDialog(null, "NO HAY NINGUNA FILA SELECCIONADA");   
        }
        
        Mostrar(); 
      }
      
      
      public void modificar(){
          
          int posicion = tablaestudiantes.getSelectedRow();
        
        if (posicion>=0)
        {
          if (txtcorreo.getText().length()==0 || txtnombre.getText().length()==0 || txtcatedratico.getText().length()==0
                || txttelefono.getText().length()==0 || txtdireccion.getText().length()==0)
          {
            JOptionPane.showMessageDialog(null, "HACE FALTA INFORMACION PARA MODIFICAR");
          }
          else
          {
           
            //
            int decision = JOptionPane.showConfirmDialog(null,
            "¿ESTAS DE A CUERDA QUE DESEAS MODIFICAR LA FILA "+(posicion+1) + "?",
            "PREGUNTA DE SEGURIDAD MODIFICAR",
            JOptionPane.YES_NO_OPTION);

        if(decision == JOptionPane.YES_OPTION){
        arreglo.get(posicion).setCarnet(txtcarnet.getText());
        arreglo.get(posicion).setNombre(txtnombre.getText());
        arreglo.get(posicion).setDireccion(txtdireccion.getText());
        arreglo.get(posicion).setTelefono(txttelefono.getText());
        arreglo.get(posicion).setCorreo(txtcorreo.getText());
        arreglo.get(posicion).setCarrera(comcarrera.getSelectedItem().toString());
        arreglo.get(posicion).setSede(comsede.getSelectedItem().toString());
        arreglo.get(posicion).setCatedratico(txtcatedratico.getText());
        arreglo.get(posicion).setCurso(comcurso.getSelectedItem().toString());
        
        Mostrar();
        Limpiar();
             
        }
        
             
        else {
            JOptionPane.showMessageDialog(null, "SE HA CONSERVADO EL DATO");
        }
     
   
        }
        }
        else
        { 
          JOptionPane.showMessageDialog(null, "NO HAY NINGUNA FILA PARA MODIFICAR");  
        }
        
        
          
      }
      
      public void buscar(){
          
         //
        // String valor = txtbuscar.getText();
          
         /* for(int i=0; i<tablaestudiantes.getRowCount(); i++){
              if(tablaestudiantes.getValueAt(i, 0).equals(valor)){
                  
                 tablaestudiantes.changeSelection(i,0,false,false);
                
              }
          
          
          }*/
         
         String matriz[][] = new String[arreglo.size()][9];
                     
                  for (int i=0; i < arreglo.size(); i++){
                      if(arreglo.get(i).getCarnet().equals(txtbuscar.getText())){
                      matriz[i][0] = arreglo.get(i).getCarnet();
                      matriz[i][1] = arreglo.get(i).getNombre();
                      matriz[i][2] = arreglo.get(i).getDireccion();
                      matriz[i][3] = arreglo.get(i).getTelefono();
                      matriz[i][4] = arreglo.get(i).getCorreo();
                      matriz[i][5] = arreglo.get(i).getCarrera();
                      matriz[i][6] = arreglo.get(i).getSede();
                      matriz[i][7] = arreglo.get(i).getCurso();
                      matriz[i][8] = arreglo.get(i).getCatedratico();
                      }
                      
                  }
                      
                  
        tablaestudiantes.setModel(new javax.swing.table.DefaultTableModel(
              matriz,
                
                new String[] 
                {
        "CARNET","NOMBRE","DIRECCION","TELEFONO","CORREO","CARRERA","SEDE","CATEDRATICO","CURSO"
                    
                    
                }
                                     
             ));
          
          
      }
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcatedratico = new javax.swing.JTextField();
        comcarrera = new javax.swing.JComboBox<>();
        comsede = new javax.swing.JComboBox<>();
        comcurso = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtcarnet = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        btguardar = new javax.swing.JButton();
        btmodificar = new javax.swing.JButton();
        bteliminar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaestudiantes = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("REGISTROS");

        jLabel1.setText("CARRERA");

        jLabel4.setText("CATEDRATICO");

        jLabel2.setText("SEDE");

        jLabel5.setText("CURSO");

        comcarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PSICOLOGIA", "DERECHO", "INGENIERIA" }));

        comsede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GUASTATOYA", "ZACAPA", "CHIQUIMULA" }));

        comcurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESTADISTICA", "PROGRA II", "CALCULO II" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcatedratico)
                    .addComponent(comcarrera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comsede, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comcurso, 0, 205, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comcarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comsede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcatedratico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comcurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel6.setText("CARNET");

        jLabel7.setText("NOMBRE");

        jLabel8.setText("DIRECCION");

        jLabel9.setText("TELEFONO");

        jLabel10.setText("CORREO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcarnet, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(txtdireccion)
                    .addComponent(txttelefono)
                    .addComponent(txtcorreo)
                    .addComponent(txtnombre))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btguardar.setText("GUARDAR");
        btguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btguardarActionPerformed(evt);
            }
        });

        btmodificar.setText("MODIFICAR");
        btmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmodificarActionPerformed(evt);
            }
        });

        bteliminar.setText("ELIMINAR");
        bteliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteliminarActionPerformed(evt);
            }
        });

        tablaestudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CARNET", "NOMBRE", "DIRECCION", "TELEFONO", "CORREO", "CARRERA", "SEDE", "CATEDRATICO", "CURSO"
            }
        ));
        jScrollPane3.setViewportView(tablaestudiantes);

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ACTUALIZAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btguardar)
                        .addGap(46, 46, 46)
                        .addComponent(btmodificar)
                        .addGap(41, 41, 41)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(bteliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(313, 313, 313))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btguardar)
                    .addComponent(btmodificar)
                    .addComponent(bteliminar)
                    .addComponent(jButton2))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btguardarActionPerformed
        // TODO add your handling code here:g
        guardar();
        Mostrar();
    }//GEN-LAST:event_btguardarActionPerformed

    private void bteliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteliminarActionPerformed
        // TODO add your handling code here:]
        eliminar();
        Mostrar();
    }//GEN-LAST:event_bteliminarActionPerformed

    private void btmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodificarActionPerformed
        // TODO add your handling code here:
        modificar();
    }//GEN-LAST:event_btmodificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        buscar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Mostrar();
    }//GEN-LAST:event_jButton2ActionPerformed

    
    private void tablaestudiantesMouseClicked(java.awt.event.MouseEvent evt) {                                            
        
        if (evt.isShiftDown())
        {
            int editar = tablaestudiantes.getSelectedRow();
           
            if (editar>=0)
            {
               txtcarnet.setText(arreglo.get(editar).getCarnet());
               txtnombre.setText(arreglo.get(editar).getNombre());
               txtdireccion.setText(arreglo.get(editar).getDireccion());
               txttelefono.setText(arreglo.get(editar).getTelefono());
               txtcorreo.setText(arreglo.get(editar).getCorreo());
               comcarrera.getSelectedItem().toString();
               comsede.getSelectedItem().toString();
               txtcatedratico.setText(arreglo.get(editar).getCorreo());
               txttelefono.setText(arreglo.get(editar).getCorreo());
                
            }
            
 
          
        }
        
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bteliminar;
    private javax.swing.JButton btguardar;
    private javax.swing.JButton btmodificar;
    private javax.swing.JComboBox<String> comcarrera;
    private javax.swing.JComboBox<String> comcurso;
    private javax.swing.JComboBox<String> comsede;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablaestudiantes;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcarnet;
    private javax.swing.JTextField txtcatedratico;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables

   

 
}
