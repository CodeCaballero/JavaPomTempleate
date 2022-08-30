package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public String info(String message){
        LocalDateTime present = LocalDateTime.now();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String logDateTime = present.format(f);
        return "INFO" + ": " + logDateTime + ": " + message;
    }
}
