package model;

public class PendingRequest {

	private int e_id;
	private int r_id;
	private String body;
	
	public PendingRequest(int e_id, int r_id, String body) {
		this.setE_id(e_id);
		this.setR_id(r_id);
		this.setBody(body);
	}
	
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
