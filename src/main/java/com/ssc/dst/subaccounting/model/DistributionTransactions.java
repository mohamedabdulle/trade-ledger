package com.ssc.dst.subaccounting.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "clienttransactions")
public class DistributionTransactions {
	@Field("aggregated")
	private boolean aggregated;
	
	@Field("distributionEventType")
	private String distributionEventType;
	
	@Field("distributionRate")
	private String distributionRate;
	
	@Field("distributionRecordDate")
	private String distributionRecordDate;
	
	@Field("eventId")
	private String[] eventId;
	
	@Field("excludedFromAggregation")
	private boolean excludedFromAggregation;
	
	@Field("omnibusTradeTransmitted")
	private boolean omnibusTradeTransmitted;
}
