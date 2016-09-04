package com.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.calc.Calculator;
import com.dto.Result;

/**
 * This is the Controller class exposing the Calculator REST API's.
 * 
 * @author Farhan
 *
 */

@RestController
@EnableAutoConfiguration
@Configuration
@ComponentScan("com.*")
@EnableCaching
public class CalculatorController {

	private Calculator calculator;
	private static String errorMessage = "Invalid Input, only numbers expected.";

	@Autowired
	public CalculatorController(Calculator calculator) {
		this.calculator = calculator;
	}
	
	/**
     * GET  /add/:a/:b/:c : add the numbers.
     *
     * @param Numbers to be added
     * @return Result with error message if numbers are not in correct format
     */
	@Cacheable("add")
	@RequestMapping(value = "/add/{a}/{b}/{c}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Result add(@PathVariable() float a, @PathVariable() float b, @PathVariable() float c) {
		simulateSlowService();
		String result = calculator.add(a, b, c);
		return new Result(result);
	}
	
	/**
     * GET  /add/:a/:b : add the numbers.
     *
     * @param Numbers to be added
     * @return Result with error message if numbers are not in correct format
     */
	@Cacheable("add")
	@RequestMapping(value = "/add/{a}/{b}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Result add(@PathVariable() float a, @PathVariable() float b) {
		simulateSlowService();
		String result = calculator.add(a, b, 0);
		return new Result(result);
	}

	/**
     * GET  /subtract/:a/:b/:c : subtract the numbers.
     *
     * @param Numbers to be subtracted
     * @return Result with error message if numbers are not in correct format
     */
	@Cacheable("subtract")
	@RequestMapping(value = "/subtract/{a}/{b}/{c}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Result subtract(@PathVariable() float a, @PathVariable() float b, @PathVariable() float c) {
		simulateSlowService();
		String result = calculator.subtract(a, b, c);
		return new Result(result);
	}
	
	/**
     * GET  /subtract/:a/:b : subtract the numbers.
     *
     * @param Numbers to be subtracted
     * @return Result with error message if numbers are not in correct format
     */
	@Cacheable("subtract")
	@RequestMapping(value = "/subtract/{a}/{b}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Result subtract(@PathVariable() float a, @PathVariable() float b) {
		simulateSlowService();
		String result = calculator.subtract(a, b, 0);
		return new Result(result);
	}

	/**
     * GET  /multiply/:a/:b/:c : multiply the numbers.
     *
     * @param Numbers to be multiplied
     * @return Result with error message if numbers are not in correct format
     */
	@Cacheable("multiply")
	@RequestMapping(value = "/multiply/{a}/{b}/{c}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Result multiply(@PathVariable() float a, @PathVariable() float b, @PathVariable() float c) {
		simulateSlowService();
		String result = calculator.multiply(a, b, c);
		return new Result(result);
	}
	
	/**
     * GET  /multiply/:a/:b : multiply the numbers.
     *
     * @param Numbers to be multiplied
     * @return Result with error message if numbers are not in correct format
     */
	@Cacheable("multiply")
	@RequestMapping(value = "/multiply/{a}/{b}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Result multiply(@PathVariable() float a, @PathVariable() float b) {
		simulateSlowService();
		String result = calculator.multiply(a, b, 1);
		return new Result(result);
	}

	/**
     * GET  /divide/:a/:b : a is divided by b.
     *
     * @param Numbers to be divided, where a is numerator, and b is denominator
     * @return Result with error message if numbers are not in correct format
     */
	@Cacheable("divide")
	@RequestMapping(value = "/divide/{a}/{b}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Result divide(@PathVariable() float a, @PathVariable() float b) {
		simulateSlowService();
		String result = calculator.divide(a, b);
		return new Result(result);
	}

	@ExceptionHandler(TypeMismatchException.class)
	public @ResponseBody Result handleMyException(Exception exception, HttpServletRequest request) {
		return new Result(errorMessage);
	}

	private void simulateSlowService() {
		try {
			long time = 5000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
}
