package org.mongo_service.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "clienttransactions")
public class DistributionTransactions {
	@Field("aggregated")
	private boolean aggregated;
	
	@Field("distributioneventtype")
	private String distributionEventType;
	
	@Field("distributionrate")
	private String distributionRate;
	
	@Field("distributionrecorddate")
	private String distributionRecordDate;
	
	@Field("eventid")
	private String[] eventId;
	
	@Field("excludedfromaggregation")
	private boolean excludedFromAggregation;
	
	@Field("omnibustradetransmitted")
	private boolean omnibusTradeTransmitted;
}
