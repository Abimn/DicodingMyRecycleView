package com.blogspot.abimcode.dicodingmyrecycleview;

import java.util.ArrayList;

/**
 * Created by Abimanyu on 4/20/18.
 */

// TODO 3 ini adalah dataset, yaitu data yang dimiliki dan akan ditampilkan pada RecycerView. ( Setelah ini tambah class baru model data dengan nama President )
public class PresidenData {
    public static String[][] data = new String[][]{
            {"Soekarno", "Presiden Pertama RI", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Presiden_Sukarno.jpg/418px-Presiden_Sukarno.jpg"},
            {"Soeharto", "Presiden Kedua RI", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/President_Suharto%2C_1993.jpg/468px-President_Suharto%2C_1993.jpg"},
            {"Bacharuddin Jusuf Habibie", "Presiden Ketiga RI", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Bacharuddin_Jusuf_Habibie_official_portrait.jpg/520px-Bacharuddin_Jusuf_Habibie_official_portrait.jpg"},
            {"Abdurrahman Wahid", "Presiden Keempat RI", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/President_Abdurrahman_Wahid_-_Indonesia.jpg/486px-President_Abdurrahman_Wahid_-_Indonesia.jpg"},
            {"Megawati Soekarnoputri", "Presiden Kelima RI", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/President_Megawati_Sukarnoputri_-_Indonesia.jpg/540px-President_Megawati_Sukarnoputri_-_Indonesia.jpg"},
            {"Susilo Bambang Yudhoyono", "Presiden Keenam RI", "https://upload.wikimedia.org/wikipedia/commons/5/58/Presiden_Susilo_Bambang_Yudhoyono.png"},
            {"Joko Widodo", "Presiden Ketujuh RI", "https://upload.wikimedia.org/wikipedia/commons/1/1c/Joko_Widodo_2014_official_portrait.jpg"}
    };


    // ArrayList dapat menambah data baru secara dinamis tanpa harus menentukan ukuran awal.
    public static ArrayList<President> getListData() {
        President president = null;
        ArrayList<President> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            president = new President();
            president.setName(data[i][0]);
            president.setRemarks(data[i][1]);
            president.setPhoto(data[i][2]);

            list.add(president);
        }

        return list;
    }

}

    /* Beberapa operasi yang terdapat pada ArrayList :

    size(), untuk mencari panjang ArrayList
    add(), untuk menambah elemen baru
    get(), untuk mengambil elemen pada indeks tertentu
    isEmpty(), untuk memeriksa apakah ArrayList kosong atau tidak
    indexOf(), untuk mengetahui indeks dari suatu nilai
    contains(), untuk memeriksa apakah suatu nilai ada dalam ArrayList
    set(), untuk menimpa nilai pada indeks tertentu
    remove(), untuk menghapus nilai pada indeks tertentu

    */
