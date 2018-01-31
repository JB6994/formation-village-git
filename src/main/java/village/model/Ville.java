package village.model;

public class Ville {
	private Integer id;
	private String code;
	private String libele;
	
	
	
	public Ville() {
		super();
		
	}
	
	
	public Ville(Integer id, String code, String libele) {
		super();
		this.id = id;
		this.code = code;
		this.libele = libele;
	}


	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibele() {
		return libele;
	}
	public void setLibele(String libele) {
		this.libele = libele;
	}
	
	

}
