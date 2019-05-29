package com.ssc.dst.subaccounting.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "clienttransactions")
public class Transfers {
	@Field("accrualmoneyamount")
	public double accrualMoneyAmount;
	
	@Field("destinationaccountomnibusindicator") 
	public String destinationAccountOmnibusIndicator;

	@Field("destinationomnibusbin")
	public String destinationOmnibusBIN;
	
	@Field("destinatioshareownerbin")
	public String destinatioShareownerBIN;
	
	@Field("firmroleintransfer")
	public String firmRoleInTransfer;
	
	@Field("nsccacatsassetssequenceid")
	public String nsccAcatsAssetsSequenceId;
	
	@Field("nsccacatscontrolnumber")
	public String nsccAcatsControlNumber;
	
	@Field("nsccfundparticipantnumber")
	public String nsccFundParticipantNumber;
	
	@Field("nsccregistrationstatuscode") 
	public String nsccRegistrationStatusCode;

	@Field("originatingaccountomnibusindicator")
	public String originatingAccountOmnibusIndicator;
	
	@Field("originatingagentforfirm")
	public String originatingAgentForFirm;
	
	@Field("originatingfirmnumber")
	public String originatingFirmNumber;
	
	@Field("originatingomnibusbin")
	public String originatingOmnibusBIN;
	
	@Field("originatingshareownerbin")
	public String originatingShareownerBIN;
	
	@Field("socialcode")
	public String socialCode;
}
