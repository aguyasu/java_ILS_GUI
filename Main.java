import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
<<<<<<< HEAD
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Font;


class light{
    int no;
    int intensity;
    light(int _no,int _intensity){
        no = _no;
=======
import java.io.*;
import javax.imageio.*;

class light{
    int No;
    int intensity;
    light(int _no,int _intensity){
        No = _no;
>>>>>>> 9541d4d92e333bd5312204929d0e8e3ddc6c7415
        intensity = _intensity;
    }
}

<<<<<<< HEAD
class sensor{
    int id;
    int pos;
    sensor(int _id,int _pos){
        id = _id;
        pos = _pos;
    }
    // public void get_info(sensor[] _sensor)
    // {

    //     _sensor[].id = id;
    //     _sensor[].pos = pos;
    // }

}

public class Main{
    static public void main(String args[]){
    int light_num =15;
    int sensor_num =3;
    int[] sensor_pos = new int[sensor_num];
    int i=0;
=======
public class Main{
    static public void main(String args[]){

            int i=0;

>>>>>>> 9541d4d92e333bd5312204929d0e8e3ddc6c7415
            // int init_cd = 1000;
            // int random_cd = (int)((Math.random()*1000000)%1001/10);
            // light light1 = new light(1,init_cd);
            // light light2 = new light(2,init_cd);
            // light light3 = new light(3,init_cd);
            // light light4 = new light(4,init_cd);
            // light light5 = new light(5,init_cd);
            // light light6 = new light(6,init_cd);
            // light light7 = new light(7,init_cd);
            // light light8 = new light(8,init_cd);
            // light light9 = new light(9,init_cd);
            // light light10 = new light(10,init_cd);
            // light light11 = new light(11,init_cd);
            // light light12 = new light(12,init_cd);
            // light light13 = new light(13,init_cd);
            // light light14 = new light(14,init_cd);
            // light light15 = new light(15,init_cd);

            AppCanvas canvas = new AppCanvas();//表示用のキャンパス
            Frame frame = new Frame();//表示用のFRAMEを作成
            frame.add(canvas); //frameに追加
            frame.addWindowListener(new Adapter());//リスナー指定
            frame.setSize(795,900); //サイズ設定
            frame.setVisible(true); //表示

<<<<<<< HEAD
            sensor[] sensors = new sensor[sensor_num];
            for(i=0;i<sensor_num;i++){
                sensors[i] = new sensor(i,(int)(Math.random()*10000%100));
                sensor_pos[i] = sensors[i].pos;
            }

            canvas.set_sensor_pos(sensor_pos);


=======
>>>>>>> 9541d4d92e333bd5312204929d0e8e3ddc6c7415
        while(true){
            try{
                Thread.sleep(200);
            }catch(InterruptedException e){}
            if(i >100){
                break;
            }
            canvas.repaint();
        }
    }
}

// --------------
// 表示用のキャンパス
// --------------
class AppCanvas extends Canvas{
<<<<<<< HEAD
    BufferedImage image_kc111; //ウィンドウ表示するイメージ
    BufferedImage image_20;
    BufferedImage image_100;
    BufferedImage image_light;
    BufferedImage image_sensor;
    int i =0, j=0,count=0;

    public int sensor_num = 3;
    public int light_num = 15;
    int[] sensor_pos = new int[sensor_num];


    //コンストラクタ
     AppCanvas(){
        image_kc111=loadImage("kc111.png");
        image_light=loadImage("light.png");
        image_sensor=loadImage("sensor.png");
    }
    void set_sensor_pos(int[] _pos){
        for(i=0;i<sensor_num;i++){
            sensor_pos[i] = _pos[i];
        }
=======
    BufferedImage image; //ウィンドウ表示するイメージ
    BufferedImage image_20;
    BufferedImage image_100;
    BufferedImage image_light;

    //コンストラクタ
    AppCanvas(){
        image=loadImage("kc111.png");
        image_light=loadImage("light.png");
>>>>>>> 9541d4d92e333bd5312204929d0e8e3ddc6c7415
    }

    //イメージをファイルから読み込む
    //引数 -Imageのファイル名
    //戻り値 -読み込んだイメージ
    BufferedImage loadImage(String name){
        try{
            FileInputStream in = new FileInputStream(name);//FileinputStreamを作る
            BufferedImage rv = ImageIO.read(in); // イメージを取り込む
            in.close(); //閉じる
            return rv;//戻り値に読み込んだイメージをセット
        }catch(IOException e) {
            //エラー時の処理(エラーを表示し) null を返す
            System.out.println("Err e="+e);
            return null;
        }
    }
    public void paint(Graphics g){
        int x1,x2,x3,x4,x5,x6,y1,y2,y3,y4,y5;
<<<<<<< HEAD
        int r,sensor_x,sensor_y;

=======
        int r;
>>>>>>> 9541d4d92e333bd5312204929d0e8e3ddc6c7415
        x1 = 100;
        x2 = 230;
        x3 = 360;
        x4 = 490;
        x5 = 625;
        x6 = 755;
        y1 = 90;
        y2 = 210;
        y3 = 340;
        y4 = 460;
        y5 = 580;
<<<<<<< HEAD
        int init_cd = 1000;
        int random_cd =0;

        // sensor  sensor1 = new sensor(1,10);
        // sensor  sensor2 = new sensor(2,56);
        // sensor  sensor3 = new sensor(3,78);

        sensor[] sensors = new sensor[sensor_num];

        g.drawImage(image_kc111,0,0,this);
        g.setColor(Color.ORANGE);
        int tmp_cd=0;

=======

        g.drawImage(image,0,0,this);
        g.setColor(Color.ORANGE);
        int tmp_cd=0;

        int init_cd = 1000;
        int random_cd =0;
>>>>>>> 9541d4d92e333bd5312204929d0e8e3ddc6c7415
        random_cd = (int)((Math.random()*1000000)%701)+300;
        light light1 = new light(1,random_cd);
        random_cd = (int)((Math.random()*1000000)%701)+300;
        light light2 = new light(2,random_cd);
        random_cd = (int)((Math.random()*1000000)%701)+300;
        light light3 = new light(3,random_cd);
        random_cd = (int)((Math.random()*1000000)%701)+300;
        light light4 = new light(4,random_cd);
        random_cd = (int)((Math.random()*1000000)%701)+300;
        light light5 = new light(5,random_cd);
        random_cd = (int)((Math.random()*1000000)%701)+300;
        light light6 = new light(6,random_cd);
        random_cd = (int)((Math.random()*1000000)%701)+300;
        light light7 = new light(7,random_cd);
        random_cd = (int)((Math.random()*1000000)%701)+300;
        light light8 = new light(8,random_cd);
        random_cd = (int)((Math.random()*1000000)%701)+300;
        light light9 = new light(9,random_cd);
        random_cd = (int)((Math.random()*1000000)%701)+300;
        light light10 = new light(10,random_cd);
        random_cd = (int)((Math.random()*1000000)%701)+300;
        light light11 = new light(11,random_cd);
        random_cd = (int)((Math.random()*1000000)%701)+300;
        light light12 = new light(12,random_cd);
        random_cd = (int)((Math.random()*1000000)%701)+300;
        light light13 = new light(13,random_cd);
        random_cd = (int)((Math.random()*1000000)%701)+300;
        light light14 = new light(14,random_cd);
        random_cd = (int)((Math.random()*1000000)%701)+300;
        light light15 = new light(15,random_cd);

        g.fillOval(x1-light1.intensity/10,y1-light1.intensity/10,light1.intensity/10*2,light1.intensity/10*2);
        g.fillOval(x1-light2.intensity/10,y3-light2.intensity/10,light2.intensity/10*2,light2.intensity/10*2);
        g.fillOval(x1-light3.intensity/10,y5-light3.intensity/10,light3.intensity/10*2,light3.intensity/10*2);
        g.fillOval(x2-light4.intensity/10,y2-light4.intensity/10,light4.intensity/10*2,light4.intensity/10*2);
        g.fillOval(x2-light5.intensity/10,y4-light5.intensity/10,light5.intensity/10*2,light5.intensity/10*2);
        g.fillOval(x3-light6.intensity/10,y1-light6.intensity/10,light6.intensity/10*2,light6.intensity/10*2);
        g.fillOval(x3-light7.intensity/10,y3-light7.intensity/10,light7.intensity/10*2,light7.intensity/10*2);
        g.fillOval(x3-light8.intensity/10,y5-light8.intensity/10,light8.intensity/10*2,light8.intensity/10*2);
        g.fillOval(x4-light9.intensity/10,y2-light9.intensity/10,light9.intensity/10*2,light9.intensity/10*2);
        g.fillOval(x4-light10.intensity/10,y4-light10.intensity/10,light10.intensity/10*2,light10.intensity/10*2);
        g.fillOval(x5-light11.intensity/10,y1-light11.intensity/10,light11.intensity/10*2,light11.intensity/10*2);
        g.fillOval(x5-light12.intensity/10,y3-light12.intensity/10,light12.intensity/10*2,light12.intensity/10*2);
        g.fillOval(x5-light13.intensity/10,y5-light13.intensity/10,light13.intensity/10*2,light13.intensity/10*2);
        g.fillOval(x6-light14.intensity/10,y2-light14.intensity/10,light14.intensity/10*2,light14.intensity/10*2);
        g.fillOval(x6-light15.intensity/10,y4-light15.intensity/10,light15.intensity/10*2,light15.intensity/10*2);

<<<<<<< HEAD
        // JLabel label1 = new JLabel();

        // label1.setText("hogehoge");
        // g.add(label1);


        for(int i =0;i<sensor_num;i++){
            sensor_x =39+65*(int)(sensor_pos[i]/9);
            sensor_y =40+61*(int)(sensor_pos[i]%9);
            g.drawImage(image_sensor,sensor_x,sensor_y,this);
        }

        Font f = new Font("Arial",Font.PLAIN,24);
        g.setColor(Color.BLACK);
        g.setFont(f);
        // setBackground(Color.RED);
        g.drawString("hoge",100,100);
        g.drawString("hoge",100,100);

        // sensor_x =39+65*(int)(sensor1.pos/9);
        // sensor_y =40+61*(int)(sensor1.pos%9);
        // g.drawImage(image_sensor,sensor_x,sensor_y,this);
        // sensor_x =39+65*(int)(sensor2.pos/9);
        // sensor_y =40+61*(int)(sensor2.pos%9);
        // g.drawImage(image_sensor,sensor_x,sensor_y,this);
        // sensor_x =39+65*(int)(sensor3.pos/9);
        // sensor_y =40+61*(int)(sensor3.pos%9);
        // g.drawImage(image_sensor,sensor_x,sensor_y,this);

=======
>>>>>>> 9541d4d92e333bd5312204929d0e8e3ddc6c7415
    }
}

class Adapter extends WindowAdapter {
    //右上の『×』がクリックされると呼び出される．
    public void windowClosing(WindowEvent e){
        System.exit(0);//アプリの終了
    }
}
