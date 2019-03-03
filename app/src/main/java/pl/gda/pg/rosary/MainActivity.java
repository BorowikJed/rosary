package pl.gda.pg.rosary;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import pl.gda.pg.rosary.RosaryUtils.Rosary;

public class MainActivity extends AppCompatActivity {

    Rosary rosary = new Rosary(0);
//    SharedPreferences data = getApplicationContext().getSharedPreferences("COUNTER_PREF", 0);
//    SharedPreferences.Editor editor = data.edit();


    @Override
    protected void onPause() {
        SharedPreferences data = getApplicationContext().getSharedPreferences("COUNTER_PREF", 0);
        SharedPreferences.Editor editor = data.edit();
        editor.putInt("savedCounter", rosary.getCounter());
        editor.apply();
        super.onPause();
    }

    @Override
    protected void onResume() {
        SharedPreferences data = getApplicationContext().getSharedPreferences("COUNTER_PREF", 0);
        int savedCounter = data.getInt("savedCounter", 0);
        rosary = new Rosary(savedCounter);
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences data = getApplicationContext().getSharedPreferences("COUNTER_PREF", 0);
        int savedCounter = data.getInt("savedCounter", 0);
        rosary = new Rosary(savedCounter);

        TextView textView = (TextView) findViewById(R.id.mainText);
        textView.setText(rosary.getStatusText(0, "Chwalebna"));
        TextView tajemnicaTextView = (TextView) findViewById(R.id.tajemnicaTextView);
        tajemnicaTextView.setText("Tajemnica: " + rosary.getTajemnica());

        final Switch mySwitch = (Switch) findViewById(R.id.switch1);
        final Switch mySwitch2 = (Switch) findViewById(R.id.switch2);
        final Switch mySwitch3 = (Switch) findViewById(R.id.switch3);
        mySwitch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && mySwitch2.isChecked() && mySwitch.isChecked()) {
                    rosary.setCounter(0);
                    Toast.makeText(getApplicationContext(),
                            "Różaniec zrestartowany", Toast.LENGTH_LONG).show();
                    TextView textView = (TextView) findViewById(R.id.mainText);
                    textView.setText(rosary.getStatusText(0, "Chwalebna"));
                    TextView tajemnicaTextView = (TextView) findViewById(R.id.tajemnicaTextView);
                    tajemnicaTextView.setText("Tajemnica: " + rosary.getTajemnica());
                    mySwitch.setChecked(false);
                    mySwitch2.setChecked(false);
                    mySwitch3.setChecked(false);
                }

                // do something, the isChecked will be
                // true if the switch is in the On position
            }
        });

        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Pomnij o miłosierna Panno Różańcowa z Pompejów," +
                                " jako nigdy jeszcze nie słyszano, aby ktokolwiek z czcicieli" +
                                " Twoich, z Różańcem Twoim, pomocy Twojej wzywający, miał być" +
                                " przez Ciebie opuszczony. Ach, nie gardź prośbą moją, o Matko" +
                                " Słowa Przedwiecznego, ale przez święty Twój różaniec i przez" +
                                " upodobanie, jakie okazujesz dla Twojej świątyni w Pompejach" +
                                " wysłuchaj mnie dobrotliwie. Amen.", Toast.LENGTH_LONG).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Cóż Ci dać mogę, o Królowo pełna miłości? Moje całe życie poświęcam" +
                                " Tobie. Ile mi sił starczy, będę rozszerzać cześć Twoją, o" +
                                " Dziewico Różańca Świętego z Pompejów, bo gdy Twojej pomocy" +
                                " wezwałem, nawiedziła mnie łaska Boża. Wszędzie będę opowiadać" +
                                " o miłosierdziu, które mi wyświadczyłaś. O ile zdołam będę" +
                                " rozszerzać nabożeństwo do Różańca Świętego, wszystkim głosić" +
                                " będę, jak dobrotliwie obeszłaś się ze mną, aby i niegodni," +
                                " tak jak i ja, grzesznicy, z zaufaniem do Ciebie się udawali." +
                                " O, gdyby cały świat wiedział jak jesteś dobra, jaką masz" +
                                " litość nad cierpiącymi, wszystkie stworzenia uciekałyby" +
                                " się do Ciebie. Amen.", Toast.LENGTH_LONG).show();
            }
        });
//        editor.putInt("homeScore", 1345);
//
//// Apply the edits!
//        editor.apply();
//
//// Get from the SharedPreferences
//        SharedPreferences settings = getApplicationContext().getSharedPreferences("COUNTER_PREF", 0);
//        int homeScore = settings.getInt("homeScore", 0);
//        System.out.println(homeScore);


    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    TextView textView = (TextView) findViewById(R.id.mainText);
                    textView.setText(rosary.getStatusText(1, "Chwalebna"));
                    TextView tajemnicaTextView = (TextView) findViewById(R.id.tajemnicaTextView);
                    tajemnicaTextView.setText(rosary.getTajemnica());
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    TextView textView = (TextView) findViewById(R.id.mainText);
                    textView.setText(rosary.getStatusText(1, "Chwalebna"));
                    TextView tajemnicaTextView = (TextView) findViewById(R.id.tajemnicaTextView);
                    tajemnicaTextView.setText(rosary.getTajemnica());
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        if (rosary.checkForChwala() == "TEN")
                            v.vibrate(VibrationEffect.createWaveform(new long[]{280, 70, 220, 50, 220,}, new int[]{255, 0, 255, 0, 255}, -1));
                        else if (rosary.checkForChwala() == "MIDDLE")
                            v.vibrate(VibrationEffect.createWaveform(new long[]{110, 50, 110}, new int[]{180, 0, 180}, -1));
                        else if (rosary.checkForChwala() == "END") {
                            v.vibrate(VibrationEffect.createWaveform(new long[]{250, 50, 250, 50, 450, 300, 200}, new int[]{255, 0, 255, 0, 255, 120, 60}, -1));
                        } else
                            v.vibrate(VibrationEffect.createOneShot(150, 180));
                    } else {
                        //deprecated in API 26
                        if (rosary.checkForChwala() == "TEN")
                            v.vibrate(1000);
                        else
                            v.vibrate(150);

                    }
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }
}
