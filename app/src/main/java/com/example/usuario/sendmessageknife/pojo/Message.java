package com.example.usuario.sendmessageknife.pojo;


/**
 * Created by usuario on 29/09/17.
 */
// se importa los archivos necesarios para hacer el parsel
import android.os.Parcel;
import android.os.Parcelable;

//se le implementa a la Clase Message Parcelable
public class Message implements Parcelable {
    //propiedades
     private String _message;
     private String _user;

    //se inpementa el set y get
    public void set_message(String _message) {
        this._message = _message;
    }

    public void set_user(String _user) {
        this._user = _user;
    }

    public String get_message() {

        return _message;
    }

    public String get_user() {
        return _user;
    }
    //se crea un contruztor para inicializar de forma normal y otro con el parcel


    public Message(String _message,String _user) {
        this._message = _message;
        this._user = _user;
    }

    protected Message(Parcel in) {
        _message = in.readString();
        _user = in.readString();
    }

    //se sobre escribe el toString
    @Override
    public String toString() {
        return "Message{" +
                "_message='" + _message + '\'' +
                ", _user='" + _user + '\'' +
                '}';
    }

    //creamos un equals para comparar ...
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message = (Message) o;

        return _message.equals(message._message) && _user.equals(message._user);

    }
    //implementaciones del parseable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        //le implementamos con parcel.write (tipo) lo que queremos parcear
        parcel.writeString(_message);
        parcel.writeString(_user);
    }


    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

}