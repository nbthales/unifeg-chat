package Main;

import Main.clazz.Message;
import Main.enumator.TypeMessageEnum;
import Main.interfaces.ChatController;
import Main.interfaces.ChatInterface;
import Main.interfaces.ClientInterface;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ChatPrivado extends javax.swing.JFrame implements ClientInterface, ChatController {

    private static final Logger LOG = Logger.getLogger(ChatPrivado.class.getName());

    public ChatInterface chat;
    public ClientInterface cliente;

    public ChatInterface getChat() {
        return chat;
    }

    public void setChat(ChatInterface chat) {
        this.chat = chat;
    }

    public ClientInterface getCliente() {
        return cliente;
    }

    public void setCliente(ClientInterface cliente) {
        this.cliente = cliente;
    }

    /* Cria nova forma ChatPrivado */
    public ChatPrivado() {
        initComponents();
    }

    /**
     * Esse método é chamado de dentro do construtor para inicializar o
     * formulário. AVISO: NÃO modifique este código. O conteúdo deste método é
     * sempre gerado pelo Editor de formulários.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDest = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaMensagens = new javax.swing.JTextArea();
        txtMessage = new javax.swing.JTextField();
        lblMensagem = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        lblRemt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDest.setText("Destinatario");
        lblDest.setName("lbDest"); // NOI18N

        txtAreaMensagens.setColumns(20);
        txtAreaMensagens.setRows(5);
        jScrollPane1.setViewportView(txtAreaMensagens);

        txtMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMessageActionPerformed(evt);
            }
        });

        lblMensagem.setText("Mensagem:");

        btnEnviar.setText("enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        lblRemt.setText("Remetente");
        lblRemt.setName("lblRemit"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMensagem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblRemt)
                        .addGap(63, 63, 63)
                        .addComponent(lblDest)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRemt)
                    .addComponent(lblDest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMensagem)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lblDest.getAccessibleContext().setAccessibleName("lblDest");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMessageActionPerformed
        btnEnviarActionPerformed(evt);
    }//GEN-LAST:event_txtMessageActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        try {

            this.chat.sendMessage(lblRemt.getText(), lblDest.getText(), txtMessage.getText(), TypeMessageEnum.PRIVATE);

        } catch (RemoteException ex) {
            LOG.log(Level.INFO, "btnSendMessage{0}", ex.getMessage());
            JOptionPane.showMessageDialog(null, "class.Message don't send");
        }
        txtMessage.setText("");
    }//GEN-LAST:event_btnEnviarActionPerformed
    @Override
    public void updateMessages(Message msg) throws RemoteException {
        if (msg.getTypeMessageEnum() == TypeMessageEnum.PRIVATE) {
            if (lblRemt.getText().equals(msg.getSender()) || lblDest.getText().equals(msg.getSender())) {
                txtAreaMensagens.append(msg.getTextMessage() + "\n");
            }
        } else {
            txtAreaMensagens.append(msg.getTextMessage() + "\n");
        }

    }

    public void updateMessage(String message) {

        txtAreaMensagens.append(message + "\n");

    }

    /* @param args os argumentos da linha de comando */
    public static void main(String args[]) {
        /* Definir o Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatPrivado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatPrivado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatPrivado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatPrivado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatPrivado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblDest;
    private javax.swing.JLabel lblMensagem;
    public javax.swing.JLabel lblRemt;
    public javax.swing.JTextArea txtAreaMensagens;
    public javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getNome() throws RemoteException {
        return cliente.getNome();
    }

    @Override
    public void setNome(String nome) throws RemoteException {
        cliente.setNome(nome);
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
    public void updateClients(List<String> clientes) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setChatGUI(ChatController chat) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
