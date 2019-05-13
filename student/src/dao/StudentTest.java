package dao;

import vo.StudentVO;

public class StudentTest {
	public static void main(String args[]) {
		StudentDAO studentDao = new StudentDAO();
		
		for (StudentVO s : studentDao.selectAll())
			System.out.println(s);
	}
}
