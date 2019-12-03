package com.licy.getcontextfromprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.licy.getcontextfromprovider.helper.ContextProvider;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tvContext;
    TextView tvApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContext = findViewById(R.id.tv_context);
        tvApp = findViewById(R.id.tv_app);

        tvContext.setText(ContextProvider.get().getContext().toString());
        tvApp.setText(ContextProvider.get().getApplication().toString());
    }
}
