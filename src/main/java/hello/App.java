package hello;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("----------app start----------");

        String host = "ftp.journaldev.com";
        String user = "ftpUser";
        String pwd = "ftpPassword";

        FTPUploader ftpUploader = new FTPUploader(host, user, pwd);
        ftpUploader.uploadFile("1.png", "1.png", "/wonderfl/");
//        ftpUploader.uploadFile("D:\\Pankaj\\images\\MyImage.png", "1.png", "/wp-content/uploads/image2/");
        ftpUploader.disconnect();
        System.out.println("----------app end----------");

    }
}
