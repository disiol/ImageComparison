package core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Denis Oleynyk on 10.10.17.
 * mail: deoniisii@gmail.com
 * 80 мин работал
 */
public class Main {
    //берет 2 изображения  сравнивает их
    //.считывает изоброжение и сохроняет его во временыйфаил
    // срвнивает по значение  его RGB  с другим рисунком
    // если разница > 10%  запоминает  кординаты и ресует надними  по дими рамочку красную
    // видет 3 изаброжение различие отмечет их на вторм , сравнивает по пиксально


    public static void main(String[] args) {
        BufferedImage img1 = null;
        try {
            img1 = ImageIO.read(new File("/media/denis/falesL/Denis/Документи/IT/Untitled Folder/прог/java/важное" +
                    "/Лекцыии/Juja_Java Professional Java Professional/Собеседования фелбек/AgileEngine/Test task/image1.png"));
            img1.createGraphics();



        } catch (IOException e) {
            e.printStackTrace();
        }


        int width = img1.getWidth();
        int height = img1.getHeight();

        int[][] arrayImg1 = new int[width][height];

        //обращение отдельно к каждому пикселю
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                arrayImg1[i][j] = img1.getRGB(i, j);
            }
        }


        BufferedImage img2 = null;
        try {
            img2 = ImageIO.read(new File("/media/denis/falesL" +
                    "/Denis/Документи/IT/Untitled Folder/прог/java/важное/Лекцыии" +
                    "/Juja_Java Professional Java Professional/Собеседования фелбек" +
                    "/AgileEngine/Test task/Comparison Requirements/src/res/image1.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }


        int width2 = img2.getWidth();
        int height2 = img2.getHeight();

        int[][] arrayImg2 = new int[width2][height2];

        //обращение отдельно к каждому пикселю
        int tmp = 0;
        for (int i = 0; i < width2; i++) {
            for (int j = 0; j < height2; j++) {
                arrayImg2[i][j] = img2.getRGB(i, j);
                System.out.print(arrayImg2[i][j] + "\t");
                tmp++;
                if (tmp ==10){
                    System.out.println();
                    tmp = 0;
                }
            }
        }



            System.out.print(Arrays.deepEquals(arrayImg1, arrayImg2));


    }



    private static void safeNewImage(BufferedImage img1) throws IOException {
        BufferedImage bi = img1;
        File outputfile = new File("saved3.png");
        ImageIO.write(bi, "png", outputfile);
    }

    private static void dowLineOnImage(BufferedImage img1) {
        Graphics2D graphics = img1.createGraphics();
        int width = img1.getWidth();
        int height = img1.getHeight();
        graphics.setColor(Color.RED);
        graphics.drawLine(0,0,width/2,height/2);
    }


}
