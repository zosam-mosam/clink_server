package com.josam.clink.jsouptest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JsoupTest {
	
	public List<NewsVO> getNewsdata() throws IOException {
			Document doc = Jsoup.connect("https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid1=101&sid2=259").get();
			Elements img = doc.getElementsByAttributeValue("class","photo");
			Elements atag = img.select("a");
			Elements imgtag=atag.select("img");
			List<NewsVO> list = new ArrayList<>();
			for(int i=0;i<10;i++) {
				NewsVO nvo = new NewsVO(atag.get(i).attr("href"),imgtag.get(i).attr("src"),imgtag.get(i).attr("alt"));
				list.add(nvo);
			}
			return list;
	}
}
