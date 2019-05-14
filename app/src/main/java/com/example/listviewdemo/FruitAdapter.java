package com.example.listviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;
    private View view;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        //View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        //通过判断是否有缓存来优化加载速度
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruit_image = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruit_name = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);//将viewHold存储在view中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }


        viewHolder.fruit_image.setImageResource(fruit.getImageId());
        viewHolder.fruit_name.setText(fruit.getName());
        return view;
    }

    public FruitAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;

    }

    private class ViewHolder {
        ImageView fruit_image;
        TextView fruit_name;
    }
}
