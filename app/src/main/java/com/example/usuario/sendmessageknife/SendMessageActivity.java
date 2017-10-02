package com.example.usuario.sendmessageknife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Juan Manuel Diaz Ortiz
 * @version v0.2
 *          <p>Esta clase manda un mensage a la clase ViewMesaggeActivity</p>
 *          <p>
 *          <ul>
 *          <li>Concepto Context</li>
 *          <li>Paso de parametros con el obj @see android.os</li>
 *          <li>Paso de mensages mediante la actividades de la clase <a href="https://developer.android.com/reference/android/content/Intent.html">Intent</a> </li>
 *          </ul>
 *          .Bundle;
 */
public class SendMessageActivity extends AppCompatActivity {
    @BindView(R.id.editMessage)
    EditText edtMessage;
    @BindView(R.id.editUser)
    EditText edtUser;
    @BindView(R.id.btnOk)
    Button btnOk;
    static final String TAG = "com.example.usuario.sendmensagge";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        //Vincular el id d ñas vistas en el xml con las clases view.
        //Iniciar los componetes
        ButterKnife.bind(this);


            /*
            //1.Registrar un lisener o escuchar OnClickLisener
            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //1.Crear un objeto  bundle y añadirlo al message
                    Bundle bundle = new Bundle();
                    //2.recoger mensage
                    Message smg = new Message(edtMessage.getText().toString(), edtUser.getText().toString());
                    bundle.putParcelable("usuarioMenssage", smg);

                //bundle.putString("message", edtMessage.getText().toString());
                //bundle.putString("user", edtUser.getText().toString());

                    //3.Crear un obj intent
                    Intent intent = new Intent(SendMensaggerActivity.this, ViewMesaggeActivity.class);
                    //4.Incluir bundel dentro de intent
                    intent.putExtras(bundle);
                    //5.Iniciar el activity view message
                    startActivity(intent);
                }
            });*/

        Log.d(TAG, "SendMensaggerActivity onCreate()");
    }

    @OnClick(R.id.btnOk)
    public void getonClick(View view) {
        switch (view.getId()) {
            case R.id.btnOk:
                Bundle bundle = new Bundle();
                //2.recoger mensage

                com.example.usuario.sendmessageknife.pojo.Message smg = new com.example.usuario.sendmessageknife.pojo.Message(edtMessage.getText().toString(), edtUser.getText().toString());
                bundle.putParcelable("usuarioMenssage", smg);
                /*
                bundle.putString("message", edtMessage.getText().toString());
                bundle.putString("user", edtUser.getText().toString());
                */
                //3.Crear un obj intent
                Intent intent = new Intent(SendMessageActivity.this, ViewMesaggeActivity.class);
                //4.Incluir bundel dentro de intent
                intent.putExtras(bundle);
                //5.Iniciar el activity view message
                startActivity(intent);
                break;
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMensaggerActivity onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMensaggerActivity OnResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMensaggerActivity onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMensaggerActivity onPause()");
    }
}
