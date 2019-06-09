package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Executar extends JFrame{
	JButton btnAluno = new JButton("Cadastrar Aluno");
	JButton btnProfessor = new JButton("Cadastrar Professor");
	
	public Executar() {
		super("Tela de Cadastro");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		btnAluno.setBounds(100, 100, 200, 200);
		btnAluno.setBackground(Color.BLUE);
		btnAluno.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			try {
				view.TelaAluno al = new view.TelaAluno();
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
			}
		});
		paine.add(btnAluno);
		
		
		btnProfessor.setBounds(400,100,200,200);
		btnProfessor.setBackground(Color.BLUE);
		btnProfessor.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					view.TelaProfessor pro = new view.TelaProfessor();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		paine.add(btnProfessor);
		
		
		this.setSize(700,500);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.YELLOW);
	}
	
	public static void main(String[] args) {
		Executar exec = new Executar();
	}
}
