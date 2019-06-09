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

	public class TelaProfessor extends JFrame{
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
		
		JLabel lblmateria = new JLabel("Máteria:");
		JComboBox txtMateria = new JComboBox();
		
		JLabel lblInstituicao = new JLabel("Instituicao");
		JTextField Instituicao = new JTextField();
		
		JLabel lblsexo = new JLabel("Sexo:");
		JRadioButton[] sexo = new JRadioButton[2];
			ButtonGroup grp = new ButtonGroup();
			
		JButton salvar = new JButton("Salvar");
		JButton alterar = new JButton("Alterar");
		JButton excluir = new JButton("Excluir");
		JButton mostrar = new JButton("Mostrar");
		
			
		public TelaProfessor() throws ClassNotFoundException, SQLException {
			super("Cadastro Professor");
			
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
			sexo[0].setBackground(Color.LIGHT_GRAY);
			painel.add(sexo[1]);
			sexo[1].setBounds(320, 140, 90, 30);
			sexo[1].setBackground(Color.LIGHT_GRAY);
			
			
			painel.add(lblmateria);
			lblmateria.setBounds(10, 180, 60, 30);
			painel.add(txtMateria);
			txtMateria.setBounds(65, 180, 140, 30);
			txtMateria.addItem("");
			txtMateria.addItem("Matemática");
			txtMateria.addItem("Física");
			txtMateria.addItem("Química");
			txtMateria.addItem("Biologia");
			txtMateria.addItem("História");
			txtMateria.addItem("Geografia");
			txtMateria.addItem("Sociologia");
			txtMateria.addItem("Filosofia");
			txtMateria.addItem("Língua portuguesa");
			txtMateria.addItem("Inglês");
			txtMateria.addItem("Artes");
			txtMateria.addItem("Literatura");
			txtMateria.addItem("Educação física");
			txtMateria.addItem("Informatica");
			txtMateria.addItem("Teatro");
			
			painel.add(lblInstituicao);
			lblInstituicao.setBounds(240,180, 120, 30);
			painel.add(Instituicao);
			Instituicao.setBounds(310, 180, 130, 30);

			painel.add(salvar);
			salvar.setBounds(10, 250, 100, 40);
			
			painel.add(excluir);
			excluir.setBounds(123, 250, 100, 40);
			
			painel.add(alterar);
			alterar.setBounds(240, 250, 100, 40);
			
			painel.add(mostrar);
			mostrar.setBounds(355, 250, 100,40);
			
			this.setVisible(true);
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(500,370);
			this.getContentPane().setBackground(Color.LIGHT_GRAY);
	
		}

		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			TelaProfessor tela = new TelaProfessor();

		}

	}

