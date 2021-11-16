package hello;

import hello.ftp.Proccess;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("----------app start----------");
        Proccess.handleFtps();
//        Proccess.handleFtp();


        System.out.println("----------app end----------");
    }
}
