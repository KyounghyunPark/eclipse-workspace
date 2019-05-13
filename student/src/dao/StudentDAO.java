package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.StudentVO;

public class StudentDAO {
	private SqlSessionFactory sqlSessionFactory;
	public StudentDAO() {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("resource/studentConfiguration.xml");
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
	
	public List<StudentVO> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectList("resource.studentMapper.selectAll");
		} finally {
			session.close();
		}
	}
}
