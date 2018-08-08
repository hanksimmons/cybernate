package model;

public class Request {

	private int e_id;
	private int r_id;
	private double amount;
	private String body;
	private int resolved_by;
	private int outcome;
	
	public Request(int e_id, int r_id, double amount, String body, int resolved_by, int outcome) {
		this.setE_id(e_id);
		this.setR_id(r_id);
		this.setAmount(amount);
		this.setBody(body);
		this.setResolved_by(resolved_by);
		this.setOutcome(outcome);
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
	public int getResolved_by() {
		return resolved_by;
	}
	public void setResolved_by(int resolved_by) {
		this.resolved_by = resolved_by;
	}
	public int getOutcome() {
		return outcome;
	}
	public void setOutcome(int outcome) {
		this.outcome = outcome;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount2) {
		this.amount = amount2;
	}
	
	@Override
	public String toString() {
		return "Request [e_id=" + e_id + ", r_id=" + r_id + ", amount=" + amount + ", body=" + body + ", resolved_by="
				+ resolved_by + ", outcome=" + outcome + "]";
	}
}
