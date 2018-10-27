package Main;

import Main.clazz.Client;
import Main.clazz.Message;
import Main.enumator.TypeMessageEnum;
import Main.interfaces.ChatController;
import Main.interfaces.ChatInterface;
import Main.interfaces.ClientInterface;
import java.awt.HeadlessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.JOptionPane;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteChat extends javax.swing.JFrame implements ClientInterface, ChatController {

    private static final Logger LOG = Logger.getLogger(ClienteChat.class.getName());

    private ChatInterface chat;
    private ClientInterface client;
    private static final int MAX_USERS = 10;
    public String selectedUser = null;
    ChatPrivado chatPrivado = new ChatPrivado();

    @Override
    public void updateMessages(Message msg) throws RemoteException {
        LOG.log(Level.INFO, "updateMessages{0}", msg);

        if (msg.getTypeMessageEnum() == TypeMessageEnum.PRIVATE) {

            if (client.getNome().equals(msg.getSender()) || client.getNome().equals(msg.getReceiver())) {

                txtAreaMensagens.append(msg.getTextMessage() + "\n");
                chatPrivado.updateMessage(msg.getTextMessage());

            }
        } else {
            txtAreaMensagens.append(msg.getTextMessage() + "\n");
        }
    }

    @Override
    public void updateClients(List<String> clients) throws RemoteException {
        LOG.log(Level.INFO, "updateClients{0}", clients);

        selectedUser = (String) listUsuarios.getSelectedValue();
        this.listUsuarios.setListData(clients.toArray());
        this.listUsuarios.setSelectedValue(selectedUser, true);
    }

    /* Cria nova forma TelaPrincipal */
    public ClienteChat() {
        initComponents();
    }

    /**
     * Este método é chamado de dentro do construtor para inicializar o
     * formulário. AVISO: NÃO modifique este código. O conteúdo deste método é
     * sempre Regenerado pelo Editor de Formulários.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaMensagens = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        listUsuarios = new javax.swing.JList();
        lblMensagem = new javax.swing.JLabel();
        txtMensagem = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblServidor = new javax.swing.JLabel();
        txtServidor = new javax.swing.JTextField();
        lblPorta = new javax.swing.JLabel();
        txtPorta = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnConectar = new javax.swing.JButton();
        btnDesconectar = new javax.swing.JButton();
        btnDesconectar1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtAreaMensagens.setColumns(20);
        txtAreaMensagens.setRows(5);
        txtAreaMensagens.setBorder(javax.swing.BorderFactory.createTitledBorder("Mensagens"));
        jScrollPane1.setViewportView(txtAreaMensagens);

        listUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuários Online"));
        listUsuarios.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "aguardando login" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listUsuarios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listUsuariosValueChanged(evt);
            }
        });
        listUsuarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                listUsuariosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                listUsuariosFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(listUsuarios);

        lblMensagem.setText("Mensagem:");

        txtMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMensagemActionPerformed(evt);
            }
        });

        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/imagens/sair.png"))); // NOI18N
        btnEnviar.setText("enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblServidor.setText("SERVER IP:");

        txtServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServidorActionPerformed(evt);
            }
        });

        lblPorta.setText("PORTA:");

        lblNome.setText("NOME:");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        btnConectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/imagens/confirmar.png"))); // NOI18N
        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logarHandler(evt);
            }
        });

        btnDesconectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/imagens/fechar.png"))); // NOI18N
        btnDesconectar.setText("Desconectar");
        btnDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesconectarActionPerformed(evt);
            }
        });

        btnDesconectar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/imagens/filtrar.png"))); // NOI18N
        btnDesconectar1.setLabel("Privado");
        btnDesconectar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesconectar1ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/imagens/70x70.png"))); // NOI18N

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("THALES TERRA, RA: 14320665 / ANTÔNIO LEANDRINI, RA: 008922 - 6º Período");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblServidor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblPorta)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblNome)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnConectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDesconectar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDesconectar1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblServidor)
                            .addComponent(txtServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPorta)
                            .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConectar)
                            .addComponent(btnDesconectar)
                            .addComponent(btnDesconectar1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMensagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMensagem)
                    .addComponent(txtMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logarHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logarHandler
        String nameClient = txtNome.getText();
        String server = txtServidor.getText().isEmpty() ? "localhost" : txtServidor.getText();
        int port = txtPorta.getText().isEmpty() ? 1099 : Integer.parseInt(txtPorta.getText());

        try {

            String url = "rmi//" + server + ":" + port + "/" + "clazz.Chat";
            LOG.log(Level.INFO, "url {0}", url);

            this.chat = (ChatInterface) LocateRegistry.getRegistry(server, port).lookup("Chat");
            if (chat == null) {
                LOG.log(Level.WARNING, "chat null");
                return;
            }
            LOG.log(Level.INFO, "chat {0}", chat);

            for (ClientInterface cli : chat.getClients()) {
                if (cli.getNome().equals(nameClient)) {
                    LOG.info("Esse cliente existe, selecione outro nome");
                    JOptionPane.showMessageDialog(null, "Esse cliente existe, selecione outro nome");
                    return;
                }
            }
            if (!(this.chat.getClients().size() >= MAX_USERS)) {
                createNewClient(nameClient);

            } else {
                LOG.log(Level.INFO, "Number max of users{0}", MAX_USERS);
                JOptionPane.showMessageDialog(null, "Number max of users" + MAX_USERS);
            }

        } catch (RemoteException | NotBoundException | HeadlessException e) {
            LOG.log(Level.WARNING, "ERROR LogHandler {0}", e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_logarHandler
    private void createNewClient(String nameClient) {
        try {
            client = new Client(nameClient);
            client.setChatGUI(this);

            this.chat.registrarObserver(client);
            this.chat.registerClient(client.getNome());

            LOG.log(Level.INFO, "List of names users {0}", chat.getListNamesClients());

            btnConectar.setEnabled(false);
            txtNome.setEnabled(false);
            txtServidor.setEnabled(false);
            txtPorta.setEnabled(false);

        } catch (Exception re) {
            LOG.log(Level.WARNING, "{0}ERROR register client", re.getMessage());
        }
    }

    private void desconectar() {
        try {
            if (this.chat != null) {
                this.chat.removeClient(client.getNome());
            }
            this.chat.removerObserver(client);
        } catch (RemoteException e) {
        }
        System.exit(0);
    }
    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO adicione seu código de manipulação aqui:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        int usuarioIndex = listUsuarios.getSelectedIndex();
        try {
            if (this.listUsuarios.isSelectionEmpty()) {
                this.chat.sendMessage(client.getNome(), null, txtMensagem.getText(), TypeMessageEnum.PUBLIC);
            } else {
                String destinatario = (String) this.listUsuarios.getSelectedValue();
                this.chat.sendMessage(client.getNome(), destinatario, txtMensagem.getText(), TypeMessageEnum.PRIVATE);
                listUsuarios.setSelectedIndex(usuarioIndex);

            }

        } catch (RemoteException ex) {
            System.out.println("MSG ERRO: " + ex.getMessage());
            //JOptionPane.showMessageDialog(null, "Mensagem nao enviada");
        }
        // Limpa o campo de mensagem
        txtMensagem.setText("");
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void listUsuariosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listUsuariosFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_listUsuariosFocusGained

    private void listUsuariosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listUsuariosFocusLost
        // TODO add your handling code here:
        // Retira todas as seleções da lista de usuários
        //this.listUsuarios.clearSelection();
    }//GEN-LAST:event_listUsuariosFocusLost

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        this.listUsuarios.clearSelection();
    }//GEN-LAST:event_formMouseClicked

    private void btnDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectarActionPerformed
        this.desconectar();
    }//GEN-LAST:event_btnDesconectarActionPerformed

    private void listUsuariosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listUsuariosValueChanged
        // TODO add your handling code here:
        //System.out.println(this.listUsuarios.getSelectedIndex());
    }//GEN-LAST:event_listUsuariosValueChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.desconectar();
    }//GEN-LAST:event_formWindowClosing

    private void txtMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMensagemActionPerformed
        btnEnviarActionPerformed(evt);
    }//GEN-LAST:event_txtMensagemActionPerformed

    private void txtServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServidorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServidorActionPerformed

    private void btnDesconectar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectar1ActionPerformed
        // TODO add your handling code here:
        chatPrivado = new ChatPrivado();
        try {
            chatPrivado.setCliente(this.client);
            chatPrivado.setChat(this.chat);
            chatPrivado.lblRemt.setText(getNome());
            chatPrivado.lblDest.setText((String) listUsuarios.getSelectedValue());
            chatPrivado.show();
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDesconectar1ActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteChat().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnDesconectar;
    private javax.swing.JButton btnDesconectar1;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPorta;
    private javax.swing.JLabel lblServidor;
    public javax.swing.JList listUsuarios;
    public javax.swing.JTextArea txtAreaMensagens;
    private javax.swing.JTextField txtMensagem;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPorta;
    private javax.swing.JTextField txtServidor;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getNome() throws RemoteException {
        return client.getNome();
    }

    @Override
    public void setNome(String nome) throws RemoteException {
        client.setNome(nome);
    }

    @Override
    public List<Message> getMessages() throws RemoteException {
        return chat.getMessages();
    }

    @Override
    public void update(ChatInterface chat) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setChatGUI(ChatController chat) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
