package apk.shizhisha.pw.apocket;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends ActionBarActivity {
    public static final String app_url = "https://github.com/xingdao/aPocket";
    public static final String browserName = "com.android.browser";
    public static final String browserActivity = "com.android.browser.BrowserActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // get intent, action, MIME type
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                handleSendText(intent); // deal seed text
            } else if (type.startsWith("image/")) {
                handleSendImage(intent); // deal seed img
            }
        } else if (null != intent.getData()) { //deal link from WeChat
            Uri data = intent.getData();
            String url = data.toString();
            Toast.makeText(this, "url:"+ url, Toast.LENGTH_SHORT).show();
            dealUrl(url);
            sendNotification(url);
            finish();
        } else { // deal other intents，start in main
            setContentView(R.layout.activity_main);

            Button button_save_test = (Button) findViewById(R.id.save_test);
            button_save_test.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dealUrl(app_url);
                }
            });

            Button button_save_clip = (Button) findViewById(R.id.save_clip);
            button_save_clip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String clipText= clipAdd();
                    if(null != clipText){
                        dealUrl(clipText);
                    }
                }
            });
        }
    }

    public void sendNotification(String edtContent){ //Click use defeat browser open
        int icon = R.mipmap.ic_launcher;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(edtContent));
        intent.setClassName(browserName, browserActivity);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification notification = new Notification.Builder(this)
                .setAutoCancel(true)
                .setContentTitle("Click use browser open")
                .setContentText(edtContent)
                .setContentIntent(pendingIntent)
                .setSmallIcon(icon)
                .setWhen(System.currentTimeMillis())
                .build();

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(100, notification);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    public Boolean dealUrl(String sharedText){
        Pattern pattern = Pattern.compile("((http|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?");
        Matcher matcher = pattern.matcher(sharedText);
        String sharedUrl="";
        if(matcher.find()){
            sharedUrl= matcher.group(); //get url in sharedText
            Toast.makeText(this, "Save in pocket:"+sharedUrl, Toast.LENGTH_SHORT).show();

            Intent intentApp= new Intent();
            intentApp.setClassName("com.ideashower.readitlater.pro","com.ideashower.readitlater.activity.AddActivity");
            intentApp.putExtra(Intent.EXTRA_TEXT, sharedUrl);
            intentApp.addCategory(Intent.CATEGORY_HOME); // run in background
            intentApp.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //run in another task

            try {
                startActivity(intentApp);
            }catch (Exception e){
                Toast.makeText(this, "Error: Please check Pocket\n"+sharedUrl, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        Toast.makeText(this, "Error:No url !\n"+sharedUrl, Toast.LENGTH_SHORT).show();
        return false;
    }

    void handleSendText(Intent intent) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (sharedText != null) { // deal shared text
            dealUrl(sharedText);
            finish();
        }
    }

    void handleSendImage(Intent intent) { // deal shared text&image
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (sharedText != null){
            dealUrl(sharedText);
            finish();
        }
    }

    private String clipAdd(){
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = clipboardManager.getPrimaryClip();
        if (clip != null) {
            String add_Text = clip.getItemAt(0).coerceToText(this).toString();
            if (add_Text.length() == 0) {
                Toast.makeText(this, "The clipboard is empty!", Toast.LENGTH_SHORT).show();
            }else {
                return  add_Text;
            }
        }else {
            Toast.makeText(this, "The clipboard is empty!", Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                //waiting
                break;
            case R.id.action_about:
                about();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void about(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("About");
        dialog.setMessage("This is aPocket apk, For the purpose to use pocket easier\n");
        dialog.setCancelable(false);
        dialog.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.setNegativeButton("Feedback", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent_Feedback = new Intent(Intent.ACTION_VIEW);
                intent_Feedback.setData(Uri.parse(app_url));
                intent_Feedback.setClassName(browserName, browserActivity);
                startActivity(intent_Feedback);
            }
        });
        dialog.show();
    }
}
