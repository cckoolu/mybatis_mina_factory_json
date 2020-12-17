package com.github.luyu.mina;


import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.nio.charset.StandardCharsets;

public class TimeServerHandler extends IoHandlerAdapter {

    public static MinaTimeServer minaTimeServer = new MinaTimeServer();

    public static void data() {
        minaTimeServer.select();
//        minaTimeServer.delete();
//        minaTimeServer.update();
//        minaTimeServer.insert();
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String str =new String((byte[]) message, StandardCharsets.UTF_8);
        System.out.println(str);
        JsonTest jsonTest = JsonUtils.fromJson(str, JsonTest.class);
        assert jsonTest != null;

        if ( jsonTest.getKey().equalsIgnoreCase("quit") ) {
            if ( jsonTest.getKey1().equalsIgnoreCase("quit") ) {
                session.write("quit\n" + "\n" + "quit\n");
                sessionClosed(session);
            }
            else if ( jsonTest.getKey1().equalsIgnoreCase("select") ) {
                session.write("quit\n" + "\n" + minaTimeServer.select());
            }
            else if (jsonTest.getKey1().equalsIgnoreCase("insert")) {
                session.write("quit\n" + "\n" + minaTimeServer.insert());
            }
            else if ( jsonTest.getKey1().equalsIgnoreCase("delete") ) {
                session.write("quit\n" + "\n" + minaTimeServer.delete());
            }
            else if ( jsonTest.getKey1().equalsIgnoreCase("update") ) {
                session.write("quit\n" + "\n" + minaTimeServer.update());
            }
            else  {
                session.write("quit\n" + "\n" + minaTimeServer.constant());
            }
//            session.write("quit\n");
//            sessionClosed(session);
        }
        else if ( jsonTest.getKey().equalsIgnoreCase("select") ) {
            if ( jsonTest.getKey1().equalsIgnoreCase("quit") ) {
                session.write(minaTimeServer.select() + "\n" + "quit\n");
                sessionClosed(session);
            }
            else if (jsonTest.getKey1().equalsIgnoreCase("insert")) {
                session.write(minaTimeServer.select() + "\n" + minaTimeServer.insert());
            }
            else if ( jsonTest.getKey1().equalsIgnoreCase("select") ) {
                session.write(minaTimeServer.select() + "\n" + minaTimeServer.select());
            }

            else if ( jsonTest.getKey1().equalsIgnoreCase("delete") ) {
                session.write(minaTimeServer.select() + "\n" + minaTimeServer.delete());
            }
            else if ( jsonTest.getKey1().equalsIgnoreCase("update") ) {
                session.write(minaTimeServer.select() + "\n" + minaTimeServer.update());
            }
            else  {
                session.write(minaTimeServer.select() + "\n" + minaTimeServer.constant());
            }
//            session.write(minaTimeServer.select());
        }
        else if ( jsonTest.getKey().equalsIgnoreCase("insert") ) {
            if (jsonTest.getKey1().equalsIgnoreCase("quit")) {
                session.write(minaTimeServer.insert() + "\n" + "quit\n");
                sessionClosed(session);
            }
            else if (jsonTest.getKey1().equalsIgnoreCase("select")) {
                session.write(minaTimeServer.insert() + "\n" + minaTimeServer.select());
            }
            else if (jsonTest.getKey1().equalsIgnoreCase("insert")) {
                session.write(minaTimeServer.insert() + "\n" + minaTimeServer.insert());
            }
            else if (jsonTest.getKey1().equalsIgnoreCase("delete")) {
                session.write(minaTimeServer.insert() + "\n" + minaTimeServer.delete());
            }
            else if (jsonTest.getKey1().equalsIgnoreCase("update")) {
                session.write(minaTimeServer.insert() + "\n" + minaTimeServer.update());
            }
        }
        else if ( jsonTest.getKey().equalsIgnoreCase("delete") ) {
            if ( jsonTest.getKey1().equalsIgnoreCase("quit") ) {
                session.write(minaTimeServer.delete() + "\n" + "quit\n");
                sessionClosed(session);
            }
            else if ( jsonTest.getKey1().equalsIgnoreCase("select") ) {
                session.write(minaTimeServer.delete() + "\n" + minaTimeServer.select());
            }
            else if (jsonTest.getKey1().equalsIgnoreCase("insert")) {
                session.write(minaTimeServer.delete() + "\n" + minaTimeServer.insert());
            }
            else if ( jsonTest.getKey1().equalsIgnoreCase("delete") ) {
                session.write(minaTimeServer.delete() + "\n" + minaTimeServer.delete());
            }
            else if ( jsonTest.getKey1().equalsIgnoreCase("update") ) {
                session.write(minaTimeServer.delete() + "\n" + minaTimeServer.update());
            }
            else  {
                session.write(minaTimeServer.delete() + "\n" + minaTimeServer.constant());
            }
//            session.write(minaTimeServer.delete());
        }
        else if ( jsonTest.getKey().equalsIgnoreCase("update") ) {
            if ( jsonTest.getKey1().equalsIgnoreCase("quit") ) {
                session.write(minaTimeServer.update() + "\n" + "quit\n");
                sessionClosed(session);
            }
            else if ( jsonTest.getKey1().equalsIgnoreCase("select") ) {
                session.write(minaTimeServer.update() + "\n" + minaTimeServer.select());
            }
            else if (jsonTest.getKey1().equalsIgnoreCase("insert")) {
                session.write(minaTimeServer.update() + "\n" + minaTimeServer.insert());
            }
            else if ( jsonTest.getKey1().equalsIgnoreCase("delete") ) {
                session.write(minaTimeServer.update() + "\n" + minaTimeServer.delete());
            }
            else if ( jsonTest.getKey1().equalsIgnoreCase("update") ) {
                session.write(minaTimeServer.update() + "\n" + minaTimeServer.update());
            }
            else  {
                session.write(minaTimeServer.update() + "\n" + minaTimeServer.constant());
            }
//            session.write(minaTimeServer.update());
        }
        else  {
            if ( jsonTest.getKey1().equalsIgnoreCase("quit") ) {
                session.write(minaTimeServer.constant() + "\n" + "quit\n");
                sessionClosed(session);
            }
            else if ( jsonTest.getKey1().equalsIgnoreCase("select") ) {
                session.write(minaTimeServer.constant() + "\n" + minaTimeServer.select());
            }
            else if ( jsonTest.getKey1().equalsIgnoreCase("delete") ) {
                session.write(minaTimeServer.constant() + "\n" + minaTimeServer.delete());
            }
            else if ( jsonTest.getKey1().equalsIgnoreCase("update") ) {
                session.write(minaTimeServer.constant() + "\n" + minaTimeServer.update());
            }
            else if (jsonTest.getKey1().equalsIgnoreCase("insert")) {
                session.write(minaTimeServer.constant() + "\n" + minaTimeServer.insert());
            }
            else  {
                session.write(minaTimeServer.constant() + "\n" + minaTimeServer.constant());
            }
        }
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println("IDLE " + session.getIdleCount(status));
    }

}

class JsonTest{
    String key;
    String key1;

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}