package com.hfad.post_example2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements ListAdapterWithRecycleView.image_listener, ListAdapterWithRecycleView.video_listener{

    Button pick;
    Button post;
    RecyclerView recyclerView;
    EditText post_text;

    static String TAG = "yoooooooooooo";

    ListAdapterWithRecycleView listAdapterWithRecycleView;


    List<Uri> uris = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pick = findViewById(R.id.pick);
        recyclerView = findViewById(R.id.recycler_view);
        post_text = findViewById(R.id.post_text);
        post = findViewById(R.id.post);

        listAdapterWithRecycleView = new ListAdapterWithRecycleView(uris,this, (ListAdapterWithRecycleView.video_listener) this,this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listAdapterWithRecycleView);


        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
                    return;
                }

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_MIME_TYPES, new String[] {"image/*", "video/*"});
                startActivityForResult(intent, 1);

            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == 1 && resultCode == RESULT_OK) {

            ClipData clipData = data.getClipData();

            if (clipData != null)
            {

                //Toast.makeText(this,"set_images",Toast.LENGTH_LONG).show();
                for (int i = 0; i < clipData.getItemCount(); i++) {
                    Uri dataUri = clipData.getItemAt(i).getUri();

                    uris.add(dataUri);

                }

                listAdapterWithRecycleView.notifyDataSetChanged();
                recyclerView.scrollToPosition(uris.size()-1);

                Toast.makeText(this,""+recyclerView.getAdapter().getItemCount(),Toast.LENGTH_LONG).show();

            }

            else
            {
                Toast.makeText(this,"Select at least one image or video!",Toast.LENGTH_LONG).show();
            }

            return;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    /*public static JSONObject uploadImage(String memberId, String sourceImageFile) {

        try {
            File sourceFile = new File(sourceImageFile);



            final MediaType MEDIA_TYPE = sourceImageFile.endsWith("png") ?
                    MediaType.parse("image/png") : MediaType.parse("image/jpeg");


            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("uploaded_file", filename, RequestBody.create(MEDIA_TYPE_PNG, sourceFile))
                    .addFormDataPart("result", "my_image")
                    .build();

            Request request = new Request.Builder()
                    .url("URL_UPLOAD_IMAGE")
                    .post(requestBody)
                    .build();

            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();
            return new JSONObject(response.body().string());

        } catch (UnknownHostException | UnsupportedEncodingException e) {
            Log.e(TAG, "Error: " + e.getLocalizedMessage());
        } catch (Exception e) {
            Log.e(TAG, "Other Error: " + e.getLocalizedMessage());
        }
        return null;
    }*/



    @Override
    public void image_click(int position) {
        UriHelper.getInstance().setUri(uris.get(position));
        Intent intent = new Intent(this,user_image_view.class);
        startActivity(intent);
    }

    @Override
    public void video_click(int position) {
        Toast.makeText(this,"set_images",Toast.LENGTH_LONG).show();
        UriHelper.getInstance().setUri(uris.get(position));
        Intent intent = new Intent(this,user_video_view.class);
        startActivity(intent);
    }
}
















