package com.example.bnb.spam.ui.contactread;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

import android.app.Activity;

import com.example.bnb.spam.R;


public class MainAct extends Activity {
    ArrayList<Contacts> listContacts;
    ListView lvContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        listContacts = new ContactFetcher(this).fetchAll();
        lvContacts = (ListView) findViewById(R.id.lvContacts);
        ContactsAdapter adapterContacts = new ContactsAdapter(this, listContacts);
        lvContacts.setAdapter(adapterContacts);
    }
}
