package br.com.gerenciamentovacina.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gerenciamentovacina.util.Conexao;
import br.com.gerenciamentovacina.vo.Usuario;

public class UsuarioDAO {

	Conexao con = new Conexao();
	
	public List<Usuario> buscarTodos(){
		
		try {
			
			String sql = "SELECT * FROM usuario ORDER BY nome;";
			
			PreparedStatement stmt = con.getConnection().prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			List<Usuario> lUsuario = new ArrayList<>();
			
			while(rs.next()) {
				
				Usuario usuario = new Usuario();
				
			    usuario.setSequencial(rs.getInt("sequencial"));
			    usuario.setNome(rs.getString("nome"));
			    usuario.setEmail(rs.getString("email"));
			    usuario.setSenha(rs.getString("senha"));
			    usuario.setStatus(rs.getString("ind_status"));
				
			    lUsuario.add(usuario);
			}
			rs.close();
			stmt.close();
			return lUsuario;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
		
		
	}
	
	public void excluir(Usuario usuario) {

		// Monta sql 
		String sql = "DELETE FROM usuario  WHERE sequencial=?";

		// Constroe o PrepareStatement com sql

		try {

			PreparedStatement stmt = con.getConnection().prepareStatement(sql);

			stmt.setInt(1, usuario.getSequencial());

			stmt.execute();
			stmt.close();

			System.out.println("Excluido com Sucesso");

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erro: " + e.getMessage());
		}
	}
	
	public void salvar(Usuario usuario) {


		if(usuario.getSequencial() !=null && usuario.getSequencial() !=0) {
			alterar(usuario);

		}else {

			cadastrar(usuario);
		}
	}
	
	public Usuario buscarPorId(Integer id) {

		String sql = "SELECT * FROM usuario WHERE sequencial = ?";

		Usuario usuario = null;

		try {
			PreparedStatement preparador = con.getConnection().prepareStatement(sql);

			preparador.setInt(1, id);

			ResultSet resultado = preparador.executeQuery();

			if(resultado.next()) { //se foi para o próximo

				usuario = new Usuario();
				usuario.setSequencial(resultado.getInt("sequencial"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setEmail(resultado.getString("email"));
				usuario.setSenha(resultado.getString("senha"));
				usuario.setStatus(resultado.getString("ind_status"));

			}




		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro" + e.getMessage());
		}

		return usuario;
	    

	}
	
	public void alterar(Usuario usuario) {

		// Monta sql 
		String sql = "UPDATE usuario SET nome=?, email=?, senha=? WHERE sequencial=?";

		// Constroe o PrepareStatement com sql

		try {

			PreparedStatement preparador = con.getConnection().prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getEmail());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getSequencial());

			preparador.execute();
			preparador.close();

			System.out.println("Alterado com Sucesso");

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erro: " + e.getMessage());
		}
	}
	
	public void cadastrar(Usuario usuario) {
		
		String sql = "INSERT INTO usuario (nome, email, senha, ind_status) VALUES (?, ?, ?, ?)";
		
		try {
			
			PreparedStatement preparador = con.getConnection().prepareStatement(sql);
			
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getEmail());
			preparador.setString(3, usuario.getSenha());
			preparador.setString(4, "B");
			
			preparador.execute();
			
			preparador.close();
			
			System.out.println("Cadastrado com sucesso");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
