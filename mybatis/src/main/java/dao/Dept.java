package dao;

public class Dept {
	private int id;
	private String dname;
	private String dloc;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDloc() {
		return dloc;
	}
	public void setDloc(String dloc) {
		this.dloc = dloc;
	}
	
//	@Override
	public String toString() {
		return "Dept [" + "id=" + id + ", dname=" + dname + ", dloc=" + dloc + "]";
	}
}
