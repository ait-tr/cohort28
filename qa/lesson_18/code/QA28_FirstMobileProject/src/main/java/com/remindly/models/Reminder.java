package com.remindly.models;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class Reminder {

    private  String title;
    private  String period;
    private  String month;
    private  int number;
    private  int index;
    private  String period2;
    private  String year;
    private  String timeOfDay;
    private  int XHour;
    private  int YHour;
    private  int XMin;
    private  int YMin;
    private  String repeat;
    private  double start;
    private  double stop;
    private  String typeRep;

}
