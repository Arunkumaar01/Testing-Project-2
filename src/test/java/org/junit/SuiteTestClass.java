package org.junit;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class SuiteTestClass {
	
	public static void main(String[] args) {
		
		Result runClasses = JUnitCore.runClasses(TestRunnerClass.class);
		
		int failureCount = runClasses.getFailureCount();
		System.out.println(failureCount);
		
		List<Failure> failures = runClasses.getFailures();
		
		for(int i=0; i<failures.size();i++) {
			Failure failure = failures.get(i);
			String string = failure.toString();
			System.out.println(string);
		}
		
		boolean wasSuccessful = runClasses.wasSuccessful();
		System.out.println(wasSuccessful);
		
	}


}
