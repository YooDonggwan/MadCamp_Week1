//package com.example.application1;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import java.util.Random;
//
//public class Game2Activity extends Activity {
//
//    View view;
//    TextView now_num; // 현재 숫자 담아줄 텍스트뷰
//    RelativeLayout button[] = new RelativeLayout[25]; // 버튼 25개
//    TextView button_text[] = new TextView[25]; // 버튼에 들어갈 텍스트뷰 25개
//    RelativeLayout start_btn; // 스타트 버튼
//    RelativeLayout ok_btn;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.game_card);
//
//        all_view();
////        view.setVisibility(View.VISIBLE);
//        game();
//        allclick();
//    }
//
//    int num_list1, num_list2;
//    private void game(){
//        for(num_list1 = 1; num_list1 <= 2; num_list1++){
//            for(num_list2 = 1; num_list2 <= 25; num_list2++){
//                random_put();
//            }
//        }
//    }
//    int match_number_int = 1;
//    int random_button_number_int;
//    int[] button_number_01 = new int[25];
//    int[] button_number_02 = new int[25];
//    private void random_put(){
//        Random random = new Random();
//        random_button_number_int = random.nextInt(25);
//        if(num_list1 == 1 && button_number_01[(random_button_number_int)] == 0) {
//            button_number_01[(random_button_number_int)] = num_list2;
//        }else if(num_list1 == 1 && num_list2 <= 25){
//            random_put();
//        }
//        if(num_list1 == 2 && button_number_02[(random_button_number_int)] == 0) {
//            button_number_02[(random_button_number_int)] = (num_list2+25);
//        }else if(num_list1 == 2 && num_list2 <= 25){
//            random_put();
//        }
//    }
//    private void all_view() {
//        view = findViewById(R.id.game_view);
//        now_num = (TextView)findViewById(R.id.now_number);
//        button[0] = (RelativeLayout)findViewById(R.id.button_1);
//        button[1] = (RelativeLayout)findViewById(R.id.button_2);
//        button[2] = (RelativeLayout)findViewById(R.id.button_3);
//        button[3] = (RelativeLayout)findViewById(R.id.button_4);
//        button[4] = (RelativeLayout)findViewById(R.id.button_5);
//        button[5] = (RelativeLayout)findViewById(R.id.button_6);
//        button[6] = (RelativeLayout)findViewById(R.id.button_7);
//        button[7] = (RelativeLayout)findViewById(R.id.button_8);
//        button[8] = (RelativeLayout)findViewById(R.id.button_9);
//        button[9] = (RelativeLayout)findViewById(R.id.button_10);
//        button[10] = (RelativeLayout)findViewById(R.id.button_11);
//        button[11] = (RelativeLayout)findViewById(R.id.button_12);
//        button[12] = (RelativeLayout)findViewById(R.id.button_13);
//        button[13] = (RelativeLayout)findViewById(R.id.button_14);
//        button[14] = (RelativeLayout)findViewById(R.id.button_15);
//        button[15] = (RelativeLayout)findViewById(R.id.button_16);
//        button[16] = (RelativeLayout)findViewById(R.id.button_17);
//        button[17] = (RelativeLayout)findViewById(R.id.button_18);
//        button[18] = (RelativeLayout)findViewById(R.id.button_19);
//        button[19] = (RelativeLayout)findViewById(R.id.button_20);
//        button[20] = (RelativeLayout)findViewById(R.id.button_21);
//        button[21] = (RelativeLayout)findViewById(R.id.button_22);
//        button[22] = (RelativeLayout)findViewById(R.id.button_23);
//        button[23] = (RelativeLayout)findViewById(R.id.button_24);
//        button[24] = (RelativeLayout)findViewById(R.id.button_25);
//        button_text[0] = (TextView)findViewById(R.id.button_text_1);
//        button_text[1] = (TextView)findViewById(R.id.button_text_2);
//        button_text[2] = (TextView)findViewById(R.id.button_text_3);
//        button_text[3] = (TextView)findViewById(R.id.button_text_4);
//        button_text[4] = (TextView)findViewById(R.id.button_text_5);
//        button_text[5] = (TextView)findViewById(R.id.button_text_6);
//        button_text[6] = (TextView)findViewById(R.id.button_text_7);
//        button_text[7] = (TextView)findViewById(R.id.button_text_8);
//        button_text[8] = (TextView)findViewById(R.id.button_text_9);
//        button_text[9] = (TextView)findViewById(R.id.button_text_10);
//        button_text[10] = (TextView)findViewById(R.id.button_text_11);
//        button_text[11] = (TextView)findViewById(R.id.button_text_12);
//        button_text[12] = (TextView)findViewById(R.id.button_text_13);
//        button_text[13] = (TextView)findViewById(R.id.button_text_14);
//        button_text[14] = (TextView)findViewById(R.id.button_text_15);
//        button_text[15] = (TextView)findViewById(R.id.button_text_16);
//        button_text[16] = (TextView)findViewById(R.id.button_text_17);
//        button_text[17] = (TextView)findViewById(R.id.button_text_18);
//        button_text[18] = (TextView)findViewById(R.id.button_text_19);
//        button_text[19] = (TextView)findViewById(R.id.button_text_20);
//        button_text[20] = (TextView)findViewById(R.id.button_text_21);
//        button_text[21] = (TextView)findViewById(R.id.button_text_22);
//        button_text[22] = (TextView)findViewById(R.id.button_text_23);
//        button_text[23] = (TextView)findViewById(R.id.button_text_24);
//        button_text[24] = (TextView)findViewById(R.id.button_text_25);
//        start_btn = (RelativeLayout)findViewById(R.id.game_view); //// 틀릴꺼 같음
//        ok_btn = (RelativeLayout)findViewById(R.id.game_view);
//    }
//    int button_num;
//    private void allclick(){
//        for (int i = 0; i < 25; i++) {
//            final int j = i;
//            button[j].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(match_number_int == 50) {
//                        view.setVisibility(View.VISIBLE);
//                    }
//                    int number = j;
//                    if(match_number_int == button_number_01[number]) {
//                        match_number_int += 1;
//                        button_text[number].setText(Integer.toString(button_number_02[number]));
//                    }
//                    if(match_number_int == button_number_02[number]) {
//                        match_number_int += 1;
//                        button_text[number].setVisibility(View.GONE);
//                    }
//                    now_num.setText(Integer.toString(match_number_int));
//                }
//            });
//        }
//        ok_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                match_number_int = 1;
//                for(int reset_button_number = 0; reset_button_number <= 24; reset_button_number++) {
//                    button_number_01[reset_button_number] = 0;
//                    button_number_02[reset_button_number] = 0;
//                    button_text[reset_button_number].setVisibility(View.VISIBLE);
//                }
//                view.setVisibility(View.VISIBLE);
//                game();
//            }
//        });
//    }
//
//
//
//
//}
