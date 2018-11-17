package com.ivf.ekapop.ivf_queue;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QueueAppointmentAdd extends AppCompatActivity {

    JSONArray jarrS, jarrQ, jarrP;
    JsonParser jsonparser = new JsonParser();
    String ab;
    Boolean pageLoad = false;

    QueueControl qc;

    TextView lbHn,lbPrefix,lbNameE,lbSurNameE,lbPassport,lbPID,lbDOB,lbNation, lbCou, lbProv;
    Spinner cboPrefix,cboNation,cboCou,cboProv;
    Button btnSave;
    EditText txtHn,txtNameE,txtSurNameE,txtPassport,txtPID,txtDOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue_appointment_add);

        lbHn = findViewById(R.id.lbHn);
        lbPrefix = findViewById(R.id.lbPrefix);
        lbNameE = findViewById(R.id.lbNameE);
        lbSurNameE = findViewById(R.id.lbSurNameE);
        lbPassport = findViewById(R.id.lbPassport);
        lbPID = findViewById(R.id.lbPID);
        lbNation = findViewById(R.id.lbNation);
        lbCou = findViewById(R.id.lbCou);
        lbProv = findViewById(R.id.lbProv);
        cboNation = findViewById(R.id.cboNation);
        cboPrefix = findViewById(R.id.cboPrefix);
        cboCou = findViewById(R.id.cboCou);
        cboProv = findViewById(R.id.cboProv);
        btnSave = findViewById(R.id.btnSave);
        txtHn = findViewById(R.id.txtHn);
        txtNameE = findViewById(R.id.txtNameE);
        txtSurNameE = findViewById(R.id.txtSurNameE);
        txtPassport = findViewById(R.id.txtPassport);
        txtPID = findViewById(R.id.txtPID);
        txtDOB = findViewById(R.id.txtDOB);
        //btnSave = findViewById(R.id.btnSave);
        btnSave = findViewById(R.id.btnSave);

        lbHn.setText(R.string.lbHn);
        lbPrefix.setText(R.string.lbPrefix);
        lbNameE.setText(R.string.lbNameE);
        lbSurNameE.setText(R.string.lbSurNameE);
        lbPassport.setText(R.string.lbPassport);
        lbPID.setText(R.string.lbPID);
        lbNation.setText(R.string.lbNation);
        lbCou.setText(R.string.lbCou);
        lbProv.setText(R.string.lbProv);

        new retrievePrefix().execute();
    }
    class retrievePrefix extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... arg0) {
            //Log.d("Login attempt", jobj.toString());
//            try {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("userdb",qc.userDB));
            params.add(new BasicNameValuePair("passworddb",qc.PasswordDB));
            jarrS = jsonparser.getJSONFromUrl(qc.hostGetDoctor,params);

//            } catch (JSONException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
            return ab;
        }
        @Override
        protected void onPostExecute(String ab){
            String aaa = ab;
            setCboPrefix();

        }
        @Override
        protected void onPreExecute(){
            String aaa = ab;

        }
    }
    private void setCboPrefix(){
        if(jarrS!=null){
            qc.sCboStaff.clear();
            qc.sStaff.clear();
            //JSONArray categories = jobj.getJSONArray("area");
            //JSONArray json = new JSONArray(jobj);
            try {
                for (int i = 0; i < jarrS.length(); i++) {
                    JSONObject catObj = (JSONObject) jarrS.get(i);
                    qc.sCboStaff.add(catObj.getString("prefix")+ " " + catObj.getString(qc.sf.dbFNameT)+ " " + catObj.getString(qc.sf.dbLNameT));
                    qc.sStaff.add(catObj.getString(qc.sf.dbID)+"@"+catObj.getString(qc.sf.dbCode)+"@"+catObj.getString(qc.sf.dbFNameT)+"@"+catObj.getString(qc.sf.dbLNameT)+"@"+catObj.getString("prefix"));
                }
                ArrayAdapter<String> adaStaff = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,qc.sCboStaff);
                pageLoad = true;
                cboPrefix.setAdapter(adaStaff);
                pageLoad = false;

                //imageArea.setImageResource(R.drawable.green1);
            }catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                Log.e("setCboArea ",e.getMessage());
            }
        }
    }
}
