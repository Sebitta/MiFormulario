package uzquiano.wagner.miformulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class segundaactividad extends AppCompatActivity {

    private TextView mitexto;
    private SeekBar miseek;

    private View btnmenu;
    private View btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundaactividad);

        btnmenu = (Button) findViewById(R.id.buttonmenu);

        btnmenu.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Intent intent = new Intent(segundaactividad.this, primeraactividad.class);
                                       startActivity(intent);
                                   }
                               });

        btn = (Button) findViewById(R.id.buttonnext);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(segundaactividad.this, terceraactividad.class);
                startActivity(intent);
            }
        });

        mitexto = (TextView) findViewById(R.id.textsalida);
        miseek = (SeekBar) findViewById(R.id.seekBar2);

        mitexto.setText("años:" + miseek.getProgress());

        miseek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mitexto.setText("años: " + progress);
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
