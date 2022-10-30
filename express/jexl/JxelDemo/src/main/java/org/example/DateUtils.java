package org.example;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.apache.commons.lang3.time.FastDateFormat;

public class DateUtils {
    public static String dateStrFormatDay(String dateStr, String format) throws ParseException {
        FastDateFormat dateFormat = FastDateFormat.getInstance(format);
        Date parse = dateFormat.parse(dateStr);
        dateFormat=FastDateFormat.getInstance("yyyyMMdd");
        return dateFormat.format(parse);
    }
}
