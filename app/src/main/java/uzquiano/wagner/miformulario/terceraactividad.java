package uzquiano.wagner.miformulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class terceraactividad extends AppCompatActivity {

    private ImageButton btnmenu;
    private TextView textnombre;
    private String nombre2;
    private Button accion;
    private Button compartir;

    private String edad2;
    private String opcion2;
    private int edad3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceraactividad);

        nombre2 = getIntent().getStringExtra("Nombres");
        opcion2 = getIntent().getStringExtra("Opciones");
        edad2 = getIntent().getStringExtra("Edades");

        textnombre = (TextView) findViewById(R.id.textViewnombre);
        textnombre.setVisibility(View.INVISIBLE);


        accion = (Button) findViewById(R.id.buttonToast2);
        accion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                accion.setVisibility(View.INVISIBLE);
                if (opcion2.equalsIgnoreCase("Saludo"))

                    Toast.makeText(terceraactividad.this,"Hola " + nombre2 + " , ¿Cómo vas con esos " + edad2 + " años?", Toast.LENGTH_SHORT).show();
                    //textnombre.setText("Hola " + nombre2 + " , ¿Cómo vas con esos " + edad2 + " años?");
                else {
                    edad3 = Integer.parseInt(edad2);
                    edad3 = edad3 + 1;
                    edad2 = String.valueOf(edad3);
                    Toast.makeText(terceraactividad.this,"Espero verte pronto, antes que cumplas " + edad2, Toast.LENGTH_SHORT).show();

                    //textnombre.setText("Espero verte pronto, antes que cumplas " + edad2);
                }



            }
        });

        btnmenu = (ImageButton) findViewById(R.id.imageButtonInicio1);

        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(terceraactividad.this, primeraactividad.class);
                startActivity(intent);
            }
        });

        compartir = (Button) findViewById(R.id.buttonCompartir);
        compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendText = new Intent();
                sendText.setAction(Intent.ACTION_SEND);

                if (opcion2.equalsIgnoreCase("Saludo")) {
                    sendText.putExtra(Intent.EXTRA_TEXT, "Hola " + nombre2 + " , ¿Cómo vas con esos " + edad2 + " años?");
                    sendText.setType("text/plain");
                    startActivity(sendText);
                   // Toast.makeText(terceraactividad.this, , Toast.LENGTH_SHORT).show();
                    //textnombre.setText("Hola " + nombre2 + " , ¿Cómo vas con esos " + edad2 + " años?");
                }
                else {
                    edad3 = Integer.parseInt(edad2);
                    edad3 = edad3 + 1;
                    edad2 = String.valueOf(edad3);
                    sendText.putExtra(Intent.EXTRA_TEXT, "Espero verte pronto, antes que cumplas " + edad2);
                    sendText.setType("text/plain");
                    startActivity(sendText);
                   // Toast.makeText(terceraactividad.this,"Espero verte pronto, antes que cumplas " + edad2, Toast.LENGTH_SHORT).show();

                    //textnombre.setText("Espero verte pronto, antes que cumplas " + edad2);
                }


            }
        });
    }
}
