package com.unicorn.easygo.entity;

/**
 * Created by guojishan on 2017/6/16.
 */

public class PersonItem {
    private String option1;
    private String option2;
    public PersonItem(String option1,String option2){
        this.option1 = option1;
        this.option2 = option2;
    }
    public String getOption1(){
        return option1;
    }
    public String getOption2(){
        return option2;
    }
}
