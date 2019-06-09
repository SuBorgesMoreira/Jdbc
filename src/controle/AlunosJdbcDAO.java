package controle;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import view.TelaAluno;
import model.Alunos;
import model.Pessoa;

public class AlunosJdbcDAO {

	private static Connection conn;
	
	public AlunosJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	/*public void salvar(Alunos c, Pessoa p) throws SQLException{
		String sql = "insert into alunos (nome, idade, endereco, bairro, cpf,sexo, RA, serie, turma, anoConc) values ('"+p.getNome()+"','"+p.getIdade()+"', '"+p.getEndereco()+"', '"+p.getBairro()+"', '"+p.getCpf()+"', '"+p.getSexo()+"', '"+c.getRa()+"', '"+c.getSerie()+"', '"+c.getTurma()+"', '"+c.getAnoConc()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}*/
	

	public static void salvar(JButton salvar, Alunos c, Pessoa p) throws SQLException{
		String sql = "insert into alunos (nome, idade, endereco, bairro, cpf,sexo, RA, serie, turma, anoConc) values ('"+p.getNome()+"','"+p.getIdade()+"', '"+p.getEndereco()+"', '"+p.getBairro()+"', '"+p.getCpf()+"', '"+p.getSexo()+"', '"+c.getRa()+"', '"+c.getSerie()+"', '"+c.getTurma()+"', '"+c.getAnoConc()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
		// TODO Auto-generated method stub
		
	}
	
	public void alterar(JButton alterar, Alunos c, Pessoa p) {
		String sql = "update alunos set nome= '"+p.getNome()+"', Idade'"+p.getIdade()+"', endereco'"+p.getEndereco()+"',bairro '"+p.getBairro()+"',cpf '"+p.getCpf()+"',sexo'"+p.getSexo()+"', ra'"+c.getRa()+"',serie '"+c.getSerie()+"',turma '"+c.getTurma()+"',ano conclusao '"+c.getAnoConc()+"';";
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
		String sql = "delete from alunos where id= '"+excluir+"', '"+id+"';";
		System.out.println(sql);
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Alunos> listar(JButton listar){
		String sql = "select * from alunos";
		System.out.println(sql);
		List<Alunos> alunos = new ArrayList<Alunos>();
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
				int ra = rs.getInt("ra");
				int serie = rs.getInt("serie");
				String turma = rs.getString("turma");
				int anoConc = rs.getInt("Ano conclusao");
				Alunos aluno = new Alunos();
				Pessoa pessoa = new Pessoa();
				aluno.setId(id);
				pessoa.setNome(nome);
				pessoa.setIdade(idade);
				pessoa.setEndereco(endereco);
				pessoa.setBairro(bairro);
				pessoa.setCpf(cpf);
				pessoa.setSexo(sexo);
				aluno.setRa(ra);
				aluno.setSerie(serie);
				aluno.setTurma(turma);
				aluno.setAnoConc(anoConc);
				
			}
			prepareStatement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}


}
