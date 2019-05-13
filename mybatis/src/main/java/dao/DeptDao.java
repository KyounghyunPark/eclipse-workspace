package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DeptDao {
	private SqlSessionFactory sqlSessionFactory;
	public DeptDao() {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatisConfiguration.xml");
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
	
	public List<Dept> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectList("dao.deptMapper.selectAll");
		} finally {
			session.close();
		}
	}
}
