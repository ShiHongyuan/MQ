package com.shy;
/**
 *
 * 测试生产者生产消息
 */
public class TestProducer {
    public static void main(String[] args){
        Producer producer = new Producer();
        producer.init();
        TestProducer testMq = new TestProducer();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Thread 1
        new Thread(testMq.new ProductorMq(producer)).start();
        //Thread 2
        new Thread(testMq.new ProductorMq(producer)).start();
        //Thread 3
        new Thread(testMq.new ProductorMq(producer)).start();
        //Thread 4
        new Thread(testMq.new ProductorMq(producer)).start();
        //Thread 5
        new Thread(testMq.new ProductorMq(producer)).start();
    }

    private class ProductorMq implements Runnable{
        Producer producer;
        public ProductorMq(Producer producer){
            this.producer = producer;
        }

        public void run() {
            while(true){
                try {
                    producer.sendMessage("Shy-MQ");
                    System.out.println("------------------------------------");
                    System.out.println("---------shy test no use------------");
                    System.out.println("------------------------------------");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
