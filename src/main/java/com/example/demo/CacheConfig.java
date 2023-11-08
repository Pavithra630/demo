package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizePolicy;

@Configuration
public class CacheConfig {

	@Bean
	public Config configure() {
		return new Config().setInstanceName("hazlecast-insatnce")
				.addMapConfig(new MapConfig().setName("userCache")
						.setTimeToLiveSeconds(3000)
                        .setEvictionConfig(new EvictionConfig()
                                .setSize(200)
                                .setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE)
                                .setEvictionPolicy(EvictionPolicy.LRU)
                        ));
	}

	 @Bean
     public Config config() {
         Config config=new Config();
         config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(true);
         return config;
    }
	
}