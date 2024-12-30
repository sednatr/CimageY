package com.example.cimage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.json.JSONObject;

import com.peersafe.base.client.pubsub.Publisher.Callback;
import com.peersafe.chainsql.core.Chainsql;
import com.peersafe.chainsql.core.Ripple;
import com.peersafe.chainsql.core.Submit.SyncCond;
import com.peersafe.chainsql.net.Connection;
import com.peersafe.chainsql.util.Util;
@SpringBootApplication
public class CimageApplication {

    public static final Chainsql c = new Chainsql();
//    public static String gmRootAddress = "zHb9CJAWyB4zj91VRWn96DkukG4bwdtyTh";
//    public static String gmRootSecret = "xnoPBzXtMeMyMHUVTgbuqAfg1SUTb";


    public static String gmRootAddress = "zEaXgaZwvypMQrLp4cbdG269pw1G1Fznjq";
    public static String gmRootSecret = "xhsdaE9E1cocnenXJYjsWzc6VWFiW";
    //@Autowired
    //private FieldRepository fieldRepository;

    @PostMapping("/saveField")
    public static void main(String[] args) {

        try {
            /*String sslKeyPath = "/Path/to/your/client.key";192.168.0.47:6006")
            String sslCertPath = "/Path/to/your/client.crt";
            String[] trustCAsPath = {"/Path/to/your/root.crt",
                    "/Path/to/your/root2.crt"};*/
            Connection con = c.connect("ws://192.168.3.47:6006");
            // c.connect("wss://127.0.0.1:6006", trustCAsPath);
            if (con == null) {
                System.out.println("can not connect");
                return;
            }
            c.as(gmRootAddress, gmRootSecret);

            //testRipple();
            //testChainSql();
            String sTableName = "test_chainsql0222";
            //int age0 = 4;
            String age1 = "汽轮机Inconel_718 火电机状通道";
            String age2 = "Inconel_718_批次_2023.4.26_1226";
            String age3 = "sample_4";
            String age4 = "杨承渝";
            String age5 = "2023-02-25 18:37:16";
            String age6 = "6f ";
            String age7 = "7f ";
            for (int i = 0; i < 1; i++) {
                //List<String> orgs = Util.array("{'id':" + a1 + ",'CIFSEQjk':'D://projecteYuploadfd','agfefgh':" + a3 + "}");
                //List<String> orgs = Util.array("{'id':" + a1 + ",'CIFSEQjk':" + a2 + ",'agfefgh':" + a3 + "}");
                //List<String> orgs = Util.array("{\"FOLDER_ID\":" + name + ",\"FOLDER_NAME\":" + age + ",\"PARENT_FOLDER_ID\":" + filePath1 + "}");
                //List<String> orgs = Util.array("{\"FOLDER_ID\":" + age0 + ",\"IMAGE_NAME\":" + age1 + ",\"IMAGE_PATH\":" + age2 + ",\"IMAGE_TYPE\":" + age3 + ",\"IMAGE_STATE\":" + age4 + ",\"IMAGE_DATE\":" + age5 + ",\"FOLDER_ID\":" + age6 + "}");
                JSONObject obj = new JSONObject();
                //obj.put("DATA_ID", age0);
                obj.put("DATA_SET", age1);
                obj.put("BATCH", age2);
                obj.put("TEST_ITEM", age3);
                obj.put("CREATOR", age4);
                obj.put("CREAT_TIME", age5);
                obj.put("REMARK", age6);
                obj.put("DETAILS", age7);

                String jsonString = obj.toString();
                List<String> orgs = Util.array(jsonString);
                JSONObject obj1;
                obj1 = c.table(sTableName).insert(orgs).submit(SyncCond.db_success);
                System.out.println("insert result:" + obj1);
            }
                // testSchema();
                // testGM();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    /*private static void testChainSql() {
        CimageApplication test = new CimageApplication();
        //建表
        test.testinsert();
    }

    public void testinsert() {
        String sTableName = "gmTestghj";
        int a1 = 3457;
        int a2 = 3457;
        int a3 = 3457;
        for(int i= 0; i<1; i++) {
            List<String> orgs = Util.array("{'idfdf5':"+ a1 +",'nafmef77':"+ a2 +",'agfefg7':"+ a3 +"}");
            JSONObject obj;
            obj = c.table(sTableName).insert(orgs).submit(SyncCond.db_success);
            System.out.println("insert result:" + obj);
        }
    }*/

}