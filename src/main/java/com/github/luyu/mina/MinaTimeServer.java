package com.github.luyu.mina;

import com.github.luyu.Entity.currency_attr;
import com.github.luyu.dao.AttrMapper;
import com.github.luyu.dao.delete;
import com.github.luyu.dao.insert;
import com.github.luyu.dao.update;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;


public class MinaTimeServer {

    private static final int PORT = 7000;

    public static void main(String[] args) throws IOException {
        TimeServerHandler.data();

        NioSocketAcceptor acceptor = new NioSocketAcceptor();
        System.out.println("begin server....");
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        acceptor.getFilterChain().addLast("coder", new ProtocolCodecFilter(new ByteArrayCodecFactory()));

        acceptor.setReuseAddress(true);
        acceptor.setHandler(new TimeServerHandler());
        acceptor.getSessionConfig().setReadBufferSize(2048);
        acceptor.bind(new InetSocketAddress(PORT));
    }

//    查
    public String select() {
        String json;
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AttrMapper mapper = session.getMapper(AttrMapper.class);

            //            查询车牌为123的
            currency_attr num_one = mapper.num1();

            Map<String, Object> foo = new HashMap<>();
            foo.put("attr_id", num_one.getAttr_id());
            foo.put("wheel", num_one.getWheel());
            foo.put("dyn_sys", num_one.getDyn_sys());
            foo.put("exh_sys", num_one.getExh_sys());
            foo.put("member", num_one.getMember());
            foo.put("size", num_one.getSize());
            foo.put("car_door", num_one.getCar_door());
            foo.put("car_light", num_one.getCar_light());
            foo.put("Clutch", num_one.getClutch());
            foo.put("car_window", num_one.getCar_window());
            foo.put("fuel", num_one.getFuel());
            foo.put("car_color", num_one.getCar_color());
            foo.put("car_attr", num_one.getCar_attr());
            json = JsonUtils.toJson(foo);
        }
        return json;
    }
//    增     需加上 session.commit(); 生效
    public String insert() {
        String json;
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            insert ins = session.getMapper(insert.class);
            ins.one();
            session.commit();
            Map<String, Object> foo = new HashMap<>();
            foo.put("code", "已增加");
            json = JsonUtils.toJson(foo);
        } catch (Exception e) {
            Map<String, Object> foo = new HashMap<>();
            foo.put("code", "增加失败");
            json = JsonUtils.toJson(foo);
        }
        return json;
    }
//    删     需加上 session.commit(); 生效
    public String delete() {
        String json;
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            delete del = session.getMapper(delete.class);
            del.two();
            session.commit();
            Map<String, Object> foo = new HashMap<>();
            foo.put("code", "已删除");
            json = JsonUtils.toJson(foo);
        }
        return json;
    }
//    改     需加上 session.commit(); 生效
    public String update() {

        String json;
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            update upd = session.getMapper(update.class);
            upd.three();
            session.commit();

            Map<String, Object> foo = new HashMap<>();
            foo.put("code", "已更改");
            json = JsonUtils.toJson(foo);
        }
        return json;
        }
//    其他json数据，均响应为已收到
    public String constant() {
        String json;
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {

            Map<String, Object> foo = new HashMap<>();
            foo.put("code", "已收到");
            json = JsonUtils.toJson(foo);
        }
        return json;
    }
}



