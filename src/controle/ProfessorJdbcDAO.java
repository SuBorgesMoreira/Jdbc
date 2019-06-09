package controle;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import view.TelaProfessor;
import model.Professor;
import model.Pessoa;

public class ProfessorJdbcDAO {
private Connection conn;
	
	public ProfessorJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(JButton salvar, Professor pr, Pessoa p) throws SQLException{
		String sql = "insert into alunos (nome, idade, endereco, bairro, cpf,sexo, materia, instituicao) values ('"+p.getNome()+"','"+p.getIdade()+"', '"+p.getEndereco()+"', '"+p.getBairro()+"', '"+p.getCpf()+"','"+p.getSexo()+"', '"+pr.getMateria()+"','"+pr.getInstituicao()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar(JButton alterar, Professor pr, Pessoa p) {
		String sql = "update alunos set nome= '"+p.getNome()+"', Idade'"+p.getIdade()+"', endereco'"+p.getEndereco()+"',bairro '"+p.getBairro()+"',cpf '"+p.getCpf()+"','"+p.getSexo()+"', materia'"+pr.getMateria()+"',instituicao '"+pr.getInstituicao()+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(JButton excluir, int id) {
		String sql = "delete from professor where id= '"+id+"';";
		System.out.println(sql);
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Professor> listar(JButton Listar){
		String sql = "select * from alunos";
		System.out.println(sql);
		List<Professor> professor = new ArrayList<Professor>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				int idade = rs.getInt("idade");
				String endereco = rs.getString("endereco");
				String bairro = rs.getString("bairro");
				int cpf = rs.getInt("cpf");
				String sexo = rs.getString("sexo");
				String materia = rs.getString("materia");
				String formacao = rs.getString("formcao");
				String instituicao = rs.getString("instituicao");
				Professor professores = new Professor();
				Pessoa pessoa = new Pessoa();
				professores.setId(id);
				pessoa.setNome(nome);
				pessoa.setIdade(idade);
				pessoa.setEndereco(endereco);
				pessoa.setBairro(bairro);
				pessoa.setCpf(cpf);
				pessoa.setSexo(sexo);
				professores.setMateria(materia);
				professores.setFormacao(formacao);
				professores.setInstituicao(instituicao);
				
			}
			prepareStatement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return professor;
	}
}

