package com.generic.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class will provide implementation of IRetryAnalyser
 * 
 * @author vivek
 *
 */
public class RetryAnalyserImplementationUtility implements IRetryAnalyzer {
	int count = 0;
	int retry = 5;

	@Override
	public boolean retry(ITestResult result) {
		while (retry > count) {
			count++;
			return true;
		}
		return false;
	}

}
