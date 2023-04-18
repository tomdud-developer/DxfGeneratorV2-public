package com.src.dxfgeneratorv2.plates.models;

import com.src.dxfgeneratorv2.plates.DataSpliter;
import com.src.dxfgeneratorv2.plates.plateDrawInterface;

import java.awt.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;

public class PlateModelW1 extends AbstractPlate implements plateDrawInterface {

    private DataSpliter data;
    public static final double SCALE = 1;

    public PlateModelW1(DataSpliter data){
        super();
        WIDTH_BORDER = 114;
        HEIGHT_BORDER = 71;
        WIDTH = 101;
        HEIGHT = 54;

        this.data = data;

        data.Typ = "Typ Wentylatora:     " + data.Typ;
        if(data.Q_unit.equals("m3/h")) data.Wydajnosc = data.Wydajnosc + " [m /h]";
        else if(data.Q_unit.equals("m3/s")) data.Wydajnosc = data.Wydajnosc + " [m /s]";
        data.Ciśnienie = data.Ciśnienie + " [Pa]";
        data.Masa = data.Masa + " [kg]";
        data.Temperatura = data.Temperatura + " [°C]";
        data.MocSilnika = data.MocSilnika + " [kW]";
        data.RPM = data.RPM + " [min  ]";
        data.Napięcie = data.Napięcie + " [V]";
        data.Prąd = data.Prąd + " [A]";
        data.Sprawność = " ="+data.Sprawność + " [%]";
        data.SprawnośćRodzaj = data.SprawnośćRodzaj;
        data.N = data.N;
        data.N2 = "N="+data.N2;
        data.NrSeryjny = "No  " + data.NrSeryjny;
        data.RokProdukcji = data.RokProdukcji;
        data.NrSprawy = data.NrSprawy;
    }

    @Override
    public void drawBorders(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        g.setColor(Color.BLACK);
        g.draw(new RoundRectangle2D.Double(offX, offY - HEIGHT_BORDER, WIDTH_BORDER, HEIGHT_BORDER, 4 * SCALE, 4 * SCALE));
        double d = 1.5;
        g.draw(new Ellipse2D.Double(offX + 6.5 - 1.2 - d/2, offY - 8.5 + 1.2 - d/2, d, d));   //left bottom
        g.draw(new Ellipse2D.Double(offX + 6.5 - 1.2 - d/2, offY - HEIGHT_BORDER + 8.5 - 1.2 - d/2, d, d)); //left top
        g.draw(new Ellipse2D.Double(offX + WIDTH_BORDER - 6.5 + 1.2 -d/2, offY - 8.5 + 1.2 - d/2, d, d)); //right bottom
        g.draw(new Ellipse2D.Double(offX + WIDTH_BORDER - 6.5 + 1.2 -d/2, offY - HEIGHT_BORDER + 8.5 - 1.2 - d/2, d, d));  //right top
    }

