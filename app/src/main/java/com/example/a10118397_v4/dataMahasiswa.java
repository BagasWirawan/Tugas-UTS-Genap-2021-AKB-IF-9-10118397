package com.example.a10118397_v4;

/*nama : bagas wirawan
  nim : 10118397
  kelas : IF9
  tgl : Juni-05-2021
* */
public class dataMahasiswa {
    private  String ID;
    private  String JUDUL;
    private  String KATEGORI;
    private  String ISI;

    public dataMahasiswa(){

    }

    public dataMahasiswa(String ID, String JUDUL, String KATEGORI, String ISI){
        this.ID = ID ;
        this.JUDUL = JUDUL ;
        this.KATEGORI = KATEGORI ;
        this.ISI = ISI ;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getJUDUL() {
        return JUDUL;
    }

    public void setJUDUL(String JUDUL) {
        this.JUDUL = JUDUL;
    }

    public String getKATEGORI() {
        return KATEGORI;
    }

    public void setKATEGORI(String KATEGORI) {
        this.KATEGORI = KATEGORI;
    }

    public String getISI() {
        return ISI;
    }

    public void setISI(String ISI) {
        this.ISI = ISI;
    }
}
