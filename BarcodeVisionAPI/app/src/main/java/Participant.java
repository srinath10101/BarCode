public class Participant {
    public String com="";
    public String cty="";
    public String lc1="";
    public String lc2="";
    public String lc3="";
    public String nam="";
    public String pay="";


    public Participant(){

    }
    public Participant(String com,String cty,String lc1,String lc2,String lc3,String nam,String pay){

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


    public void setLc1(String x){lc1=x;}

    public void setLc2(String x){lc2=x;}

    public void setLc3(String x){lc3=x;}

    public void setNam(String x){nam=x;}

    public void setPay(String x){pay=x;}

    public String getCom(){return com;}
    public String getCity(){return cty;}
    public String getLc1(){return lc1;}
    public String getLc2(){return lc2;}
    public String getLc3(){return lc3;}
    public String getNam(){return nam;}
    public String getPay(){return pay;}

}
