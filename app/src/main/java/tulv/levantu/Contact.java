package tulv.levantu;

/**
 * Created by tulv on 10/21/2016.
 */
public class Contact {
    private int mId;
    private String mName;
    private String mHobby;
    private String mSex;
    private String mAddress;

    public Contact(int mId, String mName, String mHobby, String mSex, String mAddress) {
        this.mId = mId;
        this.mName = mName;
        this.mHobby = mHobby;
        this.mSex = mSex;
        this.mAddress = mAddress;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmHobby() {
        return mHobby;
    }

    public void setmHobby(String mHobby) {
        this.mHobby = mHobby;
    }

    public String getmSex() {
        return mSex;
    }

    public void setmSex(String mSex) {
        this.mSex = mSex;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }
}
