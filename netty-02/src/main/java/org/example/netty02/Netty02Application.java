package org.example.netty02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
@SpringBootApplication
public class Netty02Application {

    public static void main(String[] args) {

        //FiledChannel
        //获取通道
        //输人输出流
        //这里直接扫描文件名可能扫不出来 换成绝对路径
        try (FileChannel channel = new FileInputStream("D:\\workspace\\netty-demo\\netty-demo\\netty-02\\test.txt").getChannel()) {
            channel.position(0);
            //准备缓冲区 静态方法分配空间 划分缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while(true){

                int len = channel.read(buffer);
            buffer.flip(); //切换读模式
            while (buffer.hasRemaining()) {
                byte b = buffer.get();
                log.info("{}", (char)b); //字节强转字符
                System.out.println((char)b);

            }
            buffer.clear();
            if(len == -1){
                break;
            }
            }
        } catch (IOException e) {
            System.out.println("============");

        }
    }

}
