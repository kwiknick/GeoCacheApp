package edu.rasmussen.mobile.geotag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;



public class GeoTagActivity extends AppCompatActivity {

    private static Button splashButton;
    private static Button mainMenuButtion;
    private static Button userProfileButton;
    private static Button gamePlayButton;
    private static Button helpMenuButton;
    private static Button loginButton;
    private static Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_tag);
        onSplashButtonClickListener();
        onMainMenuButtonClickListener();
        onUserProfileButtonClickListener();
        onGamePlayButtonClickListener();
        onHelpMenuButtonClickListener();
        onLoginScreenButtonClickListener();
    }

    public void onSplashButtonClickListener() {
        splashButton = (Button)findViewById(R.id.splash);
        splashButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("edu.rasmussen.mobile.geotag.Splash");
                        startActivity(intent);
                    }
                }
        );
    }
    public void onMainMenuButtonClickListener() {
        mainMenuButtion = (Button)findViewById(R.id.mainMenu);
        mainMenuButtion.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("edu.rasmussen.mobile.geotag.MainMenu");
                        startActivity(intent);
                    }
                }
        );
    }
    public void onUserProfileButtonClickListener() {
        userProfileButton = (Button)findViewById(R.id.userProfile);
        userProfileButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("edu.rasmussen.mobile.geotag.UserProfile");
                        startActivity(intent);
                    }
                }
        );
    }
    public void onGamePlayButtonClickListener() {
        gamePlayButton = (Button)findViewById(R.id.gamePlay);
        gamePlayButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("edu.rasmussen.mobile.geotag.GamePlay");
                        startActivity(intent);
                    }
                }
        );
    }
    public void onHelpMenuButtonClickListener() {
        helpMenuButton = (Button)findViewById(R.id.helpScreen);
        helpMenuButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("edu.rasmussen.mobile.geotag.HelpMenu");
                        startActivity(intent);
                    }
                }
        );
    }
    public void onLoginScreenButtonClickListener() {
        loginButton = (Button)findViewById(R.id.loginScreen);
        loginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("edu.rasmussen.mobile.geotag.Login");
                        startActivity(intent);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_geo_tag, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
