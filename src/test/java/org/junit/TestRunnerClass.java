package org.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({JunitPrograms.class,JunitPrograms2.class,JunitPrograms3.class})
public class TestRunnerClass {

}
