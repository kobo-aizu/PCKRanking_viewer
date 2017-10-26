package controler;

import java.util.Random;

public class Controller {
    private int[] num;

    public Controller(){
        num = new int[10];
        for(int i=0;i<10;i++){
            num[i]= new Random().nextInt(10);
            System.out.println(num[i]);
        }
    }



}
