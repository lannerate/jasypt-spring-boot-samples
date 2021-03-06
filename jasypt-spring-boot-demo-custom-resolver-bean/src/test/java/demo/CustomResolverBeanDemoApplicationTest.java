package demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CustomResolverBeanDemoApplication.class)
public class CustomResolverBeanDemoApplicationTest {

	@Autowired
	ConfigurableEnvironment environment;

	@Autowired
	MyService service;

	static {
		System.setProperty("jasypt.encryptor.password", "password");
	}

	@Test
	public void testEnvironmentProperties() {
		Assert.assertEquals("{cipherr}nrmZtkF7T0kjG/VodDvBw93Ct8EgjCA+", environment.getProperty("secret.property"));
		Assert.assertEquals("chupacabras", environment.getProperty("secret2.property"));
	}

	@Test
	public void testServiceProperties() {
		Assert.assertEquals("{cipherr}nrmZtkF7T0kjG/VodDvBw93Ct8EgjCA+", service.getSecret());
		Assert.assertEquals("chupacabras", service.getSecret2());
	}

}
