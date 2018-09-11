package com.journaldev.barcodevisionapi;

public class Participant {
    public String com="";
    public String cty="";
    public boolean lc1;
    public boolean lc2;
    public boolean lc3;
    public String nam="";
    public boolean pay;


    public Participant(){

    }
    public Participant(String com, String cty, boolean lc1, boolean lc2, boolean lc3, String nam, boolean pay){

        this.com = com;
        this.cty = cty;
        this.lc1 = lc1;
        this.lc2 = lc2;
        this.lc3 = lc3;
        this.nam = nam;
        this.pay = pay;

    }

    public void setCity(String x){cty=x;}

    public void setCom(String x){com=x;}


    public void setLc1(boolean x){lc1=x;}

    public void setLc2(boolean x){lc2=x;}

    public void setLc3(boolean x){lc3=x;}

    public void setNam(String x){nam=x;}

    public void setPay(boolean x){pay=x;}

    public String getCom(){return com;}
    public String getCity(){return cty;}
    public boolean getLc1(){return lc1;}
    public boolean getLc2(){return lc2;}
    public boolean getLc3(){return lc3;}
    public String getNam(){return nam;}
    public boolean getPay(){return pay;}

}
