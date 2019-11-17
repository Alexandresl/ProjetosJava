package aula8;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexandre Lima
 */
public class Principal extends javax.swing.JFrame {
    
    ArrayList<Departamento> ListaDep;
    ArrayList<Funcionario> ListaFunc;
    String modoDep;
    String modoFunc;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        ListaDep = new ArrayList();
        ListaFunc = new ArrayList();
        modoDep = "Navegar";
        modoFunc = "Navegar";
        ManipulaInterfaceDep();
        ManipulaInterfaceFunc();
    }
    
    public void ManipulaInterfaceDep() {
        switch (modoDep) {
            case "Navegar":
                input_dep_codigo.setText("");
                input_dep_nome.setText("");
                btn_dep_salvar.setEnabled(false);
                btn_dep_cancelar.setEnabled(false);
                input_dep_codigo.setEnabled(false);
                input_dep_nome.setEnabled(false);
                btn_dep_novo.setEnabled(true);
                btn_dep_editar.setEnabled(false);
                btn_dep_excluir.setEnabled(false);
                break;
            case "Novo":
                input_dep_codigo.setText("");
                input_dep_nome.setText("");
                btn_dep_salvar.setEnabled(true);
                btn_dep_cancelar.setEnabled(true);
                input_dep_codigo.setEnabled(true);
                input_dep_nome.setEnabled(true);
                btn_dep_novo.setEnabled(false);
                btn_dep_editar.setEnabled(false);
                btn_dep_excluir.setEnabled(false);
                break;
            case "Editar":
                btn_dep_salvar.setEnabled(true);
                btn_dep_cancelar.setEnabled(true);
                input_dep_codigo.setEnabled(true);
                input_dep_nome.setEnabled(true);
                btn_dep_novo.setEnabled(true);
                btn_dep_editar.setEnabled(false);
                btn_dep_excluir.setEnabled(false);
                break;
            case "Selecao":
                btn_dep_salvar.setEnabled(false);
                btn_dep_cancelar.setEnabled(false);
                input_dep_codigo.setEnabled(false);
                input_dep_nome.setEnabled(false);
                btn_dep_novo.setEnabled(true);
                btn_dep_editar.setEnabled(true);
                btn_dep_excluir.setEnabled(true);
                break;
                
            default:
                System.out.println("Modo Inválido");
        }
    }
    
    public void ManipulaInterfaceFunc() {
        switch (modoFunc) {
            case "Navegar":
                input_func_matricula.setText("");
                input_func_nome.setText("");
                btn_func_salvar.setEnabled(false);
                btn_func_cancelar.setEnabled(false);
                input_func_matricula.setEnabled(false);
                input_func_nome.setEnabled(false);
                btn_func_novo.setEnabled(true);
                btn_func_editar.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                cb_func_deps.setEnabled(false);
                break;
            case "Novo":
                input_func_matricula.setText("");
                input_func_nome.setText("");
                btn_func_salvar.setEnabled(true);
                btn_func_cancelar.setEnabled(true);
                input_func_matricula.setEnabled(true);
                input_func_nome.setEnabled(true);
                btn_func_novo.setEnabled(false);
                btn_func_editar.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                cb_func_deps.setEnabled(true);
                break;
            case "Editar":
                btn_func_salvar.setEnabled(true);
                btn_func_cancelar.setEnabled(true);
                input_func_matricula.setEnabled(true);
                input_func_nome.setEnabled(true);
                btn_func_novo.setEnabled(true);
                btn_func_editar.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                cb_func_deps.setEnabled(true);
                break;
            case "Selecao":
                btn_func_salvar.setEnabled(false);
                btn_func_cancelar.setEnabled(false);
                input_func_matricula.setEnabled(false);
                input_func_nome.setEnabled(false);
                btn_func_novo.setEnabled(true);
                btn_func_editar.setEnabled(true);
                btn_func_excluir.setEnabled(true);
                cb_func_deps.setEnabled(false);
                break;
                
            default:
                System.out.println("Modo Inválido");
        }
    }
    
    public void LoadTableDep() {
        Object Colunas[] = {"Código", "Nome"};
        DefaultTableModel modelo = new DefaultTableModel(Colunas, 0);
        
        for (int i = 0; i < ListaDep.size(); i++) {
            Object linha[] = new Object[]{
                ListaDep.get(i).getCodigo(), 
                ListaDep.get(i).getNome()
            };
            modelo.addRow(linha);
        }
        tbl_dep_deps.setModel(modelo);
        tbl_dep_deps.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_dep_deps.getColumnModel().getColumn(1).setPreferredWidth(200);
        LoadCBDep();
    }
    
        public void LoadTableFunc() {
        Object Colunas[] = {"Matrícula", "Nome", "Departamento"};
        DefaultTableModel modelo = new DefaultTableModel(Colunas, 0);
        
        for (int i = 0; i < ListaFunc.size(); i++) {
            Object linha[] = new Object[]{
                ListaFunc.get(i).getMatricula(), 
                ListaFunc.get(i).getNome(),
                ListaFunc.get(i).getDep().getNome()
            };
            modelo.addRow(linha);
        }
        tbl_func_funcs.setModel(modelo);
        tbl_func_funcs.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbl_func_funcs.getColumnModel().getColumn(1).setPreferredWidth(150);
        tbl_func_funcs.getColumnModel().getColumn(1).setPreferredWidth(150);
    }
    
    public void LoadCBDep() {
        cb_func_deps.removeAllItems();
        cb_func_deps.addItem("Selecione");
        for (int i = 0; i < ListaDep.size(); i++) {
            cb_func_deps.addItem(ListaDep.get(i).getNome());
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        btn_func_novo = new javax.swing.JButton();
        btn_func_editar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_func_funcs = new javax.swing.JTable();
        btn_func_excluir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        input_func_matricula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        input_func_nome = new javax.swing.JTextField();
        btn_func_salvar = new javax.swing.JButton();
        btn_func_cancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cb_func_deps = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dep_deps = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        input_dep_codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        input_dep_nome = new javax.swing.JTextField();
        btn_dep_salvar = new javax.swing.JButton();
        btn_dep_cancelar = new javax.swing.JButton();
        btn_dep_novo = new javax.swing.JButton();
        btn_dep_editar = new javax.swing.JButton();
        btn_dep_excluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_func_novo.setText("Novo");
        btn_func_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_novoActionPerformed(evt);
            }
        });

        btn_func_editar.setText("Editar");
        btn_func_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_editarActionPerformed(evt);
            }
        });

        tbl_func_funcs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matrícula", "Nome", "Departamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_func_funcs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_func_funcsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_func_funcs);
        if (tbl_func_funcs.getColumnModel().getColumnCount() > 0) {
            tbl_func_funcs.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbl_func_funcs.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbl_func_funcs.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        btn_func_excluir.setText("Excluir");
        btn_func_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_excluirActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Funcionário"));

        jLabel3.setText("Matrícula:");

        jLabel4.setText("Nome:");

        input_func_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_func_nomeActionPerformed(evt);
            }
        });

        btn_func_salvar.setText("Salvar");
        btn_func_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_salvarActionPerformed(evt);
            }
        });

        btn_func_cancelar.setText("Cancelar");
        btn_func_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_cancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Departamento:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_func_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_func_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btn_func_salvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_func_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_func_deps, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(input_func_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(input_func_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_func_deps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_func_salvar)
                    .addComponent(btn_func_cancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_func_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btn_func_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_func_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_func_novo)
                    .addComponent(btn_func_editar)
                    .addComponent(btn_func_excluir))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Funcionários", jPanel2);

        tbl_dep_deps.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_dep_deps.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dep_depsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_dep_deps);
        if (tbl_dep_deps.getColumnModel().getColumnCount() > 0) {
            tbl_dep_deps.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbl_dep_deps.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Departamento"));

        jLabel1.setText("Código:");

        jLabel2.setText("Nome:");

        btn_dep_salvar.setText("Salvar");
        btn_dep_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_salvarActionPerformed(evt);
            }
        });

        btn_dep_cancelar.setText("Cancelar");
        btn_dep_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input_dep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(input_dep_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_dep_salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_dep_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(input_dep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(input_dep_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dep_salvar)
                    .addComponent(btn_dep_cancelar))
                .addContainerGap())
        );

        btn_dep_novo.setText("Novo");
        btn_dep_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_novoActionPerformed(evt);
            }
        });

        btn_dep_editar.setText("Editar");
        btn_dep_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_editarActionPerformed(evt);
            }
        });

        btn_dep_excluir.setText("Excluir");
        btn_dep_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_dep_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btn_dep_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_dep_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dep_novo)
                    .addComponent(btn_dep_editar)
                    .addComponent(btn_dep_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Departamentos", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dep_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_editarActionPerformed
        modoDep = "Editar";
        ManipulaInterfaceDep();
        
    }//GEN-LAST:event_btn_dep_editarActionPerformed

    private void btn_dep_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_novoActionPerformed
        modoDep = "Novo";
        ManipulaInterfaceDep();
    }//GEN-LAST:event_btn_dep_novoActionPerformed

    private void btn_dep_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_excluirActionPerformed
        
        int index = tbl_dep_deps.getSelectedRow();
        if (index >= 0 && index < ListaDep.size()) {
            ListaDep.remove(index);
        }
        LoadTableDep();
        modoDep = "Navegar";
        ManipulaInterfaceDep();
    }//GEN-LAST:event_btn_dep_excluirActionPerformed

    private void btn_dep_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_salvarActionPerformed
        int cod = Integer.parseInt(input_dep_codigo.getText());
        if (modoDep.equals("Novo")) {            
            Departamento D = new Departamento(cod, input_dep_nome.getText());
            ListaDep.add(D);
        } else if (modoDep.equals("Editar")) {
            int index = tbl_dep_deps.getSelectedRow();
            ListaDep.get(index).setCodigo(cod);
            ListaDep.get(index).setNome(input_dep_nome.getText());
        }
        LoadTableDep();
        modoDep = "Navegar";
        ManipulaInterfaceDep();
    }//GEN-LAST:event_btn_dep_salvarActionPerformed

    private void btn_dep_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_cancelarActionPerformed
            modoDep = "Navegar";
            ManipulaInterfaceDep();
        
    }//GEN-LAST:event_btn_dep_cancelarActionPerformed

    private void tbl_dep_depsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dep_depsMouseClicked
        int index = tbl_dep_deps.getSelectedRow();
        if (index >= 0 && index < ListaDep.size()) {
            Departamento D = ListaDep.get(index);
            input_dep_codigo.setText(String.valueOf(D.getCodigo()));
            input_dep_nome.setText(D.getNome());
            modoDep = "Selecao";
            ManipulaInterfaceDep();
        }
    }//GEN-LAST:event_tbl_dep_depsMouseClicked

    private void btn_func_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_novoActionPerformed
        modoFunc = "Novo";
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_novoActionPerformed

    private void btn_func_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_editarActionPerformed
        modoFunc = "Editar";
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_editarActionPerformed

    private void tbl_func_funcsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_func_funcsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_func_funcsMouseClicked

    private void btn_func_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_excluirActionPerformed
        modoFunc = "Navegar";
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_excluirActionPerformed

    private void input_func_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_func_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_func_nomeActionPerformed

    private void btn_func_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_salvarActionPerformed
        int index = cb_func_deps.getSelectedIndex();
        if (index == 0) {
            JOptionPane.showMessageDialog(
                    this, 
                    "Você deve selecionar um departamento!", 
                    "Alerta",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            Funcionario F = new Funcionario();
            F.setMatricula(Integer.parseInt(input_func_matricula.getText()));
            F.setNome(input_func_nome.getText());
            F.setDep(ListaDep.get(index - 1));
            ListaFunc.add(F);
            ListaDep.get(index - 1).addFunc(F);
        }
        LoadTableFunc();
        modoFunc = "Navegar";
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_salvarActionPerformed

    private void btn_func_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_cancelarActionPerformed
        modoFunc = "Navegar";
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_cancelarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dep_cancelar;
    private javax.swing.JButton btn_dep_editar;
    private javax.swing.JButton btn_dep_excluir;
    private javax.swing.JButton btn_dep_novo;
    private javax.swing.JButton btn_dep_salvar;
    private javax.swing.JButton btn_func_cancelar;
    private javax.swing.JButton btn_func_editar;
    private javax.swing.JButton btn_func_excluir;
    private javax.swing.JButton btn_func_novo;
    private javax.swing.JButton btn_func_salvar;
    private javax.swing.JComboBox<String> cb_func_deps;
    private javax.swing.JTextField input_dep_codigo;
    private javax.swing.JTextField input_dep_nome;
    private javax.swing.JTextField input_func_matricula;
    private javax.swing.JTextField input_func_nome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_dep_deps;
    private javax.swing.JTable tbl_func_funcs;
    // End of variables declaration//GEN-END:variables
}
