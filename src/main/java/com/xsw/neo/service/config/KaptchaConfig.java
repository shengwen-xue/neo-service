package com.xsw.neo.service.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author xueshengwen
 * @since 2021/8/31 10:58
 */
@Configuration
public class KaptchaConfig {

    @Bean
    public DefaultKaptcha producer() {
        Properties properties = new Properties();
        properties.put("kaptcha.border", "no");
        properties.put("kaptcha.textproducer.font.color", "0,0,139");
        properties.put("kaptcha.textproducer.char.space", "5");
        //如果需要生成算法验证码加上一下配置
        properties.put("kaptcha.textproducer.char.string", "1234567890");
        // 设置背景渐变色
        properties.put("kaptcha.background.clear.from", "192,192,192");
        properties.put("kaptcha.background.clear.to", "255,255,255");
        properties.put("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.WaterRipple");
        //如果需要去掉干扰线
        properties.put("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");

        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
