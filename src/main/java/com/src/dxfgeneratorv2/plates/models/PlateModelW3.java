package com.src.dxfgeneratorv2.plates.models;

import com.src.dxfgeneratorv2.plates.DataSpliter;
import com.src.dxfgeneratorv2.plates.plateDrawInterface;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;

public class PlateModelW3 extends AbstractPlate implements plateDrawInterface {

    private DataSpliter data;
    public static final double SCALE = 1;

    public PlateModelW3(DataSpliter data) {
        super();
        WIDTH_BORDER = 90 + 15;
        HEIGHT_BORDER = 58 + 13;
        WIDTH = 90;
        HEIGHT = 58;

        this.data = data;

        data.NrSeryjny = "Nr seryjny:  " + data.NrSeryjny;
        data.Wydajnosc = "Vmax = " + data.Wydajnosc;
        if(data.Q_unit.equals("m3/h")) data.Wydajnosc = data.Wydajnosc + "[m /h]";
        else if(data.Q_unit.equals("m3/s")) data.Wydajnosc = data.Wydajnosc + "[m /s]";
        data.Ciśnienie = "PCmax = " + data.Ciśnienie + "[Pa]";
        data.motor = data.Napięcie + "V, " + data.frequency + "Hz, " + data.MocSilnika + "kW, " + data.RPM + "rpm";
        data.RokProdukcji = data.RokProdukcji + "/" + data.NrSprawy;
        data.Ta = "Ta = " + data.Ta_low + "°C  " + data.Ta_high + "°C";
    }

    @Override
    public void drawBorders(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        g.setColor(Color.BLACK);
        g.draw(new RoundRectangle2D.Double(offX, offY - HEIGHT_BORDER, WIDTH_BORDER, HEIGHT_BORDER, 4 * SCALE, 4 * SCALE));
        double d = 1.5;
        g.draw(new Ellipse2D.Double(offX + 6.5 - 1.2 - d/2, offY - 8.5 + 2.2 - d/2, d, d));   //left bottom
        g.draw(new Ellipse2D.Double(offX + 6.5 - 1.2 - d/2, offY - HEIGHT_BORDER + 8.5 - 2.2 - d/2, d, d)); //left top
        g.draw(new Ellipse2D.Double(offX + WIDTH_BORDER - 6.5 + 1.2 -d/2, offY - 8.5 + 2.2 - d/2, d, d)); //right bottom
        g.draw(new Ellipse2D.Double(offX + WIDTH_BORDER - 6.5 + 1.2 -d/2, offY - HEIGHT_BORDER + 8.5 - 2.2 - d/2, d, d));  //right top
    }

    @Override
    public void drawText(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        g.setColor(Color.BLACK);
        double x = offX + 0.5 * (WIDTH_BORDER - WIDTH);
        double y = offY - 0.5 * (HEIGHT_BORDER -HEIGHT);

        Line2D.Double line = new Line2D.Double();
        double[] linesHorizontal = {11, 27};
        for (int i = 0; i < linesHorizontal.length; i++) {
            line.setLine(x, y - linesHorizontal[i], x + WIDTH, y - linesHorizontal[i]);
            g.draw(line);
        }
        drawLogo(g, x - 2 - 11.5, y - HEIGHT + 3.5 - 3 - 5, 1.1);
        drawCE(g, x + WIDTH - 10, y - 27 - 3.6 + 33, 1.15);

        font = font.deriveFont((float) (3.5));
        g.setFont(font);

        g.drawString(data.Typ, (float) (x + 0.5 * WIDTH - 31), (float) (y - HEIGHT + 10 + 2));
        g.drawString(data.companyName, (float) (x + 1), (float) (y - HEIGHT + 17));
        g.drawString(data.adress, (float) (x + 1), (float) (y - HEIGHT + 22));
        g.drawString(data.NrSeryjny, (float) (x + 1), (float) (y - HEIGHT + 27));

        g.drawString(data.Wydajnosc, (float) (x + 1), (float)(y - 27 + 3.6 + 2.6));
        g.drawString(data.Ciśnienie, (float) (x + 1), (float)(y - 27 + 3.6 + 2.6 + 3.6 + 2.6));

        g.drawString(data.motor, (float)(x + 0.5*WIDTH - 3), (float)(y - 27 + 3.6 + 2.6));
        g.drawString(data.RokProdukcji, (float)(x + 0.5*WIDTH - 3), (float)(y - 27 + 3.6 + 2.6 + 3.6 + 2.6));

        drawEX(g,(int)x+6,(int)(y - 11*0.5 + 2.6*0.5),2.5);

        g.drawString(data.NormaEx, (float) (x + 20 - 5.5), (float) (y - 11*0.5 + 2.6*0.5 + 4.0));
        g.drawString(data.Ta, (float) (x + 60 - 4), (float) (y - 11*0.5 + 2.6*0.5));

        font = font.deriveFont((float) (2.5F * SCALE));
        g.setFont(font);
        double widthWydajnosc = (data.Wydajnosc.length() - 4) * 1.85;
        g.drawString("3",  (float) (x + 1 + widthWydajnosc + 0.5), (float)(y - 27 + 3.6 + 2.6-1.6));
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
