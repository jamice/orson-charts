/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orsoncharts.renderer;

/**
 * A base interface for renderers.
 */
public interface Renderer3D {
    public void addChangeListener(Renderer3DChangeListener listener);
    public void removeChangeListener(Renderer3DChangeListener listener);
}
