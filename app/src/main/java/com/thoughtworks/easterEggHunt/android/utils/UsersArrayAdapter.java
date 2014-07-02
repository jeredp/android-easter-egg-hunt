package com.thoughtworks.easterEggHunt.android.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.thoughtworks.easterEggHunt.R;
import com.thoughtworks.easterEggHunt.domain.User;

import java.util.List;

public class UsersArrayAdapter extends ArrayAdapter<User> {

    public UsersArrayAdapter(Context context, List<User> users) {
        super(context, R.layout.list_item);
        this.addAll(users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView userTextView;
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            userTextView = (TextView) convertView.findViewById(R.id.user);
        } else {
            userTextView = (TextView) convertView.findViewById(R.id.user);
        }

        userTextView.setText(getItem(position).getName());
        return convertView;
    }
}