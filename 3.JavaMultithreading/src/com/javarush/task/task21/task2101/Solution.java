package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {

        //System.out.print((byte) 168 &255);
//        -127, +127
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {

//        IP-адрес: 11000000 10101000 00000001 00000010 (192.168.1.2)
//        Маска подсети: 11111111 11111111 11111110 00000000 (255.255.254.0)
//        Адрес сети: 11000000 10101000 00000000 00000000 (192.168.0.0)
        byte[] res = new byte[4];

        res[0] = (byte)(ip[0] & mask[0]);
        res[1] = (byte)(ip[1] & mask[1]);
        res[2] = (byte)(ip[2] & mask[2]);
        res[3] = (byte)(ip[3] & mask[3]);

        return res;
    }

    public static void print(byte[] bytes) {

        for (int i=0; i<bytes.length; i++) {
            String bString = "";
            int num = bytes[i] & 255;
            for (int b=0; b<8; b++) {
                bString = String.valueOf(num % 2) + bString;
                num = num >> 1;
            }
            System.out.print(bString + " ");
        }
        System.out.println();
    }
}
