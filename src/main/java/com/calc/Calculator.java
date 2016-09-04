package com.calc;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

/**
 * Calculator class responsible to perform arithmetic operations and formating
 * the result
 * 
 * @author Farhan
 *
 */

@Service
public class Calculator {
	DecimalFormat df;
	public Calculator() {
		df = new DecimalFormat("###.##");
	}

	public String add(float a, float b, float c) {
		return df.format(a + b + c);
	}

	public String subtract(float a, float b, float c) {
		return df.format(a - b - c);
	}

	public String multiply(float a, float b, float c) {
		return df.format(a * b * c);
	}

	public String divide(float a, float b) {
		return df.format(a / b);
	}
}
