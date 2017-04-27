package com.mycompany.myfirstapp.cor.fragment.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mycompany.myfirstapp.R;

/**
 * Created by wangz on 2017/4/16.
 */

public class ChatView extends AppCompatActivity implements View.OnClickListener{

    LinearLayout mChatContainer;
    EditText mMessage;
    Button mSend;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.page_message);
        mChatContainer = (LinearLayout) findViewById(R.id.chat_container);
        mMessage = (EditText) findViewById(R.id.editText);
        mSend = (Button) findViewById(R.id.btn_submitmsg);
        mSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String message = mMessage.getText().toString();
        View chatBox = getLayoutInflater().inflate(R.layout.page_chatbox, mChatContainer, false);
        ((TextView)chatBox.findViewById(R.id.textView6)).setText(message);
        mChatContainer.addView(chatBox);
        mMessage.setText("");
    }
}
