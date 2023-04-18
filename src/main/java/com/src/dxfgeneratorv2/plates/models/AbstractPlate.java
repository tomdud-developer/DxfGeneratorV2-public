package com.src.dxfgeneratorv2.plates.models;

import com.src.dxfgeneratorv2.plates.plateDrawInterface;

import java.awt.*;
import java.awt.geom.*;
import java.io.File;

public abstract class AbstractPlate implements plateDrawInterface {

    public int WIDTH;
    public int HEIGHT;
    public int WIDTH_BORDER;
    public int HEIGHT_BORDER;
    public double offX;
    public double offY;

    private File root;

    //public File fileFont = new File(".\\src\\main\\resources\\GOST type B.ttf");
    //public File fileXirod = new File(".\\src\\main\\resources\\xirod.ttf");
    //public File fileXirodOrg = new File(".\\src\\main\\resources\\xirod8.ttf");

    public File fileFont = new File(File.separator+"home" + File.separator+ "cnc" + File.separator+ "Pulpit" +File.separator+ "programFiles"+File.separator+"GOST type B.ttf");
    public File fileXirod = new File(File.separator+"home" + File.separator+ "cnc" + File.separator+ "Pulpit" +File.separator+ "programFiles"+File.separator+"xirod.ttf");
    public File fileXirodOrg = new File(File.separator+"home" + File.separator+ "cnc" + File.separator+ "Pulpit" +File.separator+ "programFiles"+File.separator+"xirod8.ttf");

    public Font font;
    public Font xirodFont;
    public Font xirodFontOrg;

    public AbstractPlate(){

        try {
           //root = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI());
          //  fileFont = new File(Thread.currentThread().getContextClassLoader().getResource(File.separator+"GOST type B.ttf").toURI());
         //   fileXirod = new File(Thread.currentThread().getContextClassLoader().getResource(File.separator+"xirod.ttf").toURI());
            font = Font.createFont(Font.TRUETYPE_FONT, fileFont);
            xirodFont = Font.createFont(Font.TRUETYPE_FONT, fileXirod);
            xirodFontOrg = Font.createFont(Font.TRUETYPE_FONT, fileXirodOrg);
        } catch (Exception e) {
            System.out.println("Problem with Font: " + e.toString());
        }

    }
    public abstract void setOffset(double x, double y);

    public void drawXirodPlanetfan(Graphics g, double offsetX, double offsetY, double scale) {
        Graphics2D g2d = (Graphics2D) g;

        xirodFont = xirodFont.deriveFont((float) (4F * scale));
        g2d.setFont(xirodFont);

        double x = offsetX + 14 * scale;
        double y = offsetY + 9 * scale;

        g2d.drawString("planetfan", (float) (x + 1), (float) (y));
        g2d.setStroke(new BasicStroke(0.2F));

        Arc2D.Double arc1 = new Arc2D.Double(new Rectangle2D.Double(x - 9.3308 * scale, y - 5.0914 * scale, 8.0939 * 2 * scale, 6.4123 * scale), 40 + 90, 360 - 158, Arc2D.OPEN);
        Path2D.Double path = new Path2D.Double();
        path.append(arc1, false);
        AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(12), x - 1.2369 * scale, y - 1.8852 * scale);
        path.transform(at);

        Arc2D.Double arc2 = new Arc2D.Double(new Rectangle2D.Double(x - 8.2848 * scale, y - 5.0824 * scale, 8.1161 * 2 * scale, 5.9609 * scale), 180 - 40, 360 - 173, Arc2D.OPEN);
        Path2D.Double path2 = new Path2D.Double();
        path2.append(arc2, false);
        AffineTransform at2 = AffineTransform.getRotateInstance(Math.toRadians(12), x - 0.1697 * scale, y - 2.1136 * scale);
        path2.transform(at2);

        Arc2D.Double arc3 = new Arc2D.Double(new Rectangle2D.Double(x - 4.2409 * scale, y - 8.0045 * scale, 6.8103 * 2 * scale, 6.8103 * 2 * scale), 51, 136, Arc2D.OPEN);
        Arc2D.Double arc4 = new Arc2D.Double(new Rectangle2D.Double(x - 4.2409 * scale, y - 8.0045 * scale, 6.8103 * 2 * scale, 6.8103 * 2 * scale), 180 + 17, 112, Arc2D.OPEN);

        Arc2D.Double arc5 = new Arc2D.Double(new Rectangle2D.Double(x - 5.5912 * scale, y - 8.5442 * scale, 7.35 * 2 * scale, 7.35 * 2 * scale), 46, 136, Arc2D.OPEN);
        Arc2D.Double arc6 = new Arc2D.Double(new Rectangle2D.Double(x - 5.5912 * scale, y - 8.5442 * scale, 7.35 * 2 * scale, 7.35 * 2 * scale), 180 + 12, 122, Arc2D.OPEN);

        Line2D.Double line1 = new Line2D.Double(x - 5.5890 * scale, y - 1.0131 * scale, x - 4.1889 * scale, y - 0.3539 * scale);
        Line2D.Double line2 = new Line2D.Double(x - 5.54516 * scale, y + 0.2315 * scale, x - 3.9428 * scale, y + 0.7988 * scale);

        Path2D.Double path3 = new Path2D.Double();

        path3.append(arc3, false);
        path3.append(arc4, false);
        path3.append(arc5, false);
        path3.append(arc6, false);
        path3.append(line1, false);
        path3.append(line2, false);

