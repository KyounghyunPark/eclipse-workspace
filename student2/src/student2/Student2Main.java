package student2;

public class Student2Main {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		
		// insert
		Student student = new Student("sue", "111-1111", 45);
		studentDao.insertRow(student);
		
		// select all
		for (Student s : studentDao.selectAll())
			System.out.println(s);
		
		// delete
		studentDao.deleteRow(student);
		
		// select all
		for (Student s : studentDao.selectAll())
			System.out.println(s);		
	}
}
