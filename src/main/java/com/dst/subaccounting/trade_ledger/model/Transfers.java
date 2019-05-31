package com.dst.subaccounting.trade_ledger.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "clientTransactions")
public class Transfers {
	
	@Field("accrualmoneyamount")
	private double accrualMoneyAmount;

	@Field("destinationaccountomnibusindicator")
	private String destinationAccountOmnibusIndicator;

	@Field("destinationomnibusbin")
	private String destinationOmnibusBIN;

	@Field("destinatioshareownerbin")
	private String destinatioShareownerBIN;

	@Field("firmroleintransfer")
	private String firmRoleInTransfer;

	@Field("nsccacatsassetssequenceid")
	private String nsccAcatsAssetsSequenceId;

	@Field("nsccacatscontrolnumber")
	private String nsccAcatsControlNumber;

	@Field("nsccfundparticipantnumber")
	private String nsccFundParticipantNumber;

	@Field("nsccregistrationstatuscode")
	private String nsccRegistrationStatusCode;

	@Field("originatingaccountomnibusindicator")
	private String originatingAccountOmnibusIndicator;

	@Field("originatingagentforfirm")
	private String originatingAgentForFirm;

	@Field("originatingfirmnumber")
	private String originatingFirmNumber;

	@Field("originatingomnibusbin")
	private String originatingOmnibusBIN;

	@Field("originatingshareownerbin")
	private String originatingShareownerBIN;

	@Field("socialcode")
	private String socialCode;
}