        g2d.draw(path);
        g2d.draw(path2);
        g2d.draw(path3);

        Ellipse2D.Double rCircle = new Ellipse2D.Double(x + 45 * scale, y - 8 * scale, 2.5 * scale, 2.5 * scale);
        g2d.draw(rCircle);

        font = font.deriveFont((float) (2F * scale));
        g.setFont(font);
        g2d.drawString("R", (float) (x + 46 * scale), (float) (y - 6.0 * scale));
    }

    public void drawLogo(Graphics g, double offsetX, double offsetY, double scale) {
        Graphics2D g2d = (Graphics2D) g;
        xirodFontOrg = xirodFontOrg.deriveFont((float) (4F * scale));
        g2d.setFont(xirodFontOrg);

        double x = offsetX + 14 * scale;
        double y = offsetY + 9 * scale;

        g2d.drawString("planetfN", (float) (x + 1), (float) (y));
        g2d.setStroke(new BasicStroke(0.2F));
    }

    public void drawCE(Graphics g1, double x, double y, double scale) {

        double offsetX = x + 2 * scale;
        double d = 5;
        double offsetY = y - (34 - ((7 - d) / 2)) * scale;

        Graphics2D g = (Graphics2D) g1;

        g.draw(new Arc2D.Double(offsetX + 0 * scale, offsetY + 0 * scale, d * scale, d * scale, 90, 180, Arc2D.OPEN));
        g.draw(new Arc2D.Double(offsetX + d * scale, offsetY + 0 * scale, d * scale, d * scale, 90, 180, Arc2D.OPEN));
        g.draw(new Line2D.Double(offsetX + (d) * scale, offsetY + (d / 2) * scale, offsetX + (d + 2) * scale, offsetY + (+d / 2) * scale));
    }

    public void drawETA(Graphics g1, double x, double y){
        y += - 2.5;
        Graphics2D g = (Graphics2D) g1;
        g.draw(new Line2D.Double(x,y,x,y+1.5));
        g.draw(new Line2D.Double(x+1.2,y+0.75,x+1.2,y+3));
        g.draw(new Arc2D.Double(x, y, 1.2, 1.2, 0, 180, Arc2D.OPEN));
    }

    public void drawEX(Graphics g, int offsetX, int offsetY, double scale) {
        g.setColor(Color.BLACK);
        Graphics2D g2d = (Graphics2D) g;

        double x = offsetX;
        double y = offsetY;
        double r = 2.5 * scale;
        double a = 2 * r;
        double r2 = r * 0.88;
        r = r * (1 - 0.12 / 2);

        for (int i = 0; i <= 6; i++) {
            Line2D.Double line = new Line2D.Double(x + r * Math.cos(2 * Math.PI * i / 6), y + r * Math.sin(i * 2 * Math.PI / 6), x + r * Math.cos(2 * Math.PI * (i + 1) / 6), y + r * Math.sin((i + 1) * 2 * Math.PI / 6));
            g2d.draw(line);
        }

        Arc2D.Double arc = new Arc2D.Double(new Rectangle2D.Double(x - 0.27 * a, y - 0.24 * a, 0.24 * a, 0.24 * a), 45, 225, Arc2D.OPEN);  // łuk górny e
        g2d.draw(arc);

        arc = new Arc2D.Double(new Rectangle2D.Double(x - 0.27 * a, y + 0 * a, 0.24 * a, 0.24 * a), 90, 225, Arc2D.OPEN);  // łuk dolny e
        g2d.draw(arc);

        Line2D.Double line = new Line2D.Double(x - 0.15 * a, y + 0 * a, x - 0.09 * a, y + 0 * a); //linia poziomowa e
        g2d.draw(line);

        arc = new Arc2D.Double(new Rectangle2D.Double(x - (-0.01 + 0.09) * a, y + 0 * a, 0.09 * 2 * a, 0.09 * 2 * a), 25, 65, Arc2D.OPEN);  // łuk górny lewy x
        g2d.draw(arc);

        arc = new Arc2D.Double(new Rectangle2D.Double(x - (-0.01 + 0.09 - 0.23) * a, y + 0 * a, 0.09 * 2 * a, 0.09 * 2 * a), 90, 65, Arc2D.OPEN);  // łuk górny prawy e , przesunięty o 0.23
        g2d.draw(arc);

        arc = new Arc2D.Double(new Rectangle2D.Double(x - (-0.01 + 0.09) * a, y + 0.06 * a, 0.09 * 2 * a, 0.09 * 2 * a), 270, 65, Arc2D.OPEN);  // łuk dolny lewy x, x zostaje, y przesuniety o 0.06
        g2d.draw(arc);

        arc = new Arc2D.Double(new Rectangle2D.Double(x - (-0.01 + 0.09 - 0.23) * a, y + 0.06 * a, 0.09 * 2 * a, 0.09 * 2 * a), 180 + 25, 65, Arc2D.OPEN);  // łuk dolny prawy x, y przesuniety o 0.23
        g2d.draw(arc);

        line = new Line2D.Double(x + 0.092 * a, y + 0.05 * a, x + (0.24 - 0.078) * a, y + (0.09 + 0.06 + 0.04) * a); //linia 1
        g2d.draw(line);

        line = new Line2D.Double(x + (0.24 - 0.078) * a, y + 0.05 * a, x + 0.092 * a, y + (0.09 + 0.06 + 0.04) * a); //linia 2
        g2d.draw(line);
    }

}
