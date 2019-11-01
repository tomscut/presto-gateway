package com.lyft.data.gateway.ha.router.strategy;

import com.lyft.data.gateway.ha.config.ProxyBackendConfiguration;
import com.lyft.data.proxyserver.ProxyServerConfiguration;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangyun@bigo.sg
 * @date 10/31/19 3:33 PM
 */
public class TestClusterUtils {

  @Test
  public void testGetClusterState() {
    ProxyServerConfiguration proxyServerConfiguration = new ProxyBackendConfiguration();
    proxyServerConfiguration.setProxyTo("http://test.presto.bigo.sg:8285");
    ClusterState clusterState = ClusterUtils.getClusterState(proxyServerConfiguration);
    System.out.println(clusterState);
  }

  @Test
  public void testGetQueryInfo() {
    ProxyServerConfiguration proxyServerConfiguration = new ProxyBackendConfiguration();
    proxyServerConfiguration.setProxyTo("http://test.presto.bigo.sg:8285");
    List<QueryState> queryStates = new ArrayList<>();
    queryStates.add(QueryState.FINISHED);
    List<QueryInfo> queryInfos = ClusterUtils.getQueryInfo(proxyServerConfiguration, queryStates);
    System.out.println(queryInfos);
  }
}
