package com.lyc.webmagic;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;

import javax.management.JMException;

/**
 * Created by lyc on 2017/6/15.
 */
public class MonitorExample {
    public static void main(String[] args) throws JMException {

        Spider githubSpider = Spider.create(new GithubRepoPageProcessor())
                .addUrl("https://github.com/code4craft");


        SpiderMonitor.instance().register(githubSpider);

        githubSpider.start();
    }
}
