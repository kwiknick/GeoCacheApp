package edu.rasmussen.mobile.geotag;

        import android.content.Context;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Xml;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import org.xmlpull.v1.XmlSerializer;

        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.OutputStreamWriter;


public class SubmitActivity extends AppCompatActivity {

    Button submit;
    EditText description, street, city, state, zip;
    String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        submit = (Button) findViewById(R.id.submitButton);
        description = (EditText) findViewById(R.id.inputDescBox);
        street = (EditText) findViewById(R.id.inputAddressBox);
        city = (EditText) findViewById(R.id.inputCityBox);
        state = (EditText) findViewById(R.id.inputStateBox);
        zip = (EditText) findViewById(R.id.inputZipCodeBox);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location = description.getText().toString() + " \n" + street.getText().toString() + " \n" +
                        city.getText().toString() + " \n" + state.getText().toString() + " \n" +
                        zip.getText().toString();
                try {
                    OutputStreamWriter writeToFile = new OutputStreamWriter(openFileOutput("location.txt", Context.MODE_PRIVATE));
                    writeToFile.write(location);
                    writeToFile.close();
                    Toast.makeText(SubmitActivity.this, "New Location Saved", Toast.LENGTH_LONG).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        FileOutputStream fos;
        try {
        fos = openFileOutput("location.txt", Context.MODE_APPEND);

        XmlSerializer serializer = Xml.newSerializer();
        serializer.setOutput(fos, "UTF-8");

            serializer.startDocument(null, Boolean.valueOf(true));

        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);

        serializer.startTag(null, "root");

        for(int j = 0; j < 3; j++) {
            serializer.startTag(null, "record");
            serializer.text(location);
            serializer.endTag(null, "record");
        }
        serializer.endDocument();
        serializer.flush();
        fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_submit, menu);
        return true;
    }*/

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
