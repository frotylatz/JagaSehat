package com.oop.android.jagasehat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DemografiActivity extends AppCompatActivity {

    private Button btnSubmit;
    private EditText etUsia, etEmail;
    private RadioGroup jk;
    private Spinner spinEdu, spinJob;
    private String stringUsia, stringJk, stringEmail, stringEdu, stringJob;

    DatabaseReference databaseDemografi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demografi);

        databaseDemografi = FirebaseDatabase.getInstance().getReference("data");

        jk = (RadioGroup) findViewById(R.id.radio);
        etUsia = (EditText) findViewById(R.id.inputUsia);
        etEmail = (EditText) findViewById(R.id.inputEmail);

        spinEdu = (Spinner) findViewById(R.id.pend);



        // Initializing a String Array
        String[] pendidikan = new String[]{
                "SD",
                "SMP",
                "SMA",
                "Perguruan Tinggi",
        };
        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(
                this,R.layout.spinner_item,pendidikan
        );
        spinnerArrayAdapter1.setDropDownViewResource(R.layout.spinner_item);
        spinEdu.setAdapter(spinnerArrayAdapter1);

        spinJob = (Spinner) findViewById(R.id.kerja);
        // Initializing a String Array
        String[] pekerjaan = new String[]{
                "PNS/TNI/POLRI",
                "Pegawai Swasta",
                "Wiraswasta",
                "Mahasiswa",
                "Pelajar",
                "Lainnya"
        };
        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(
                this,R.layout.spinner_item,pekerjaan
        );
        spinnerArrayAdapter2.setDropDownViewResource(R.layout.spinner_item);
        spinJob.setAdapter(spinnerArrayAdapter2);

        btnSubmit = (Button) findViewById(R.id.submitButton);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    public boolean validate(){
        boolean valid = true;
        if (stringEmail.isEmpty()) {
            etEmail.setError("Masukkan email anda!");
            etEmail.requestFocus();
            valid = false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(stringEmail).matches()) {
            etEmail.setError("Email tidak valid!");
            etEmail.requestFocus();
            valid = false;
        }

        if(stringUsia.isEmpty()){
            etUsia.setError("Masukkan usia anda!");
            etUsia.requestFocus();
            valid = false;
        }

        return valid;
    }

    private void initialize(){
        int radioButtonID = jk.getCheckedRadioButtonId();
        View radioButton = jk.findViewById(radioButtonID);
        int idx = jk.indexOfChild(radioButton);

        RadioButton r = (RadioButton) jk.getChildAt(idx);
        stringJk = r.getText().toString();
        stringUsia = etUsia.getText().toString();
        stringEmail = etEmail.getText().toString();
        stringEdu = spinEdu.getSelectedItem().toString();
        stringJob = spinJob.getSelectedItem().toString();
    }

    private void register(){
        initialize(); //inisiasi variabel ke dalam string
        if(!validate()){
            Toast.makeText(this, "Submit gagal!", Toast.LENGTH_SHORT).show();
        }
        else{
            onSubmitSuccess();
        }
    }
    private void onSubmitSuccess(){
        String id = databaseDemografi.push().getKey();

        Demografi demografi = new Demografi(stringJk, stringUsia, stringEdu, stringJob, stringEmail);

        databaseDemografi.child(id).setValue(demografi);
        Toast.makeText(this, "Data telah diinput", Toast.LENGTH_SHORT).show();


        Intent intent = new Intent(DemografiActivity.this,
                MainActivity.class);
        startActivity(intent);
        DemografiActivity.this.finish();
    }
}




