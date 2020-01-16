package com.adtd.web.dataAccess;

import java.io.Serializable;


/**
 * Class for with Transporter-Job information
 *
 * @author  Matthias Birnthaler
 */
public class JobDTO implements Serializable {

    private String NodeStartID;
    private String NodeTargetID;
    private float JobPayload;

    public String getNodeStartID() {
        return NodeStartID;
    }

    public String getNodeTargetID() {
        return NodeTargetID;
    }

    public float getJobPayload() {
        return JobPayload;
    }

    public void setJobPayload(float jobPayload) {
        JobPayload = jobPayload;
    }

    public void setNodeStartID(String nodeStartID) {
        NodeStartID = nodeStartID;
    }

    public void setNodeTargetID(String nodeTargetID) {
        NodeTargetID = nodeTargetID;
    }
}
