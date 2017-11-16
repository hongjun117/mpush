/*
 * (C) Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *   ohun@live.cn (夜色)
 */

package com.mpush.test.sever;

import com.mpush.bootstrap.Main;
import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by yxx on 2016/5/16.
 *
 * @author ohun@live.cn
 */
public class ServerTestMain {

    public static void main(String[] args) {
        start();
    }

    @Test
    public void testServer() {
        start();
        LockSupport.park();
    }

    public static void start() {
        /**
         * 设置netty内存泄露级别
         * DISABLED, SIMPLE, ADVANCED, PARANOID;
         DISABLED（禁用）;: 不进行内存泄露的检测；
         SIMPLE（操作简单）: 抽样检测，且只对部分方法调用进行记录，消耗较小，有泄漏时可能会延迟报告，默认级别；
         ADVANCED（高级）: 抽样检测，记录对象最近几次的调用记录，有泄漏时可能会延迟报告；
         PARANOID（偏执）: 每次创建一个对象时都进行泄露检测，且会记录对象最近的详细调用记录。是比较激进的内存泄露检测级别，消耗最大，建议只在测试时使用。
         如果需要修改默认的检测级别，可以通过：1、调用静态方法setLevel进行修改；2、设置启动参数io.netty.leakDetectionLevel
         */
        System.setProperty("io.netty.leakDetection.level", "PARANOID");
        /**
         * io.netty.noKeySetOptimization开关决定Netty对Selector的selectedKeys进行了优化是否启用该优化项
         */
        System.setProperty("io.netty.noKeySetOptimization", "false");
        Main.main(null);
    }

}
