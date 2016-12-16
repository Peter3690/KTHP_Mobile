package tulv.levantu;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

/**
 * Created by tulv on 10/21/2016.
 */
public class ContactModel extends DatabaseHelper {
    public ContactModel(Context context) {
        super(context);
    }

    public ArrayList<Contact> getList() {
        ArrayList<Contact> arrayList = new ArrayList<>();
        Contact contact;
        String sql = "select * from contact";
        Cursor cursor = this.getCursor(sql);
        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            contact = new Contact(cursor.getInt(0), cursor.getString(1),cursor.getString(2), cursor.getString(3),cursor.getString(4));
            arrayList.add(contact);
        }
        return arrayList;
    }

    public boolean Add(Contact contact) {
        String sql = "select * from contact where id='" + contact.getmId() + "'";
        int count = this.getCount(sql);
        if (count > 0) {
            return false;
        }else {
            sql = "insert into contact Values(" + contact.getmId() + ",'" + contact.getmName()+"','" + contact.getmHobby() + "','" + contact.getmSex()+"','" + contact.getmAddress()+"')";
            this.execSQL(sql);
            return true;
        }
    }
    public boolean Update(Contact contact) {
        String sql = "select * from contact where id=" + contact.getmId() + "";
        int count = this.getCount(sql);
        if (count <= 0) {
            return false;
        }else{
            sql = "update contact set name='" + contact.getmName()+"',hobby='" + contact.getmHobby()+"',sex='" + contact.getmSex()+"',address='" + contact.getmAddress()+"' where id=" + contact.getmId() + "";
            this.execSQL(sql);return true;
        }

    }
    public boolean Delete(int id) {
        String sql = "select * from contact where id=" + id + "";
        int count = this.getCount(sql);
        if (count <= 0) {
            return false;
        }
      else {
            sql = "delete from contact where id=" +id + "";
            this.execSQL(sql);
            return true;
        }
    }
}
