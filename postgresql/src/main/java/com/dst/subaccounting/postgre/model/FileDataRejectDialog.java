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

import com.dst.subaccounting.postgre.FileData;

import lombok.Data;

@Data
public class FileDataRejectDialog implements FileData {

	public static String getTableName() {
		return "RejectDialog";
	}

	public FileDataRejectDialog() {}
	
	public FileDataRejectDialog(RejectDialog rd, Integer ctId) {
		setRejectDialogId(rd.getRejectDialogId());
		setRejectId(rd.getRejectId());
		setRejectCode(rd.getRejectCode());
		setRejectDescription(rd.getRejectDescription());
		setClientTransactionId(ctId);

	}

	private Integer rejectDialogId;
	private String rejectId;
	private String rejectCode;
	private String rejectDescription;
	private Integer clientTransactionId;

}
