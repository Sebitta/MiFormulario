package uzquiano.wagner.miformulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class primeraactividad extends AppCompatActivity {

    private View btn;
    private EditText text;
    public String nombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeraactividad);

        btn = (Button) findViewById(R.id.buttonNext);
        text= (EditText) findViewById(R.id.editTextNombre);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombres = text.getText().toString();

 //               Toast.makeText(getApplicationContext(),nombres,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(primeraactividad.this,segundaactividad.class);
                intent.putExtra("Nombre", nombres);
                startActivity(intent);
            }
        });
    }
}
