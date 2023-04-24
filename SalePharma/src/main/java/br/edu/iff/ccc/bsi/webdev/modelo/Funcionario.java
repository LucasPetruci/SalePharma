package br.edu.iff.ccc.bsi.webdev.modelo;

import java.io.Serializable;
<<<<<<< Updated upstream
import java.util.Date;

=======
import java.util.HashSet;
import java.util.Set;

import br.edu.iff.ccc.bsi.webdev.service.Role;
>>>>>>> Stashed changes
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
<<<<<<< Updated upstream
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
=======
>>>>>>> Stashed changes


@Entity
@Table(name = "Funcionario")
public class Funcionario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
<<<<<<< Updated upstream
	public Funcionario(int id,  String nome){
		this.id = id;
		this.nome = nome;
	}
	
=======
	private String senha;
	
	  @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "funcionario_role",
	        joinColumns = @JoinColumn(name = "funcionario_id"),
	        inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private Set<Role> roles = new HashSet<>();
	  
	  
	public Funcionario(String nome, String senha){
		this.nome = nome;
		this.senha = senha;
	    this.roles = new HashSet<>();

	}
	
	public Funcionario() {
		
	}
		
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

>>>>>>> Stashed changes
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
<<<<<<< Updated upstream
	
	
=======
		
>>>>>>> Stashed changes
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
<<<<<<< Updated upstream
	
	public void adicionarProduto() {
		
	}
	
	public void recebeVenda() {
		
	}
	
	public void encerrarVenda() {
		
	}
=======
	public void addRole(Role role) {
	    roles.add(role);
	}

	public void removeRole(Role role) {
	    roles.remove(role);
	}

	public Set<Role> getRole() {
	    return roles;
	}

	
>>>>>>> Stashed changes
}
