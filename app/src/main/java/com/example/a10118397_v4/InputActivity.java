package com.example.a10118397_v4;
/*nama : bagas wirawan
  nim : 10118397
  kelas : IF9
  tgl : Juni-05-2021
* */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {
    private EditText et_judul,
            et_kategori,
            et_isi;
    private SQLiteHelper helper;
    private Button btn_simpan;
    private String pilih = "Tambah";
    private String id, judul, kategori, isi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_judul = findViewById (R.id.et_judul);
        et_kategori = findViewById (R.id.et_kategori);
        et_isi = findViewById (R.id.et_isi);
        btn_simpan = findViewById (R.id.btn_simpan);

        helper = new SQLiteHelper(this);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            getSupportActionBar().setTitle("Ubah Data");

            id = bundle.getString("ID");
            judul = bundle.getString("JUDUL");
            kategori = bundle.getString("KATEGORI");
            isi = bundle.getString("ISI");
            pilih = bundle.getString("TANDA");

            et_judul.setText(judul);
            et_kategori.setText(kategori);
            et_isi.setText(isi);

        } else {
            getSupportActionBar().setTitle("Tambah Data");
        }

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String judul = et_judul.getText().toString();
                String kategori = et_kategori.getText().toString();
                String isi = et_isi.getText().toString();

                if (TextUtils.isEmpty(judul)) {
                    et_judul.setError("Data Tidak Boleh Kosong");
                    et_judul.requestFocus();
                } else if (TextUtils.isEmpty(kategori)) {
                    et_kategori.setError("Data Tidak Boleh Kosong");
                    et_kategori.requestFocus();
                } else if (TextUtils.isEmpty(isi)) {
                    et_isi.setError("Data Tidak Boleh Kosong");
                    et_isi.requestFocus();
                } else {
                   if (pilih.equals("Tambah")){
                       boolean isInsert = helper.insertData(judul, kategori, isi);

                       if (isInsert) {
                           Toast.makeText(InputActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                           kosong();
                           startActivity(new Intent(InputActivity.this, MainActivity.class));
                           finish();
                       } else
                           Toast.makeText(InputActivity.this, "Data Gagal Disimpan", Toast.LENGTH_SHORT).show();
                       kosong();
                       startActivity(new Intent(InputActivity.this, MainActivity.class));
                       finish();
                   } else {
                       boolean isUpdate = helper.updateData(id,
                               judul,
                               kategori,
                               isi
                       );
                       if (isUpdate) {
                           Toast.makeText(InputActivity.this, "Data Berhasil Diubah", Toast.LENGTH_SHORT).show();
                           kosong();
                           startActivity(new Intent(InputActivity.this, MainActivity.class));
                           finish();
                       } else
                           Toast.makeText(InputActivity.this, "Data Gagal Diubah", Toast.LENGTH_SHORT).show();
                       kosong();
                       startActivity(new Intent(InputActivity.this, MainActivity.class));
                       finish();

                   }

                }
            }
        });

    }
    private void kosong() {
        et_judul.setText(null);
        et_kategori.setText(null);
        et_isi.setText(null);

    }
}