package lee.vioson.watchtv.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Author:李烽
 * Date:2016-11-25
 * FIXME
 * Todo
 */

public class TVSource implements Serializable {
    @Expose
    public String title;
    @Expose
    public String url;
    @Expose
    public Type type;

    public TVSource(String title, String url) {
        this.title = title;
        this.url = url;
        this.type = Type.other;
    }

    public TVSource(String url) {
        this.url = url;
        this.title = "自定义频道";
        this.type = Type.other;
    }

    public TVSource(String title, String url, Type type) {
        this.title = title;
        this.url = url;
        this.type = type;
    }

    public enum Type {
        cctv, weishi, local, other, kids
    }
}
