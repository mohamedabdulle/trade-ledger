/*
 * COPYRIGHT:
 *
 *   The computer systems, procedures, data bases and programs
 *   created and maintained by DST Systems, Inc., are proprietary
 *   in nature and as such are confidential.  Any unauthorized
 *   use or disclosure of such information may result in civil
 *   liabilities.
 *
 *   Copyright 2019 by DST Systems, Inc.
 *   All Rights Reserved.
 */
package com.dst.subaccounting.postgre.model;

public class RejectDialog {

    private String rejectId;
    private String rejectCode;
    private String rejectDescription;
    
    
    public String getRejectId() {
        return rejectId;
    }
    public void setRejectId(String rejectId) {
        this.rejectId = rejectId;
    }
    public String getRejectCode() {
        return rejectCode;
    }
    public void setRejectCode(String rejectCode) {
        this.rejectCode = rejectCode;
    }
    public String getRejectDescription() {
        return rejectDescription;
    }
    public void setRejectDescription(String rejectDescription) {
        this.rejectDescription = rejectDescription;
    }
    @Override
    public String toString() {
	return "RejectDialog [rejectId=" + rejectId + ", rejectCode=" + rejectCode + ", rejectDescription="
		+ rejectDescription + "]";
    }
    
    
    
}

