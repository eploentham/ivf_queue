package com.ivf.ekapop.ivf_queue;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class InitConfig extends AppCompatActivity {
    public QueueControl qc;

    TextView lbHostDB,lbNameDB,lbUserDB,lbPassDB,lbPortDB, lbWebDirectory, lbHostWeb, lbPortWeb;
    EditText txtHostDB,txtNameDB,txtUserDB,txtPassDB,txtPortDB,txtWebDirectory, txtHostWeb, txtPortWeb;
    Button btnIcSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_config);
        qc = (QueueControl) getIntent().getSerializableExtra("QueueControl");

        lbHostDB = findViewById(R.id.lbHostDB);
        lbNameDB = findViewById(R.id.lbNameDB);
        lbUserDB = findViewById(R.id.lbUserDB);
        lbPassDB = findViewById(R.id.lbPassDB);
        lbPortDB = findViewById(R.id.lbPortDB);
        lbWebDirectory = findViewById(R.id.lbWebDirectory);
        lbHostWeb = findViewById(R.id.lbHostWeb);
        lbPortWeb = findViewById(R.id.lbPortWeb);
        txtHostWeb = findViewById(R.id.txtHostWeb);
        txtPortWeb = findViewById(R.id.txtPortWeb);

        txtHostDB = findViewById(R.id.txtHostDB);
        txtNameDB = findViewById(R.id.txtNameDB);
        txtUserDB = findViewById(R.id.txtUserDB);
        txtPassDB = findViewById(R.id.txtPassDB);
        txtPortDB = findViewById(R.id.txtPortDB);
        txtWebDirectory = findViewById(R.id.txtWebDirectory);
        btnIcSave = findViewById(R.id.btnIcSave);

        lbHostDB.setText(R.string.lbHostDB);
        lbNameDB.setText(R.string.lbNameDB);
        lbUserDB.setText(R.string.lbUserDB);
        lbPassDB.setText(R.string.lbPassDB);
        lbPortDB.setText(R.string.lbPortDB);
        lbWebDirectory.setText(R.string.lbWebDirectory);
        lbPortWeb.setText(R.string.lbPortWeb);
        lbHostWeb.setText(R.string.lbHostWeb);
        txtHostDB.setText("");
        txtNameDB.setText("");
        txtUserDB.setText("");
        txtPassDB.setText("");
        txtPortDB.setText("");
        txtWebDirectory.setText("");

        btnIcSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveText();
            }
        });
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
            txtWebDirectory.setText(path);
//            String appPath = App.getApp().getApplicationContext().getFilesDir().getAbsolutePath();
            path = "";
            File file =getFileStreamPath(path+"initial.cnf");
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
                txtUserDB.setText(p[2].replace("userDB=","").replace("\n",""));
                txtPassDB.setText(p[3].replace("passDB=","").replace("\n",""));
                txtPortDB.setText(p[4].replace("portDB=","").replace("\n",""));
                txtWebDirectory.setText(p[5].replace("WebDirectory=","").replace("\n",""));
                txtHostWeb.setText(p[6].replace("hostWeb=","").replace("\n",""));
                txtPortWeb.setText(p[7].replace("portWeb=","").replace("\n",""));

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
    private void saveText(){
        String path = "";
        try {
            PackageInfo p = getPackageManager().getPackageInfo(getPackageName(), 0);
            path = getPackageManager().getPackageInfo(getPackageName(), 0).applicationInfo.dataDir;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("yourtag", "Error Package name not found ", e);
        }

        FileOutputStream outputStream;
        String textSize="",printOrder="",printBill="",printCloseDay="";
//        textSize = chkPrintOrder.isChecked()?"ON":"Off";
//        printOrder = chkPrintOrder.isChecked()?"ON":"Off";
//        printBill = chkPrintBill.isChecked()?"ON":"Off";
//        printCloseDay = chkPrintCloseDay.isChecked()?"ON":"Off";
//        if(cboIaTextSize.getSelectedItem().toString().contains("16")){
//            textSize="16";
//        }else if(cboIaTextSize.getSelectedItem().toString().contains("18")){
//            textSize="18";
//        }else if(cboIaTextSize.getSelectedItem().toString().contains("20")){
//            textSize="20";
//        }else if(cboIaTextSize.getSelectedItem().toString().contains("21")){
//            textSize="21";
//        }
        String string = "hostDB="+txtHostDB.getText().toString().trim()+";\n"
                +"nameDB="+txtNameDB.getText().toString().trim()+";\n"
                +"userDB="+txtUserDB.getText().toString().trim()+";\n"
                +"passDB="+txtPassDB.getText().toString().trim()+";\n"
                +"portDB="+txtPortDB.getText().toString().trim()+";\n"
                +"WebDirectory="+txtWebDirectory.getText().toString().trim()+";\n"
                +"hostWeb="+txtHostWeb.getText().toString().trim()+";\n"
                +"portWeb="+txtPortWeb.getText().toString().trim()+";\n"
                ;
        try {
            path = "";
//            File file =getFileStreamPath(path+"initial.cnf");
            outputStream = openFileOutput(path+"initial.cnf", Context.MODE_PRIVATE);
//            outputStream = openFileOutput(file.getPath(), Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
            qc.pageLoad=true;
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
