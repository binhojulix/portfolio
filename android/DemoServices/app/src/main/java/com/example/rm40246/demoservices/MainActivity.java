package com.example.rm40246.demoservices;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import service.DownloadIntentService;
import service.MeuServico;

public class MainActivity extends AppCompatActivity {
    private EditText etUrlImagem;
    private ImageView ivImagem;
    private DownlaodResultReceiver downlaodResultReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUrlImagem = (EditText) findViewById(R.id.edtUrlImagem);
        etUrlImagem.setText("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRdQbjHx4-tzXxTLZvclZPJYcWeKPHdnwsip91-kcebPleFckYRQw");
        ivImagem = (ImageView) findViewById(R.id.image_view);
        downlaodResultReceiver = new DownlaodResultReceiver(new Handler());
    }

    public void iniciarServico(View v) {
        Intent service = new Intent(getBaseContext(), MeuServico.class);
        startService(service);
    }

    public void pararServico(View v) {
        Intent service = new Intent(getBaseContext(), MeuServico.class);
        stopService(service);
    }

    public void download(View v) {
        Intent service = new Intent(MainActivity.this, DownloadIntentService.class);
        service.putExtra(DownloadIntentService.URL_DOWNLAOD, etUrlImagem.getText().toString());
        service.putExtra(DownloadIntentService.RESULT_RECEIVER, downlaodResultReceiver);
        startActivity(service);
    }


    private class DownlaodResultReceiver extends ResultReceiver {

        /**
         * Create a new ResultReceive to receive results.  Your
         * {@link #onReceiveResult} method will be called from the thread running
         * <var>handler</var> if given, or from an arbitrary thread if null.
         *
         * @param handler
         */
        public DownlaodResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);

            switch (resultCode) {
                case DownloadIntentService.DOWNLOAD_ERRO:
                    Toast.makeText(MainActivity.this, "nao foi possivel baixar a imagem",
                            Toast.LENGTH_LONG).show();
                    break;
                case DownloadIntentService.DOWNLOAD_SUCESSO:
                    String path = resultData.getString(DownloadIntentService.FILE_PAH);
                    Bitmap foto = BitmapFactory.decodeFile(path);
                    if (foto == null) {
                        Toast.makeText(MainActivity.this, "Foto não encontrada",
                                Toast.LENGTH_LONG).show();
                    } else {
                        ivImagem.setImageBitmap(foto);
                    }
                    break;

            }
        }
    }
}
