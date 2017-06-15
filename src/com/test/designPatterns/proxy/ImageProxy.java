package com.test.designPatterns.proxy;

import java.awt.Component;  
import java.awt.Graphics;  
import java.net.URL;  
  
import javax.swing.Icon;  
import javax.swing.ImageIcon;  
  
//实现Icon接口  
public class ImageProxy implements Icon {  
    ImageIcon imageIcon;  
    URL imageURL;  
    Thread retrievalThread;  
    boolean retrieving = false;  
  
    // 将图片的URL传入构造器中  
    public ImageProxy(URL url) {  
        imageURL = url;  
    }  
  
    // 在图像加载完毕前，返回默认的宽和高  
    // 图像加载完毕后，装给iamgeIcon处理  
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
  
    // 当要在屏幕上绘制图像时，就调用此方法  
    public void paintIcon(final Component c, Graphics g, int x, int y) {  
        // 如果已经有了icon，就画出  
        if (imageIcon != null) {  
            imageIcon.paintIcon(c, g, x, y);  
        } else {  
            // 还没有icon时，就显示“加载中...”的消息  
            g.drawString("CD封面加载中，请稍后...", x + 300, y + 190);  
            if (!retrieving) {  
                retrieving = true;  
                  
                // 在这个线程中加载真正的icon图像。注意，加载图像和ImageIcon是同步（synchronous）  
                // 也就是说，只有在加载完之后，ImageIcon构造器才会返回。这样，我们的程序会耗在这里  
                // 所以要把加载变成异步(asynchronous)的。  
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
