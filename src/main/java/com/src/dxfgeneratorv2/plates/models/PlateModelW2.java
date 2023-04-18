package com.src.dxfgeneratorv2.plates.models;

import com.src.dxfgeneratorv2.plates.DataSpliter;
import com.src.dxfgeneratorv2.plates.plateDrawInterface;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;

public class PlateModelW2 extends AbstractPlate implements plateDrawInterface {

    private DataSpliter data;
    public static final double SCALE = 1;

    public PlateModelW2(DataSpliter data) {
        super();
        WIDTH_BORDER = 85 + 12;
        HEIGHT_BORDER = 58 + 12;
        WIDTH = 85;
        HEIGHT = 58;

        this.data = data;

        data.NrSeryjny = "Nr seryjny:  " + data.NrSeryjny;
        data.Wydajnosc = "Q = " + data.Wydajnosc;
        if(data.Q_unit.equals("m3/h")) data.Wydajnosc = data.Wydajnosc + "[m /h]";
        else if(data.Q_unit.equals("m3/s")) data.Wydajnosc = data.Wydajnosc + "[m /s]";
        data.Ciśnienie = "Pst = " + data.Ciśnienie + "[Pa]";
        data.motor = data.Napięcie + ", " + data.MocSilnika + "kW, " + data.RPM + " rpm";
        data.RokProdukcji = data.RokProdukcji + "/" + data.NrSprawy;
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

        g.drawString(data.Typ, (float) (x + 0.5 * WIDTH), (float) (y - HEIGHT + 10));
        g.drawString(data.companyName, (float) (x + 3), (float) (y - HEIGHT + 17));
        g.drawString(data.adress, (float) (x + 3), (float) (y - HEIGHT + 22));
        g.drawString(data.NrSeryjny, (float) (x + 3), (float) (y - HEIGHT + 27));

        g.drawString(data.Wydajnosc, (float) (x + 3), (float)(y - 27 + 3.6 + 2.6));
        g.drawString(data.Ciśnienie, (float) (x + 3), (float)(y - 27 + 3.6 + 2.6 + 3.6 + 2.6));

        g.drawString(data.motor, (float)(x + 0.5*WIDTH), (float)(y - 27 + 3.6 + 2.6));
        g.drawString(data.RokProdukcji, (float)(x + 0.5*WIDTH), (float)(y - 27 + 3.6 + 2.6 + 3.6 + 2.6));

        g.drawString(data.phoneNumber, (float) (x + 0.5*(WIDTH-62)), (float) (y - 11*0.5 + 2.6*0.5));

        font = font.deriveFont((float) (2.5F * SCALE));
        g.setFont(font);
        double widthWydajnosc = (data.Wydajnosc.length() - 4) * 1.61;
        g.drawString("3",  (float) (x + 3 + widthWydajnosc + 0.5 + 0.6), (float)(y - 27 + 3.6 + 2.6-1.6));
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
