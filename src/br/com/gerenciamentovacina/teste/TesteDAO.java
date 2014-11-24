package br.com.gerenciamentovacina.teste;

import br.com.gerenciamentovacina.dao.UsuarioDAO;
import br.com.gerenciamentovacina.vo.Usuario;

public class TesteDAO {

	
	public static void main(String[] args) {
		
		cadastrar();
		
	}
	
	public static void cadastrar(){
		
		Usuario usu = new Usuario();
		usu.setNome("João");
		usu.setEmail("joao@hotmail.com");
		usu.setSenha("123");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		usuDAO.cadastrar(usu);
		
	}
	
}
