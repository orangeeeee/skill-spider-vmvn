package jp.co.aimsoft.attendance.sample.suggest.model;

public class Campaing {

	private String token;
	private String id;
	private String kind;
	private String title;

	public Campaing(String token, String id, String kind, String title) {
		this.token = token;
		this.id = id;
		this.kind = kind;
		this.title = title;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
