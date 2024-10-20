package com.example.aula03_exercicio02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etBits;
    private RadioButton rbBytes;
    private RadioButton rbKB;
    private RadioButton rbMB;
    private RadioButton rbGB;
    private RadioButton rbTB;
    private Button btnConverter;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etBits = findViewById(R.id.etBits);
        rbBytes = findViewById(R.id.rbBytes);
        rbBytes.setChecked(true);
        rbKB = findViewById(R.id.rbKB);
        rbMB = findViewById(R.id.rbMB);
        rbGB =findViewById(R.id.rbGB);
        rbTB =findViewById(R.id.rbTB);
        btnConverter = findViewById(R.id.btnConverter);
        tvRes = findViewById(R.id.tvRes);

        btnConverter.setOnClickListener(op -> converter());
    }

    private void converter() {
        StringBuilder builder = new StringBuilder();
        builder.append("Resultado da conversao: ");
        float bytes = (Float.parseFloat(etBits.getText().toString()) / 8);
        float kb = bytes / 1024;
        float mb = kb / 1024;
        float gb = kb / 1024;
        float tb = gb / 1024;
        if(rbBytes.isChecked()) {
            builder.append(bytes + " Bytes");
        }
        if(rbKB.isChecked()) {
            builder.append(kb + " KB");
        }
        if(rbMB.isChecked()) {
            builder.append(mb + " MB");
        }
        if(rbGB.isChecked()) {
            builder.append(gb + " GB");
        }
        if(rbTB.isChecked()) {
            builder.append(tb + " TB");
        }
        tvRes.setText(builder.toString());
    }
}