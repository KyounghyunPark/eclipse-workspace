package student2;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class StudentDao {
	private SqlSessionFactory sqlSessionFactory;
	
	public StudentDao() {
		InputStream is = null;
		try {
		is = Resources.getResourceAsStream("student2/studentConfig.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void insertRow(Student student) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			int result = session.insert("etri.student.insertRow", student);
			
			if (result>0) {
				session.commit();
				System.out.println("insert " + result + " items successfully");
			}
			else {
				System.out.println("fail to insert");
			}
		} finally {
			session.close();
		}
	}
	
	public void deleteRow(Student student) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			int result = session.delete("etri.student.deleteRow", student);
			if (result > 0 ) {
				session.commit();
				System.out.println("delete " + result + " items successfully");
			} else {
				System.out.println("fail to delete");
			}
		} finally {
			session.close();
		}
	}
	
	public List<Student> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectList("etri.student.selectAll");
		} finally {
			session.close();
		}
	}

}

