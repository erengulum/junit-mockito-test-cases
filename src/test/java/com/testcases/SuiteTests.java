package com.testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({QuickBeforeAfterTest.class, ArrayCompareTest.class}) //so those two test classes will be executed together
public class SuiteTests {


}
