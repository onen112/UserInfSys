package web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCode")
public class CheckcodeServlet extends HttpServlet {
    private Graphics g;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 80;
        int height = 30;
        //1.创建一个对象（图片）
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        //2.1填充背景色
        Graphics g = img.getGraphics();//画笔对象
        g.setColor(Color.pink);//设置画笔颜色
        g.fillRect(0,0,width,height);

        //2.2画边框
        g.setColor(Color.green);
        g.drawRect(0,0,width-1,height-1);
        //2.3写字
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random r = new Random();
        g.setColor(Color.WHITE);
        String checkCode = "";
        for(int i = 0;i < 4;i++){
            checkCode += str.charAt(r.nextInt(str.length()));
        }
        request.setAttribute("checkCode",checkCode);
        g.drawString("" + checkCode.charAt(0),15,15);
        g.drawString("" + checkCode.charAt(1),30,15);
        g.drawString("" + checkCode.charAt(2),45,15);
        g.drawString("" + checkCode.charAt(3),60,15);
        //2.4 画干扰线

        g.setColor(Color.blue);
        for(int i = 0;i < 3;i++){
            int x1 = r.nextInt(width);
            int y1 = r.nextInt(height);
            int x2 = r.nextInt(width);
            int y2 = r.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }
        //3.输出到页面
        ImageIO.write(img,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
