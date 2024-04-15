package model;

public class Seller {
	private int id;
	private String name;
	private String lastname;
	private String document;

	
	public Seller(int id, String name, String lastname, String document) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.document = document;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

}
