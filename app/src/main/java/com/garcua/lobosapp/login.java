package com.garcua.lobosapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends Activity {

    private EditText correo;
    private EditText contraseña;
    private Button entrar;

    private String email= "";
    private String password= "";


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth= FirebaseAuth.getInstance();

        correo=(EditText)findViewById(R.id.editText_email);
        contraseña=(EditText)findViewById(R.id.editText_contraseña);
        entrar=(Button)findViewById(R.id.btn_entar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email= correo.getText().toString();
                password=contraseña.getText().toString();
                if (!email.isEmpty() && !password.isEmpty() ){
                    loginUser();
                }
                else {
                    Toast.makeText(login.this,"complete los campos", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


    private void loginUser () {
        mAuth.signInWithEmailAndPassword(email, password). addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    //  startActivity( new Intent(login.this, eventos.class));
                    finish();
                }
                else{
                    Toast.makeText(login.this, "Error en inicio de sesion", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
    //no volver a pedir login
    @Override
    protected void onStart(){
        super.onStart();

        if (mAuth.getCurrentUser() != null);{

            // startActivity(new Intent(login.this, ));
            finish();
        }



    }
}
