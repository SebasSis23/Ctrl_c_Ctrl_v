package Ctrl_c_Ctrl_v.demo;

import Ctrl_c_Ctrl_v.demo.repository.OficinaRepository;
import Ctrl_c_Ctrl_v.demo.repository.OrguserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest(properties = {
		"spring.autoconfigure.exclude="
				+ "org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration,"
				+ "org.springframework.boot.hibernate.autoconfigure.HibernateJpaAutoConfiguration,"
				+ "org.springframework.boot.data.jpa.autoconfigure.JpaRepositoriesAutoConfiguration"
})
class DemoApplicationTests {

	@MockitoBean
	private OficinaRepository oficinaRepository;

	@MockitoBean
	private OrguserRepository orguserRepository;

	@Test
	void contextLoads() {
	}

}
