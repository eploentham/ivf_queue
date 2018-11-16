package com.ivf.ekapop.ivf_queue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class QueueAppointmentAdd extends AppCompatActivity {

    TextView lbHn,lbPrefix,lbNameE,lbSurNameE,lbPassport,lbPID,lbDOB,lbNation;

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
        //imageStaff = findViewById(R.id.imageStaff);
    }
}
