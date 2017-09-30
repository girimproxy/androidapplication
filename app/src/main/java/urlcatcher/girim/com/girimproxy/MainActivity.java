package urlcatcher.girim.com.girimproxy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri blockedWebsite = getIntent().getData();

        if (blockedWebsite != null) {

            String girimUri = "https://gir.im/"+blockedWebsite.toString();

            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(girimUri));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            } catch (Exception e) {
                Log.e("GirimProxy", "Runtime Error!");
            }
        }

        finish();
    }
}
