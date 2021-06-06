package com.example.a10118397_v4;
/*nama : bagas wirawan
  nim : 10118397
  kelas : IF9
  tgl : Juni-05-2021
* */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private List<dataMahasiswa> listMahasiswa;
    private Context context;
    private SQLiteHelper helper;

    private TextView tv_judul, tv_kategori, tv_isi;

    private LinearLayout linear;
    private ImageView hapus;

    public ListViewAdapter(List<dataMahasiswa> listMahasiswa, Context context) {
        this.listMahasiswa = listMahasiswa;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listMahasiswa.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View V = LayoutInflater.from(context).inflate(R.layout.item_catatan, null);
        tv_judul = V.findViewById(R.id.tv_judul);
        tv_kategori = V.findViewById(R.id.tv_kategori);
        tv_isi = V.findViewById(R.id.tv_isi);
        linear = V.findViewById(R.id.linear);
        hapus = V.findViewById(R.id.hapus);

        helper = new SQLiteHelper(context);

        tv_judul.setText("Judul :"+ listMahasiswa.get(position).getJUDUL());
        tv_kategori.setText("Kategori :"+ listMahasiswa.get(position).getKATEGORI());
        tv_isi.setText("Isi :"+ listMahasiswa.get(position).getISI());

        linear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(context, InputActivity.class);
                intent.putExtra("ID", listMahasiswa.get(position).getID());
                intent.putExtra("JUDUL", listMahasiswa.get(position).getJUDUL());
                intent.putExtra("KATEGORI", listMahasiswa.get(position).getKATEGORI());
                intent.putExtra("ISI", listMahasiswa.get(position).getISI());
                intent.putExtra("TANDA", "Ubah");

                context.startActivity(intent);

                return true;
            }
        });


        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer isDelete = helper.deleteData(listMahasiswa.get(position).getID());
                if (isDelete > 0){
                    Toast.makeText(context,"Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context,"Data gagal dihapus", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return V;
    }
}
