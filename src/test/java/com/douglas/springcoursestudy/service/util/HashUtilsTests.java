package com.douglas.springcoursestudy.service.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class HashUtilsTests {
	
	@Test
	public void  getSecureHashTest() {
		String hash = HashUtil.getSecurityHash("123");
		System.out.println(hash);
		assertThat(hash.length()).isEqualTo(64);	
	}
}
