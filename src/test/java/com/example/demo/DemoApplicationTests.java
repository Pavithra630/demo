package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.DemoController;
import com.example.demo.model.DemoModel;
import com.example.demo.repository.DemoRepository;
import com.jayway.jsonpath.internal.Utils;

@SpringBootTest
class DemoApplicationTests {
	@Mock
	DemoRepository dr;
	
	@InjectMocks
	DemoController dc;
	
	@Test
	 void saveDetailsTest() {
		DemoModel dm=new DemoModel();
		when(dr.save(dm)).thenReturn(dm);
		
		assertEquals(dm, dc.saveDetails(dm));
		
	}
	@Test
	void privateMethod() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		DemoController demo=new DemoController();
		java.lang.reflect.Method method=DemoController.class.getDeclaredMethod("getString");
		method.setAccessible(true);
		String result =  (String) method.invoke(demo);
        assertEquals("hello world", result);
	}
	
	@Test
	void staticMethod() {
		
	}

}
