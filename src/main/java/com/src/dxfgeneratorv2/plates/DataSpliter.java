package com.src.dxfgeneratorv2.plates;

public class DataSpliter {
    public String serialNumber;
    public String rotor;
    public String Q;
    public String Q_unit;
    public String Pst;
    public String motor;
    public String rpm;
    public String yearOfProduction;
    public String STOP;
    public String nr;
    public String model;
    public String Typ;
    public String Wydajnosc;
    public String Ciśnienie;
    public String Masa;
    public String Temperatura;
    public String MocSilnika;
    public String RPM;
    public String Napięcie;
    public String Prąd;
    public String Sprawność;
    public String SprawnośćRodzaj;
    public String N;
    public String N2;
    public String frequency;
    public String NormaEx;
    public String Ta_low;
    public String Ta_high;
    public String NrSeryjny;
    public String RokProdukcji;
    public String NrSprawy;
    public String Ta;

    public String companyName = "PLANETFAN sp. z o.o. sp. k.";
    public String adress = "Ul. Przemysłowa 5, 41-407 Imielin, Poland";
    public String phoneNumber = "Tel. 32 506 61 10,  32 506 61 11";
    public String emailAdress = "www.planetfan.pl;  biuro@planetfan.pl";

    public String A1Typ;
    public String A1line1;
    public String A1line2;



    /*
    public void addUnits(){
        if(this.model.charAt(0)=='W') this.Typ = "Typ Wentylatora:     " + this.Typ;
        else if(this.model.charAt(0)=='T') this.Typ = "Typ: " + this.Typ;

        this.Wydajnosc = this.Wydajnosc + " [m /s]";
        this.Ciśnienie = this.Ciśnienie + " [Pa]";

        if(this.model.equals("W")) this.Masa = this.Masa + " [kg]";
        else if(this.model.equals("T"))  this.Masa = "Ciężar:   " + this.Masa + " [kg]";
        this.Temperatura = this.Temperatura + " [°C]";
        this.MocSilnika = this.MocSilnika + " [kW]";
        this.RPM = this.RPM + " [min  ]";
        this.Napięcie = this.Napięcie + " [V]";
        this.Prąd = this.Prąd + " [A]";
        this.Sprawność = " ="+this.Sprawność + " [%]";
        this.SprawnośćRodzaj = this.SprawnośćRodzaj;
        this.N = this.N;
        this.N2 = "N="+this.N2;
        this.NrSeryjny = "No  " + this.NrSeryjny;
        this.RokProdukcji = this.RokProdukcji;
        this.NrSprawy = this.NrSprawy;
    }

     */
}
