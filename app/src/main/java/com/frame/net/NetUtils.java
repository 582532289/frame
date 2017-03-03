package com.frame.net;

import com.frame.joke.model.Back;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;

import static com.frame.net.NetBaese.getService;

/**
 * Created by xuning on 17/3/2.
 */

public class NetUtils {

    public static Observable<Back> loadJoke(String page) {
        Map<String, String> map = new HashMap<>();
        map.put("key", "e5919ae4d8f9288fdede67e4ed4634df");
        map.put("sort", "desc");
        map.put("page", page);
        map.put("time", "1418816972");
        map.put("pagesize", "20");
        return getService().load(map);
    }
}
