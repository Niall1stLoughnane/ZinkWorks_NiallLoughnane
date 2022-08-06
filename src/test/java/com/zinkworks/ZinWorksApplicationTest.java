package com.zinkworks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// Test class added ONLY to cover main() invocation not covered by application tests.
public class ZinWorksApplicationTest {

    @DisplayName("Test - ZinWorksApplicationTest - testMain")
    @Test
    public void testMain() {
        ZinWorksApplication.main(new String[] {});
    }

}