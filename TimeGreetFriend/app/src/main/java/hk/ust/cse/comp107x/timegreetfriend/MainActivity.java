package hk.ust.cse.comp107x.timegreetfriend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  Button greetButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // get a reference to the greetButton on the UI
    greetButton = (Button) findViewById(R.id.greetButton);
    // Set the onClickListener for the greetButton to be this class.
    // This requires that the class implement the View.OnClickListener callback
    // the onClick() method
    greetButton.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {

    // get a reference to the TextView on the UI
    TextView textMessage = (TextView) findViewById(R.id.textMessage);

    //get a reference to the EditText so that we can read in the value typed
    // by the user
    EditText editFriendName = (EditText) findViewById(R.id.editFriendName);

    // get the name of the friend typed in by the user in the EditText field
    String friendName = editFriendName.getText().toString();
    Calendar cal = Calendar.getInstance();
    int hour = cal.get(Calendar.HOUR_OF_DAY);

    // TODO 1
    // Add the code to display the appropriate greeting message. Your output message should be
    // exactly the same as the one you see on the video with exactly the same number of spaces
    // in the same positions.
    // The code from the previous exercise is commented and kept below for your reference

    switch (v.getId()) {

      case R.id.greetButton:
        // set the string being displayed by the TextView to
        // the greeting message for the friend
        String greeting = "";
        if (hour >= 6 && hour <= 12) greeting = "Good Morning";
        if (hour >= 12 && hour <= 17) greeting = "Good Afternoon";
        if (hour >= 17 && hour <= 21) greeting = "Good Evening";
        if (hour >= 21 && hour <= 24) greeting = "Good Night";

        textMessage.setText(greeting + " " + friendName + "!");

        break;

      default:

        break;
    }
  }
}
