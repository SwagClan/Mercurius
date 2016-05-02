/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lots.mercurius.stemming.updater;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JOptionPane;
import lots.mercurius.stemming.Main;

/**
 *
 * @author 11305838
 */
public class Update implements Runnable {

    private static final int MAX_BUFFER_SIZE = 1024;
    public static final String STATUSES[] = {"Downloading", "Paused",
        "Complete", "Cancelled", "Error"};
    public static final int DOWNLOADING = 0;
    public static final int PAUSED = 1;
    public static final int COMPLETE = 2;
    public static final int CANCELLED = 3;
    public static final int ERROR = 4;
    public static boolean MOET_UPDATEN = false;

    private Progres progres;
    private Main data;

    public void CheckForUpdates(Main data) {
        this.data = data;
        try {
            URL oracle = new URL("http://84.193.192.89/mercurius/downloads/mercurius.version.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
            String inputLine = in.readLine();
            in.close();
            boolean ok = false;
            System.out.println(inputLine);
            String[] web = inputLine.split(":");
            String[] app = data.VERSION.split(":");
            System.out.println("web.length " + web.length);
            int[] iweb = new int[web.length];
            int[] iapp = new int[app.length];
            for(int i = 0; i < iweb.length; i++){
                iweb[i] = Integer.parseInt(web[i]);
                System.out.println("iweb " + iweb[i]);
            }
            for(int i = 0; i < iapp.length; i++){
                iapp[i] = Integer.parseInt(app[i]);
            }
            if(iweb.length == iapp.length){
                for(int i = 0; i < iweb.length; i++){
                    System.out.println(iapp[i] + " == " + iweb[i]);
                    if(iapp[i] == iweb[i]){
                        ok = true;
                    }else{
                        ok = false;
                        break;
                    }
                }
            }
            if (!ok) {
                MOET_UPDATEN = true;
                if (JOptionPane
                        .showConfirmDialog(data,
                                "Er is een update beschikbaar, Nu updaten?",
                                "UPDATE", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE) == 0) {
                    url = new URL(
                            "http://84.193.192.89/mercurius/downloads/mercurius.jar");
                    updateNu(url);
                    progres = new Progres(data, this);
                    progres.setVisible(true);
                    progres.setAlwaysOnTop(true);
                }
            }
        } catch (MalformedURLException ex) {
            JOptionPane
                    .showMessageDialog(
                            data,
                            "Kan niet connecten naar update server \n"
                            + "Dit kan problemen geven in het gebruik van de app",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane
                    .showMessageDialog(
                            data,
                            "Kan niet connecten naar update server \n"
                            + "Dit kan problemen geven in het gebruik van de app",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private URL url;
    private int size;
    private int downloaded;
    private int status;
    private BufferedInputStream in = null;
    private FileOutputStream fout = null;

    private void updateNu(URL url) {
        this.url = url;
        size = -1;
        status = DOWNLOADING;
        downloaded = 0;
        download();
    }

    private String getUrl() {
        return url.toString();
    }

    public int getSize() {
        return size;
    }

    public float getProgress() {
        return ((float) downloaded / size) * 100;
        // return downloaded - size;
    }

    public int getStatus() {
        return status;
    }

    public void pause() {
        status = PAUSED;
    }

    public void resume() {
        status = DOWNLOADING;
        download();
    }

    public void cancel() {
        status = CANCELLED;
    }

    private void error() {
        status = ERROR;
    }

    private void download() {
        Thread thread = new Thread(this);
        thread.start();
    }

    private String getFileName(URL url) {
        String fileName = url.getFile();
        return fileName.substring(fileName.lastIndexOf("/") + 1);
    }

    private String getFileName() {
        return this.getFileName(url);
    }

    @Override
    public void run() {
        try {
            InputStream stream = url.openStream();
            in = new BufferedInputStream(stream);
            fout = new FileOutputStream(getFileName(url));
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("HEAD");
            connection.getInputStream();

            if (connection.getResponseCode() / 100 != 2) {
                error();
            }
            int contentLength = connection.getContentLength();
            if (contentLength < 1) {
                error();
            }

            if (size == -1) {
                size = contentLength;
                progres.sendProgres();
            }

            byte data[] = new byte[MAX_BUFFER_SIZE];
            while (status == DOWNLOADING) {
                int read = stream.read(data);
                if (read == -1) {
                    break;
                }
                downloaded += read;
                progres.sendProgres();
                fout.write(data, 0, read);
            }
            progres.sendProgres();
            if (status == DOWNLOADING) {
                status = COMPLETE;
                progres.sendProgres();
                JOptionPane.showMessageDialog(null, "Klaar", "UPDATE",
                        JOptionPane.INFORMATION_MESSAGE);
                progres.dispose();
                JOptionPane
                        .showMessageDialog(
                                null,
                                "Volg instucties: \n"
                                + "1) Verwijder de oude app \n"
                                + "2) verander de naam van de nieuwe app naar financi� \n"
                                + "3) Je kan werken in de geupdate vercie",
                                "ALLERT", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            error();
            progres.sendProgres();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
