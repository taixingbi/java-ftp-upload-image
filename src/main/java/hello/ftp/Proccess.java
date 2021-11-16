package hello.ftp;

public class Proccess {
    static String host = "";
    static String user = "";
    static String pwd = "";

    public static void handleFtps() throws Exception {
        String localFileFullName = "2.png";
        String remotePath = "/wonderfl/test/";
        String remoteFilename = "2.png";

        FTPSUploader FTPSUploader = new FTPSUploader(host, user, pwd);
        //ftpUploader.uploadFile("D:\\Pankaj\\images\\MyImage.png", "1.png", "/wp-content/uploads/image2/");
        FTPSUploader.uploadFile(localFileFullName, remoteFilename, remotePath);
        FTPSUploader.disconnect();
    }

    public static void handleFtp() throws Exception {
        String localFileFullName = "1.png";
        String remotePath = "/wonderfl/";
        String remoteFilename = "1.png";

        FTPSUploader FTPUploader = new FTPSUploader(host, user, pwd);
        //ftpUploader.uploadFile("D:\\Pankaj\\images\\MyImage.png", "1.png", "/wp-content/uploads/image2/");
        FTPUploader.uploadFile(localFileFullName, remoteFilename, remotePath);
        FTPUploader.disconnect();
    }
}

