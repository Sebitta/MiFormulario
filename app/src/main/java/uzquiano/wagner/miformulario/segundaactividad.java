package uzquiano.wagner.miformulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class segundaactividad extends AppCompatActivity {

    private TextView mitexto;
    private TextView nombre;
    private SeekBar miseek;

    private View btnmenu;
    private View btn;

    private RadioGroup radioGroup;
    private RadioButton radioButton;

    private String nombre1;
    private String opcion;
    private String edad ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundaactividad);

        edad = "0";
        nombre1 = getIntent().getStringExtra("Nombre");

        btnmenu = (ImageButton) findViewById(R.id.imageButtonInicio);
        radioGroup = (RadioGroup) findViewById(R.id.radios);

        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(segundaactividad.this, primeraactividad.class);
                startActivity(intent);
            }
        });

        btn = (Button) findViewById(R.id.buttonNext2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioGroup.getCheckedRadioButtonId();


                radioButton = (RadioButton) findViewById(selectedId);

                opcion = (String) radioButton.getText();

                //Toast.makeText(segundaactividad.this,nombre1+edad+opcion, Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(segundaactividad.this, terceraactividad.class);
                intent.putExtra("Nombres", nombre1);
                intent.putExtra("Opciones", opcion);
                intent.putExtra("Edades", edad);


                startActivity(intent);
            }
        });

        mitexto = (TextView) findViewById(R.id.textViewEdad);
        miseek = (SeekBar) findViewById(R.id.seekBar2);
        nombre = (TextView) findViewById(R.id.textViewnombre1);
        mitexto.setText("0 años");

        miseek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mitexto.setText(progress + " años");
                //mitexto.setText(nombre1);
                edad = String.valueOf(progress);
                nombre.setVisibility(View.INVISIBLE);
                //nombre.setText(edad);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }


}
