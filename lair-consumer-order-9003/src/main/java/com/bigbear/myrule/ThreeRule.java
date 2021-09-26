package com.bigbear.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wuyd
 * 2021/9/23 15:06
 */
public class ThreeRule extends AbstractLoadBalancerRule {

    /**
     * 访问计数
     */
    private final AtomicInteger callCount;

    private final AtomicInteger nextServerCyclicCounter;

    private static final Logger log = LoggerFactory.getLogger(ThreeRule.class);

    public ThreeRule() {
        callCount = new AtomicInteger(0);
        nextServerCyclicCounter = new AtomicInteger(0);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            log.warn("no load balancer");
            return null;
        }
        log.info("choose:");
        Server server = null;
        while (server == null) {
            List<Server> reachableServers = lb.getReachableServers();
            List<Server> allServers = lb.getAllServers();

            int upCount = reachableServers.size();
            int serverCount = allServers.size();

            if ((upCount == 0) || (serverCount == 0)) {
                log.warn("No up servers available from load balancer: " + lb);
                return null;
            }
            if(callCount.get() >= 3){
                callCount.set(0);
                nextServerCyclicCounter.incrementAndGet();
            }else {
                callCount.incrementAndGet();
            }
            int nextServerIndex = (nextServerCyclicCounter.get() + 1) % serverCount;
            server = allServers.get(nextServerIndex);

            if (server == null) {
                /* Transient. */
                Thread.yield();
                continue;
            }

            if (server.isAlive() && (server.isReadyToServe())) {
                return (server);
            }

            // Next.
            server = null;
        }
        return server;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }
}
