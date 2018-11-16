package com.ivf.ekapop.ivf_queue;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;

public class QueueControl extends Application implements Serializable {
    public String HostID="", Language="",AccessMethod="",AccessMode="";
    public ArrayList<String> sCboStaff = new ArrayList<String>();

    public ArrayList<String> sStaff = new ArrayList<String>();

    public String hostIP="192.168.1.2", hostWebDirectory ="ivf/web/", hostPORT="80", UserDB="root", PasswordDB ="Ekartc2c5",TextSize="",PrnO="",PrnB="",PrnC="";

    public String hostGetStaff ="http://"+hostIP+":"+hostPORT+"/"+ hostWebDirectory +"getStaff.php";
    public String hostGetDoctor ="http://"+hostIP+":"+hostPORT+"/"+ hostWebDirectory +"getDoctor.php";
    public String hostGetDoctorQueueLast ="http://"+hostIP+":"+hostPORT+"/"+ hostWebDirectory +"getDoctorQueueLast.php";
    public String hostGetDoctorQueueFirst ="http://"+hostIP+":"+hostPORT+"/"+ hostWebDirectory +"getDoctorQueueFirst.php";
    public String hostInsertQueue ="http://"+hostIP+":"+hostPORT+"/"+ hostWebDirectory +"QueueInsert.php";
    public String hostUpdateQueueFinish ="http://"+hostIP+":"+hostPORT+"/"+ hostWebDirectory +"QueueUpdateFinish.php";

    public Staff sf;

    public QueueControl(){
        sf = new Staff();
    }

    public void refresh(){
        hostGetStaff="http://"+hostIP+":"+hostPORT+"/"+ hostWebDirectory +"getStaff.php";
    }
    private void getText(Context context){
        try {
            File file =context.getFileStreamPath("initial.cnf");
            final int READ_BLOCK_SIZE = 100;
            FileInputStream fileIn=context.openFileInput(file.getName());
//            FileInputStream fileIn=openFileInput(file.getPath());
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            InputRead.close();
            String[] p = s.split(";");
            if(p.length>0){
                Log.d("getText() length ",String.valueOf(p.length));

//                btnFrCreate.setEnabled(false);

                String hostID = p[12].length()>0 ? p[12].replace("HostID=","").replace("\n",""):"";
                String AccessMethod = p[13].length()>0 ? p[13].replace("AccessMethod=","").replace("\n",""):"";
                String language = p[14].length()>0 ? p[14].replace("Language=","").replace("\n",""):"";
                this.HostID=hostID;
                this.AccessMethod=AccessMethod;
                Log.d("getText() language ",language);
                if(language.equals("Thai")){
                    Language="Thai";
                }else if(language.equals("English")){
                    Language="English";
                }else{
                    Language="Thai";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("getText() ",e.getMessage());
        }
    }
    public void setInitial(FileOutputStream ot, String node, String data) {
        String xmlFile = "initial.xml";
        String userNAme = "username";
        String password = "password";
        try {
//            xmlFile = getResources().getAssets()+"initial.xml";
            FileOutputStream fos = new FileOutputStream("com.bangna.ekapop.bangna_queue.assets/initial.cnf");
//            ot = getApplicationContext().openFileOutput(xmlFile, Context.MODE_PRIVATE);
            XmlSerializer xmlSerializer = Xml.newSerializer();
            StringWriter writer = new StringWriter();
            xmlSerializer.setOutput(writer);
            xmlSerializer.startDocument("UTF-8", true);
            xmlSerializer.startTag(null, "Queue");
            xmlSerializer.startTag(null, node);
            xmlSerializer.text(data);
            xmlSerializer.endTag(null, node);
            xmlSerializer.endTag(null, "Queue");
            xmlSerializer.endDocument();
            xmlSerializer.flush();
            String dataWrite = writer.toString();
            ot.write(dataWrite.getBytes());
            ot.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public String getStaff(String staffName, String flag){
        String ab="";
        for(int i=0;i<sStaff.size();i++){
            String[] aa = sStaff.get(i).split("@");
            if(staffName.equals(aa[4]+" "+aa[2]+" "+aa[3])){
                if(flag.equals("code")){
                    ab = aa[1];
                }else{
                    ab = aa[0];
                }
            }
        }
        return ab;
    }
}
