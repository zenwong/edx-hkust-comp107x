package hk.ust.cse.comp107x.chatclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by muppala on 8/6/16.
 */
public class MyAdapter extends ArrayAdapter<Message> {
  private final Context context;
  private final ArrayList<Message> messages;

  public MyAdapter(Context context, ArrayList<Message> messages) {
    super(context, R.layout.message, messages);
    this.context = context;
    this.messages = messages;
  }

  // This method constructs the ListItem's view from the data obtained
  // from the Message object. This will be called by ListView while it
  // is being drawn.
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    // Get a reference to the LayoutInflater. This helps construct the
    // view from the layout file
    LayoutInflater inflater = (LayoutInflater) context
      .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    // Change the layout based on who the message is from
    if (messages.get(position).fromMe()) {

      FromMeViewHolder vh;

      if (convertView == null) {
        convertView = inflater.inflate(R.layout.mymessage, parent, false);
        vh = new FromMeViewHolder();
        vh.mymessageTextView = (TextView) convertView.findViewById(R.id.mymessageTextView);
        vh.mytimeTextView = (TextView) convertView.findViewById(R.id.mytimeTextView);

        convertView.setTag(vh);

      } else {
        vh = (FromMeViewHolder) convertView.getTag();
      }

      vh.mymessageTextView.setText(messages.get(position).getMessage());
      vh.mytimeTextView.setText(messages.get(position).getTime());

    } else {

      IncomingViewHolder vh;

      if (convertView == null) {
        convertView = inflater.inflate(R.layout.message, parent, false);
        vh = new IncomingViewHolder();
        vh.messageTextView = (TextView) convertView.findViewById(R.id.messageTextView);
        vh.timeTextView = (TextView) convertView.findViewById(R.id.timeTextView);

        convertView.setTag(vh);

      } else {
        vh = (IncomingViewHolder) convertView.getTag();
      }

      vh.messageTextView.setText(messages.get(position).getMessage());
      vh.timeTextView.setText(messages.get(position).getTime());

    }

    return convertView;
  }

  @Override public int getItemViewType(int position) {
    if(messages.get(position).fromMe()) return 0;
    else return 1;
  }

  @Override public int getViewTypeCount() {
    return 2;
  }

  static class IncomingViewHolder {
    TextView messageTextView, timeTextView;
  }

  static class FromMeViewHolder {
    TextView mymessageTextView, mytimeTextView;
  }
}