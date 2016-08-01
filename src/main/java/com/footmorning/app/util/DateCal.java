package com.footmorning.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCal{
   
   public long date1(String date) throws ParseException{
      SimpleDateFormat t = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date resdate = t.parse(date);
      
      String now = t.format(new Date());
      Date nowdate = t.parse(now);
      
      long diff = nowdate.getTime() - resdate.getTime();
      long diffTime = (diff/(1000*60))%60;
      
      return diffTime;
   }
}