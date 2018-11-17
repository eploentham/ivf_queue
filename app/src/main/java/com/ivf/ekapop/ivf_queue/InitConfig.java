package com.ivf.ekapop.ivf_queue;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InitConfig extends AppCompatActivity {
    public QueueControl qc;

    TextView lbHostDB,lbNameDB,lbUserDB,lbPassDB,lbPortDB, lbWebDirectory;
    EditText txtHostDB,txtNameDB,txtUserDB,txtPassDB,txtPortDB,txtWebDirectory;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_config);

        lbHostDB = findViewById(R.id.lbHostDB);
        lbNameDB = findViewById(R.id.lbNameDB);
        lbUserDB = findViewById(R.id.lbUserDB);
        lbPassDB = findViewById(R.id.lbPassDB);
        lbPortDB = findViewById(R.id.lbPortDB);
        lbWebDirectory = findViewById(R.id.lbWebDirectory);

        txtHostDB = findViewById(R.id.txtHostDB);
        txtNameDB = findViewById(R.id.txtNameDB);
        txtUserDB = findViewById(R.id.txtUserDB);
        txtPassDB = findViewById(R.id.txtPassDB);
        txtPortDB = findViewById(R.id.txtPortDB);
        txtWebDirectory = findViewById(R.id.txtWebDirectory);
        btnSave = findViewById(R.id.btnSave);

        lbHostDB.setText(R.string.lbHostDB);
        lbNameDB.setText(R.string.lbNameDB);
        lbUserDB.setText(R.string.lbUserDB);
        lbPassDB.setText(R.string.lbPassDB);
        lbPortDB.setText(R.string.lbPortDB);
        lbWebDirectory.setText(R.string.lbWebDirectory);

        String txt = "";
//        String appPath = App.getApp().getApplicationContext().getFilesDir().getAbsolutePath();
//        txt = context.getf
//        txt = getActivity().getFilesDir();
        getText();
    }
    private void getText(){
        try {
//            PackageManager m = getPackageManager();
            String path = "";
            try {
                PackageInfo p = getPackageManager().getPackageInfo(getPackageName(), 0);
                path = getPackageManager().getPackageInfo(getPackageName(), 0).applicationInfo.dataDir;
            } catch (PackageManager.NameNotFoundException e) {
                Log.w("yourtag", "Error Package name not found ", e);
            }

            File file =getFileStreamPath(path+"/initial.cnf");
            final int READ_BLOCK_SIZE = 100;
            FileInputStream fileIn=openFileInput(path+"initial.cnf");
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
                String textSize="",printOrder="",printBill="",printCloseDay="";
                txtHostDB.setText(p[0].replace("hostDB=",""));
                txtNameDB.setText(p[1].replace("nameDB=","").replace("\n",""));
                txtUserDB.setText(p[2].replace("UserDB=","").replace("\n",""));
                txtPassDB.setText(p[3].replace("PassDB=","").replace("\n",""));
                txtPortDB.setText(p[4].replace("PortDB=","").replace("\n",""));
                txtWebDirectory.setText(p[5].replace("WebDirectory=","").replace("\n",""));

                //txtIaUserDB.setText(p[6].replace("UserDB=","").replace("\n",""));
                //txtIaPasswordDB.setText(p[7].replace("PasswordDB=","").replace("\n",""));
//                txtIaPasswordDB.setText(p[7].replace("PasswordDB=","").replace("\n",""));

//                textSize = p[8].length()>0 ? p[8].replace("TextSize=","").replace("\n",""):"";
//                printOrder = p[9].length()>0 ? p[9].replace("PrintOrder=","").replace("\n",""):"";
//                printBill = p[10].length()>0 ? p[10].replace("PrintBill=","").replace("\n",""):"";
//                printCloseDay = p[11].length()>0 ? p[11].replace("PrintCloseDay=","").replace("\n",""):"";
//                if(textSize.contains("16")){
//                    cboIaTextSize.setSelection(0);
//                }else if(textSize.contains("18")){
//                    cboIaTextSize.setSelection(1);
//                }else if(textSize.contains("20")){
//                    cboIaTextSize.setSelection(2);
//                }else if(textSize.contains("21")){
//                    cboIaTextSize.setSelection(3);
//                }
//                chkPrintOrder.setChecked(printOrder.equals("ON"));
//                chkPrintBill.setChecked(printBill.equals("ON"));
//                chkPrintCloseDay.setChecked(printCloseDay.equals("ON"));
//                qc.PrnO = printOrder;
//                qc.PrnB = printBill;
//                qc.PrnC = printCloseDay;

            }
            fileIn.close();
            //qc.refresh();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
