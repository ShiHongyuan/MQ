package com.shy;
/**
 *
 * 测试消费者消费消息
 */
public class TestComsumer {
    public static void main(String[] args){
        Comsumer comsumer = new Comsumer();
        comsumer.init();
        TestComsumer testConsumer = new TestComsumer();
        new Thread(testConsumer.new ComsumerMq(comsumer)).start();
        new Thread(testConsumer.new ComsumerMq(comsumer)).start();
        new Thread(testConsumer.new ComsumerMq(comsumer)).start();
        new Thread(testConsumer.new ComsumerMq(comsumer)).start();
    }

    private class ComsumerMq implements Runnable{
        Comsumer comsumer;
        public ComsumerMq(Comsumer comsumer){
            this.comsumer = comsumer;
        }

        public void run() {
            while(true){
                try {
                    comsumer.getMessage("Shy-MQ");
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
