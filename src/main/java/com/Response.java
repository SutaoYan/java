package com;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Response {
    private Date date;
    private double weightedAvg;
}
