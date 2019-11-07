package remoteTesting;

import org.junit.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class stopDocker
{
    public void stopDockerFunction() throws InterruptedException, IOException {
        boolean flag=false;

        /*

        Working:
        String cmd="./docker_start.sh";
        Process p = Runtime.getRuntime().exec(cmd);
        p.waitFor(10,TimeUnit.SECONDS);

         */

        Process p = new ProcessBuilder("./docker_stop.sh").start();
        p.waitFor(25,TimeUnit.SECONDS);

        String basePath = System.getProperty("user.dir");
        String file1 ="output.txt";
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND,45);
        long stopNow = cal.getTimeInMillis();

        while(System.currentTimeMillis()<stopNow)
        {
            if(flag)
            {
                break;
            }
            BufferedReader br = new BufferedReader(new FileReader(file1));
            String currentLine = br.readLine();
            while (currentLine != null)
            {
                if (currentLine.contains("selenium-hub exited with code 143")) {
                    System.out.println("Docker Selenium hub is stopped");
                    flag = true;
                    break;
                }
                currentLine = br.readLine();
            }
            br.close();
        }
        Assert.assertTrue(flag);

        File f2 = new File(file1);
        Boolean fileDeleteStatus = f2.delete();
        if(fileDeleteStatus)
        {
            System.out.println("Output File is deleted.");
        }
    }
}
