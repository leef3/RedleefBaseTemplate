package studios.redleef.redleefbasetemplate.Helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Fred Lee on 8/6/2015.
 */
public class CustomListAdapter extends BaseAdapter{

    Context context;
    protected ArrayList<Object> itemList;
    LayoutInflater inflater;

    public CustomListAdapter(Context context, ArrayList<Object> itemList)
    {
        this.itemList = itemList;
        this.context = context;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount()
    {
        return itemList.size();
    }
    public Object getItem(int position)
    {
        return itemList.get(position);
    }
    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = this.inflater.inflate(R.layout.lat_long_list_item, parent, false);

            //Find UI elements for Lat Long and Timestamp
            holder.LatitudeTextView = (TextView) convertView.findViewById(R.id.latitudeListItem);
            holder.LongitudeTextView = (TextView) convertView.findViewById(R.id.longitudeListItem);
            //Used to re-track the ingredient
            holder.LatitudeTextView.setTag(position);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //Get the current Employee Object
        Object item = itemList.get(position);

        //Set the contents of the UI elements
        holder.LatitudeTextView.setText(String.valueOf(item.getLatitude()));
        holder.LongitudeTextView.setText(String.valueOf(item.getLongitude()));

        return convertView;
    }


    private class ViewHolder {
        TextView LatitudeTextView;
        TextView LongitudeTextView;
    }

}