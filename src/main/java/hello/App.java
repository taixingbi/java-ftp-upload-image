package hello;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("----------app start----------");

        System.out.println("Start");
        FTPUploader ftpUploader = new FTPUploader("ftp.journaldev.com", "ftpUser", "ftpPassword");
        ftpUploader.uploadFile("1.png", "1.png", "/wonderfl/");
//        ftpUploader.uploadFile("D:\\Pankaj\\images\\MyImage.png", "1.png", "/wp-content/uploads/image2/");
        ftpUploader.disconnect();
        System.out.println("----------app end----------");

    }
}
