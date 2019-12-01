/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.PedidoMB;
import controle.PessoaMB;
import controle.ProdutoMB;
import controle.ProdutosPedidosMB;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.Pedido;
import modelo.Pessoa;
import modelo.Produto;
import modelo.ProdutosPedidos;

/**
 *
 * @author luis
 */
public class CadastroPedidos extends javax.swing.JFrame {

    Pedido pedido = new Pedido();
    ArrayList<Produto> idProdutos = new ArrayList<>();
    ArrayList<Pessoa> idPessoas = new ArrayList<>();
    ProdutosPedidosMB produtosPedidosMB = new ProdutosPedidosMB();
    boolean cadastrado = false;
    double valorTotal = 0;

    public CadastroPedidos() {
        initComponents();
        preencherComboProdutos();
        preencherComboPessoas();
        botaoIncluir.setEnabled(true);
        botaoEditar.setEnabled(false);
        botaoExcluir.setEnabled(false);

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
        comboPessoas = new javax.swing.JComboBox();
        campoData = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboProduto = new javax.swing.JComboBox();
        botaoIncluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        botaoExcluir = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        campoValor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        campoQuantidade = new javax.swing.JTextField();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        campoValorTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Data:");

        jLabel2.setText("Pessoa:");

        comboPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPessoasActionPerformed(evt);
            }
        });

        jLabel3.setText("Item:");

        comboProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProdutoActionPerformed(evt);
            }
        });

        botaoIncluir.setText("Adicionar");
        botaoIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoIncluirActionPerformed(evt);
            }
        });

        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Produto", "Quantidade", "Valor Unitário", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaProdutos);

        botaoExcluir.setText("Remover");

        botaoEditar.setText("Editar");

        jLabel4.setText("Valor:");

        jLabel5.setText("Qtde:");

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Valor Total do Pedido:");

        jLabel7.setText("0");
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        campoValorTotal.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(campoData))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(botaoIncluir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(botaoEditar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(botaoExcluir)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(campoValor)
                                        .addComponent(campoQuantidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(botaoSalvar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(botaoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoValorTotal))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoIncluir)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoEditar))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(campoValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIncluirActionPerformed
        double calcValorTotal;
        calcValorTotal = Integer.parseInt(campoQuantidade.getText()) * Double.parseDouble(campoValor.getText());
        ProdutosPedidos produtoPedido = new ProdutosPedidos();
        ProdutosPedidosMB produtosPedidosMB = new ProdutosPedidosMB();
        produtoPedido.setProduto(idProdutos.get(comboProduto.getSelectedIndex()));
        produtoPedido.setQuantidade(Integer.parseInt(campoQuantidade.getText()));
        produtoPedido.setValorUnitario(Double.parseDouble(campoValor.getText()));
        produtoPedido.setValorTotalproduto(calcValorTotal);
        valorTotal +=calcValorTotal;
        campoValorTotal.setText(String.valueOf(valorTotal));
        try {
            cadastraPedido();
        } catch (ParseException ex) {
            Logger.getLogger(CadastroPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        produtoPedido.setPedido(pedido);
        produtosPedidosMB.inserir(produtoPedido);

        atualizarListaProdutos();
    }//GEN-LAST:event_botaoIncluirActionPerformed

    private void tabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosMouseClicked

        pedido.setId(Long.parseLong(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0).toString()));
        campoValor.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 2).toString());

        ProdutosPedidos produtoPedido = new ProdutosPedidos();

        produtoPedido.setId(Long.parseLong(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 2).toString()));

        ProdutosPedidosMB produtosPedidosMB = new ProdutosPedidosMB();

        produtoPedido = produtosPedidosMB.buscar(produtoPedido);
        int size = comboProduto.getItemCount();
        for (int i = 0; i < size; i++) {
            String item = comboProduto.getItemAt(i).toString();
            if (item.equals(produtoPedido.getProduto().getNome().toString())) {
                comboProduto.setSelectedIndex(i);
            }
        }

        botaoIncluir.setEnabled(false);
        botaoEditar.setEnabled(true);
        botaoExcluir.setEnabled(true);
    }//GEN-LAST:event_tabelaProdutosMouseClicked

    private void comboPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPessoasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPessoasActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        System.out.println("salvando");
        pedido.setValorTotal(valorTotal);
        PedidoMB pedidoMB = new PedidoMB();
        if(cadastrado)
        pedidoMB.editar(pedido);
        
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        if(cadastrado){
            PedidoMB pedidoMB = new PedidoMB();
            List<ProdutosPedidos> produtosPedido = new ArrayList();
            produtosPedido = produtosPedidosMB.buscarProdutosPedido(pedido);
            for (ProdutosPedidos prod : produtosPedido){
                produtosPedidosMB.excluir(prod);
            }
            pedidoMB.excluir(pedido);            
        }
            
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void comboProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProdutoActionPerformed
        Produto produto = new Produto();
        produto = idProdutos.get(comboProduto.getSelectedIndex());
        campoValor.setText(String.valueOf(produto.getValor()));
    }//GEN-LAST:event_comboProdutoActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPedidos().setVisible(true);
            }
        });
    }

    private void atualizarListaProdutos() {
        List<ProdutosPedidos> produtosPedidos = new ArrayList<>();

        produtosPedidos = produtosPedidosMB.buscarProdutosPedido(pedido);

        DefaultTableModel model = (DefaultTableModel) tabelaProdutos.getModel();
        model.setRowCount(0);

        for (ProdutosPedidos produtosPedido : produtosPedidos) {
            Object[] row = {produtosPedido.getId(),
                produtosPedido.getProduto().getNome(),
                produtosPedido.getQuantidade(),
                produtosPedido.getValorUnitario(),
                produtosPedido.getValorTotalproduto()};
            model.addRow(row);
        }
    }

    private void preencherComboProdutos() {
        ProdutoMB produtoMB = new ProdutoMB();;
        List<Produto> produtos = new ArrayList<Produto>();
        produtos = produtoMB.buscarTodos();

        for (Produto produto : produtos) {
            idProdutos.add(produto);
            comboProduto.addItem(produto.getNome());
        }
    }

    private void preencherComboPessoas() {
        System.out.println("Preenchendo combo?");
        PessoaMB pessoaMB = new PessoaMB();;
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas = pessoaMB.buscarTodos();

        for (Pessoa pessoa : pessoas) {
            idPessoas.add(pessoa);
            comboPessoas.addItem(pessoa.getNome());
        }
    }

    private void cadastraPedido() throws ParseException {
        if (!cadastrado) {
            PedidoMB pedidoMB = new PedidoMB();

            pedido.setPessoa(idPessoas.get(comboPessoas.getSelectedIndex()));
            pedido.setData(formataData());
        //valor zerado pois o pedido está sendo cadastrado apenas
            //para relacionamento com itens pedidos
            pedido.setValorTotal(0);
            pedidoMB.inserir(pedido);
            cadastrado = true;
        }
    }

    public Date formataData() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse(campoData.getText());
        return data;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoIncluir;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoData;
    private javax.swing.JTextField campoQuantidade;
    private javax.swing.JTextField campoValor;
    private javax.swing.JTextField campoValorTotal;
    private javax.swing.JComboBox comboPessoas;
    private javax.swing.JComboBox comboProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabelaProdutos;
    // End of variables declaration//GEN-END:variables

}
