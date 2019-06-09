package view;

import java.awt.Color;
import java.awt.Container;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controle.AlunosJdbcDAO;
import controle.JdbUtil;

public class TelaAluno extends JFrame{
	MaskFormatter frmtCpf = null;
	
	JLabel lblNome = new JLabel("Nome:");
	static JTextField txtNome = new JTextField();
	
	JLabel lblIdade = new JLabel("Idade:");
	JTextField txtIdade = new JTextField();
	
	JLabel lblEndereco = new JLabel("Endereço:");
	JTextField txtEndereco = new JTextField();
	
	JLabel lblBairro = new JLabel("Bairro:");
	JTextField txtBairro = new JTextField();
	
	JLabel lblCpf = new JLabel("CPF:");
	JTextField txtCpf = new JTextField();
	
	JLabel lblRa = new JLabel("RA:");
	JTextField txtRa = new JTextField();
	JTextField dgRa = new JTextField();
	
	JLabel lblSerie = new JLabel("Serie:");
	JComboBox Serie = new JComboBox();
	
	JLabel lblTurma = new JLabel("Turma");
	JComboBox Turma = new JComboBox();
	
	JLabel lblAnoConc = new JLabel("Ano de Conclusão:");
	JComboBox AnoConc = new JComboBox();
	
	JLabel lblsexo = new JLabel("Sexo:");
	JRadioButton[] sexo = new JRadioButton[2];
		ButtonGroup grp = new ButtonGroup();
		
	JButton salvar = new JButton("Salvar");
	JButton alterar = new JButton("Alterar");
	JButton excluir = new JButton("Excluir");
	JButton mostrar = new JButton("Mostrar");
	
		
	public TelaAluno() throws ClassNotFoundException, SQLException {
		super("Cadastro Aluno");
		
		Container painel = this.getContentPane();
		painel.setLayout(null);
		
		painel.add(lblNome);
		lblNome.setBounds(8,8,40,30);
		painel.add(txtNome);
		txtNome.setBounds(60, 10,240, 30);
		
		painel.add(lblIdade);
		lblIdade.setBounds(335,8,40,30);
		painel.add(txtIdade);
		txtIdade.setBounds(375,10,30,30);
		
		painel.add(lblEndereco);
		lblEndereco.setBounds(10,55,58,30);
		painel.add(txtEndereco);
		txtEndereco.setBounds(85, 55, 280, 30);
		
		painel.add(lblBairro);
		lblBairro.setBounds(10, 100, 40, 30);
		painel.add(txtBairro);
		txtBairro.setBounds(60, 100, 180, 30);
		
		painel.add(lblCpf);
		lblCpf.setBounds(10, 140, 30, 30);
		try {
			frmtCpf = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(frmtCpf);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		painel.add(txtCpf);
		txtCpf.setBounds(50, 140, 120 ,30);
		
		painel.add(lblsexo);
		lblsexo.setBounds(200,140, 40, 30);
		sexo[0] = new JRadioButton("Feminino");
		sexo[1] = new JRadioButton("Masculino");
			grp.add(sexo[0]);
			grp.add(sexo[1]);
		painel.add(sexo[0]);
		sexo[0].setBounds(240, 140, 80, 30);
		sexo[0].setBackground(Color.lightGray);
		painel.add(sexo[1]);
		sexo[1].setBounds(320, 140, 90, 30);
		sexo[1].setBackground(Color.lightGray);
		
		
		painel.add(lblRa);
		lblRa.setBounds(10, 180, 20, 30);
		painel.add(txtRa);
		txtRa.setBounds(40, 180, 130, 30);
		painel.add(dgRa);
		dgRa.setBounds(190, 180, 35, 30);
		
		
		painel.add(lblSerie);
		lblSerie.setBounds(10, 225, 35, 30);
		painel.add(Serie);
		Serie.setBounds(50, 225, 100, 30);
		Serie.addItem("");
		Serie.addItem("6° série");
		Serie.addItem("7° série");
		Serie.addItem("8° série");
		Serie.addItem("1° ano");
		Serie.addItem("2° ano");
		Serie.addItem("3° ano");
		
		painel.add(lblTurma);
		lblTurma.setBounds(165,225, 40, 30);
		painel.add(Turma);
		Turma.setBounds(210, 225, 50, 30);
		Turma.addItem("");
		Turma.addItem("A");
		Turma.addItem("B");
		Turma.addItem("C");
		Turma.addItem("D");
		Turma.addItem("E");
		Turma.addItem("F");
		
		painel.add(lblAnoConc);
		lblAnoConc.setBounds(280, 225, 120, 30);
		painel.add(AnoConc);
		AnoConc.setBounds(395, 225, 60, 30);
		AnoConc.addItem("");
		AnoConc.addItem("2014");
		AnoConc.addItem("2015");
		AnoConc.addItem("2016");
		AnoConc.addItem("2017");
		AnoConc.addItem("2018");
		AnoConc.addItem("2019");
		AnoConc.addItem("2020");
		AnoConc.addItem("2021");
		AnoConc.addItem("2022");
		AnoConc.addItem("2023");
		AnoConc.addItem("2024");
		AnoConc.addItem("2025");
		AnoConc.addItem("2026");
		AnoConc.addItem("2027");	

		painel.add(salvar);
		salvar.setBounds(10, 290, 100, 40);
		
		painel.add(excluir);
		excluir.setBounds(123, 290, 100, 40);
		
		painel.add(alterar);
		alterar.setBounds(240, 290, 100, 40);
		
		painel.add(mostrar);
		mostrar.setBounds(355, 290, 100,40);
		
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400);
		this.getContentPane().setBackground(Color.lightGray);
	
	}
	
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		TelaAluno tela = new TelaAluno();

	}

}
