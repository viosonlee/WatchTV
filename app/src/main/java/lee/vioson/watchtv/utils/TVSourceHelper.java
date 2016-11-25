package lee.vioson.watchtv.utils;

import java.util.ArrayList;

import lee.vioson.watchtv.MyApplication;
import lee.vioson.watchtv.model.TVSource;

/**
 * Author:李烽
 * Date:2016-11-25
 * FIXME
 * Todo
 */

public class TVSourceHelper {
    private static final String tVSource = "$广东体育,http://14.18.17.142:9009/live/chid=56\n" +
            "$CZ少儿 ,http://14.18.17.142:9009/live/chid=57\n" +
            "$珠江  ,http://14.18.17.142:9009/live/chid=58\n" +
            "$珠江電影 ,http://cdn9.3gtv.net:9235/tvlive/zjdy-h.stream/playlist.m3u8?wowzatokenCustomParameter=23800433690770737_121.201.14.133&wowzatokenendtime=1479667140&wowzatokenstarttime=1479659940&wowzatokenhash=mRZN7wWxnIIRn4HHRHR2oji2Y95JjrAbO1s3osXZBI4=&sec=dede8c4eeb2da39cd991967103dbfed7&portalId=6&contentType=4&pid=2&nettype=wifi&uac=android&rid=0&uid=866915020324713&mobilePhone=null\n" +
            "$TVS1  ,http://14.18.17.142:9009/live/chid=61\n" +
            "$TVS2           ,http://14.18.17.142:9009/live/chid=62\n" +
            "$TVS3           ,http://14.18.17.142:9009/live/chid=63\n" +
            "$TVS4           ,http://14.18.17.142:9009/live/chid=64\n" +
            "$TVS4           ,http://14.18.17.142:9009/live/chid=65\n" +
            "$广东新闻           ,http://14.18.17.142:9009/live/chid=66\n" +
            "$CZ         ,http://14.18.17.142:9009/live/chid=68\n" +
            "$CZ经济           ,http://14.18.17.142:9009/live/chid=69\n" +
            "$CZ新闻       ,http://14.18.17.142:9009/live/chid=70\n" +
            "$CZ影视       ,http://14.18.17.142:9009/live/chid=71\n" +
            "$翡翠台1HD     ,http://wshls.acgvideo.com/live/live_44206803_1959058/playlist.m3u8?wsSecret=51d71659d69878d413a6f489b1e9bb0f&wsTime=57c569f1\n" +
            "$翡翠台2HD     ,http://wshls.acgvideo.com/live/live_44206803_1959058/playlist.m3u8\n" +
            "$美亚1        ,http://wshls.acgvideo.com/live/live_752869_9917726/playlist.m3u8?wsSecret=f28031532dd9afc281971a07f485e729&wsTime=57af0606\n" +
            "$美亚2,http://wshls.acgvideo.com/live/live_752869_9917726/playlist.m3u8?wsSecret=6e43792f78fab86cfa2493ec6f09bdb1&wsTime=57c56a4a\n" +
            "$美亚3,http://wshls.acgvideo.com/live/live_752869_9917726/playlist.m3u8?wsSecret=de2523cc025ae837ebb1bbac0a6edc2c&wsTime=57a40ca3\n" +
            "$美亚4,http://wshls.acgvideo.com/live/live_752869_9917726/playlist.m3u8?wsSecret=ded1ac48de775be007ff8a8bf14c3c79&wsTime=57c6392b\n" +
            "$美亚5,http://wshls.acgvideo.com/live/live_752869_9917726/playlist.m3u8\n" +
            "$代理1HD,http://app.tll888.com/bilibili.php?cid=1366528\n" +
            "$代理2,http://app.tll888.com/bilibili.php?cid=1213889\n" +
            "$凤凰卫视中文,http://180.100.1.250/cdn/iptv/Tvod/001/ch00000090990000001307/index.m3u8\n" +
            "$凤凰卫视中文HD,http://111.39.226.103:8112/120000001001/wlds:8080/ysten-business/live/fhchinese/.m3u8\n" +
            "$凤凰中文HD,http://218.203.106.12:5580/ysten-business/live/fhchinese/.m3u8.ts\n" +
            "$凤凰中文HD,http://218.203.106.12:5580/ysten-business/live/fhchinese/.m3u8\n" +
            "$凤凰中文HD,http://202.205.93.230:280/99e8f095e48865d9cecff47cd5563763/playlist.m3u8\n" +
            "$凤凰中文HD,http://zv.3gv.ifeng.com/live/zhongwen800k.m3u8\n" +
            "$凤凰资讯HD,http://202.205.93.230:280/b039f4e32adba3c507423b46e08eece6/playlist.m3u8\n" +
            "$JET综合,p2p://138.68.6.47:8290/5607aec8000c499658ed5adf32ff77b2\n" +
            "$卫视中文HD,p2p://138.68.6.47:8290/5604fab4000952444e5debff5e3c48ff\n" +
            "$星卫HD电影,p2p://138.68.6.47:8290/5607802f000dfcee583755ad4e2a59d1\n" +
            "$星卫娱乐,p2p://138.68.6.47:8290/560772ef0003a31758039106117e19ee\n" +
            "$民视四季HD,p2p://138.68.6.47:8290/56070ff10008f3995680e23a647c6a70\n" +
            "$民视新闻,p2p://138.68.6.47:8290/5646e5300008b5e0141f1879170347a1\n" +
            "$壹新闻,p2p://138.68.6.47:8290/560724d300075af656d2749b04d73753\n" +
            "$中天新闻,p2p://138.68.6.47:8290/571e917800045e3f3ff05e07668d4ed2\n" +
            "$中天娱乐,p2p://138.68.6.47:8290/56075708000e4dc6579695672c481f25\n" +
            "$中天综合,p2p://138.68.6.47:8290/56076f33000325c857f4fa8202ee52d5\n" +
            "$东森新闻HD,p2p://138.68.6.47:8290/571e91c70009583a3ff193e501761e6c\n" +
            "$东森财经新闻,p2p://138.68.6.47:8290/571e8df60002dc5e3fe2a9d528cf229c\n" +
            "$凤凰资讯HD,http://202.205.93.230:280/b039f4e32adba3c507423b46e08eece6/playlist.m3u8\n" +
            "$凤凰资讯HD,http://112.17.0.10:8085/ysten-business/live/fhzixun/yst.m3u8\n" +
            "$凤凰中文HD,http://218.203.106.12:5580/ysten-business/live/fhchinese/.m3u8\n" +
            "$凤凰中文HD,http://202.205.93.230:280/99e8f095e48865d9cecff47cd5563763/playlist.m3u8\n" +
            "$星空卫视,http://222.36.5.53:9800/live/xktv.m3u8\n" +
            "$香港电视HKTV,http://14.198.245.135:8088/hktvlive/hktv_432pb_track.m3u8?t=12e9a7f66f3a892b396e94d81206eb6c&udid=82ab2c92-e15a-4b81-9c1b-2f98fbf3d596&uid=1&vid=1&mxres=720&s=f28849d9f4c57e9e93a5e77cc87c7338\n" +
            "$香港电视HKTV,http://ott-video-lb.hktvmall.com:8088/hktvlive.m3u8?uid=1&vid=1&d=pc&t=12e9a7f66f3a892b396e94d81206eb6c&mxres=1920&net=&udid=83fedc4f-f254-11e4-97ac-0862662c98fc&ts=1430742398985&s=15e72de02a374db21d5952849fdd6a17\n" +
            "$香港电视31台, http://rthklive1-lh.akamaihd.net/i/rthk31_1@167495/index_2052_av-b.m3u8\n" +
            "$香港电视31台, http://rthklive1-lh.akamaihd.net:80/i/rthk31_1@167495/index_1296_av-b.m3u8\n" +
            "$香港电视32台, http://rthklive2-lh.akamaihd.net/i/rthk32_1@168450/index_1296_av-b.m3u8\n" +
            "$香港电视32台, http://rthklive2-lh.akamaihd.net/i/rthk32_1@168450/index_2052_av-b.m3u8\n" +
            "$香港卫视HKS,http://live.hkstv.hk.lxdns.com/live/hks/playlist.m3u8\n" +
            "$香港卫视HKS,rtmp://live.hkstv.hk.lxdns.com/live/hks\n" +
            "$湛江综合,http://stream1.grtn.cn/zjzh/sd/live.m3u8?_upt=?ts\n" +
            "$澳亞衛視1,http://live.mastvnet.com/n1rtlHG/500/live.m3u8\n" +
            "$GATV19,http://123.108.164.71/etv2sb/phd43/playlist.m3u8\n" +
            "$TVB8,http://112.17.0.10:8085/ysten-business/live/tvb8/dujuejiami.m3u8\n" +
            "$GOODTV,http://210.59.248.53/hls-live/goodtv/_definst_/liveevent/live-ch1-1.m3u8\n" +
            "$GoodTV ,http://210.59.248.53/hls-live/livepkgr/_definst_/liveevent/live-ch1-3.m3u8\n" +
            "$壹新闻 ,http://d2e6xlgy8sg8ji.cloudfront.net/liveedge/eratv3/chunklist.m3u8\n" +
            "$星卫娱乐,http://dlhls.cdn.zhanqi.tv/zqlive/1285_Zloy4_400/index.m3u8\n" +
            "$高清电影台,http://chyd-wsvod.wasu.tv/data13/ott/344/2015-05/28/1432782476341_377935/playlist.m3u8\n" +
            "$华语电影,http://live.g3proxy.lecloud.com/gslb?stream_id=lb_hydy_1800&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1#http://live.g3proxy.lecloud.com/gslb?stream_id=lb_hydy_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$VB-翡翠台HD,p2p://211.75.214.186:9906/5784fc99000f3f1f0b3533aabef510df\n" +
            "$TVB-明珠台HD,p2p://211.75.214.186:9906/5784fcc90002a48a0b35ebf0659ca56c\n" +
            "$TVB-8HD,p2p://211.75.214.186:9906/5783bc78000004660652aedc3cda8e95\n" +
            "$TVB-8HD(備用),http://210.242.52.97/sta/ch511.m3u8\n" +
            "$TVB-J5HD,p2p://211.75.214.186:9906/5784fc86000b53a70b34e8719320cef4\n" +
            "$TVB-J2HD,p2p://211.75.214.186:9906/5784fcdc000b0a390b36384e07b64fe7\n" +
            "$TVB-互動新聞台HD,p2p://211.75.214.186:9906/5784fcec00052d760b36754e5c21b7df\n" +
            "$TVB-星河台,p2p://211.75.214.186:9906/5783c61800059ee70678494bc46fc52b\n" +
            "$翡翠台HD,http://wshls.acgvideo.com/live/live_44206803_1959058/playlist.m3u8#http://app.tll888.com/bilibili.php?cid=1366528#http://wshls.acgvideo.com/live/live_44206803_1959058/playlist.m3u8?wsSecret=51d71659d69878d413a6f489b1e9bb0f\n" +
            "$阳光卫视,http://111.39.226.103:8112/120000001001/wlds:8080/ysten-business/live/yangguangstv/.m3u8\n" +
            "$壹电视新闻 ,http://d2e6xlgy8sg8ji.cloudfront.net/liveedge/eratv1/chunklist.m3u8#http://d2e6xlgy8sg8ji.cloudfront.net/liveedge/eratv3/playlist.m3u8\n" +
            "$FOX_HD,http://61.216.71.67/sta/ch01.m3u8\n" +
            "$FOX_sports3,http://61.216.71.67/sta/ch02.m3u8\n" +
            "$台灣藝術台,http://61.216.71.67/sta/ch03.m3u8\n" +
            "$HBO優質,http://61.216.71.67/sta/ch04.m3u8\n" +
            "$HBO_HD,http://61.216.71.67/sta/ch05.m3u8\n" +
            "$衛視HD西片,http://61.216.71.67/sta/ch07.m3u8\n" +
            "$TVBS新聞HD,http://61.216.71.67/sta/ch08.m3u8\n" +
            "$八大綜合HD,http://61.216.71.67/sta/ch10.m3u8\n" +
            "$八大第1HD,http://61.216.71.67/sta/ch11.m3u8\n" +
            "$中天娛樂,http://61.216.71.67/sta/ch13.m3u8\n" +
            "$中天新聞,http://61.216.71.67/sta/ch14.m3u8\n" +
            "$中天綜合,http://61.216.71.67/sta/ch15.m3u8\n" +
            "$東風37,http://61.216.71.67/sta/ch16.m3u8\n" +
            "$東森電影,http://61.216.71.67/sta/ch18.m3u8\n" +
            "$東森洋片,http://61.216.71.67/sta/ch20.m3u8\n" +
            "$東森新聞HD,http://61.216.71.67/sta/ch21.m3u8\n" +
            "$龍華電影,http://61.216.71.67/sta/ch23.m3u8\n" +
            "$緯來電影,http://61.216.71.67/sta/ch25.m3u8\n" +
            "$非凡新聞HD,http://61.216.71.67/sta/ch31.m3u8\n" +
            "$非凡新闻HD,http://59.120.41.145/sta/ch31.m3u8\n" +
            "$世界影城電影,http://61.216.71.67/sta/ch35.m3u8\n" +
            "$衛視中文,http://61.216.71.67/sta/ch37.m3u8\n" +
            "$衛視電影,http://61.216.71.67/sta/ch38.m3u8\n" +
            "$好萊塢電影,http://61.216.71.67/sta/ch40.m3u8\n" +
            "$中視HD,http://61.216.71.67/sta/ch41.m3u8\n" +
            "$公視,http://61.216.71.67/sta/ch42.m3u8\n" +
            "$台視,http://61.216.71.67/sta/ch43.m3u8\n" +
            "$華視,http://61.216.71.67/sta/ch46.m3u8\n" +
            "$JET綜合,http://61.216.71.67/sta/ch48.m3u8\n" +
            "$三立台灣,http://61.216.71.67/sta/ch49.m3u8\n" +
            "$中天亞洲,http://61.216.71.67/sta/ch82.m3u8\n" +
            "$中視新聞,http://61.216.71.67/sta/ch508.m3u8\n" +
            "$中視經典,http://61.216.71.67/sta/ch507.m3u8\n" +
            "$TVBS新聞,http://61.216.71.67/sta/ch510.m3u8\n" +
            "$華視新聞,http://61.216.71.67/sta/ch519.m3u8\n" +
            "$寰宇新聞,http://61.216.71.67/stc/ch016.m3u8\n" +
            "$中天新闻,http://210.242.52.97/sta/ch14.m3u8\n" +
            "$星空卫视,http://222.36.5.53:9800/live/xktv.m3u8\n" +
            "$凤凰卫视中文HD,http://218.203.106.12:5580/ysten-business/live/fhchinese/yst.m3u8.ts\n" +
            "$凤凰中文HD,http://112.17.0.10:8085/ysten-business/live/fhchinese/yst.m3u8\n" +
            "$凤凰卫视资讯HD,http://112.17.0.10:8085/ysten-business/live/fhzixun/yst.m3u8\n" +
            "$耀才财经台,rtmp://fc_video.bsgroup.com.hk:443/webcast/bshdlive-pc\n" +
            "$耀才财经台,http://202.69.67.66:443/webcast/bshdlive-pc/playlist.m3u8\n" +
            "$香港耀才財經 ,http://202.69.67.66:443/webcast/bshdlive-mobile/playlist.m3u8\n" +
            "$香港电视HKTV,http://14.198.245.135:8088/hktvlive/hktv_432pb_track.m3u8?t=12e9a7f66f3a892b396e94d81206eb6c&udid=82ab2c92-e15a-4b81-9c1b-2f98fbf3d596&uid=1&vid=1&mxres=720&s=f28849d9f4c57e9e93a5e77cc87c7338\n" +
            "$香港电视HKTV,http://ott-video-lb.hktvmall.com:8088/hktvlive.m3u8?uid=1&vid=1&d=pc&t=12e9a7f66f3a892b396e94d81206eb6c&mxres=1920&net=&udid=83fedc4f-f254-11e4-97ac-0862662c98fc&ts=1430742398985&s=15e72de02a374db21d5952849fdd6a17\n" +
            "$香港卫视,http://live.hkstv.hk.lxdns.com/live/hks/playlist.m3u8\n" +
            "$香港衛視 ,rtmp://live.hkstv.hk.lxdns.com/live//hks\n" +
            "$香港HKTV ,http://ott-video-lb.hktvmall.com:8088/hktvlive/hktv_432pa_track.m3u8?t=12e9a7f66f3a892b396e94d81206eb6c&udid=c64c7900-515f-4713-9baf-152d4e966aac&uid=1&vid=1&mxres=720&s=b6fa37f9bd983f769db4fd8fea19ab43\n" +
            "$本港HKS ,http://live.hkstv.hk.lxdns.com/live/hks/playlist.m3u8#rtmp://live.hkstv.hk.lxdns.com/live/hks\n" +
            "$健康卫视 ,http://2om8w3.hls1.z1.pili.qiniucdn.com/jkwshk/live1.m3u8\n" +
            "$RHK-31,http://rthklive1-lh.akamaihd.net:80/i/rthk31_1@167495/index_1296_av-b.m3u8\n" +
            "$RHK-32,http://rthklive2-lh.akamaihd.net/i/rthk32_1@168450/index_1296_av-b.m3u8\n" +
            "$TVB8,http://112.17.0.10:8085/ysten-business/live/tvb8/dujuejiami.m3u8\n" +
            "$TVBS-新聞台 ,http://60.199.188.151/HLS/WG_TVBS-N/index.m3u8\n" +
            "$亚太第一卫视,rtmp://v1.one-tv.com:1935/live/mpegts.stream\n" +
            "$亚洲联合卫视,http://tv.unbtv.tv/app_2/ls_1.stream/playlist.m3u8\n" +
            "$TARA,http://dlhls.cdn.zhanqi.tv/zqlive/1285_Zloy4_400/index.m3u8\n" +
            "$MOMO亲子,http://saka24.fansmestar.com/ch024/playlist.m3u8\n" +
            "$MOMO1台,rtmp://flv.ccdntech.com/live/mp4:vod169_Live/live\n" +
            "$八大第1,http://saka24.fansmestar.com/ch027/playlist.m3u8\n" +
            "$三立国际,http://saka19.fansmestar.com/ch030/playlist.m3u8\n" +
            "$中天娱乐,rtsp://173.224.209.43/ztyl\n" +
            "$中天新闻 ,http://saka19.fansmestar.com/ch054/playlist.m3u8\n" +
            "$ANIMAX动漫,http://saka24.fansmestar.com/ch034/playlist.m3u8\n" +
            "$壹新闻,http://d2e6xlgy8sg8ji.cloudfront.net/liveedge/eratv3/chunklist.m3u8\n" +
            "$AXN电影,rtsp://c.itvitv.com/axn\n" +
            "$CHC高清电影,http://ivi.bupt.edu.cn/hls/chchd.m3u8\n" +
            "$台湾axn电影台 ,rtsp://c.itvitv.com/axn\n" +
            "$迪斯尼少年 ,http://saka29.fansmestar.com/ch074/playlist.m3u8\n" +
            "$宏观电视台,http://mobile.ccdntech.com/live/_definst_/vod62_Live/live2/playlist.m3u8\n" +
            "$TW台湾唱歌,rtsp://c.itvitv.com/twm1\n" +
            "$台湾唯心卫视 ,rtsp://118.163.182.167/wxtv300k\n" +
            "$台湾生命电视HD,http://211.73.19.201/live/E6290DC0-BE6A-B7C4-79F5-114BDB417F9E?fmt=x264_500K_ts&cpid=admin&size=1280X720&toflv=15\n" +
            "$星空电影,rtmp://202.117.80.19:1935/live/live2\n" +
            "$美亚综合,rtmp://live.boyabo.com:1935/livepkgr/livestream\n" +
            "$耀才财经台,rtmp://202.69.69.180:443/webcast/bshdlive-pc\n" +
            "$东森电影,rtsp://c.itvitv.com/etm.jhfuowamedr\n" +
            "$亚洲联合卫视,http://tv.unbtv.tv/app_2/ls_1.stream/playlist.m3u8\n" +
            "$龙翔电影,rtsp://c.itvitv.com/ls.sdtwsatxbaw\n" +
            "$animax,rtsp://c.itvitv.com/animaxj.yuwnshydgtrf\n" +
            "$AXN电影,rtsp://c.itvitv.com/axn\n" +
            "$ITV电影台,rtsp://c.itvitv.com/itv\n" +
            "$美亚综合,rtmp://live.boyabo.com:1935/livepkgr/livestream\n" +
            "$耀才财经台,rtmp://202.69.69.180:443/webcast/bshdlive-pc\n" +
            "$迪士尼动画频道,rtsp://c.itvitv.com/disney.rinujhtgfv\n" +
            "$龙翔电影,rtsp://c.itvitv.com/ls.sdtwsatxbaw\n" +
            "$宏观卫视台,http://mobile.ccdntech.com/live/_definst_/vod62_Live/live1/playlist.m3u8\n" +
            "$迪士尼动画频道,rtsp://c.itvitv.com/disney.rinujhtgfv\n" +
            "$澳视澳门,rtmp://live4.tdm.com.mo:80/tv/ch1.live\n" +
            "$澳视澳门,rtmp://live2.tdm.com.mo:80/tv/ch1.live\n" +
            "$韩国中文台,http://122.202.129.136:1935/live/ch5/playlist.m3u8\n" +
            "$美国中文台,rtmp://media3.sinovision.net:1935/live/livestream\n" +
            "$好美味,http://182.92.189.193:1935/live/h_food_1/playlist.m3u8\n" +
            "$新唐人电视,rtmp://123.108.164.71/etv2/phd1058\n" +
            "$新唐人亚太,rtmp://123.108.164.71/etv2/phd926\n" +
            "$台湾好消息1,http://210.59.248.53/hls-live/livepkgr/_definst_/liveevent/live-ch1-1.m3u8\n" +
            "$台湾好消息2,http://210.59.248.53/hls-live/livepkgr/_definst_/liveevent/live-ch2-1.m3u8\n" +
            "$台湾生命电视台,http://211.73.19.201/live/E6290DC0-BE6A-B7C4-79F5-114BDB417F9E?fmt=x264_500K_ts&cpid=admin&size=1280X720&toflv=15\n" +
            "$佛教2,rtmp://hk2.hwadzan.com/liveedge/amtb\n" +
            "$佛教4,rtmp://hk2.hwadzan.com/liveedgelist/livetv\n" +
            "$宏观电视,http://mobile.ccdntech.com/live/_definst_/vod62_Live/live1/playlist.m3u8\n" +
            "$宏观电视,http://mobile.ccdntech.com/live/_definst_/vod62_Live/live2/chunklist_w197568671.m3u8\n" +
            "$高清翡翠台,http://dlhls.cdn.zhanqi.tv/zqlive/2869_tUPFz.m3u8\n" +
            "$高清翡翠台,\n" +
            "$lyingman,http://dlhls.cdn.zhanqi.tv/zqlive/36596_HD3eX.m3u8\n" +
            "$野外频道,rtsp://c.itvitv.com/wild\n" +
            "$汉亚星空,http://182.92.189.193:1935/live/h_hanya_1/playlist.m3u8\n" +
            "$菲律宾UN,rtmp://livestream01.untvweb.com/public/untvwebstream\n" +
            "$美国中文电视,rtmp://media3.sinovision.net:1935/live/livestream\n" +
            "$美国中文台,http://media3.sinovision.net:1935/live/livestream/playlist.m3u8\n" +
            "$美国中文电视 ,http://ec.sinovision.net/video/ts/lv.m3u8\n" +
            "$新闻-NTVNEWS,rtmp://extondemand.livestream.com:80/ondemand/trans/dv10/mogulus-user-files/chntvnewslive/2010/11/21/4124d900-deee-4aa3-aa93-e1e42d7f0d89\n" +
            "$星衛娛樂,http://dlhls.cdn.zhanqi.tv/zqlive/1285_Zloy4.m3u8\n" +
            "$星衛娛樂,http://dlhls.cdn.zhanqi.tv/zqlive/1285_Zloy4_400/index.m3u8\n" +
            "$美国中文电视,http://ec.sinovision.net/video/ts/lv.m3u8\n" +
            "$泰国中文台,http://110.164.48.237:1935/tcctv_ch002/tcctv02.stream_live1/playlist.m3u8\n" +
            "$泰国中文台,rtmp://110.164.48.237:1935/tcctv_ch002/tcctv02.stream_live1\n" +
            "$翡翠台HD ,http://dlhls.cdn.zhanqi.tv/zqlive/2869_tUPFz.m3u8\n" +
            "$CNN,http://61.216.71.67/sta/ch5168036.m3u8\n" +
            "$民视 ,http://61.216.71.67/sta/ch5168603.m3u8\n" +
            "$人间卫视,http://61.216.71.67/sta/ch5168517.m3u8\n" +
            "$台视,http://61.216.71.67/sta/ch5168043.m3u8\n" +
            "$大爱电视台,http://61.216.71.67/sta/ch5168012.m3u8\n" +
            "$中视,http://61.216.71.67/sta/ch5168506.m3u8\n" +
            "$华视,http://61.216.71.67/sta/ch5168046.m3u8\n" +
            "$华视,http://61.216.71.67/sta/ch5168518.m3u8\n" +
            "$公共电视,http://61.216.71.67/sta/ch5168042.m3u8\n" +
            "$客家电视,http://61.216.71.67/sta/ch5168601.m3u8\n" +
            "$客家电视,http://61.216.71.67/sta/ch5168602.m3u8\n" +
            "$Discovery,http://61.216.71.67/sta/ch5168030.m3u8\n" +
            "$东森幼幼台,http://61.216.71.67/sta/ch5168017.m3u8\n" +
            "$八大第一台,http://61.216.71.67/sta/ch5168011.m3u8\n" +
            "$八大综合台,http://61.216.71.67/sta/ch5168010.m3u8\n" +
            "$三立台湾台,http://61.216.71.67/sta/ch5168049.m3u8\n" +
            "$卫视中文台,http://61.216.71.67/sta/ch5168037.m3u8\n" +
            "$东森超视,http://61.216.71.67/sta/ch5168047.m3u8\n" +
            "$东森购物2台,http://61.216.71.67/sta/ch5168107.m3u8\n" +
            "$东森购物2台,http://61.216.71.67/sta/ch5168501.m3u8\n" +
            "$中天综合台,http://61.216.71.67/sta/ch5168015.m3u8\n" +
            "$东风卫视,http://61.216.71.67/sta/ch5168016.m3u8\n" +
            "$年代MUCH台,http://61.216.71.67/sta/ch5168039.m3u8\n" +
            "$中天娱乐台,http://61.216.71.67/sta/ch5168013.m3u8\n" +
            "$东森戏剧台,http://61.216.71.67/sta/ch5168019.m3u8\n" +
            "$八大戏剧台,http://61.216.71.67/sta/ch5168009.m3u8\n" +
            "$东森购物4台,http://61.216.71.67/sta/ch5168110.m3u8\n" +
            "$东森购物4台,http://61.216.71.67/sta/ch5168504.m3u8\n" +
            "$HBO HD,http://61.216.71.67/sta/ch5168005.m3u8\n" +
            "$东森购物3台,http://61.216.71.67/sta/ch5168108.m3u8\n" +
            "$东森购物3台,http://61.216.71.67/sta/ch5168502.m3u8\n" +
            "$东森购物1台,http://61.216.71.67/sta/ch5168106.m3u8\n" +
            "$东森购物1台,http://61.216.71.67/sta/ch5168500.m3u8\n" +
            "$东森新闻台,http://61.216.71.67/sta/ch5168512.m3u8\n" +
            "$中天新闻台,http://61.216.71.67/sta/ch5168014.m3u8\n" +
            "$民视新闻台,http://61.216.71.67/sta/ch5168604.m3u8\n" +
            "$TVBS新闻台,http://61.216.71.67/sta/ch5168510.m3u8\n" +
            "$TVBS,http://61.216.71.67/sta/ch5168509.m3u8\n" +
            "$东森财经新闻台,http://61.216.71.67/sta/ch5168513.m3u8\n" +
            "$非凡新闻台,http://61.216.71.67/sta/ch5168031.m3u8\n" +
            "$Viva购物1台,http://61.216.71.67/sta/ch5168608.m3u8\n" +
            "$东森购物5台,http://61.216.71.67/sta/ch5168109.m3u8\n" +
            "$东森购物5台,http://61.216.71.67/sta/ch5168503.m3u8\n" +
            "$卫视电影台,http://61.216.71.67/sta/ch5168038.m3u8\n" +
            "$东森电影台,http://61.216.71.67/sta/ch5168018.m3u8\n" +
            "$纬来电影台,http://61.216.71.67/sta/ch5168025.m3u8\n" +
            "$东森洋片台,http://61.216.71.67/sta/ch5168020.m3u8\n" +
            "$AXN,http://61.216.71.67/sta/ch5168034.m3u8\n" +
            "$纬来体育台,http://61.216.71.67/sta/ch5168027.m3u8\n" +
            "$FOX频道,http://61.216.71.67/sta/ch5168001.m3u8\n" +
            "$台湾艺术台,http://61.216.71.67/sta/ch5168003.m3u8\n" +
            "$信吉电视台,http://61.216.71.67/sta/ch5168702.m3u8\n" +
            "$天良电视台,http://61.216.71.67/sta/ch5168701.m3u8\n" +
            "$好莱坞电影台,http://61.216.71.67/sta/ch5168040.m3u8\n" +
            "$富立电视台,http://61.216.71.67/sta/ch5168521.m3u8\n" +
            "$富立电视台,http://61.216.71.67/sta/ch5168600.m3u8\n" +
            "$华藏电视台,http://61.216.71.67/sta/ch5168067.m3u8\n" +
            "$JET综合台,http://61.216.71.67/sta/ch5168048.m3u8\n" +
            "$HBO 原创钜献,http://61.216.71.67/sta/ch5168006.m3u8\n" +
            "$台视新闻台,http://61.216.71.67/sta/ch5168516.m3u8\n" +
            "$台视财经台,http://61.216.71.67/sta/ch5168515.m3u8\n" +
            "$交通电视台,http://61.216.71.67/sta/ch5168605.m3u8\n" +
            "$国家地理高画质频道,http://61.216.71.67/sta/ch5168029.m3u8\n" +
            "$中视经典台,http://61.216.71.67/sta/ch5168507.m3u8\n" +
            "$中视菁采台,http://61.216.71.67/sta/ch5168505.m3u8\n" +
            "$TVB8频道,http://61.216.71.67/sta/ch5168511.m3u8\n" +
            "$中视新闻台,http://61.216.71.67/sta/ch5168508.m3u8\n" +
            "$华视新闻资讯台,http://61.216.71.67/sta/ch5168519.m3u8\n" +
            "$龙华电影,http://61.216.71.67/sta/ch5168023.m3u8\n" +
            "$Star Movies HD,http://61.216.71.67/sta/ch5168007.m3u8\n" +
            "$CinemaWorld,http://61.216.71.67/sta/ch5168035.m3u8\n" +
            "$华视综合娱乐台,http://61.216.71.67/sta/ch5168520.m3u8\n" +
            "$四季台,http://61.216.71.67/sta/ch5168606.m3u8\n" +
            "$公视2台,http://61.216.71.67/sta/ch5168607.m3u8\n" +
            "$爱尔达体育台,http://61.216.71.67/sta/ch5168032.m3u8\n" +
            "$FOX SPORTS 3,http://61.216.71.67/sta/ch5168002.m3u8\n" +
            "$中天亚洲台,http://61.216.71.67/sta/ch5168514.m3u8\n" +
            "$台艺2台,http://61.216.71.67/sta/ch5168522.m3u8\n" +
            "$松视一台(18age),http://211.22.61.109/stc/ch168022.m3u8\n" +
            "$松视一台(18age),http://211.22.61.109/stc/ch168023.m3u8\n" +
            "$松视二台(18age),http://211.22.61.109/stc/ch168019.m3u8\n" +
            "$松视三台(18age),http://211.22.61.109/stc/ch168020.m3u8\n" +
            "$松视四台(18age),http://211.22.61.109/stc/ch168021.m3u8\n" +
            "$博斯高球台,http://211.22.61.109/stc/ch168009.m3u8\n" +
            "$博斯高球台,http://211.22.61.109/stc/ch168039.m3u8\n" +
            "$博斯高球二台,http://211.22.61.109/stc/ch168010.m3u8\n" +
            "$博斯高球二台,http://211.22.61.109/stc/ch168040.m3u8\n" +
            "$博斯网球台,http://211.22.61.109/stc/ch168011.m3u8\n" +
            "$博斯网球台,http://211.22.61.109/stc/ch168041.m3u8\n" +
            "$博斯足球台,http://211.22.61.109/stc/ch168002.m3u8\n" +
            "$博斯足球台,http://211.22.61.109/stc/ch168032.m3u8\n" +
            "$博斯魅力网,http://211.22.61.109/stc/ch168003.m3u8\n" +
            "$博斯魅力网,http://211.22.61.109/stc/ch168033.m3u8\n" +
            "$龙华动画,http://211.22.61.109/stc/ch168013.m3u8\n" +
            "$靖洋卡通台,http://211.22.61.109/stc/ch168158.m3u8\n" +
            "$靖洋卡通台,http://211.22.61.109/stc/ch168168.m3u8\n" +
            "$靖天卡通台,http://211.22.61.109/stc/ch168154.m3u8\n" +
            "$靖天卡通台,http://211.22.61.109/stc/ch168164.m3u8\n" +
            "$靖天资讯台,http://211.22.61.109/stc/ch168157.m3u8\n" +
            "$靖天资讯台,http://211.22.61.109/stc/ch168167.m3u8\n" +
            "$靖天育乐台,http://211.22.61.109/stc/ch168155.m3u8\n" +
            "$靖天育乐台,http://211.22.61.109/stc/ch168165.m3u8\n" +
            "$亚洲旅游台,http://211.22.61.109/stc/ch168004.m3u8\n" +
            "$亚洲旅游台,http://211.22.61.109/stc/ch168034.m3u8\n" +
            "$龙华戏剧,http://211.22.61.109/stc/ch168015.m3u8\n" +
            "$龙华戏剧,http://211.22.61.109/stc/ch168045.m3u8\n" +
            "$龙华偶像,http://211.22.61.109/stc/ch168007.m3u8\n" +
            "$龙华偶像,http://211.22.61.109/stc/ch168037.m3u8\n" +
            "$寰宇新闻台,http://211.22.61.109/stc/ch168016.m3u8\n" +
            "$寰宇新闻台,http://211.22.61.109/stc/ch168046.m3u8\n" +
            "$寰宇新闻二台,http://211.22.61.109/stc/ch168017.m3u8\n" +
            "$寰宇新闻二台,http://211.22.61.109/stc/ch168047.m3u8\n" +
            "$靖天国际台,http://211.22.61.109/stc/ch168159.m3u8\n" +
            "$靖天国际台,http://211.22.61.109/stc/ch168169.m3u8\n" +
            "$靖天日本台,http://211.22.61.109/stc/ch168156.m3u8\n" +
            "$靖天日本台,http://211.22.61.109/stc/ch168166.m3u8\n" +
            "$Medici-arts,http://211.22.61.109/stc/ch168018.m3u8\n" +
            "$Medici-arts,http://211.22.61.109/stc/ch168048.m3u8\n" +
            "$宝宝世界频道,http://211.22.61.109/stc/ch168005.m3u8\n" +
            "$ITV Choice,http://211.22.61.109/stc/ch168006.m3u8\n" +
            "$ITV Choice,http://211.22.61.109/stc/ch168036.m3u8\n" +
            "$博斯无限台,http://211.22.61.109/stc/ch168001.m3u8\n" +
            "$博斯无限台,http://211.22.61.109/stc/ch168031.m3u8\n" +
            "$博斯运动网,http://211.22.61.109/stc/ch168012.m3u8\n" +
            "$博斯运动网,http://211.22.61.109/stc/ch168042.m3u8\n" +
            "$SI运动画刊频道,http://211.22.61.109/stc/ch168014.m3u8\n" +
            "$SI运动画刊频道,http://211.22.61.109/stc/ch168044.m3u8\n" +
            "$VTV4台,http://211.22.61.109/stc/ch168160.m3u8\n" +
            "$VTV4台,http://211.22.61.109/stc/ch168170.m3u8\n" +
            "$乐活频道(18age),http://211.22.61.109/stc/ch168161.m3u8\n" +
            "$奥视惊艳(18age),http://211.22.61.109/stc/ch168162.m3u8\n" +
            "$奥视香蕉(18age),http://211.22.61.109/stc/ch168163.m3u8\n" +
            "$龙华日韩,http://211.22.61.109/stc/ch168008.m3u8\n" +
            "$龙华日韩,http://211.22.61.109/stc/ch168038.m3u8\n" +
            "$台视,http://kk.luoke.net.cn/tw/astt.php?id=171\n" +
            "$大爱电视台,http://kk.luoke.net.cn/tw/astt.php?id=059\n" +
            "$中视,http://kk.luoke.net.cn/tw/astt.php?id=239\n" +
            "$华视,http://kk.luoke.net.cn/tw/astt.php?id=172\n" +
            "$好消息电视台,http://kk.luoke.net.cn/tw/asbb.php?id=156\n" +
            "$国家地理高画质频道,http://kk.luoke.net.cn/tw/astt.php?id=206\n" +
            "$东森幼幼台,http://kk.luoke.net.cn/tw/astt.php?id=227\n" +
            "$纬来综合台,http://kk.luoke.net.cn/tw/asbb.php?id=235\n" +
            "$八大第一台,http://kk.luoke.net.cn/tw/astt.php?id=157\n" +
            "$八大综合台,http://kk.luoke.net.cn/tw/astt.php?id=231\n" +
            "$三立台湾台,http://kk.luoke.net.cn/tw/asbb.php?id=211\n" +
            "$三立都会台,http://kk.luoke.net.cn/tw/astt.php?id=159\n" +
            "$卫视中文台,http://kk.luoke.net.cn/tw/astt.php?id=158\n" +
            "$东森综合台,http://kk.luoke.net.cn/tw/asbb.php?id=237\n" +
            "$中天综合台,http://kk.luoke.net.cn/tw/astt.php?id=220\n" +
            "$东风卫视,http://kk.luoke.net.cn/tw/asbb.php?id=214\n" +
            "$年代MUCH台,http://kk.luoke.net.cn/tw/asbb.php?id=226\n" +
            "$中天娱乐台,http://kk.luoke.net.cn/tw/astt.php?id=228\n" +
            "$TVBS欢乐台,http://kk.luoke.net.cn/tw/astt.php?id=160\n" +
            "$HBO HD,http://kk.luoke.net.cn/tw/astt.php?id=210\n" +
            "$年代新闻台,http://kk.luoke.net.cn/tw/astt.php?id=236\n" +
            "$东森新闻台,http://kk.luoke.net.cn/tw/astt.php?id=170\n" +
            "$中天新闻台,http://kk.luoke.net.cn/tw/astt.php?id=169\n" +
            "$民视新闻台,http://kk.luoke.net.cn/tw/astt.php?id=225\n" +
            "$三立新闻台,http://kk.luoke.net.cn/tw/astt.php?id=161\n" +
            "$TVBS新闻台,http://kk.luoke.net.cn/tw/astt.php?id=162\n" +
            "$TVBS,http://kk.luoke.net.cn/tw/astt.php?id=215\n" +
            "$东森财经新闻台,http://kk.luoke.net.cn/tw/astt.php?id=233\n" +
            "$非凡新闻台,http://kk.luoke.net.cn/tw/astt.php?id=212\n" +
            "$卫视电影台,http://kk.luoke.net.cn/tw/asbb.php?id=167\n" +
            "$东森电影台,http://kk.luoke.net.cn/tw/astt.php?id=234\n" +
            "$AXN,http://kk.luoke.net.cn/tw/astt.php?id=179\n" +
            "$纬来育乐台,http://kk.luoke.net.cn/tw/asbb.php?id=166\n" +
            "$纬来体育台,http://kk.luoke.net.cn/tw/astt.php?id=163\n" +
            "$FOX SPORTS 2,http://kk.luoke.net.cn/tw/asbb.php?id=165\n" +
            "$纬来日本台,http://kk.luoke.net.cn/tw/astt.php?id=164\n" +
            "$MTV,http://kk.luoke.net.cn/tw/asbb.php?id=241\n" +
            "$国兴卫视,http://kk.luoke.net.cn/tw/astt.php?id=213\n" +
            "$壹电视新闻台,http://kk.luoke.net.cn/tw/astt.php?id=232\n" +
            "$Z频道,http://kk.luoke.net.cn/tw/asbb.php?id=229\n" +
            "$Discovery HD World,http://kk.luoke.net.cn/tw/astt.php?id=244\n" +
            "$DMAX,http://kk.luoke.net.cn/tw/asbb.php?id=200\n" +
            "$Discovery 科学频道,http://kk.luoke.net.cn/tw/asbb.php?id=247\n" +
            "$EVE,http://kk.luoke.net.cn/tw/asbb.php?id=243\n" +
            "$BBC Lifestyle,http://kk.luoke.net.cn/tw/asbb.php?id=219\n" +
            "$博斯高球台,http://kk.luoke.net.cn/tw/asbb.php?id=222\n" +
            "$博斯高球二台,http://kk.luoke.net.cn/tw/asbb.php?id=209\n" +
            "$国家地理野生频道,http://kk.luoke.net.cn/tw/asbb.php?id=207\n" +
            "$Baby TV,http://kk.luoke.net.cn/tw/asbb.php?id=224\n" +
            "$Disney Junior,http://kk.luoke.net.cn/tw/asbb.php?id=223\n" +
            "$壹电视综合台,http://kk.luoke.net.cn/tw/asbb.php?id=238\n" +
            "$美亚电影台,http://kk.luoke.net.cn/tw/asbb.php?id=204\n" +
            "$星卫电影台,http://kk.luoke.net.cn/tw/astt.php?id=205\n" +
            "$Star Movies HD,http://kk.luoke.net.cn/tw/astt.php?id=246\n" +
            "$FOX Family Movies ,http://kk.luoke.net.cn/tw/astt.php?id=202\n" +
            "$Universal Channel,http://kk.luoke.net.cn/tw/asbb.php?id=203\n" +
            "$Syfy,http://kk.luoke.net.cn/tw/asbb.php?id=216\n" +
            "$Catch Play电影台,http://kk.luoke.net.cn/tw/asbb.php?id=155\n" +
            "$星卫娱乐台,http://kk.luoke.net.cn/tw/asbb.php?id=242\n" +
            "$tvN,http://kk.luoke.net.cn/tw/asbb.php?id=240\n" +
            "$CI罪案侦缉频道,http://kk.luoke.net.cn/tw/asbb.php?id=058\n" +
            "$Animax HD,http://kk.luoke.net.cn/tw/asbb.php?id=208\n" +
            "$韩国娱乐台,http://kk.luoke.net.cn/tw/asbb.php?id=218\n" +
            "$爱尔达体育台,http://kk.luoke.net.cn/tw/asbb.php?id=217\n" +
            "$博斯运动网,http://kk.luoke.net.cn/tw/asbb.php?id=221\n" +
            "$FOX SPORTS 3,http://kk.luoke.net.cn/tw/astt.php?id=230\n" +
            "$WIN综合台,http://kk.luoke.net.cn/tw/asbb.php?id=168\n" +
            "$WIN综合台,http://kk.luoke.net.cn/tw/asbb.php?id=175\n" +
            "$WIN综合台,http://kk.luoke.net.cn/tw/asbb.php?id=177\n" +
            "$WIN综合台,http://kk.luoke.net.cn/tw/astt.php?id=060\n" +
            "$WIN综合台,http://kk.luoke.net.cn/tw/astt.php?id=173\n" +
            "$WIN综合台,http://kk.luoke.net.cn/tw/astt.php?id=178\n" +
            "$台视新闻台HD,http://211.22.61.109/sta/ch323076.m3u8\n" +
            "$寰宇新闻2台,http://211.22.61.109/stc/ch168017.m3u8\n" +
            "$寰宇新闻台,http://211.22.61.109/stc/ch168016.m3u8\n" +
            "$中天新闻,http://61.216.71.67/sta/ch5168014.m3u8\n" +
            "$东森新闻,http://61.216.71.67/sta/ch5168512.m3u8\n" +
            "$东森新闻,http://60.199.188.151/HLS/WG_ETTV-N/index.m3u8\n" +
            "$中视新闻台,http://61.216.71.67/sta/ch5168508.m3u8\n" +
            "$TVBS新闻台,http://61.216.71.67/sta/ch5168510.m3u8\n" +
            "$TVBS HD,http://bcoveliveios-i.akamaihd.net/hls/live/249639/4862438529001_6/master.m3u8\n" +
            "$非凡新闻HD,http://61.216.71.67/sta/ch5168031.m3u8\n" +
            "$民视新闻台,http://61.216.71.67/sta/ch5168604.m3u8\n" +
            "$东森财经新闻,http://61.216.71.67/sta/ch5168513.m3u8\n" +
            "$台视新闻台,http://61.216.71.67/sta/ch5168516.m3u8\n" +
            "$华视新闻资讯,http://61.216.71.67/sta/ch5168519.m3u8\n" +
            "$凤凰卫视资讯HD,http://111.39.226.103:8112/120000001001/wlds:8080/ysten-business/live/fhzixun/.m3u8\n" +
            "$凤凰卫视资讯HD,http://112.17.0.10:8085/ysten-business/live/fhzixun/yst.m3u8\n" +
            "$凤凰卫视资讯HD,http://202.205.93.230:280/b039f4e32adba3c507423b46e08eece6/playlist.m3u8\n" +
            "$凤凰卫视HD,http://111.39.226.103:8112/120000001001/wlds:8080/ysten-business/live/fhchinese/.m3u8\n" +
            "$壹电视新闻,http://d2e6xlgy8sg8ji.cloudfront.net/liveedge/eratv3/chunklist.m3u8\n" +
            "$壹电视新闻,http://d2e6xlgy8sg8ji.cloudfront.net/liveedge/eratv1/chunklist.m3u8\n" +
            "$朝鲜日报,rtmp://live.chosun.gscdn.com/live//tvchosun1.stream\n" +
            "$凤凰中文,http://202.205.93.230:280/99e8f095e48865d9cecff47cd5563763/playlist.m3u8\n" +
            "$凤凰中文,http://218.203.106.12:5580/ysten-business/live/fhchinese/yst.m3u8\n" +
            "$凤凰中文HD,http://112.17.0.10:8085/ysten-business/live/fhchinese/yst.m3u8\n" +
            "$TVB8,http://112.17.0.10:8085/ysten-business/live/tvb8/dujuejiami.m3u8\n" +
            "$paxTV,rtmp://124.139.232.61:1935/live/livestream\n" +
            "$Davinci,http://211.22.61.109/sta/ch323079.m3u8\n" +
            "$澳门莲花,http://111.39.226.103:8112/120000001001/wlds:8080/ysten-business/live/aomenlianhua/.m3u8\n" +
            "$TVB8,http://111.39.226.103:8112/120000001001/wlds:8080/ysten-business/live/tvb8/dujuejiami/.m3u8\n" +
            "$华娱卫视,http://111.39.226.103:8112/120000001001/wlds:8080/ysten-business/live/huayutv/.m3u8\n" +
            "$阳光卫视,http://111.39.226.103:8112/120000001001/wlds:8080/ysten-business/live/yangguangstv/.m3u8\n" +
            "$三立都會,http://bcoveliveios-i.akamaihd.net/hls/live/226707/4338955585001/02wevfbdd54.m3u8#http://bcoveliveios-i.akamaihd.net/hls/live/226707/4338955585001/master.m3u8\n" +
            "$原视,http://live.waaarp.com/live/_definst_/smil:titv/titv.smil/chunklist_b3000000.m3u8#http://live.waaarp.com/live/_definst_/smil:titv/titv.smil/chunklist_w.m3u8\n" +
            "$宏观卫视,http://mobile.ccdntech.com/live/_definst_/vod62_Live/live1/chunklist_w.m3u8\n" +
            "$澳门,http://live4.tdm.com.mo:80/ch3/_definst_//ch3.live/playlist.m3u8\n" +
            "$松视HD,http://211.22.61.109/stc/ch168023.m3u8\n" +
            "$松视1,http://211.22.61.109/stc/ch168022.m3u8\n" +
            "$松视2,http://211.22.61.109/stc/ch168019.m3u8\n" +
            "$松视3,http://211.22.61.109/stc/ch168020.m3u8\n" +
            "$松视4,http://211.22.61.109/stc/ch168021.m3u8\n" +
            "$FOX HD,http://61.216.71.67/sta/ch5168001.m3u8\n" +
            "$FOX 3HD,http://61.216.71.67/sta/ch5168002.m3u8\n" +
            "$台湾艺术台,http://61.216.71.67/sta/ch5168003.m3u8\n" +
            "$HBO HD,http://61.216.71.67/sta/ch5168005.m3u8\n" +
            "$HBO HD,http://61.216.71.67/sta/ch5168006.m3u8\n" +
            "$HD,http://61.216.71.67/sta/ch5168007.m3u8\n" +
            "$八大戏剧,http://61.216.71.67/sta/ch5168009.m3u8\n" +
            "$八大综合HD,http://61.216.71.67/sta/ch5168010.m3u8\n" +
            "$八大第1台,http://61.216.71.67/sta/ch5168011.m3u8\n" +
            "$大爱HD,http://61.216.71.67/sta/ch5168012.m3u8\n" +
            "$中天娱乐,http://61.216.71.67/sta/ch5168013.m3u8\n" +
            "$东风37,http://61.216.71.67/sta/ch5168016.m3u8\n" +
            "$EBCYOYOY6,http://61.216.71.67/sta/ch5168017.m3u8\n" +
            "$纬来电影,http://61.216.71.67/sta/ch5168025.m3u8\n" +
            "$纬来体育,http://61.216.71.67/sta/ch5168027.m3u8\n" +
            "$国家地理,http://61.216.71.67/sta/ch5168029.m3u8\n" +
            "$探索频道,http://61.216.71.67/sta/ch5168030.m3u8\n" +
            "$ELTA体育 HD,http://61.216.71.67/sta/ch5168032.m3u8\n" +
            "$AXN,http://61.216.71.67/sta/ch5168034.m3u8\n" +
            "$世界影城電影頻道,http://61.216.71.67/sta/ch5168035.m3u8\n" +
            "$CNN,http://61.216.71.67/sta/ch5168036.m3u8\n" +
            "$卫视中文台HD,http://61.216.71.67/sta/ch5168037.m3u8\n" +
            "$卫视电影台,http://61.216.71.67/sta/ch5168038.m3u8\n" +
            "$年代MUCH,http://61.216.71.67/sta/ch5168039.m3u8\n" +
            "$台湾未知,http://61.216.71.67/sta/ch5168040.m3u8\n" +
            "$四季台,http://61.216.71.67/sta/ch5168606.m3u8\n" +
            "$公视2,http://61.216.71.67/sta/ch5168607.m3u8\n" +
            "$天良,http://61.216.71.67/sta/ch5168701.m3u8\n" +
            "$信吉,http://61.216.71.67/sta/ch5168702.m3u8\n" +
            "$台未知,http://61.216.71.67/sta/ch5168703.m3u8\n" +
            "$公视HD,http://61.216.71.67/sta/ch5168042.m3u8\n" +
            "$三立台湾,http://61.216.71.67/sta/ch5168049.m3u8\n" +
            "$华蒧,http://61.216.71.67/sta/ch5168067.m3u8\n" +
            "$菁采台,http://61.216.71.67/sta/ch5168505.m3u8\n" +
            "$中视HD,http://61.216.71.67/sta/ch5168506.m3u8\n" +
            "$TVBS HD,http://61.216.71.67/sta/ch5168509.m3u8\n" +
            "$TVB8,http://61.216.71.67/sta/ch5168511.m3u8\n" +
            "$富立,http://61.216.71.67/sta/ch5168600.m3u8\n" +
            "$hakka,http://61.216.71.67/sta/ch5168602.m3u8\n" +
            "$民视,http://61.216.71.67/sta/ch5168603.m3u8\n" +
            "$交通电视台,http://61.216.71.67/sta/ch5168605.m3u8\n" +
            "$中天亚洲台,http://61.216.71.67/sta/ch5168514.m3u8\n" +
            "$台视财经台,http://61.216.71.67/sta/ch5168515.m3u8\n" +
            "$台视HD,http://61.216.71.67/sta/ch5168043.m3u8\n" +
            "$华视HD,http://61.216.71.67/sta/ch5168046.m3u8\n" +
            "$东森超视HD,http://61.216.71.67/sta/ch5168047.m3u8\n" +
            "$JET综合,http://61.216.71.67/sta/ch5168048.m3u8\n" +
            "$人间卫视,http://61.216.71.67/sta/ch5168517.m3u8\n" +
            "$华视,http://61.216.71.67/sta/ch5168518.m3u8\n" +
            "$华视综合娱乐,http://61.216.71.67/sta/ch5168520.m3u8\n" +
            "$印心佛法,http://61.216.71.67/sta/ch5168522.m3u8\n" +
            "$乐活频道,http://211.22.61.109/stc/ch168161.m3u8\n" +
            "$奥视惊艳,http://211.22.61.109/stc/ch168162.m3u8\n" +
            "$奥视香蕉,http://211.22.61.109/stc/ch168163.m3u8\n" +
            "$高清翡翠,http://wshls.acgvideo.com/live/live_44206803_1959058/playlist.m3u8\n" +
            "$高清翡翠台,http://dlhls.cdn.zhanqi.tv/zqlive/2869_tUPFz.m3u8\n" +
            "$香港卫视,rtmp://live.hkstv.hk.lxdns.com/live/hks\n" +
            "$香港卫视,http://live.hkstv.hk.lxdns.com/live/hks/playlist.m3u8\n" +
            "$星空卫视,http://222.36.5.53:9800/live/xktv.m3u8\n" +
            "$华娱卫视,http://112.17.0.10:8085/ysten-business/live/huayutv/yst.m3u8\n" +
            "$宏观卫视,http://mobile.ccdntech.com/live/_definst_/vod62_Live/live1/playlist.m3u8\n" +
            "$澳亚卫视,http://live.mastvnet.com/n1rtlHG/500/live.m3u8\n" +
            "$韩国高清8台,http://123.108.164.75/etv2sb/phd10499/playlist.m3u8\n" +
            "$新唐人电视,http://123.108.164.71/etv2/phd1058/playlist.m3u8\n" +
            "$星卫娱乐,http://dlhls.cdn.zhanqi.tv/zqlive/1285_Zloy4.m3u8\n" +
            "$星卫娱乐,http://dlhls.cdn.zhanqi.tv/zqlive/1285_Zloy4_400/index.m3u8\n" +
            "$星卫娱乐,http://dlhls.cdn.zhanqi.tv/zqlive/1285_Zloy4_400/index.m3u8#http://s03.otTCLub.info:1935/live/c742.stream/playlist.m3u8\n" +
            "$亚洲联合,http://tv.unbtv.tv/app_2/ls_1.stream/chunklist.m3u8?wowzasessionid=1998247339\n" +
            "$亚洲联合卫视,rtmp://tv.unbtv.tv:1935/app_2/_definst_/ls_1.stream\n" +
            "$好消息1台,http://210.59.248.53/hls-live/livepkgr/_definst_/liveevent/live-ch1-1.m3u8\n" +
            "$港臺電視,http://rthklive2-lh.akamaihd.net/i/rthk32_1@168450/index_1296_av-b.m3u8\n" +
            "$香港电影,http://live.gslb.letv.com/gslb?stream_id=lb_hkmovie_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=3\n" +
            "$珠江电影,http://218.244.147.118:6389/wtvlive/migu2/614953729_4\n" +
            "$超清影院,http://dlhls.cdn.zhanqi.tv/zqlive/6500_S9pw2.m3u8\n" +
            "$韦哥影院,http://dlhls.cdn.zhanqi.tv/zqlive/7032_0s2qn.m3u8\n" +
            "$超清影院,http://dlhls.cdn.zhanqi.tv/zqlive/6500_S9pw2.m3u8\n" +
            "$NEWTV动作电影,http://111.39.226.103:8112/120000001001/wlds:8080/ysten-business/live/dongzuody/.m3u8\n" +
            "$东森电影,http://61.216.71.67/sta/ch5168018.m3u8\n" +
            "$东森洋片,http://61.216.71.67/sta/ch5168020.m3u8\n" +
            "$龙华电影,http://61.216.71.67/sta/ch5168023.m3u8\n" +
            "$纬来电影,http://61.216.71.67/sta/ch5168025.m3u8\n" +
            "$世界影城電影頻道,http://61.216.71.67/sta/ch5168035.m3u8\n" +
            "$卫视电影台,http://61.216.71.67/sta/ch5168038.m3u8\n" +
            "$林正英经典之作,http://dlhls.cdn.zhanqi.tv/zqlive/35349_iXsXw.m3u8\n" +
            "$高能大片,http://dlhls.cdn.zhanqi.tv/zqlive/2869_tUPFz.m3u8\n" +
            "$监狱风云,http://dlhls.cdn.zhanqi.tv/zqlive/20910_uUMgC.m3u8\n" +
            "$谍影重重,http://dlhls.cdn.zhanqi.tv/zqlive/49858_wgGj1.m3u8\n" +
            "$成龙经典,http://dlhls.cdn.zhanqi.tv/zqlive/45338_MRc2N.m3u8\n" +
            "$猪猪相声,http://dlhls.cdn.zhanqi.tv/zqlive/43626_vQOn9.m3u8\n" +
            "$武林外传,http://dlhls.cdn.zhanqi.tv/zqlive/33765_6qakZ.m3u8\n" +
            "$看鬼来这里,http://dlhls.cdn.zhanqi.tv/zqlive/65500_fnGUH.m3u8\n" +
            "$神仙姐姐影院,http://dlhls.cdn.zhanqi.tv/zqlive/20910_uUMgC.m3u8\n" +
            "$战旗电影19,http://dlhls.cdn.zhanqi.tv/zqlive/36799_8JBTz.m3u8\n" +
            "$战旗电影28,http://dlhls.cdn.zhanqi.tv/zqlive/2869_tUPFz.m3u8\n" +
            "$战旗电影29,http://dlhls.cdn.zhanqi.tv/zqlive/35349_iXsXw.m3u8\n" +
            "$战旗电影30,http://dlhls.cdn.zhanqi.tv/zqlive/7032_0s2qn.m3u8\n" +
            "$少年包青天,http://dlhls.cdn.zhanqi.tv/zqlive/45338_MRc2N.m3u8\n" +
            "$经典电影,http://dlhls.cdn.zhanqi.tv/zqlive/55147_dlCCR.m3u8\n" +
            "$VIP电影-悬战,http://chyd-wsvod.wasu.tv/data13/ott/344/2015-06/10/1433923712941_962055/playlist.m3u8\n" +
            "$VIP电影-非常营救,http://chyd-wsvod.wasu.tv/data9/ott/344/2013-06/07/1370600803122_737204/playlist.m3u8\n" +
            "$VIP电影-公路美人,http://chyd-wsvod.wasu.tv/data13/ott/344/2015-05/28/1432782476341_377935/playlist.m3u8\n" +
            "$VIP电影-博物馆奇妙夜3,http://chyd-wsvod.wasu.tv/data12/ott/344/2015-03/05/1425521511475_343177/playlist.m3u8\n" +
            "$韩国娱乐台,http://211.22.61.109/sta/ch323078.m3u8\n" +
            "$韩-音乐,http://123.108.164.71/etv2sb/phd4/playlist.m3u8\n" +
            "$韩综合,http://123.108.164.71/etv2sb/phd4/playlist.m3u8\n" +
            "$韩国电视,rtmp://218.38.152.69:1935/da_live/72136989/mp4:ch001\n" +
            "$韩国音乐,http://123.108.164.71/etv2sb/phd4/playlist.m3u8\n" +
            "$韩国KTV-HD,rtmp://218.38.152.31:1935/klive/klive.stream\n" +
            "$韩国CBS,rtmp://cbs-live.gscdn.com/cbs-live/cbs-live.stream\n" +
            "$韩国CTS,rtmp://ctsnanum.rtsp.vercoop.com:1935/CTS/CTS_34312_100.sdp\n" +
            "$韩国KCTV-N,rtmp://122.202.129.136:1935/live/ch4\n" +
            "$韩国KCTV-HD,rtmp://122.202.129.136:1935/live/ch5\n" +
            "$韩版KTV-HD,rtmp://218.38.152.31:1935/klive/klive.stream\n" +
            "$新韩源8,rtmp://edge2.everyon.tv:1935/etv2/phd877\n" +
            "$韩国KCTV,rtmp://122.202.129.136:1935/live/ch4\n" +
            "$德国,rtmp://62.113.210.250/medienasa-live/ok-salzwedel_low\n" +
            "$希腊ZOUGLA TVZOUGLA TV,rtmp://cp67108.live.edgefcs.net/live/zouglaradio@15863\n" +
            "$战旗韩国音乐,http://dlhls.cdn.zhanqi.tv/zqlive/1285_Zloy4.m3u8\n" +
            "$战旗影院17,http://dlhls.cdn.zhanqi.tv/zqlive/7032_0s2qn.m3u8\n" +
            "$战旗67,http://dlhls.cdn.zhanqi.tv/zqlive/7032_0s2qn.m3u8\n" +
            "$战旗12武林外传,http://dlhls.cdn.zhanqi.tv/zqlive/33765_6qakZ.m3u8\n" +
            "$战旗14综艺,http://dlhls.cdn.zhanqi.tv/zqlive/34822_KA3zE.m3u8\n" +
            "$经典经典,http://dlhls.cdn.zhanqi.tv/zqlive/20910_uUMgC.m3u8\n" +
            "$惊悚悬疑,http://111.39.226.103:8112/120000001001/wlds:8080/ysten-business/live/jingsongxy/.m3u8\n" +
            "$明星大片,http://111.39.226.103:8112/120000001001/wlds:8080/ysten-business/live/mingxingdp/.m3u8\n" +
            "$海外剧场,http://111.39.226.103:8112/120000001001/wlds:8080/ysten-business/live/xiqumd/.m3u8\n" +
            "$爱情喜剧,http://111.39.226.103:8112/120000001001/wlds:8080/ysten-business/live/aiqingxj/.m3u8\n" +
            "$军旅剧场,http://111.39.226.103:8112/120000001001/wlds:8080/ysten-business/live/junlvjc/.m3u8\n" +
            "$柚子剧场,http://dlhls.cdn.zhanqi.tv/zqlive/35349_iXsXw.m3u8\n" +
            "$博斯网球,http://211.22.61.109/stc/ch168011.m3u8\n" +
            "$博斯运动,http://211.22.61.109/stc/ch168012.m3u8\n" +
            "$博斯无限,http://211.22.61.109/stc/ch168001.m3u8\n" +
            "$博斯足球,http://211.22.61.109/stc/ch168002.m3u8\n" +
            "$靖天卡通台,http://211.22.61.109/stc/ch168164.m3u8\n" +
            "$靖天育乐台,http://211.22.61.109/stc/ch168165.m3u8\n" +
            "$靖天资讯台,http://211.22.61.109/stc/ch168167.m3u8\n" +
            "$靖天国际台,http://211.22.61.109/stc/ch168169.m3u8\n" +
            "$靖天育乐台,http://211.22.61.109/stc/ch168165.m3u8\n" +
            "$靖天日本台,http://211.22.61.109/stc/ch168166.m3u8\n" +
            "$靖天资讯台,http://211.22.61.109/stc/ch168167.m3u8\n" +
            "$靖洋卡通台,http://211.22.61.109/stc/ch168168.m3u8\n" +
            "$靖天国际台,http://211.22.61.109/stc/ch168169.m3u8\n" +
            "$动物星球,http://211.22.61.109/sta/ch323052.m3u8\n" +
            "$CN卡通频道,http://211.22.61.109/sta/ch323058.m3u8\n" +
            "$美食的季节,http://dlhls.cdn.zhanqi.tv/zqlive/31302_yB09H.m3u8\n" +
            "$軍事瞭望,http://live.gslb.letv.com/gslb?stream_id=lb_jslw_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$美食解碼,http://live.gslb.letv.com/gslb?stream_id=lb_msjm_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$樂視美食,http://live.gslb.letv.com/gslb?stream_id=lb_meishi_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$歡樂季,http://live.gslb.letv.com/gslb?stream_id=lb_2015xjdws_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$動物世界,http://live.gslb.letv.com/gslb?stream_id=lb_dwsj_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$最強大腦,http://live.gslb.letv.com/gslb?stream_id=lb_zqdn_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$美克家居ART,http://live.gslb.letv.com/gslb?stream_id=lb_mkmj_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$紀錄片,http://live.gslb.letv.com/gslb?stream_id=lb_jilu_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$紀錄唐卡,http://live.gslb.letv.com/gslb?stream_id=lb_lb_tangka_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$紀錄歷史,http://live.gslb.letv.com/gslb?stream_id=lb_jlls_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$紀錄文化遺產,http://live.gslb.letv.com/gslb?stream_id=lb_lb_whyc_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$人物傳記,http://live.gslb.letv.com/gslb?stream_id=lb_rwzj_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$人文地理,http://live.gslb.letv.com/gslb?stream_id=lb_rwdl_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$狂野自然,http://live.gslb.letv.com/gslb?stream_id=lb_kyzr_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$樂視旅遊,http://live.gslb.letv.com/gslb?stream_id=lb_lvyou_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$樂視公益,http://live.gslb.letv.com/gslb?stream_id=lb_gongyi_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$樂視檔案,http://live.gslb.letv.com/gslb?stream_id=lb_dangan_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$樂視盛典,http://live.gslb.letv.com/gslb?stream_id=lb_lssd_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=cs1&expect=1\n" +
            "$樂視風尚,http://live.gslb.letv.com/gslb?stream_id=lb_fengshang_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$娛樂頻道,http://live.gslb.letv.com/gslb?stream_id=lb_yule_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$戲曲,http://live.gslb.letv.com/gslb?stream_id=lb_xiqu_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$LIVE生活,http://live.gslb.letv.com/gslb?stream_id=lb_livemusic_720p&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$華鼎獎頒獎典禮,http://live.gslb.letv.com/gslb?stream_id=lb_hdjbjdl_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$籃球,http://live.gslb.letv.com/gslb?stream_id=lb_lanqiu_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$新疆廣匯籃球,http://live.gslb.letv.com/gslb?stream_id=lb_xjgh_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$廣廈籃球,http://live.gslb.letv.com/gslb?stream_id=lb_gslqpd_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$福建潯興籃球,http://live.gslb.letv.com/gslb?stream_id=lb_fjxx_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$佛山龍獅籃球,http://live.gslb.letv.com/gslb?stream_id=lb_fsls_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$江蘇肯帝亞籃球,http://live.gslb.letv.com/gslb?stream_id=lb_jskdy_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$(藥都)瑜伽籃球,http://live.gslb.letv.com/gslb?stream_id=lb_yujia_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$樂視體育體育+,http://live.gslb.letv.com/gslb?stream_id=lb_tyzx_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$體育1,http://live.gslb.letv.com/gslb?stream_id=lb_sports_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$體育2,http://live.gslb.letv.com/gslb?stream_id=lb_tiyu2_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "$粵語頻道,http://live.gslb.letv.com/gslb?stream_id=lb_yylbpd_1300&tag=live&ext=m3u8&sign=live_tv&platid=10&splatid=1009&format=letv&expect=1\n" +
            "\n";

    public static void initTVSource() {
        if (SPUtil.getTVSource(MyApplication.getContext()).isEmpty()) {
            ArrayList<TVSource> tvSources = new ArrayList<>();
            String[] split = tVSource.split("$");
            for (String s : split) {
                try {
                    String[] split1 = s.split(",");
                    if (split1.length >= 2) {
                        TVSource tvSource = new TVSource(split1[0], split1[1]);
                        tvSources.add(tvSource);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String json = JSONUtils.toJson(tvSources);
            SPUtil.saveTVSource(MyApplication.getContext(), json);
        }
    }
}
