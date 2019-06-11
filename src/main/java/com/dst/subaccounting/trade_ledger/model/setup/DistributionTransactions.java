package com.dst.subaccounting.trade_ledger.model.setup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class DistributionTransactions {
	
	@JsonAlias("aggregated")
	@Field("aggregated")
	private boolean aggregated;

	@JsonAlias("distributioneventtype")
	@Field("distributioneventtype")
	private String distributionEventType;

	@JsonAlias("distributionrate")
	@Field("distributionrate")
	private String distributionRate;

	@JsonAlias("distributionrecorddate")
	@Field("distributionrecorddate")
	private String distributionRecordDate;

	@JsonAlias("eventid")
	@Field("eventid")
	private String[] eventId;

	@JsonAlias("excludedfromaggregation")
	@Field("excludedfromaggregation")
	private boolean excludedFromAggregation;

	@JsonAlias("omnibustradetransmitted")
	@Field("omnibustradetransmitted")
	private boolean omnibusTradeTransmitted;
}
