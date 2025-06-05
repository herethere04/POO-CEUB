package escolar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscolarWin extends JFrame {

    private JRadioButton rdbAluno, rdbEmpresa;
    private ButtonGroup tipoPessoaGroup;
    private JTextField txtNome, txtEndereco, txtTelefone, txtEmail, txtVlrMensalidade, txtPercentualDesconto, txtQtdColaboradores;
    private JLabel lblQtdColaboradores;
    private JButton btnCadastrar;
    private JTextArea areaResultado;

    public EscolarWin() {
        setTitle("Cadastro Escolar");
        setSize(500, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Tipo de Pessoa
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Tipo:"), gbc);

        rdbAluno = new JRadioButton("Aluno", true);
        rdbEmpresa = new JRadioButton("Empresa");
        tipoPessoaGroup = new ButtonGroup();
        tipoPessoaGroup.add(rdbAluno);
        tipoPessoaGroup.add(rdbEmpresa);

        JPanel panelTipo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTipo.add(rdbAluno);
        panelTipo.add(rdbEmpresa);
        gbc.gridx = 1;
        gbc.gridwidth = 2; // Ocupa duas colunas
        add(panelTipo, gbc);
        gbc.gridwidth = 1; // Reset gridwidth

        // Campos de texto
        gbc.gridy++;
        gbc.gridx = 0;
        add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        txtNome = new JTextField(20);
        add(txtNome, gbc);
        gbc.gridwidth = 1;

        gbc.gridy++;
        gbc.gridx = 0;
        add(new JLabel("Endereço:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        txtEndereco = new JTextField(20);
        add(txtEndereco, gbc);
        gbc.gridwidth = 1;

        gbc.gridy++;
        gbc.gridx = 0;
        add(new JLabel("Telefone:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        txtTelefone = new JTextField(20);
        add(txtTelefone, gbc);
        gbc.gridwidth = 1;

        gbc.gridy++;
        gbc.gridx = 0;
        add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        txtEmail = new JTextField(20);
        add(txtEmail, gbc);
        gbc.gridwidth = 1;

        gbc.gridy++;
        gbc.gridx = 0;
        add(new JLabel("Valor Mensalidade (R$):"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        txtVlrMensalidade = new JTextField(20);
        add(txtVlrMensalidade, gbc);
        gbc.gridwidth = 1;

        gbc.gridy++;
        gbc.gridx = 0;
        // O label do percentual muda um pouco para empresa para ficar mais claro
        add(new JLabel("Perc. Desconto (Ex: 0.1 para 10%):"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        txtPercentualDesconto = new JTextField(20);
        add(txtPercentualDesconto, gbc);
        gbc.gridwidth = 1;

        gbc.gridy++;
        gbc.gridx = 0;
        lblQtdColaboradores = new JLabel("Qtd. Colaboradores:");
        add(lblQtdColaboradores, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        txtQtdColaboradores = new JTextField(20);
        add(txtQtdColaboradores, gbc);
        gbc.gridwidth = 1;

        // Visibilidade inicial do campo de colaboradores
        lblQtdColaboradores.setVisible(false);
        txtQtdColaboradores.setVisible(false);

        // Listeners para os RadioButtons
        ActionListener radioListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isEmpresa = rdbEmpresa.isSelected();
                lblQtdColaboradores.setVisible(isEmpresa);
                txtQtdColaboradores.setVisible(isEmpresa);
            }
        };
        rdbAluno.addActionListener(radioListener);
        rdbEmpresa.addActionListener(radioListener);

        // Botão Cadastrar
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 3; // Ocupa três colunas
        gbc.fill = GridBagConstraints.NONE; // Centralizar o botão
        gbc.anchor = GridBagConstraints.CENTER;
        btnCadastrar = new JButton("Processar Cadastro");
        add(btnCadastrar, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL; // Reset fill
        gbc.gridwidth = 1; // Reset gridwidth

        // Área de Resultado
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0; // Permitir que a área de texto expanda horizontalmente
        gbc.weighty = 1.0; // Permitir que a área de texto expanda verticalmente
        gbc.fill = GridBagConstraints.BOTH;
        areaResultado = new JTextArea(8, 30);
        areaResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaResultado);
        add(scrollPane, gbc);

        // Ação do Botão Cadastrar
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processarCadastro();
            }
        });
    }

    private void processarCadastro() {
        try {
            String nome = txtNome.getText();
            String endereco = txtEndereco.getText();
            String telefone = txtTelefone.getText();
            String email = txtEmail.getText();
            double vlrMensalidade = Double.parseDouble(txtVlrMensalidade.getText().replace(",", "."));
            double percentualDesconto = Double.parseDouble(txtPercentualDesconto.getText().replace(",", "."));

            if (nome.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nome e Email são obrigatórios.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (vlrMensalidade <= 0 || percentualDesconto < 0 || percentualDesconto > 1) {
                 JOptionPane.showMessageDialog(this, "Valores numéricos inválidos. Percentual de desconto deve ser entre 0 (0%) e 1 (100%).", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }


            Pessoa pessoa; // Referência da Superclasse

            if (rdbAluno.isSelected()) {
                pessoa = new Aluno(nome, endereco, telefone, email, vlrMensalidade, percentualDesconto);
            } else { // Empresa selecionada
                int qtdColaboradores = Integer.parseInt(txtQtdColaboradores.getText());
                 if (qtdColaboradores <= 0) {
                    JOptionPane.showMessageDialog(this, "Quantidade de colaboradores deve ser maior que zero.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                pessoa = new Empresa(nome, endereco, telefone, email, vlrMensalidade, percentualDesconto, qtdColaboradores);
            }

            // Aqui o polimorfismo (sobrescrita) entra em ação:
            // A JVM decide em tempo de execução qual método calcularDesconto() chamar
            // (o da classe Aluno ou o da classe Empresa) com base no tipo real do objeto 'pessoa'.
            double descontoCalculado = pessoa.calcularDesconto();

            StringBuilder resultado = new StringBuilder();
            resultado.append(pessoa.toString()); // toString() também pode ser polimórfico se sobrescrito
            resultado.append("\n-----------------------------------");
            resultado.append("\nValor do Desconto Calculado: R$").append(String.format("%.2f", descontoCalculado));
            resultado.append("\nValor Final com Desconto: R$").append(String.format("%.2f", vlrMensalidade - descontoCalculado));

            areaResultado.setText(resultado.toString());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao converter valores numéricos. Verifique os campos 'Valor Mensalidade', 'Perc. Desconto' e 'Qtd. Colaboradores'.\nUse ponto como separador decimal (ex: 500.00 ou 0.1).", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Garante que a UI seja criada na Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EscolarWin().setVisible(true);
            }
        });
    }
}