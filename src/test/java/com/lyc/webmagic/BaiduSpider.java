package com.lyc.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by lyc on 2017/6/15.
 */
public class BaiduSpider implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public static void main(String[] args) {

        Downloader downloader = new HttpClientDownloader();
        Spider.create(new BaiduSpider()).addUrl("http://www.tairunmh.com/").addPipeline(new FilePipeline("e:\\webmagic\\")).thread(5).run();

    }

    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().all());
        page.putField("author","lyc");
        page.putField("name", "asdsd");
        if (page.getResultItems().get("name")==null){
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", "asdsd");
    }

    public Site getSite() {
        return site;
    }
}
