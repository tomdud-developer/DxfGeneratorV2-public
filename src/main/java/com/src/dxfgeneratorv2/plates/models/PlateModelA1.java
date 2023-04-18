package com.src.dxfgeneratorv2.plates.models;

import com.src.dxfgeneratorv2.plates.DataSpliter;
import com.src.dxfgeneratorv2.plates.plateDrawInterface;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class PlateModelA1 extends AbstractPlate implements plateDrawInterface {

    private DataSpliter data;
    public static final double SCALE = 1;
    private final Double CENTER;
    public PlateModelA1(DataSpliter data) {
        super();
        WIDTH_BORDER = 95;
        HEIGHT_BORDER = 95;
        WIDTH = 94;
        HEIGHT = 94;

        CENTER = 95.0/2;

        this.data = data;
    }

    @Override
    public void setOffset(double x, double y){
        offX = x;
        offY = y;
    }

    @Override
    public void drawBorders(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        g.setColor(Color.BLACK);
        g.draw(new RoundRectangle2D.Double(offX, offY - HEIGHT_BORDER, WIDTH_BORDER, HEIGHT_BORDER, 2 * SCALE, 2 * SCALE));
        double d = 5.5;
        g.draw(new Ellipse2D.Double(offX + CENTER - 41 - d/2, offY - CENTER - 41 - d/2, d, d));   //left bottom
        g.draw(new Ellipse2D.Double(offX + CENTER - 41 - d/2, offY - CENTER + 41 - d/2, d, d)); //left top
        g.draw(new Ellipse2D.Double(offX + CENTER + 41 - d/2, offY - CENTER - 41 - d/2, d, d)); //right bottom
        g.draw(new Ellipse2D.Double(offX + CENTER + 41 - d/2, offY - CENTER + 41 - d/2, d, d));  //right top

        double dBig = 22.5;
        g.draw(new Ellipse2D.Double(offX + CENTER - dBig/2, offY - CENTER - dBig/2, dBig, dBig));   //center
    }

    @Override
    public void drawText(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        double x = offX;
        double y = offY - HEIGHT_BORDER;
        font = font.deriveFont((float) (7F * SCALE));
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        double typeWidth = data.A1Typ.length() * 4.35;
        double line1Width = data.A1line1.length() * 2.75;
        double line2Width = data.A1line2.length() * 2.75;

        g.drawString(data.A1Typ, (float) (x + CENTER - typeWidth/2.0), (float) (offY - 75.5) );

        font = font.deriveFont((float) (5F * SCALE));
        g.setFont(font);
        g.drawString(data.A1line1, (float) (x + CENTER - line1Width/2.0), (float) (offY - 19) );
        g.drawString(data.A1line2, (float) (x + CENTER - line2Width/2.0), (float) (offY - 12) );

        drawCE(g, x+71, y+90, 1.4);
    }

    @Override
    public void drawAll(Graphics g) {
        drawText(g);
        drawBorders(g);
    }
}
