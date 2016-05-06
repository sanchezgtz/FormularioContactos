package com.sancheztech.formulariocontactos;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    android.support.design.widget.TextInputEditText nombre;
    android.support.design.widget.TextInputEditText telefono;
    android.support.design.widget.TextInputEditText email ;
    android.support.design.widget.TextInputEditText descripcion;
    DatePicker fechaNacimiento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSiguiente = (Button)findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = (android.support.design.widget.TextInputEditText) findViewById(R.id.txeNombre);
                fechaNacimiento = (DatePicker) findViewById(R.id.dpFechaNacimiento);
                telefono = (android.support.design.widget.TextInputEditText) findViewById(R.id.txeTelefono);
                email = (android.support.design.widget.TextInputEditText) findViewById(R.id.txeEmail);
                descripcion = (android.support.design.widget.TextInputEditText) findViewById(R.id.txeDescripcion);
                Intent confirmacionIntent = new Intent(MainActivity.this, ConfirmacionActivity.class);
                confirmacionIntent.putExtra(getResources().getString(R.string.pNombre),  nombre.getText().toString());
                int mes = fechaNacimiento.getMonth() + 1;
                String date = fechaNacimiento.getDayOfMonth()+"/" + mes + "/" + fechaNacimiento.getYear();
                confirmacionIntent.putExtra(getResources().getString(R.string.pFechaNacimiento), date );
                confirmacionIntent.putExtra(getResources().getString(R.string.pTelefono),  telefono.getText().toString());
                confirmacionIntent.putExtra(getResources().getString(R.string.pEmail),  email.getText().toString());
                confirmacionIntent.putExtra(getResources().getString(R.string.pDescripcion),  descripcion.getText().toString());
                startActivityForResult(confirmacionIntent, 0);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == 0)
        {
            if(resultCode == RESULT_OK)
            {

            }
            else if(resultCode == RESULT_CANCELED)
            {

            }
        }
    }
}
