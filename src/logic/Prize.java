package logic;

public class Prize {

	private String code;
	private String name;
	private String type;
	
	private String imagePath;
	
	public Prize(String code, String name, String type) {
		
		setCode(code);
		setName(name);
		setType(type);
		
		this.imagePath = new StringBuffer("/img/").append(this.code).append(".png").toString();
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
