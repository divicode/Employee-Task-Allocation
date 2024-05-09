package com.cts.userdetails.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class SuccessResponseTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link SuccessResponse}
     *   <li>{@link SuccessResponse#setMessage(String)}
     *   <li>{@link SuccessResponse#setTimestamp(Date)}
     *   <li>{@link SuccessResponse#getMessage()}
     *   <li>{@link SuccessResponse#getTimestamp()}
     * </ul>
     */
    @Test
    void testConstructor() {
        SuccessResponse actualSuccessResponse = new SuccessResponse();
        actualSuccessResponse.setMessage("Not all who wander are lost");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualSuccessResponse.setTimestamp(fromResult);
        assertEquals("Not all who wander are lost", actualSuccessResponse.getMessage());
        assertSame(fromResult, actualSuccessResponse.getTimestamp());
    }
}

