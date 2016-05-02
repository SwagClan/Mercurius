/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lots.mercurius.stemming.fileHandler;

import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;
import javax.swing.JFileChooser;
import lots.mercurius.stemming.Main;

/**
 *
 * @author joris
 */
public class FileHandler {

    private Main main;

    public FileHandler(Main main) {
        this.main = main;
    }

    public void redfile() {
        try {
            System.out.println(System.getProperty("user.home") + File.separatorChar + "Documents");
            String path = System.getProperty("user.home") + File.separatorChar + "Documents" + "/Mercurius";
            File f = new File(path);
            if (f.exists() && f.isDirectory()) {
                Scanner scan = new Scanner(new File(path + "/mercurius.settings"));
                while (scan.hasNext()) {
                    String scaned = scan.nextLine();
                    if (scaned.contains("URL")) {
                        String[] args = scaned.split(":");
                        args[1] = args[1].substring(args[1].indexOf("'") + 1);
                        args[1] = args[1].substring(0, args[1].indexOf("'"));
                        System.out.println("URL = " + args[1]);
                        main.getSQLhandler().setUrl(args[1]);
                    }
                    if (scaned.contains("userName")) {
                        String[] args = scaned.split(":");
                        args[1] = args[1].substring(args[1].indexOf("'") + 1);
                        args[1] = args[1].substring(0, args[1].indexOf("'"));
                        System.out.println("username = " + args[1]);
                        main.getSQLhandler().setUsername(args[1]);
                    }
                    if (scaned.contains("pass")) {
                        String[] args = scaned.split(":");
                        args[1] = args[1].substring(args[1].indexOf("'") + 1);
                        args[1] = args[1].substring(0, args[1].indexOf("'"));
                        main.getSQLhandler().setPasswoord(args[1]);
                        System.out.println("passwoord = " + args[1]);
                    }
                }
            } else {
                if(!f.exists()){
                    f.mkdirs();
                }
                Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f + "/mercurius.settings")));
                String content
                        = "URL: ''\n"
                        + "userName: ''\n"
                        + "pass: ''";
                w.write(content);
                w.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
