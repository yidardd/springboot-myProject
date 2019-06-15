package com.mr.zk.test;

import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher.Event.KeeperState;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ZooKeeperProSync implements Watcher {

    private static ZooKeeper zookeeper;

    private static final int SESSION_TIME_OUT = 2000;

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void process(WatchedEvent event) {
        if (event.getState() == KeeperState.SyncConnected) {
            System.out.println("Watch received event");
            countDownLatch.countDown();
        }
    }

    /**
     * 连接zookeeper
     *     * @param host
     *     * @throws Exception
     *    
     */

    public void connectZookeeper(String host) throws Exception {
        zookeeper = new ZooKeeper(host, SESSION_TIME_OUT, this);
        countDownLatch.await();
        System.out.println("zookeeper connection success");
    }

    /**
     *     * 创建节点
     *     * @param path
     *     * @param data
     *     * @throws Exception
     *    
     */

    public String createNode(String path, String data) throws Exception {
        return this.zookeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    /**
     *     * 获取路径下所有子节点
     *     * @param path
     *     * @return
     *     * @throws KeeperException
     *     * @throws InterruptedException
     *    
     */
    public List<String> getChildren(String path) throws KeeperException, InterruptedException {
        List<String> children = zookeeper.getChildren(path, false);
        return children;
    }

    /**
     *     * 获取节点上面的数据
     *     * @param path  路径
     *     * @return
     *     * @throws KeeperException
     *     * @throws InterruptedException
     *    
     */
    public String getData(String path) throws KeeperException, InterruptedException {
        byte[] data = zookeeper.getData(path, false, null);
        if (data == null) {
            return "";
        }
        return new String(data);
    }

    public static void main(String[] args) throws Exception {
    //连接zookeeper并且注册一个默认的监听器
        zookeeper = new ZooKeeper("127.0.0.1:2181", 5000, //
                new ZooKeeperProSync());
        ZooKeeperProSync zooKeeperProSync = new ZooKeeperProSync();
        List<String> children = zooKeeperProSync.getChildren("/");
        for (String child : children) {
            System.out.println(child);
        }
    }

}