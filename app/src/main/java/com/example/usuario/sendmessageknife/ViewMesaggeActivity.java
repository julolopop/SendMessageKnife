package com.example.usuario.sendmessageknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.usuario.sendmessageknife.pojo.Message;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @Autor Juan Manuel Diaz Ortiz
 * @Version v0.2
 * @Comentario Esta clase recive un mensage de la clase SendMensaggerActivity y la muestra
 */
public class ViewMesaggeActivity extends AppCompatActivity {

    @BindView(R.id.ediMessage)
    TextView txvViewMessage;
    @BindView(R.id.ediUserMessage)
    TextView txvViewUser;
    Message smg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mesagge);

        //se enlaza con el editmessage de View
        //Vincular el id d ñas vistas en el xml con las clases view.
        ButterKnife.bind(this);

        //se recoge el intert y de el se coge el mensage que se envio con el bundle
        /*
        txvViewMessage.setText(getIntent().getExtras().getString("message"));
        */
        smg = ((Message) getIntent().getExtras().getParcelable("usuarioMenssage"));
        txvViewMessage.setText(smg.get_message());
        String viewUser = String.format(getResources().getString(R.string.ediUserMessage), smg.get_user());
        txvViewUser.setText(viewUser);


    }
}
