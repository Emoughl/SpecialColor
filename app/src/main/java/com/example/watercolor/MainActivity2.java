package com.example.watercolor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.service.controls.templates.ControlButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.watercolor.object.MainActivity3;

public class MainActivity2 extends AppCompatActivity {
    EditText edtemail, edtpassword;
    Button btndangky, btndangnhap, btnthoat;
    String ten, mk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Anhxa();
        ControlButton();
    }

    private void ControlButton() {
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn thực sự muốn thoát");
                builder.setMessage("Hãy lựa chọn bên dưới để xác nhận");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });

        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity2.this);
                dialog.setTitle("Hộp thoại xử lý");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.customdialog);
                EditText edttk = (EditText) dialog.findViewById(R.id.edttk);
                EditText edtmk = (EditText) dialog.findViewById(R.id.edtmk);
                EditText edtxnmk = (EditText) dialog.findViewById(R.id.edtxnmk);
                Button btnhuy = (Button) dialog.findViewById(R.id.buttonhuy);
                Button btnxacnhan = (Button) dialog.findViewById(R.id.buttonxacnhan);
                btnxacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ten = edttk.getText().toString().trim();
                        mk = edtmk.getText().toString().trim();
                        edtemail.setText(ten);
                        edtpassword.setText(mk);
                        dialog.cancel();

                    }


                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });

        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtemail.getText().length() != 0 && edtpassword.getText().length() != 0) {
                    if (edtemail.getText().toString().equals(ten) && edtpassword.getText().toString().equals(mk)) {
                        Toast.makeText(MainActivity2.this, "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                        startActivity(intent);
                    } else if (edtemail.getText().toString().equals("Huy") && edtpassword.getText().toString().equals("123")) {

                        Toast.makeText(MainActivity2.this, "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity2.this, "Đăng Nhập Thất Bại", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity2.this, "Hãy Nhập Đủ Thông Tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Anhxa () {
        edtemail = (EditText) findViewById(R.id.edittextemail);
        edtpassword = (EditText) findViewById(R.id.edittextpassword);
        btndangky = (Button) findViewById(R.id.buttondangky);
        btndangnhap = (Button) findViewById(R.id.buttondangnhap);
        btnthoat = (Button) findViewById(R.id.buttonthoat);
    }


    }
