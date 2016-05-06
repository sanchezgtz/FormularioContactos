package com.sancheztech.formulariocontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmacionActivity extends AppCompatActivity {

    TextView txtNombre;
    TextView txtFechaNacimiento;
    TextView txtTelefono;
    TextView txtDescripcion;
    TextView txtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);
        setDatos();

        Button btnEditar = (Button)findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent();
                setResult(2, mainIntent);
                finish();
            }
        });
    }

    private void setDatos() {
        Bundle parameters = getIntent().getExtras();

        String nombre = parameters.getString(getResources().getString(R.string.pNombre));
        String telefono = parameters.getString(getResources().getString(R.string.pTelefono));
        String email = parameters.getString(getResources().getString(R.string.pEmail));
        String fecha = parameters.getString(getResources().getString(R.string.pFechaNacimiento));
        String descripcion = parameters.getString(getResources().getString(R.string.pDescripcion));

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtFechaNacimiento = (TextView)findViewById(R.id.txtFechaNacimiento);
        txtTelefono = (TextView) findViewById(R.id.txttelefono);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        txtEmail = (TextView) findViewById(R.id.txtEmail);

        txtNombre.setText(nombre);
        txtFechaNacimiento.setText(txtFechaNacimiento.getText().toString()+" "+fecha);
        txtTelefono.setText(txtTelefono.getText().toString()+" "+telefono);
        txtEmail.setText(txtEmail.getText().toString()+" "+email);
        txtDescripcion.setText(txtDescripcion.getText().toString()+ " " + descripcion);
    }
}
