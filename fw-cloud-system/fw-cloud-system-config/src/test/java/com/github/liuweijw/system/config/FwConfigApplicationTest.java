package com.github.liuweijw.system.config;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Config Server 配置中心
 * 
 * @author liuweijw
 */
@RunWith( SpringRunner.class )
@SpringBootTest(classes={FwConfigApplication.class} ,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FwConfigApplicationTest {

	@Autowired
	private StringEncryptor stringEncryptor;

	@Test
	public void testDecrypt() throws Exception {
		final String username = stringEncryptor.encrypt( "root" );
		final String password = stringEncryptor.encrypt( "admin123" );

		System.err.println( "username = " + username );
		System.err.println( "password = " + password );

		System.out.println("-------------------------------------------------");

		System.out.println( "username = " + stringEncryptor.decrypt("rC/X/8UBBH2bn9Tgfuu7aw=="));
		System.out.println( "password = " + stringEncryptor.decrypt("IVTzs5LDfVEsblAFWFgA9w=="));
		System.out.println( "password = " + stringEncryptor.decrypt("03nxkiAhmy8VCRvovXc2X8CaEblfHUsV"));

		System.out.println("-------------------------------------------------");
		System.out.println( "username = " + stringEncryptor.decrypt("eZLNwFxeSKENBh1pu/M/rMMB76nxo/RLhWSaSLHa8+0="));
		System.out.println( "username = " + stringEncryptor.decrypt("eZLNwFxeSKENBh1pu/M/rMMB76nxo/RLhWSaSLHa8+0="));
		System.out.println( "password = " + stringEncryptor.decrypt("sKbpJGHz9JZmdydv1WOyAYjyXm2irxc0xYqvQ6VpF31uEw/FVNxYeA=="));
		System.out.println( "password = " + stringEncryptor.decrypt("fmVD9Jt6YXP9Q+KBPU8/1cWgKn5WhlGuD10SzFADNz4="));


		System.out.println("-------------------------------------------------");


	}
}
