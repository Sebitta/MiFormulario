package uzquiano.wagner.miformulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class terceraactividad extends AppCompatActivity {

    private View btnmenu;
    private TextView textnombre;
    private String nombre2;
    private Button accion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceraactividad);

        nombre2 = getIntent().getStringExtra("Nombres");

        textnombre = (TextView) findViewById(R.id.textViewnombre);

        accion = (Button) findViewById(R.id.buttonToast2);
        accion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textnombre.setText(nombre2);
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



    }
}
