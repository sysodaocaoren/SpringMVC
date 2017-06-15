package com.test.designPatterns.proxy;

import java.awt.Component;  
import java.awt.Graphics;  
import java.net.URL;  
  
import javax.swing.Icon;  
import javax.swing.ImageIcon;  
  
//ʵ��Icon�ӿ�  
public class ImageProxy implements Icon {  
    ImageIcon imageIcon;  
    URL imageURL;  
    Thread retrievalThread;  
    boolean retrieving = false;  
  
    // ��ͼƬ��URL���빹������  
    public ImageProxy(URL url) {  
        imageURL = url;  
    }  
  
    // ��ͼ��������ǰ������Ĭ�ϵĿ�͸�  
    // ͼ�������Ϻ�װ��iamgeIcon����  
    public int getIconWidth() {  
        if (imageIcon != null) {  
            return imageIcon.getIconWidth();  
        } else {  
            return 800;  
        }  
    }  
      
    public int getIconHeight() {  
        if (imageIcon != null) {  
            return imageIcon.getIconHeight();  
        } else {  
            return 600;  
        }  
    }  
  
    // ��Ҫ����Ļ�ϻ���ͼ��ʱ���͵��ô˷���  
    public void paintIcon(final Component c, Graphics g, int x, int y) {  
        // ����Ѿ�����icon���ͻ���  
        if (imageIcon != null) {  
            imageIcon.paintIcon(c, g, x, y);  
        } else {  
            // ��û��iconʱ������ʾ��������...������Ϣ  
            g.drawString("CD��������У����Ժ�...", x + 300, y + 190);  
            if (!retrieving) {  
                retrieving = true;  
                  
                // ������߳��м���������iconͼ��ע�⣬����ͼ���ImageIcon��ͬ����synchronous��  
                // Ҳ����˵��ֻ���ڼ�����֮��ImageIcon�������Ż᷵�ء����������ǵĳ�����������  
                // ����Ҫ�Ѽ��ر���첽(asynchronous)�ġ�  
                retrievalThread = new Thread(new Runnable() {  
                    public void run() {  
                        try {  
                            imageIcon = new ImageIcon(imageURL, "CD Cover");  
                            c.repaint();  
                        } catch (Exception e) {  
                            e.printStackTrace();  
                        }  
                    }  
                });  
                retrievalThread.start();  
            }  
        }  
    }  
  
}  
