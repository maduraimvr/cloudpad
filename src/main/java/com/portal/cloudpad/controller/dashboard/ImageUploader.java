/**
 * 
 */
package com.portal.cloudpad.controller.dashboard;

import java.io.File;
import java.io.OutputStream;

import com.vaadin.server.FileResource;
import com.vaadin.ui.Image;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;

/**
 * @author Venkatraman
 *
 */
public class ImageUploader implements Receiver, SucceededListener{
    
    final Image image = new Image("Uploaded Image");
    
    public File file;


    /* (non-Javadoc)
     * @see com.vaadin.ui.Upload.SucceededListener#uploadSucceeded(com.vaadin.ui.Upload.SucceededEvent)
     */
    @Override
    public void uploadSucceeded(SucceededEvent event) {
	// TODO Auto-generated method stub
	image.setSource(new FileResource(file));
    }

    /* (non-Javadoc)
     * @see com.vaadin.ui.Upload.Receiver#receiveUpload(java.lang.String, java.lang.String)
     */
    @Override
    public OutputStream receiveUpload(String filename, String mimeType) {
	// TODO Auto-generated method stub
	return null;
    }

}
