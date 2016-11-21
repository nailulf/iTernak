package com.example.nailul.iternak.Models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nailul on 11/19/2016.
 */

// [START post_class]
@IgnoreExtraProperties
public class Sapi {

    public String uid,petani,sapiid,jenissapi,ptsapi,pjsapi;
    public int usiasapi,bb,tb,lb;
    public Map<String, Boolean> stars = new HashMap<>();

    public Sapi() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Sapi(String uid, String petani, String sapiid,
                int bb, int tb, int lb, int usiasapi,
                String jenissapi, String ptsapi, String pjsapi) {
        this.uid = uid;
        this.petani = petani;
        this.sapiid = sapiid;
        this.bb = bb;
        this.tb = tb;
        this.lb = lb;
        this.usiasapi = usiasapi;
        this.jenissapi = jenissapi;
        this.ptsapi = ptsapi;
        this.pjsapi = pjsapi;
    }

    // [START post_to_map]
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("sapiid", sapiid);
        result.put("bb", bb);
        result.put("tb", tb);
        result.put("lb", tb);

        return result;
    }
    // [END post_to_map]

}
// [END post_class]
