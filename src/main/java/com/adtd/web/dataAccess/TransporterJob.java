package com.adtd.web.dataAccess;

public class TransporterJob {

    private long NodeStartID;
    private long NodeTargetID;
    private float payload;

    public void setNodeStartID(long nodeStartID) {
        NodeStartID = nodeStartID;
    }

    public void setNodeTargetID(long nodeTargetID) {
        NodeTargetID = nodeTargetID;
    }

    public float getPayload() {
        return payload;
    }

    public long getNodeStartID() {
        return NodeStartID;
    }

    public long getNodeTargetID() {
        return NodeTargetID;
    }

    public void setPayload(float payload) {
        this.payload = payload;
    }
}