    @Override
    public void drawText(Graphics g1) {

        Graphics2D g = (Graphics2D) g1;
        g.setColor(Color.BLACK);
        double x = offX + 0.5 * (WIDTH_BORDER - WIDTH);
        double y = offY - 0.5 * (HEIGHT_BORDER -HEIGHT);

        //left bottom corner is zero point O(x,y)!
        RoundRectangle2D.Double border = new RoundRectangle2D.Double(x, y - HEIGHT, WIDTH, HEIGHT, 5, 5);
        g.draw(border);
        Line2D.Double line = new Line2D.Double();
        double[] linesHorizontal = {8, 13.75, 19.5, 25.25, 31, 39};
        for (int i = 0; i < linesHorizontal.length; i++) {
            line.setLine(x, y - linesHorizontal[i], x + WIDTH, y - linesHorizontal[i]);
            g.draw(line);
        }

        double[][] linesVertical = {
                {21.8, 13.75, 21.8, 31},
                {48.3, 8, 48.3, 31},
                {72.5, 13.75, 72.5, 31},
                {36.8, 39, 36.8, HEIGHT}};
        for (double[] linesVertical1 : linesVertical) {
            line.setLine(x + linesVertical1[0], y - linesVertical1[1], x + linesVertical1[2], y - linesVertical1[3]);
            g.draw(line);
        }

        drawLogo(g, x - 2 - 11.5, y - HEIGHT + 3.5 - 3, 1);
        drawCE(g, x, y, 1.15);

        font = font.deriveFont((float) (3.5));
        g.setFont(font);

        g.drawString(data.Typ, (float) (x + 17.25), (float) (y - (31 + 0.5 * (8 - 2.5)) * (float) SCALE));

        g.drawString(data.Wydajnosc, (float) (x + 1.2), (float) (y - (25.25 + 0.5 * (5.75 - 2.5 )) * (float) SCALE));
        g.drawString(data.Ciśnienie, (float) (x + 23), (float) (y - (25.25 + 0.5 * (5.75 - 2.5 )) * (float) SCALE));
        g.drawString(data.Masa, (float) (x + 49.5), (float) (y - (25.25 + 0.5 * (5.75 - 2.5 )) * (float) SCALE));
        g.drawString(data.Temperatura, (float) (x + 73.7), (float) (y - (25.25 + 0.5 * (5.75 - 2.5 )) * (float) SCALE));

        g.drawString(data.MocSilnika, (float) (x + 1.2), (float) (y - (19.5 + 0.5 * (5.75 - 2.5 )) * (float) SCALE));
        g.drawString(data.RPM, (float) (x + 23),(float) (y - (19.5 + 0.5 * (5.75 - 2.5 )) * (float) SCALE));
        g.drawString(data.Napięcie, (float) (x + 49.5), (float) (y - (19.5 + 0.5 * (5.75 - 2.5 )) * (float) SCALE));
        g.drawString(data.Prąd, (float) (x + 73.7 * SCALE), (float) (y - (19.5 + 0.5 * (5.75 - 2.5 )) * (float) SCALE));

        drawETA(g1, (float) (x + 1), (float) (y - (13.75 + 0.5 * (5.75 - 2.5 )) * (float) SCALE));
        g.drawString(data.Sprawność, (float) (x + 1.2), (float) (y - (13.75 + 0.5 * (5.75 - 2.5 )) * (float) SCALE));
        g.drawString(data.SprawnośćRodzaj, (float) (x + 23 * SCALE), (float) (y - (13.75 + 0.5 * (5.75 - 2.5 )) * (float) SCALE));
        g.drawString(data.N2, (float) (x + 49.5 * SCALE), (float) (y - (13.75 + 0.5 * (5.75 - 2.5 )) * (float) SCALE));
        g.drawString(data.N, (float) (x + 73.7 * SCALE), (float) (y - (13.75 + 0.5 * (5.75 - 2.5 )) * (float) SCALE));

        g.drawString(data.NrSeryjny, (float) (x + 1 * SCALE), (float) (y - (8 + 0.5 * (5.75 - 2.5 )) * (float) SCALE));
        g.drawString(data.RokProdukcji, (float) (x + 49.5 * SCALE), (float) (y - (8 + 0.5 * (5.75 - 2.5 )) * (float) SCALE));

        font = font.deriveFont((float) (2.5F * SCALE));
        g.setFont(font);

        g.drawString("W obliczeniu sprawności wentylatora nie uwzględniono zastosowania", (float) (x + 0.5*(WIDTH-80)), (float) (y - 8 + 1.8 + 1.7));
        g.drawString("układu regulacji prędkości obrotowej.", (float) (x + 0.5*(WIDTH-44)), (float) (y - 1.8));

        g.drawString(data.companyName, (float) (x + 40), (float) (y - HEIGHT + 1 + 2));
        g.drawString(data.adress,      (float) (x + 40), (float) (y - HEIGHT + 1 + 2 + 1.65 + 2));
        g.drawString(data.emailAdress, (float) (x + 40), (float) (y - HEIGHT + 1 + 2 + 1.67 + 2 + 1.65 +2));
        g.drawString(data.phoneNumber, (float) (x + 40), (float) (y - HEIGHT + 1 + 2 + 1.67 + 2 + 1.67 +2 + 1.65 + 2));


        FontMetrics fm = g.getFontMetrics();
        double widthRPM = (data.RPM.length() - 8)==4 ? 1.61 * 9 : 1.61 * 8;
        g.drawString("-1", (float) (x + 23 + widthRPM + 0.8) , (float) (y - (19.5 + 1.62 + 0.5 * (5.75 - 2.5 )) * (float) SCALE));

        double widthWydajnosc = (data.Wydajnosc.length() - 4) * 1.61;
        g.drawString("3",  (float) (x + 1.2 + widthWydajnosc + 0.5), (float) (y - (25.25 + 1.62 + 0.5 * (5.75 - 2.5 )) * (float) SCALE));
    }

    @Override
    public void drawAll(Graphics g) {
        drawText(g);
        drawBorders(g);
    }


    @Override
    public void setOffset(double x, double y){
        offX = x;
        offY = y;
    }
}
