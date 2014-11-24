package br.com.gerenciamentovacina.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.gerenciamentovacina.dao.UsuarioDAO;
import br.com.gerenciamentovacina.vo.Usuario;

@Path("usuario")
public class UsuarioResource {
	
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	@GET
	@Path("/listarUsuarios")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Usuario> buscarTodos() {
		
		System.out.println("Listou todos");
		
		return usuarioDAO.buscarTodos();
	}
	
	@GET
	@Path("/listarUsuarios/{sequencial}")
	@Produces("application/json")
	public Usuario buscarPorId(@PathParam("sequencial") int sequencial) {
		
		return usuarioDAO.buscarPorId(sequencial);
	}

	 @DELETE
	 @Path("/deletar/{id}")
	 @Produces("application/json")
	 public void getExcluir(@PathParam("id") int id) {
	
	 System.out.println("conseguiu encontrar usuário pelo id");
	 Usuario usuario = new Usuario();
	
	usuario.setSequencial(id);
	
	usuarioDAO.excluir(usuario);
	 
	 }
	 
	 @POST
	 @Path("/salvar")
	 @Produces("application/json")
	 @Consumes("application/json")
	 public void salvar(Usuario usuario) {
		 
		 usuario.setNome(usuario.getNome());
		 usuario.setEmail(usuario.getEmail());
		 usuario.setSenha(usuario.getSenha());
		 usuario.setStatus("Usuário");
		 
		 usuarioDAO.salvar(usuario);
	 }
	 
	 @PUT
	 @Path("/atualizar")
	 @Produces("application/json")
	 @Consumes("application/json")
	 public void atualizar(Usuario usuario) {
		 
		 usuario.setSequencial(usuario.getSequencial());
		 usuario.setNome(usuario.getNome());
		 usuario.setEmail(usuario.getEmail());
		 usuario.setSenha(usuario.getSenha());
		 usuario.setStatus("Usuário");
		 
		 usuarioDAO.salvar(usuario);
	 }
	
	
}
