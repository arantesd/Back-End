package org.generation.blogPessoal.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.model.UserLogin;
import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private PostagemRepository repositoryPostagem;
	
	public Usuario CadastrarUsuario(Usuario usuario){
		Optional<Usuario> usuarioExistente = repository.findByUsuario(usuario.getUsuario());
		if(usuarioExistente.isPresent()) {
			return null;
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
		String senhaEcoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEcoder);
		
		return repository.save(usuario);
	}
	
	public Optional<UserLogin> Logar(Optional<UserLogin>user){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByUsuario(user.get().getUsuario());
		
		if(usuario.isPresent()) { //se existe algo no optional
			if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
				
				String auth = user.get().getUsuario() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				
				user.get().setToken(authHeader);
				user.get().setNome(usuario.get().getNome());
				user.get().setSenha(usuario.get().getSenha());
				
				return user;
			}
		}
		
		return null;
	}
	public Optional<Usuario> cadastrarPostagem(Postagem novaPostagem, Long idUsuario){
		Optional<Usuario> usuarioExistente =  repository.findById(idUsuario);
		if (usuarioExistente.isPresent()) {
			novaPostagem.setCriadoPor(usuarioExistente.get());
			repositoryPostagem.save(novaPostagem);
			return repository.findById(idUsuario);
		} else {
			return Optional.empty();

		}
				
	}
}