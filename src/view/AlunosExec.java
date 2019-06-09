package view;

import java.sql.Connection;

import controle.AlunosJdbcDAO;
import controle.JdbUtil;
import model.Alunos;
import model.Pessoa;

public class AlunosExec{

	public static void main(String args[]) {
		Alunos alunos = new Alunos();
		Pessoa pessoas = new Pessoa();
		try {
			pessoas.setNome("");
			pessoas.setIdade(9);
			pessoas.setEndereco("");
			pessoas.setBairro("");
			pessoas.setCpf(5);
			pessoas.setSexo("");
			alunos.setRa(4);
			alunos.setSerie(0);
			alunos.setTurma("");
			alunos.setAnoConc(7);
			
			Connection connection = JdbUtil.getConnection();
			AlunosJdbcDAO alunosJdbcDAO = new AlunosJdbcDAO(connection);
			
	//		alunosJdbcDAO.salvar(alunos, pessoas);
			//alunosJdbcDAO.listar(alunos,pessoas);
			//alunosJdbcDAO.alterar(alunos,pessoas);
			//alunosJdbcDAO.excluir(alunos,pessoas);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
