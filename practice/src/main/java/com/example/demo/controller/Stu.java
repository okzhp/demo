package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author zhp
 * @date 2023/7/13 11:26
 **/

@Data
public class Stu {
    private String name;

//    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date time;

    private String timeStr;

    public String getTimeStr() {
        return new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss", Locale.CHINA).format(this.time);
    }
}
