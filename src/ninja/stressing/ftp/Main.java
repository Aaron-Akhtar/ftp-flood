package ninja.stressing.ftp;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{

        if(args.length == 0){
            System.out.println("Please enter host and port for FTP Client (and amount of threads)");
            System.exit(0);
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);
        int threads = Integer.parseInt(args[2]);

        List<Thread> threads1 = new ArrayList<>();
        for (int x=0; x < threads; x++){
            threads1.add(new Thread(new ConnectionThread(host, port)));
        }

        for (Thread t : threads1){
            t.start();
            Thread.sleep(30);
        }


    }
}
