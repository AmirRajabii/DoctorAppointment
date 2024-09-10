package com.appointment.system.doctor_appointment.utils;

import com.appointment.system.doctor_appointment.exception.DateMismatchException;
import com.appointment.system.doctor_appointment.exception.DateTimeOrderException;
import com.appointment.system.doctor_appointment.model.dto.TimeRange;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TimeSplitterTest {

    @Test
    void shouldThrowDateTimeOrderExceptionWhenEndTimeIsBeforeStartTime() {
        LocalDateTime start = LocalDateTime.of(2024, 9, 10, 10, 0);
        LocalDateTime end = LocalDateTime.of(2024, 9, 10, 9, 0);

        Exception exception = assertThrows(DateTimeOrderException.class, () -> {
            TimeSplitter.timeDivision(start, end, 30);
        });

        assertEquals("Error: End time is before start time.", exception.getMessage());
    }

    @Test
    void shouldThrowDateMismatchExceptionWhenStartAndEndAreOnDifferentDays() {
        LocalDateTime start = LocalDateTime.of(2024, 9, 10, 10, 0);
        LocalDateTime end = LocalDateTime.of(2024, 9, 11, 10, 0);

        Exception exception = assertThrows(DateMismatchException.class, () -> {
            TimeSplitter.timeDivision(start, end, 30);
        });

        assertEquals("Error: Start and end date-times are not on the same day.", exception.getMessage());
    }

    @Test
    void shouldReturnCorrectTimeRangesForValidInput() {
        LocalDateTime start = LocalDateTime.of(2024, 9, 10, 10, 0);
        LocalDateTime end = LocalDateTime.of(2024, 9, 10, 12, 0);

        List<TimeRange> result = TimeSplitter.timeDivision(start, end, 30);

        assertEquals(4, result.size());
        assertEquals(new TimeRange(LocalDateTime.of(2024, 9, 10, 10, 0),
                LocalDateTime.of(2024, 9, 10, 10, 30)), result.get(0));
        assertEquals(new TimeRange(LocalDateTime.of(2024, 9, 10, 11, 30),
                LocalDateTime.of(2024, 9, 10, 12, 0)), result.get(3));
    }

    @Test
    void shouldReturnEmptyListWhenStartAndEndAreEqual() {
        LocalDateTime start = LocalDateTime.of(2024, 9, 10, 10, 0);
        LocalDateTime end = LocalDateTime.of(2024, 9, 10, 10, 0);

        List<TimeRange> result = TimeSplitter.timeDivision(start, end, 30);

        assertTrue(result.isEmpty());
    }
}
