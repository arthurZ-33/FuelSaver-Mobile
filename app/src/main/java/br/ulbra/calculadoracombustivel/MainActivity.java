package br.ulbra.calculadoracombustivel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView txtConsumoCombustivel, txtCustoDaViagem;
    EditText txtv1, txtv2, txtv3, txtv4, txtv5;
    Button btnCalcullar, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txtConsumoCombustivel = findViewById(R.id.txtConsumoCombustivel);
        txtCustoDaViagem = findViewById(R.id.txtCustoDaViagem);
        txtv1 = findViewById(R.id.txtv1);
        txtv2 = findViewById(R.id.txtv2);
        txtv3 = findViewById(R.id.txtv3);
        txtv4 =findViewById(R.id.txtv4);
        txtv5 = findViewById(R.id.txtv5);
        btnCalcullar = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    btnCalcullar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double combNece, dist, consu,custoViagem, precoLitro;

            dist = Double.parseDouble(txtv3.getText().toString());
            consu = Double.parseDouble(txtv4.getText().toString());
            combNece = dist / consu;
            txtConsumoCombustivel.setText("o consumo será: " + combNece + " litros");

            precoLitro = Double.parseDouble(txtv5.getText().toString());
            custoViagem = combNece * precoLitro;
            txtCustoDaViagem.setText("O custo da viagem será de: " + custoViagem + " R$");
        }
    });

    btnLimpar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        limpar();
        }
    });
    }
    private void limpar(){
    txtv1.setText("");
    txtv2.setText("");
    txtv3.setText("");
    txtv4.setText("");
    txtv5.setText("");
    }

}