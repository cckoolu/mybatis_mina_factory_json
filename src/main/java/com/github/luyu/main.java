package com.github.luyu;



import com.github.luyu.Entity.car_attr;
import com.github.luyu.Entity.currency_attr;
import com.github.luyu.dao.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class main {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        try (SqlSession session = sqlSessionFactory.openSession()) {
            BusMapper mapper = session.getMapper(BusMapper.class);
//            查询bus数量
            int bus_two = mapper.count2();
            System.out.println(bus_two);

            int bus_one = mapper.count1();
            System.out.println(bus_one);
            }



        try (SqlSession session = sqlSessionFactory.openSession()) {
            AttrMapper mapper = session.getMapper(AttrMapper.class);
//            查询车牌为123的
            currency_attr num_one = mapper.num1();
            System.out.println(num_one.toString());

            currency_attr num_two = mapper.num2();
            System.out.println(num_two.toString());

            currency_attr num_four = mapper.subQuery();
            System.out.println(num_four.toString());

            currency_attr num_three = mapper.num3();
            System.out.println(num_three.toString());
            }


        try (SqlSession session = sqlSessionFactory.openSession()) {
            CarMapper mapper = session.getMapper(CarMapper.class);
//            查询车辆总数
            int count = mapper.count();
            System.out.println(count);
//            通缉车辆
            car_attr car = mapper.wanted();
            System.out.println(car.getCar_id());
//            多表查询
            }

//        增
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            insert insert = session.getMapper(insert.class);
//            insert.one();
//            session.commit();
//
//        }
//
////        删
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            delete del = session.getMapper(delete.class);
//            del.two();
//            session.commit();
//        }
////        改
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            update upd = session.getMapper(update.class);
//            upd.three();
//            session.commit();
//        }
//        创建视图索引
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            view view_one = session.getMapper(view.class);
//            view_one.four();
//            view_one.five();
//            session.commit();
//        }
    }
}

