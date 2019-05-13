package dao;

public class DaoTest {
	public static void main(String[] args) {
		DeptDao deptdao = new DeptDao();
		
		for (Dept d : deptdao.selectAll())
			System.out.println(d);
	}
}
