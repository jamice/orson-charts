/* ============
 * Orson Charts
 * ============
 * 
 * (C)opyright 2013, 2014, by Object Refinery Limited.
 * 
 * http://www.object-refinery.com/orsoncharts/index.html
 * 
 * Redistribution of these source files is prohibited.
 * 
 */

package com.orsoncharts.graphics3d.swing;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * A file filter for PDF files.
 */
public class PDFFileFilter extends FileFilter {
  
    /**
     * Default constructor.
     */
    public PDFFileFilter() {
        super();
    }

    /**
     * Returns <code>true</code> if the file name has a ".pdf" suffix, and 
     * <code>false</code> otherwise.
     * 
     * @param f  the file (<code>null</code> not permitted).
     * 
     * @return A boolean. 
     */
    @Override
    public boolean accept(File f) {
      if (f.getName().endsWith(".pdf")) {
        return true;
      }
      return false;
    }

    /**
     * Returns the string "Portable Document Format (PDF)".
     * 
     * @return The string "Portable Document Format (PDF)".
     */
    @Override
    public String getDescription() {
        return "Portable Document Format (PDF)";
    }
}
