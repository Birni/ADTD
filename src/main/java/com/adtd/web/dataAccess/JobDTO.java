package com.adtd.web.dataAccess;

import java.io.Serializable;

public class JobDTO implements Serializable {

    private long NodeStartID;
    private long NodeTargetID;
    private float JobPayload;

    public long getNodeStartID() {
        return NodeStartID;
    }

    public long getNodeTargetID() {
        return NodeTargetID;
    }

    public float getJobPayload() {
        return JobPayload;
    }

    public void setJobPayload(float jobPayload) {
        JobPayload = jobPayload;
    }

    public void setNodeTargetID(long nodeTargetID) {
        NodeTargetID = nodeTargetID;
    }

    public void setNodeStartID(long nodeStartID) {
        NodeStartID = nodeStartID;
    }
}
