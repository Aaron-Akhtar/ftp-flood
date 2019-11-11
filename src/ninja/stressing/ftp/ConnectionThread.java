package ninja.stressing.ftp;

import org.apache.commons.net.ftp.FTPClient;

import java.util.Random;

public class ConnectionThread implements Runnable {

    private int x = 0;
    private String host;
    private int port;
    private FTPClient client = new FTPClient();
    private String abc = "abcdefghijklmnopqrstuvwxyz";

    public String genUserPass(){
        String username = "";
        String password = "";
        for (int x = 0; x < 5; x++){  //gen user
            username += abc.charAt(new Random().nextInt(abc.length()));
        }
        for (int x = 0; x < 10; x++){ //gen pass
            password += abc.charAt(new Random().nextInt(abc.length()));
        }
        return username + ":" + password;
    }

    public ConnectionThread(String host, int port){
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        while(true){
            int x = 0;
            try{
                x++;
                client.connect(host, port);
                client.setDefaultTimeout(1000);
                System.out.println("Connected " + x);
               // client.login(x.split(":")[0], x.split(":")[1]);
                Thread.sleep(500000);
                client.disconnect();
            }catch (Exception e){
                System.out.println("Err Connecting: " + e);
            }
        }
    }


}
