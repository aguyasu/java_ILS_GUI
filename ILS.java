import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;


class Main{
    static class ILS extends Thread{
        int light_num = 15;
        int sensor_num = 3;

        int init_cd = 800;
        int MAX_cd = 1000;
        int MIN_cd = 300;

        light[] light_list;
        light[] tmp_light_list;
        sensor[] sensor_list;

        int F=0;
        int tmp_F=0;
        int sum_penalty=0;
        int sum_cd=0;

        int tmp_cd=0;
        int ill=0;
        int i=0;
        int j=0;
        int P=0;
        int G=0;
        int w=10;

        int[][] influence = new int[99][15];

        public void run(){


            try {
                //ファイルを読み込む
                FileReader fr = new FileReader("./influence.csv");
                BufferedReader br = new BufferedReader(fr);

                //読み込んだファイルを１行ずつ処理する
                String line;
                StringTokenizer token;
                while ((line = br.readLine()) != null) {

                    //区切り文字","で分割する
                    token = new StringTokenizer(line, ",");

                    //分割した文字を画面出力する
                    while (token.hasMoreTokens()) {
                        // System.out.println(token.nextToken());
                        if((i>0)&&(j>0)){
                            influence[j][i] = Integer.parseInt(token.nextToken());
                        }
                        i = i+1;
                    }
                    i = 0;
                    // System.out.println("**********");
                    j= j +1;
                }
                //終了処理
                br.close();
            } catch (IOException ex) {
                //例外発生時処理
                ex.printStackTrace();
            }

            // (int)((Math.random()*1000000)%701)+300;   <--for random

            for(i=0;i<light_num;i++){
                light_list[i] = new light(i+1,init_cd);
                    }
            for(i=0;i<sensor_num;i++){
                sensor_list[i] = new sensor(i+1,20*(i+1)); //sensorの位置適当に決めてます．
                    }

            for(int a=0;true;a++){

                try{
                    Thread.sleep(200);
                }catch(InterruptedException e){}

                sensor_list = calc_ill(light_list,sensor_list);

                P = sum_cd(light_list);
                G = sum_penalty(sensor_list);
                tmp_F = calc_F(P,G,w);
                tmp_light_list = light_list;

                light_list = cd_change(light_list);

                sensor_list = calc_ill(light_list,sensor_list);
                P = sum_cd(light_list);
                G = sum_penalty(sensor_list);
                F = calc_F(P,G,w);

                if(tmp_F < F){
                    light_list = tmp_light_list;
                }
            }
        }

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

        sensor[] calc_ill(light[] _light,sensor[] _sensor){
            for(int j=0;j<=sensor_num;j++){
                for(i=0;i<light_num;i++){
                    _sensor[j].current =  + _light[i].intensity*influence[j+1][i];
                }
            }
            return _sensor;
        }

        int sum_cd(light[] _light){
            sum_cd = 0;
            for(i=0;i<light_num;i++){
                sum_cd = sum_cd + _light[i].intensity;
            }
            return sum_cd;
        }
        int sum_penalty(sensor[] _sensor){
            sum_penalty =0;
            for(i=0;i<sensor_num;i++){
                if(_sensor[i].current <= _sensor[i].target){
                    sum_penalty = sum_penalty +
                        (_sensor[i].target - _sensor[i].current)
                        *(_sensor[i].target - _sensor[i].current);
                }
            }
            return sum_penalty;
        }
        int calc_F(int _sum_cd,int _sum_penalty,int _w){
            F = _sum_cd + _sum_penalty * _w;
            return F;
        }

        light[] cd_change(light[] _light){
            for(i=0;i<light_num;i++){
                // _light[i].intensity = _light[i].intensity*(int)(Math.random()*1000%201-100)/10;
                _light[i].intensity = _light[i].intensity + (int)(_light[i].intensity*(Math.random()*1000%21-10)/100);
            }
            return _light;
        }

    }
    public static void main(String args[]){

        int i=0;

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
        ILS thread1 = new ILS();
        Frame frame = new Frame();//表示用のFRAMEを作成
        frame.add(canvas); //frameに追加
        frame.addWindowListener(new Adapter());//リスナー指定
        frame.setSize(795,900); //サイズ設定
        frame.setVisible(true); //表示

        // while(true){
        //     try{
        //         Thread.sleep(200);
        //     }catch(InterruptedException e){}
        //     if(i >100){
        //         break;
        //     }
        thread1.start();

        canvas.repaint();
    }
}

// --------------
// 表示用のキャンパス
// --------------
class AppCanvas extends Canvas{
    BufferedImage image; //ウィンドウ表示するイメージ
    BufferedImage image_20;
    BufferedImage image_100;
    BufferedImage image_light;

    //コンストラクタ
    AppCanvas(){
        image=loadImage("kc111.png");
        image_light=loadImage("light.png");
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
        int r;
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

        g.drawImage(image,0,0,this);
        g.setColor(Color.ORANGE);

        int tmp_cd=0;
        int init_cd = 1000;
        int random_cd =0;
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

    }
}


class light{
    int No;
    int intensity;
    light(int _no,int _intensity){
        No = _no;
        intensity = _intensity;
    }
    light(int _no){
        No = _no;
    }
}
class sensor{
    int No;
    int target;
    int current;
    int position;
    sensor(int _no){
        No = _no;
    }
    sensor(int _no,int _pos){
        No = _no;
        position = _pos;
    }
}

class Adapter extends WindowAdapter {
    //右上の『×』がクリックされると呼び出される．
    public void windowClosing(WindowEvent e){
        System.exit(0);//アプリの終了
    }
}
