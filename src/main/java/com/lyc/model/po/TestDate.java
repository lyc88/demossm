package com.lyc.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Properties;

/**
 * Created by lyc on 2017/12/3.
 * email 984006207@qq.com
 */
public class TestDate {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date b;
    private String name;


    public Date getB() {
        return b;
    }

    public void setB(Date b) {
        this.b = b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName1() {
        return name+"1222";
    }
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TestDate testDate = new TestDate();

        testDate.setB(new Date());
        testDate.setName("helll");

        F f = new F();

        H h =new H();
      // org.springframework.beans.BeanUtils.copyProperties(testDate,f);

       org.apache.commons.beanutils.BeanUtils.copyProperties(h,testDate);
        System.out.println(h);
        org.apache.commons.beanutils.BeanUtils.copyProperties(f,testDate);
       // org.apache.commons.beanutils.BeanUtils.copyProperty(f,"name",testDate);

    }
}
class F{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "H{" +
                "name='" + name + '\'' +
                '}';
    }

}