package com.src.dxfgeneratorv2.plates.models;

import com.src.dxfgeneratorv2.plates.DataSpliter;
import com.src.dxfgeneratorv2.plates.plateDrawInterface;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;

public class PlateModelT1 extends AbstractPlate implements plateDrawInterface{

    private DataSpliter data;
    public static final double SCALE = 1;

    public PlateModelT1(DataSpliter data){
        super();
        WIDTH_BORDER = 114;
        HEIGHT_BORDER = 58;
        WIDTH = 101;
        HEIGHT = 44;

        this.data = data;

        data.Typ = "Typ: " + data.Typ;
        data.Masa = "Ciężar:  " + data.Masa + " [kg]";
        data.NrSeryjny = "No  " + data.NrSeryjny;
    }

    @Override
    public void drawBorders(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        g.setColor(Color.BLACK);
        g.draw(new RoundRectangle2D.Double(offX, offY - HEIGHT_BORDER, WIDTH_BORDER, HEIGHT_BORDER, 4 * SCALE, 4 * SCALE));
        double d = 1.5;
        g.draw(new Ellipse2D.Double(offX + 6.5 - 1.2 - d/2, offY - 8.5 + 2.8 - d/2, d, d));   //left bottom
        g.draw(new Ellipse2D.Double(offX + 6.5 - 1.2 - d/2, offY - HEIGHT_BORDER + 8.5 - 2.8 - d/2, d, d)); //left top
        g.draw(new Ellipse2D.Double(offX + WIDTH_BORDER - 6.5 + 1.2 -d/2, offY - 8.5 + 2.8 - d/2, d, d)); //right bottom
        g.draw(new Ellipse2D.Double(offX + WIDTH_BORDER - 6.5 + 1.2 -d/2, offY - HEIGHT_BORDER + 8.5 - 2.8 - d/2, d, d));  //right top
    }

    @Override
    public void drawText(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        g.setColor(Color.BLACK);

        //left bottom corner is zero point O(x,y)!
        double x = offX + 0.5 * (WIDTH_BORDER - WIDTH);
        double y = offY - 0.5 * (HEIGHT_BORDER -HEIGHT);
        RoundRectangle2D.Double border = new RoundRectangle2D.Double(x, y - HEIGHT, WIDTH, HEIGHT, 5, 5);
        g.draw(border);

        Line2D.Double line = new Line2D.Double();

        double[] linesHorizontal = {6, 12, 21, 29};
        for (int i = 0; i < linesHorizontal.length; i++) {
            line.setLine(x, y - linesHorizontal[i], x + WIDTH, y - linesHorizontal[i]);
            g.draw(line);
        }

        double[][] linesVertical = {
                {WIDTH/2, 0, WIDTH/2, 6},
                {36.8, 29, 36.8, HEIGHT}};
        for (double[] linesVertical1 : linesVertical) {
            line.setLine(x + linesVertical1[0], y - linesVertical1[1], x + linesVertical1[2], y - linesVertical1[3]);
            g.draw(line);
        }

        drawLogo(g, x - 2 - 11.5, y - HEIGHT + 3.5 - 3, 1);
        drawCE(g, x, y+10, 1.15);

        font = font.deriveFont((float) (5F * SCALE));
        g.setFont(font);
        g.drawString("TŁUMIK AKUSTYCZNY", (float) (x + 0.5*(WIDTH-50)), (float) (y - (21 + 0.5 * (8 - 3.5)) * (float) SCALE));
        g.drawString(data.Typ, (float) (x + 12.5), (float) (y - (12 + 0.5 * (9 - 3.5)) * (float) SCALE));

        font = font.deriveFont((float) (2.5F));
        g.setFont(font);
        g.drawString(data.companyName, (float) (x + 40), (float) (y - HEIGHT + 1 + 2));
        g.drawString(data.adress,      (float) (x + 40), (float) (y - HEIGHT + 1 + 2 + 1.65 + 2));
        g.drawString(data.emailAdress, (float) (x + 40), (float) (y - HEIGHT + 1 + 2 + 1.67 + 2 + 1.65 +2));
        g.drawString(data.phoneNumber, (float) (x + 40), (float) (y - HEIGHT + 1 + 2 + 1.67 + 2 + 1.67 +2 + 1.65 + 2));

        font = font.deriveFont((float) (3.5F));
        g.setFont(font);
        g.drawString(data.Masa, (float) (x + 40), (float) (y - (6 + 0.5 * (6 - 2.5)) * (float) SCALE));
        g.drawString(data.NrSeryjny, (float) (x + 6), (float) (y - (0 + 0.5 * (6 - 2.5)) * (float) SCALE));
        g.drawString(data.RokProdukcji, (float) (x + WIDTH*0.5 + 2), (float) (y - (0 + 0.5 * (6 - 2.5)) * (float) SCALE));
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
