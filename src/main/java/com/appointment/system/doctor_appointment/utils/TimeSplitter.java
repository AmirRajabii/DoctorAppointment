package com.appointment.system.doctor_appointment.utils;

import com.appointment.system.doctor_appointment.exception.DateMismatchException;
import com.appointment.system.doctor_appointment.exception.DateTimeOrderException;
import com.appointment.system.doctor_appointment.model.dto.TimeRange;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TimeSplitter {

    public static List<TimeRange> timeDivision(LocalDateTime startDateTime, LocalDateTime endDateTime, int intervalMinute) {
        List<TimeRange> intervals = new ArrayList<>();
        LocalDateTime currentStart = startDateTime;

        if (endDateTime.isBefore(startDateTime)) {
            throw new DateTimeOrderException("Error: End time is before start time.");
        }
        if (!startDateTime.toLocalDate().equals(endDateTime.toLocalDate())) {
            throw new DateMismatchException("Error: Start and end date-times are not on the same day.");
        }
        while (currentStart.plusMinutes(intervalMinute).isBefore(endDateTime) || currentStart.plusMinutes(intervalMinute).isEqual(endDateTime)) {
            LocalDateTime currentEnd = currentStart.plusMinutes(intervalMinute);
            intervals.add(new TimeRange(currentStart, currentEnd));
            currentStart = currentEnd;
        }
        return intervals;
    }
}