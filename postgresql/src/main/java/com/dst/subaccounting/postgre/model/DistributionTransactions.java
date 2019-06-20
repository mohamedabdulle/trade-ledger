package com.dst.subaccounting.postgre.model;

import lombok.Data;

@Data
public class DistributionTransactions {

	private boolean aggregated;
	private String distributionEventType;
	private String distributionRate;
	private String distributionRecordDate;
	private String[] eventId;
	private boolean excludedFromAggregation;
	private boolean omnibusTradeTransmitted;
}
