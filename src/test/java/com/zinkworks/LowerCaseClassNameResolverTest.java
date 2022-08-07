package com.zinkworks;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowerCaseClassNameResolverTest {

    private LowerCaseClassNameResolver lowerCaseClassNameResolver;

    @BeforeEach
    public void doSetup(){
        lowerCaseClassNameResolver = new LowerCaseClassNameResolver();
    }

    @Test
    public void testIdFromValue() {
        LinkedList linkedList = new LinkedList();

        String result = lowerCaseClassNameResolver.idFromValue(linkedList);

        assertEquals("linkedlist", result);
    }

    @Test
    public void testIdFromValueAndType() {
        LinkedList linkedList = new LinkedList();

        String result = lowerCaseClassNameResolver.idFromValueAndType(linkedList, this.getClass());

        assertEquals("linkedlist", result);
    }

    @Test
    public void test() {
        JsonTypeInfo.Id result = lowerCaseClassNameResolver.getMechanism();

        assertEquals(JsonTypeInfo.Id.CUSTOM, result);
    }

}
