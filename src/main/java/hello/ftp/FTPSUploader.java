package hello.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;

public class FTPSUploader {
    String protocol = "SSL"; // SSL/TLS
    FTPSClient ftps = null;

    public FTPSUploader(String host, String user, String pwd) throws Exception{
        ftps = new FTPSClient(protocol);

        ftps.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        int reply;
        ftps.connect(host);
        reply = ftps.getReplyCode();

        if (!FTPReply.isPositiveCompletion(reply)) {
            ftps.disconnect();
            throw new Exception("Exception in connecting to FTP Server");
        }
        ftps.login(user, pwd);
        ftps.setFileType(FTP.BINARY_FILE_TYPE);
        ftps.enterLocalPassiveMode();
    }

    public void uploadFile(String localFileFullName, String fileName, String hostDir)
            throws Exception {
        try(InputStream input = new FileInputStream(new File(localFileFullName))){
            this.ftps.storeFile(hostDir + fileName, input);
        }
    }

    public void disconnect(){
        if (this.ftps.isConnected()) {
            try {
                this.ftps.logout();
                this.ftps.disconnect();
            } catch (IOException f) {
                // do nothing as file is already saved to server
            }
        }
    }
}
