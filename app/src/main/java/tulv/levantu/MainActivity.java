package tulv.levantu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvContact;
    EditText edtId, edtName;
    Spinner spinAddress;
    CheckBox cbFilm,cbSport,cbEat;
    RadioButton rdMale,rdFemale;

    ContactModel contactModel;
    ArrayList<Contact> arrayList = new ArrayList<>();
    ArrayList<String> arrAdress;
    ArrayList<String> arrayListString;
    ArrayAdapter<String> arrayAdapter;
    ArrayAdapter<String> arrayAdapterSpin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactModel = new ContactModel(this);
        getWidget();
        getData();
        setEvent();
    }

    public void getData() {
        arrAdress=new ArrayList<>();
        arrAdress.add("Hung Yen");
        arrAdress.add("Ha Noi");
        arrAdress.add("Thai Binh");
        arrayList = contactModel.getList();
        arrayListString = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            String s=arrayList.get(i).getmId() + "-" + arrayList.get(i).getmName()+ "-" + arrayList.get(i).getmAddress()+ "-" + arrayList.get(i).getmHobby()+ "-" + arrayList.get(i).getmSex();
            arrayListString.add(s);
        }
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListString);
        lvContact.setAdapter(arrayAdapter);

        arrayAdapterSpin=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,arrAdress);

        //phải gọi lệnh này để hiển thị danh sách cho Spinner
        arrayAdapterSpin.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        //Thiết lập adapter cho Spinner
        spinAddress.setAdapter(arrayAdapterSpin);
    }

    public void setEvent(){
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtName.setText(arrayList.get(i).getmName());
                edtId.setText(arrayList.get(i).getmId()+"");
            }
        });
    }

    public void getWidget() {
        edtName = (EditText) findViewById(R.id.edt_name);
        edtId = (EditText) findViewById(R.id.edt_id);
        lvContact = (ListView) findViewById(R.id.lv_contact);
        spinAddress=(Spinner)findViewById(R.id.spin_address);
        cbFilm=(CheckBox)findViewById(R.id.cb_film);
        cbSport=(CheckBox)findViewById(R.id.cb_sport);
        cbEat=(CheckBox)findViewById(R.id.cb_eat);
        rdFemale=(RadioButton)findViewById(R.id.rd_female);
        rdMale=(RadioButton)findViewById(R.id.rd_male);
    }

    public void add(View v) {
        String name = edtName.getText().toString();
        int id =Integer.parseInt(edtId.getText().toString());
        String hobby="";
        String sex="";
        if (rdFemale.isChecked()){
            sex="Female";
        }else {
            sex="Male";
        }
       if (cbFilm.isChecked()){
            hobby+=" film";
        }
        if (cbSport.isChecked()){
            hobby+=" sport";
        }
        if (cbEat.isChecked()){
            hobby+=" eat";
        }
        String address = spinAddress.getSelectedItem().toString();
        Contact s = new Contact(id, name,hobby,sex, address);
        Boolean b = contactModel.Add(s);
        if (b == false) {
            Toast.makeText(MainActivity.this, "This contact is exist", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "add successful", Toast.LENGTH_SHORT).show();
            arrayAdapter.notifyDataSetChanged();
            getData();
        }
    }
    public void update(View v) {
        String name = edtName.getText().toString();
        int id =Integer.parseInt(edtId.getText().toString());
        String hobby="";
        String sex="";
        if (rdFemale.isChecked()){
            sex="Female";
        }else {
            sex="Male";
        }
        if (cbFilm.isChecked()){
            hobby+=" film";
        }
        if (cbSport.isChecked()){
            hobby+=" sport";
        }
        if (cbEat.isChecked()){
            hobby+=" eat";
        }
        String address = spinAddress.getSelectedItem().toString();
        Contact s = new Contact(id, name,hobby,sex,address);
        Boolean b = contactModel.Update(s);
        if (b == false) {
            Toast.makeText(MainActivity.this, "false", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "update successful", Toast.LENGTH_SHORT).show();
            arrayAdapter.notifyDataSetChanged();
            getData();
        }

    }
    public void delete(View v) {
        int id =Integer.parseInt(edtId.getText().toString());
        Boolean b = contactModel.Delete(id);
        if (b == false) {
            Toast.makeText(MainActivity.this, "false", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this, "delete successful", Toast.LENGTH_SHORT).show();
        }
        arrayAdapter.notifyDataSetChanged();
        getData();
    }
}
