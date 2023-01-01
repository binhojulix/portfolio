package service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.ResultReceiver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by rm40246 on 08/12/2015.
 */
public class DownloadIntentService extends IntentService {

    public static final int DOWNLOAD_SUCESSO = 1;
    public static final int DOWNLOAD_ERRO = 0;
    public static final String FILE_PAH = "filePath";
    public static final String URL_DOWNLAOD = "url";
    public static final String RESULT_RECEIVER = "resultReceiver";

    public DownloadIntentService() {
        super(DownloadIntentService.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String url = intent.getStringExtra(DownloadIntentService.URL_DOWNLAOD);
        final ResultReceiver receiver =
                intent.getParcelableExtra(DownloadIntentService.RESULT_RECEIVER);

        File file = new File(
                Environment.getExternalStorageDirectory().getAbsolutePath(), "imagemservice.png");

        if (file.exists()) {
            file.delete();
        }
        try {

            file.createNewFile();

            URL downloadURL = new URL(url);

            HttpURLConnection connection = (HttpURLConnection)
                    downloadURL.openConnection();

            int responseCode = connection.getResponseCode();

            if (responseCode != 200) throw new Exception("nao foi possivel baixar a imagem");

            InputStream is = connection.getInputStream();
            FileOutputStream out = new FileOutputStream(file);

            byte[] buffer = new byte[1024];
            int byteCount;

            while ((byteCount = is.read(buffer)) != -1) {
                out.write(buffer, 0, byteCount);
            }

            out.close();
            is.close();

            Bundle bundle = new Bundle();
            bundle.putString(FILE_PAH, file.getPath());
            receiver.send(DOWNLOAD_SUCESSO, bundle);

        } catch (IOException e) {
            receiver.send(DOWNLOAD_ERRO, Bundle.EMPTY);
            e.printStackTrace();
        } catch (Exception e) {
            receiver.send(DOWNLOAD_ERRO, Bundle.EMPTY);
            e.printStackTrace();
        }
    }
}
