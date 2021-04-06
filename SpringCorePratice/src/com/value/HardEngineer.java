package com.value;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class HardEngineer implements Engineer {

	@Override
	public void development() {
	System.out.println(" I am Hard ware Engineer ");
		
	}

}
