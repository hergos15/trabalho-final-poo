package br.edu.ifpi.poo.prova.ui;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import br.edu.ifpi.poo.prova.dao.DizimistaDAO;
import br.edu.ifpi.poo.prova.model.Dizimista;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class janela extends JFrame {

	private JPanel contentPane;
	private JTextField txfNome;
	private JTextField txfId;
	private JTextField txfCpf;
	private JTextField txfEndereco;
	private JTextField txfTelefone;
	
	private DizimistaDAO dDAO = new DizimistaDAO();
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janela frame = new janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public janela() {
		setTitle("Cadastro de DIzimistas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("nome :");
		lblNome.setBounds(10, 46, 46, 14);
		contentPane.add(lblNome);
		
		txfNome = new JTextField();
		txfNome.setBounds(49, 43, 344, 20);
		contentPane.add(txfNome);
		txfNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id :");
		lblNewLabel.setBounds(10, 21, 46, 14);
		contentPane.add(lblNewLabel);
		
		txfId = new JTextField();
		txfId.setBounds(50, 18, 86, 20);
		contentPane.add(txfId);
		txfId.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF :");
		lblCpf.setBounds(10, 71, 46, 14);
		contentPane.add(lblCpf);
		
		txfCpf = new JTextField();
		txfCpf.setBounds(49, 68, 143, 20);
		contentPane.add(txfCpf);
		txfCpf.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereco :");
		lblEndereco.setBounds(10, 96, 59, 14);
		contentPane.add(lblEndereco);
		
		txfEndereco = new JTextField();
		txfEndereco.setBounds(79, 93, 345, 20);
		contentPane.add(txfEndereco);
		txfEndereco.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setBounds(10, 121, 70, 14);
		contentPane.add(lblTelefone);
		
		txfTelefone = new JTextField();
		txfTelefone.setBounds(79, 118, 143, 20);
		contentPane.add(txfTelefone);
		txfTelefone.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long id = Long.parseLong(txfId.getText());
				String nome = txfNome.getText();
				String CPF = txfCpf.getText();
				String endereco = txfEndereco.getText();
				String telefone = txfTelefone.getText();
				dDAO.iniciar();
				if (dDAO.salvar(new Dizimista())) {
					dDAO.commit();
					dDAO.fechar();
					JOptionPane.showMessageDialog(null, "Dizimista cadastrado");
					txfId.setText("");
					txfNome.setText("");
					txfCpf.setText("");
					txfEndereco.setText("");
					txfTelefone.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "não foi possivel cadastrar o dizimista");
				}
			}
		});
		btnCadastrar.setBounds(10, 172, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long id = Long.parseLong(txfId.getText());
				dDAO.iniciar();
				dDAO.commit();
				List<Dizimista> dizimistas = (List<Dizimista>) dDAO.procurar(id);
				DefaultListModel lstModel = new DefaultListModel();
				AbstractButton list;
				list.setList(lstModel);
				if (dizimistas.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Id ñ encontrado");
				} else {
					for (Dizimista Dizimista : dizimistas) {
						lstModel.addElement(lstModel);
						
					}
			
				}
				dDAO.fechar();
			}
		});
		btnNewButton.setBounds(109, 172, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					dDAO.iniciar();
					dDAO.commit();
					List<Dizimista> dizimistas = dDAO.listarTodos();
					DefaultListModel lstModel = new DefaultListModel();
					if (dizimistas.isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"Não tem alunos cadastrados");
					} else {
						for (Dizimista Dizimista : dizimistas) {
							lstModel.addElement(dizimistas);
						}
					}
					list.setModel(lstModel);
					dDAO.fechar();
				}
			
		});
		btnListar.setBounds(208, 172, 89, 23);
		contentPane.add(btnListar);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Long id = Long.parseLong(txfId.getText());
				dDAO.iniciar();
				dDAO.commit();
				Dizimista dizimista = dDAO.procurar(id);
				if(dizimista != null){
					dDAO.apagar(dizimista);
					JOptionPane.showMessageDialog(null, "Aluno excluido com sucesso");
					dDAO.salvar(dizimista);
					txfId.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "Não foi possivel excluir aluno");
				}
				dDAO.fechar()
			}
			
		});
		btnApagar.setBounds(307, 172, 89, 23);
		contentPane.add(btnApagar);
	}
}
