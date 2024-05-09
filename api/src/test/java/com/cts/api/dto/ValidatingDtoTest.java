package com.cts.api.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidatingDtoTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ValidatingDto#ValidatingDto()}
     *   <li>{@link ValidatingDto#setValidStatus(boolean)}
     *   <li>{@link ValidatingDto#toString()}
     *   <li>{@link ValidatingDto#isValidStatus()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ValidatingDto actualValidatingDto = new ValidatingDto();
        actualValidatingDto.setValidStatus(true);
        String actualToStringResult = actualValidatingDto.toString();
        assertTrue(actualValidatingDto.isValidStatus());
        assertEquals("ValidatingDto(validStatus=true)", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ValidatingDto#ValidatingDto(boolean)}
     *   <li>{@link ValidatingDto#setValidStatus(boolean)}
     *   <li>{@link ValidatingDto#toString()}
     *   <li>{@link ValidatingDto#isValidStatus()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ValidatingDto actualValidatingDto = new ValidatingDto(true);
        actualValidatingDto.setValidStatus(true);
        String actualToStringResult = actualValidatingDto.toString();
        assertTrue(actualValidatingDto.isValidStatus());
        assertEquals("ValidatingDto(validStatus=true)", actualToStringResult);
    }
}

