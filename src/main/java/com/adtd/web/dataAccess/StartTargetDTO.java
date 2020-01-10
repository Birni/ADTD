package com.adtd.web.dataAccess;

public class StartTargetDTO {

    private long NodeStartID;
    private long NodeTargetID;

    public StartTargetDTO(){

    }

    public long getNodeStartID() {
        return NodeStartID;
    }

    public long getNodeTargetID() {
        return NodeTargetID;
    }

    public void setNodeStartID(long nodeStartID) {
        NodeStartID = nodeStartID;
    }

    public void setNodeTargetID(long nodeTargetID) {
        NodeTargetID = nodeTargetID;
    }

}
