//package com.example.application1;
//
//import android.app.Activity;
//import android.content.ContentProviderOperation;
//import android.content.OperationApplicationException;
//import android.os.Bundle;
//import android.os.RemoteException;
//import android.provider.ContactsContract;
//
//import java.util.ArrayList;
//
//public class ContactAddActivity extends Activity {
//
//
//    @Override
//    protected  void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView();
//
//    }
//
//
//
//
//
//    public void ContactAdd(final String name, final String phone_num){
//        new Thread(){
//            @Override
//            public void run() {
//
//                ArrayList<ContentProviderOperation> list = new ArrayList<>();
//                try{
//                    list.add(
//                            ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
//                                    .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
//                                    .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
//                                    .build()
//                    );
//                    list.add(
//                            ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
//                                    .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
//                                    .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
//                                    .withValue(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, name)   //이름
//                                    .build()
//                    );
//                    list.add(
//                            ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
//                                    .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
//                                    .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
//                                    .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, phone_num)           //전화번호
//                                    .withValue(ContactsContract.CommonDataKinds.Phone.TYPE  , ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)   //번호타입(Type_Mobile : 모바일)
//                                    .build()
//                    );
////                    list.add(
////                            ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
////                                    .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
////                                    .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)
////                                    .withValue(ContactsContract.CommonDataKinds.Email.DATA  , "hong_gildong@naver.com")  //이메일
////                                    .withValue(ContactsContract.CommonDataKinds.Email.TYPE  , ContactsContract.CommonDataKinds.Email.TYPE_WORK)     //이메일타입(Type_Work : 직장)
////                                    .build()
////                    );
//                    getApplicationContext().getContentResolver().applyBatch(ContactsContract.AUTHORITY, list);  //주소록추가
//                    list.clear();   //리스트 초기화
//                }catch(RemoteException e){
//                    e.printStackTrace();
//                }catch(OperationApplicationException e){
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//    }
//}
