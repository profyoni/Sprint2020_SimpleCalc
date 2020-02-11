package edu.touro.mco364;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

class GraphicFrame extends JFrame {

    private List<Point> pointsDrawn = new ArrayList<>();
    public GraphicFrame() {
        setSize(500, 800);
        setBackground(Color.GREEN);
        setVisible(true);

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point p = e.getPoint();
                Point lastPoint =  pointsDrawn.size() > 0 ? pointsDrawn.get(pointsDrawn.size()-1) : p;

                //System.out.println(p);
                pointsDrawn.add(p);

                Graphics g = getGraphics();
                g.drawLine( lastPoint.x, lastPoint.y, p.x, p.y);
//                g.setColor(Color.ORANGE);
//                g.fillRect( lastPoint.x, lastPoint.y, p.x, p.y);
//                g.setColor(Color.RED);
//                g.drawOval( lastPoint.x, lastPoint.y, p.x, p.y);

                g.drawString("Hello !", p.x, p.y);
            }
        });



    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        g.setColor( new Color(52, 103, 123));
        for (int i=0; i< pointsDrawn.size() - 1; i++)
        {
            g.drawLine( pointsDrawn.get(i).x, pointsDrawn.get(i).y,
                        pointsDrawn.get(i+1).x, pointsDrawn.get(i+1).y);
        }


    }

}

