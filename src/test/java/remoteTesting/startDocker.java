package remoteTesting;

import org.junit.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class startDocker
{
    public void startDockerFunction() throws Exception
    {
        boolean flag=false;

        /*

        Working:
        String cmd="./docker_start.sh";
        Process p = Runtime.getRuntime().exec(cmd);
        p.waitFor(10,TimeUnit.SECONDS);

         */
        String basePath = System.getProperty("user.dir");
        String file1 ="/Users/lee/Documents/DockerValidation/output.txt";
        File f1 =new File(file1);

        if(f1.exists())
        {
            Boolean fileExistStatus = f1.delete();
            if(fileExistStatus)
                System.out.println("Old output file is deleted.");
        }

        Process p = new ProcessBuilder("./docker_start.sh").start();
        p.waitFor(10,TimeUnit.SECONDS);

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
                if (currentLine.contains("Registered a node")) {
                    System.out.println("Docker Selenium hub is running");
                    flag = true;
                    break;
                }
                currentLine = br.readLine();
            }
            br.close();
        }
        Assert.assertTrue(flag);

    }
}

