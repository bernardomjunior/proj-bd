package model.bean;

public class Cliente {
	
	private int id;
	private int cpf; //Primary key
	private int telefone; //varchar11
	private String nomeCli; //varchar100
	private String email; //varchar50
	
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int string) {
		this.cpf = string;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getNomeCli() {
		return nomeCli;
	}
	public void setNomeCli(String nomeCli) {
		this.nomeCli = nomeCli;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId(){
		return id;
	}
	public void setId(int id) {
		this.id = id;		
	}
	
	
	
}
