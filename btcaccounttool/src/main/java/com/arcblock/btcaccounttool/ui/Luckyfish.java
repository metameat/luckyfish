package com.arcblock.btcaccounttool.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.apollographql.apollo.api.Mutation;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.arcblock.btcaccounttool.EthHelp;
import com.arcblock.btcaccounttool.PublisherInfo;
import com.arcblock.btcaccounttool.R;
import com.arcblock.btcaccounttool.btc.AccountByAddressQuery;
import com.arcblock.btcaccounttool.btc.RichestAccountsQuery;
import com.arcblock.corekit.ABCoreKitClient;
import com.arcblock.corekit.CoreKitMutation;
import com.arcblock.corekit.CoreKitPagedQuery;
import com.arcblock.corekit.CoreKitQuery;

import org.jetbrains.annotations.NotNull;

public class Luckyfish extends AppCompatActivity {


    public boolean fordemo = true;


    private EditText publisherAddressEdt;
    private ImageView publisherAddressScan;

    private EditText privateAddressEdt;
    private ImageView privateAddressScan;

    private TextView numberleftView;
    private ScrollView joiningRealtime;
    private Button join;
    private Button confirm;

    private PublisherInfo publisherInfo;
    private TextView publisherView;

//    private CoreKitQuery mCore = new CoreKitQuery(this, EthHelp.getInstance().abCoreKitClient());
    private CoreKitQuery mCore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luckgame);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();


    }
    void initView() {
        publisherAddressEdt = findViewById(R.id.luck_search_et);
        privateAddressEdt = findViewById(R.id.luck_search_et_private);

        publisherAddressScan = findViewById(R.id.luck_scan_iv);
        privateAddressScan = findViewById(R.id.luck_scan_iv_private);

        numberleftView = findViewById(R.id.numberleft_tv);
        joiningRealtime = findViewById(R.id.joiningRealtime_scv);
        confirm = findViewById(R.id.confirm_bt);
        publisherView = findViewById(R.id.publisherInfo_tv);


        publisherAddressScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fordemo) {
                    publisherAddressEdt.setText("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa,338888,100,0");
                    publisherView.setText("publisherAdd:1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa\n");
                    publisherView.append("publishedTime(block height):338888\n");
                    publisherView.append("how many players expected:1000\n");
                    publisherView.append("attendFee : 0.00001");
                }

            }
        });

        privateAddressScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fordemo) {
                    privateAddressEdt.setText("5A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa");
                }
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String publisherInfoString = String.valueOf(publisherAddressEdt.getText());

                //check validation
                if (validate(publisherInfoString)) {
                    publisherInfo = getPublisherInfo(publisherInfoString);

                    long currentPlayerNum = 10;
                    long leftNum = publisherInfo.getPlayersNum()-currentPlayerNum;
//                    long currentPlayerNum = mCore.query(AccountByAddressQuery.builder().address(publisherInfo.getAddress()).build()) - publisherInfo.getPlayersNum();
                    numberleftView.setText("当前参与人数:" + currentPlayerNum + ",剩余名额:" + leftNum);



                }
            }
        });

        join = findViewById(R.id.join_bt);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CoreKitMutation coreKitMutation = new CoreKitMutation(Luckyfish.this, EthHelp.getInstance().abCoreKitClient());
//                coreKitMutation.mutation(new Mutation() {
//                    @Override
//                    public String queryDocument() {
//                        return null;
//                    }
//
//                    @Override
//                    public Variables variables() {
//                        return null;
//                    }
//
//                    @Override
//                    public ResponseFieldMapper responseFieldMapper() {
//                        return null;
//                    }
//
//                    @Override
//                    public Object wrapData(Data data) {
//                        return null;
//                    }
//
//                    @NotNull
//                    @Override
//                    public OperationName name() {
//                        return null;
//                    }
//
//                    @NotNull
//                    @Override
//                    public String operationId() {
//                        return null;
//                    }
//                }, new CoreKitResultListener<XXMutation.Data>() {
//                    @Override
//                    public void onSuccess(XXMutation.Data data) {
//                        // 获得数据
//                    }
//
//                    @Override
//                    public void onError(String errMsg) {
//                        // 获得错误信息
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        // 查询结束
//                    }
//                });
            }
        });

    }

    private boolean validate(String publisherString) {
        return true;
    }
    private PublisherInfo getPublisherInfo(String publisherString) {
        return new PublisherInfo();
    }
}
