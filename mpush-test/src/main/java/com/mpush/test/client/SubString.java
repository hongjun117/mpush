package com.mpush.test.client;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class SubString {
    public static void main(String[] args) {
        String str = "{\"content\":\"{\\\"content\\\":\\\"MPush开源推送，1111 say:hello\\\",\\\"nid\\\":1,\\\"ticker\\\":\\\"你有一条新的消息,请注意查收\\\",\\\"title\\\":\\\"MPUSH推送\\\"}\",\"msgId\":\"msg_1\",\"msgType\":3}";
        String[] strArray = str.split("say:");
        strArray = strArray[1].split("\\\\");
        System.out.println(strArray[0]);
    }
}
