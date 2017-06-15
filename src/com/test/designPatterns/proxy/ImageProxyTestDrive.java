package com.test.designPatterns.proxy;

import java.net.*;  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import java.util.*;  
  
public class ImageProxyTestDrive {  
      
    ImageComponent imageComponent;  
    JFrame frame = new JFrame("CD���������");  
    JMenuBar menuBar;  // �˵���  
    JMenu menu;        // �˵�  
    Hashtable cds = new Hashtable();  
   
    public static void main (String[] args) throws Exception {  
        ImageProxyTestDrive testDrive = new ImageProxyTestDrive();  
    }  
   
    public ImageProxyTestDrive() throws Exception{  
          
        // ����˵����õģ� key=CD��,  value=URL  
        cds.put("����־��Ӣ�۵�����","http://img3.douban.com/lpic/s4131026.jpg");  
        cds.put("��а����","http://img3.douban.com/lpic/s10425517.jpg");  
        cds.put("��è","http://img3.douban.com/lpic/s1668213.jpg");  
        cds.put("Once<����>","http://img3.douban.com/lpic/s2821080.jpg");  
        cds.put("̫���ճ�����","http://img3.douban.com/lpic/s4714977.jpg");  
        cds.put("����������Ӱ֮��","http://img3.douban.com/lpic/s4591642.jpg");  
        cds.put("�������","http://img3.douban.com/lpic/s2595263.jpg");  
  
        // ���ó�ʼ��CD����  
        URL initialURL = new URL((String)cds.get("Once<����>"));  
        // �����˵���  
        menuBar = new JMenuBar();  
        menu = new JMenu("���CD");  
        menuBar.add(menu);  
        frame.setJMenuBar(menuBar);  
  
        for(Enumeration e = cds.keys(); e.hasMoreElements();) {  
            String name = (String)e.nextElement();  
            JMenuItem menuItem = new JMenuItem(name);  
            menu.add(menuItem);   
            menuItem.addActionListener(new ActionListener() {  
                  public void actionPerformed(ActionEvent event) {  
                     imageComponent.setIcon(new ImageProxy(getCDUrl(event.getActionCommand())));  
                    frame.repaint();  
                  }  
            });  
        }  
          
        // set up frame and menus  
  
        Icon icon = new ImageProxy(initialURL);  
        imageComponent = new ImageComponent(icon);  
        frame.getContentPane().add(imageComponent);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setSize(800,600);  
        frame.setVisible(true);  
    }  
  
    URL getCDUrl(String name) {  
        try {  
            return new URL((String)cds.get(name));  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
}  
