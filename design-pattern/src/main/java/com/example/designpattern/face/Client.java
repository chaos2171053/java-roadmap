package com.example.designpattern.face;

public class Client {
    public static void main(String[] args) {
////普通模式需要这样
//        AliSmsService aliSmsService = new AliSmsServiceImpl();
//        EamilSmsService eamilSmsService = new EamilSmsServiceImpl();
//        WeiXinSmsService weiXinSmsService = new WeiXinSmsServiceImpl();
//        aliSmsService.sendSms();
//        eamilSmsService.sendSms();
//        weiXinSmsService.sendSms();
//利用外观模式简化方法
        new Computer().sendMsg();
    }
}
