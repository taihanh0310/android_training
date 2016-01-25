package com.example.nthanh.selectionlistview;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SelectionListViewActivity extends ListActivity {
    TextView selection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //set list Adapter for mutil choise
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, WORLDCUP2010));
        //setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, WORLDCUP2010));
        final ListView listView = getListView();
        listView.setItemsCanFocus(true);
        //list view chon dc nhieu item
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        selection = (TextView) findViewById(R.id.selection);
    }

    public void onListItemClick(ListView parent, View v,
                                int position,long id) {
        selection.setText(WORLDCUP2010[position]);
    }

    static final String[] WORLDCUP2010 = new String[] {
            "Algeria",  "Argentina", "Australia",
            "Brazil", "Cote d'Ivoire", "Cameroon",
            "Chile", "Costa Rica", "Denmark",
            "England", "France", "Germany",
            "Ghana",  "Greece", "Honduras",
            "Italy",  "Japan", "Netherlands",
            "New Zealand", "Nigeria", "North Korea",
            "Paraguay", "Portugal","Serbia",
            "Slovakia", "Slovenia", "South Africa",
            "South Korea",  "Spain", "Switzerland",
            "United States", "Uruguay" };
}
