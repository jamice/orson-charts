/* ===========
 * OrsonCharts
 * ===========
 * 
 * (C)opyright 2013 by Object Refinery Limited.
 * 
 */

package com.orsoncharts.demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import com.orsoncharts.ChartPanel3D;
import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.data.xyz.StandardXYZDataset;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;

/**
 * A test app showing resizing of the ChartBox (or plot dimensions).
 */
public class ChartBoxResizeDemo1 extends JFrame implements ChangeListener {

    Chart3D chart;

    ChartPanel3D chartPanel3D;
  
    JSlider sliderX;
  
    JSlider sliderY;
  
    JSlider sliderZ;

    /**
     * Creates a new test app.
     *
     * @param title  the frame title.
     */
    public ChartBoxResizeDemo1(String title) {
        super(title);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        getContentPane().add(createContent());
    }

    final JPanel createContent() {
        JPanel content = new JPanel(new BorderLayout());
        content.setPreferredSize(new Dimension(600, 400));
        XYZDataset dataset = new StandardXYZDataset(3, 100);
        this.chart = Chart3DFactory.createScatterPlot("ChartBoxResizeDemo1", 
                dataset, "X", "Y", "Z");
        this.chartPanel3D = new ChartPanel3D(this.chart);
        content.add(new DisplayPanel3D(this.chartPanel3D));
     
        JPanel sliderPanel = new JPanel(new FlowLayout());
        this.sliderX = new JSlider(10, 30);
        this.sliderX.addChangeListener(this);
        this.sliderY = new JSlider(10, 30);
        this.sliderY.addChangeListener(this);
        this.sliderZ = new JSlider(10, 30);
        this.sliderZ.addChangeListener(this);
        sliderPanel.add(this.sliderX);
        sliderPanel.add(this.sliderY);
        sliderPanel.add(this.sliderZ);
        content.add(sliderPanel, BorderLayout.SOUTH);
        return content;
    }

    /**
     * Starting point for the app.
     *
     * @param args  command line arguments (ignored).
     */
    public static void main(String[] args) {
        ChartBoxResizeDemo1 app = new ChartBoxResizeDemo1(
                "OrsonCharts : ChartBoxResizeDemo1.java");
        app.pack();
        app.setVisible(true);
    }

    /**
     * The user changed the value of one of the sliders, so we change the
     * plot dimensions accordingly.
     * 
     * @param e 
     */
    @Override
    public void stateChanged(ChangeEvent e) { 
        double w = this.sliderX.getValue();
        double h = this.sliderY.getValue();
        double d = this.sliderZ.getValue();
        Dimension3D dim = new Dimension3D(w, h, d);
        XYZPlot plot = (XYZPlot) this.chart.getPlot();
        plot.setDimensions(dim);
    }
}
