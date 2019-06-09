package view;

import java.sql.Connection;


import controle.JdbUtil;
import controle.ProfessorJdbcDAO;
import model.Pessoa;
import model.Professor;

public class ProfessorExec {

	public static void main(String args[]) {
		Professor professores = new Professor();
		Pessoa pessoas = new Pessoa();
		try {
			pessoas.setNome("");
			pessoas.setIdade(9);
			pessoas.setEndereco("");
			pessoas.setBairro("");
			pessoas.setCpf(5);
			pessoas.setSexo("");
			professores.setMateria("");
			professores.setFormacao("");
			professores.setInstituicao("");
			
			Connection connection = JdbUtil.getConnection();
			ProfessorJdbcDAO ProfessorJdbcDAO = new ProfessorJdbcDAO(connection);
			
			//ProfessorJdbcDAO.salvar(professores,pessoas);
			//alunosJdbcDAO.listar(professores,pessoas);
			//alunosJdbcDAO.alterar(professores,pessoas);
			//alunosJdbcDAO.excluir(professores,pessoas);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
