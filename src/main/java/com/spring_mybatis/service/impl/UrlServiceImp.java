package com.spring_mybatis.service.impl;

import com.spring_mybatis.service.UrlService;
import org.springframework.stereotype.Service;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月27日 9:12
 */
@Service
public class UrlServiceImp implements UrlService {
    @Override
    public void openUrl(String url) {
        System.out.println(url);
    }


    @Override
    public void openUrl2(String url) {
        System.out.println(url);
    }
}
